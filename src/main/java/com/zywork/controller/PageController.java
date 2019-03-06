package com.zywork.controller;

import com.zywork.common.BeanUtils;
import com.zywork.constant.LimitSizeConstants;
import com.zywork.dto.*;
import com.zywork.query.ArticleQuery;
import com.zywork.service.ArticleCategoryService;
import com.zywork.service.ArticleService;
import com.zywork.service.InfoService;
import com.zywork.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Api("页面跳转的控制器")
@Controller
@RequestMapping("/")
public class PageController {


    private InfoService infoService;

    private ArticleCategoryService articleCategoryService;

    private ArticleService articleService;

    @Autowired
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    @Autowired
    public void setArticleCategoryService(ArticleCategoryService articleCategoryService) {
        this.articleCategoryService = articleCategoryService;
    }

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * 获取公共的视图对象
     * @return
     */
    private ModelAndView getBaseModel() {
        ModelAndView mav = new ModelAndView();
        // 取系统信息
        InfoVO infoVO = BeanUtils.copy(infoService.catchGetInfo(), InfoVO.class);
        // 取文章分类
        List<ArticleCategoryDTO> articleCategoryDTOList = articleCategoryService.catchGgetAll();
        List<Object> articleCategoryVOList = BeanUtils.copyListObj(articleCategoryDTOList, ArticleCategoryVO.class);
        // 取首页文章列表
        List<Object> articleIndexList = BeanUtils.copyListObj(articleService.indexArticleTop(
                LimitSizeConstants.ARTICLE_INDEX_ARTICLE_SIZE), ArticleVO.class);
        // 取推荐文章
        List<Object> articleRecommendList = BeanUtils.copyListObj(articleService.indexArticleRecommentTop(
                LimitSizeConstants.ARTICLE_INDEX_RECOMMEND_SIZE), ArticleVO.class);
        // 取点击最多文章
        List<Object> articleClickList = BeanUtils.copyListObj(articleService.indexArticleClickTop(
                LimitSizeConstants.ARTICLE_INDEX_CLICK_SIZE), ArticleVO.class);
        mav.addObject("articleClickList", articleClickList);
        mav.addObject("articleRecommendList", articleRecommendList);
        mav.addObject("articleIndexList", articleIndexList);
        mav.addObject("articleCategoryVOList", articleCategoryVOList);
        mav.addObject("info", infoVO);
        return mav;
    }

    @ApiOperation("首页")
    @GetMapping(value = {"index","/"})
    public ModelAndView index() {
        ModelAndView mav = getBaseModel();
        mav.setViewName("index");
        return mav;
    }

    @ApiOperation("关于我")
    @GetMapping("about")
    public ModelAndView about() {
        ModelAndView mav = new ModelAndView("about");
        InfoVO infoVO = BeanUtils.copy(infoService.catchGetInfo(), InfoVO.class);
        mav.addObject("info", infoVO);
        return mav;
    }

    @ApiOperation("资源下载")
    @GetMapping("download")
    public ModelAndView download() {
        ModelAndView mav = new ModelAndView("download");
        InfoVO infoVO = BeanUtils.copy(infoService.catchGetInfo(), InfoVO.class);
        mav.addObject("info", infoVO);
        return mav;
    }

    @ApiOperation("学无止境")
    @GetMapping("list")
    public ModelAndView list(@RequestParam(value="pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value="categoryId",defaultValue = "0") Long categoryId) {
        ModelAndView mav = getBaseModel();
        mav.setViewName("list");
        // 查询分页文章列表
        Integer pageSize = LimitSizeConstants.DEFAULT_PAGE_SIZE;
        ArticleQuery articleQuery = new ArticleQuery();
        articleQuery.setPageNo(pageNo);
        articleQuery.setPageSize(pageSize);
        if (categoryId != 0) {
            // 如果有制定文章类型，先查询文章类型
            ArticleCategoryDTO articleCategoryDTO = BeanUtils.copy(
                    articleCategoryService.getById(categoryId), ArticleCategoryDTO.class);
            if (null != articleCategoryDTO) {
                // 有查询到，查询条件带文章类型
                articleQuery.setCategoryId(categoryId);
                mav.addObject("categoryName", articleCategoryDTO.getTitle());
            }
        }
        PagerDTO pagerDTO = articleService.userListPageByCondition(articleQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ArticleVO.class));
        // 计算总页数
        Integer pageTotal = (pagerVO.getTotal().intValue() + pageSize - 1) / pageSize;
        mav.addObject("categoryId", categoryId);
        mav.addObject("pageVO", pagerVO);
        mav.addObject("pageNo", pageNo);
        mav.addObject("pageTotal", pageTotal);
        return mav;
    }

    @ApiOperation("时间轴")
    @GetMapping("timeaxis")
    public ModelAndView timeaxis() {
        ModelAndView mav = getBaseModel();
        mav.setViewName("timeaxis");
        List<TimeaxisVO> timeaxisVOList = new ArrayList<>();
        List<TimeaxisDTO> timeaxisDTOList = articleService.getTimeaxis();
        for (TimeaxisDTO timeaxis : timeaxisDTOList) {
            TimeaxisVO timeaxisVO = new TimeaxisVO();
            timeaxisVO.setYearColumn(timeaxis.getYearColumn());
            List<TimeaxisDetailDTO> timeaxisDetailDTOList = (List) timeaxis.getRows();
            List<Object> timeaxisDetailVOList = BeanUtils.copyListObj(timeaxisDetailDTOList, TimeaxisDetailVO.class);
            timeaxisVO.setRows(timeaxisDetailVOList);
            timeaxisVOList.add(timeaxisVO);
        }
        mav.addObject("timeaxisVOList", timeaxisVOList);
        return mav;
    }

    @ApiOperation("留言")
    @GetMapping("gbook")
    public ModelAndView gbook() {
        ModelAndView mav = new ModelAndView("gbook");
        InfoVO infoVO = BeanUtils.copy(infoService.catchGetInfo(), InfoVO.class);
        mav.addObject("info", infoVO);
        return mav;
    }

    @ApiOperation("文章详情")
    @GetMapping("detail")
    public ModelAndView detail(@RequestParam(value = "id", defaultValue = "0", required = true) Long id) {
        ModelAndView mav = getBaseModel();
        if (id == 0) {
            mav.setViewName("redirect:/list");
            return mav;
        }
        mav.setViewName("detail");
        // 根据文章id查询文章信息
        ArticleVO articleVO = BeanUtils.copy(articleService.getById(id), ArticleVO.class);
        // 根据分类取相关的文章
        List<Object> articleVOList = BeanUtils.copyListObj(
                articleService.getByCategoryId(articleVO.getCategoryId(),
                        LimitSizeConstants.DEFAULT_PAGE_SIZE), ArticleVO.class);
        mav.addObject("articleVOList", articleVOList);
        mav.addObject("articleVO", articleVO);
        return mav;
    }
}
