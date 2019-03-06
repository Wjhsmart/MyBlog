package com.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.zywork.common.BeanUtils;
import com.zywork.common.BindingResultUtils;
import com.zywork.common.StringUtils;
import com.zywork.dto.PagerDTO;
import com.zywork.dto.ArticleCommentDTO;
import com.zywork.query.ArticleCommentQuery;
import com.zywork.service.ArticleCommentService;
import com.zywork.vo.ResponseStatusVO;
import com.zywork.vo.PagerVO;
import com.zywork.vo.ArticleCommentVO;

import java.util.List;

/**
 * ArticleCommentController控制器类<br/>
 *
 * 创建于2019-03-04<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/article-comment")
public class ArticleCommentController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleCommentController.class);

    private ArticleCommentService articleCommentService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ArticleCommentVO articleCommentVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        articleCommentService.save(BeanUtils.copy(articleCommentVO, ArticleCommentDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ArticleCommentVO> articleCommentVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        articleCommentService.saveBatch(BeanUtils.copyListObj(articleCommentVOList, ArticleCommentDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        articleCommentService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        articleCommentService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated ArticleCommentVO articleCommentVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = articleCommentService.update(BeanUtils.copy(articleCommentVO, ArticleCommentDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ArticleCommentVO> articleCommentVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        articleCommentService.updateBatch(BeanUtils.copyListObj(articleCommentVOList, ArticleCommentDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody ArticleCommentVO articleCommentVO) {
        articleCommentService.update(BeanUtils.copy(articleCommentVO, ArticleCommentDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ArticleCommentVO> articleCommentVOList) {
        articleCommentService.updateBatch(BeanUtils.copyListObj(articleCommentVOList, ArticleCommentDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ArticleCommentVO articleCommentVO = new ArticleCommentVO();
        Object obj = articleCommentService.getById(id);
        if (obj != null) {
            articleCommentVO = BeanUtils.copy(obj, ArticleCommentVO.class);
        }
        return ResponseStatusVO.ok("查询成功", articleCommentVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = articleCommentService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ArticleCommentVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ArticleCommentQuery articleCommentQuery) {
        PagerDTO pagerDTO = articleCommentService.listAllByCondition(articleCommentQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ArticleCommentVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ArticleCommentQuery articleCommentQuery) {
        PagerDTO pagerDTO = articleCommentService.listPageByCondition(articleCommentQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ArticleCommentVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setArticleCommentService(ArticleCommentService articleCommentService) {
        this.articleCommentService = articleCommentService;
    }
}
