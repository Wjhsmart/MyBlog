package com.zywork.service.impl;

import com.zywork.common.BeanUtils;
import com.zywork.dos.TimeaxisDO;
import com.zywork.dto.PagerDTO;
import com.zywork.dto.TimeaxisDTO;
import com.zywork.dto.TimeaxisDetailDTO;
import com.zywork.query.ArticleQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zywork.dao.ArticleDAO;
import com.zywork.dos.ArticleDO;
import com.zywork.dto.ArticleDTO;
import com.zywork.service.AbstractBaseService;
import com.zywork.service.ArticleService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * ArticleServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-05<br/>
 *
 * @author http://wjhsmart.vip 危锦辉
 * @version 1.0
 */
@Service(value = "articleService")
public class ArticleServiceImpl extends AbstractBaseService implements ArticleService {

    private ArticleDAO articleDAO;

    @Autowired
    public void setArticleDAO(ArticleDAO articleDAO) {
        super.setBaseDAO(articleDAO);
        this.articleDAO = articleDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ArticleDO.class, ArticleDTO.class);
    }

    @Override
    public PagerDTO userListPageByCondition(ArticleQuery queryObj) {
        PagerDTO pagerDTO = new PagerDTO();
        Long count = countByCondition(queryObj);
        pagerDTO.setTotal(count);
        if (count > 0) {
            List<Object> doObjList = articleDAO.userListPageByCondition(queryObj);
            pagerDTO.setRows(BeanUtils.copyList(doObjList, ArticleDTO.class));
        } else {
            pagerDTO.setRows(new ArrayList<>());
        }
        return pagerDTO;
    }

    @Override
    public List<ArticleDTO> indexArticleTop(Integer size) {
        return (List) articleDAO.indexArticleTop(size);
    }

    @Override
    public List<ArticleDTO> indexArticleRecommentTop(Integer size) {
        return (List) articleDAO.indexArticleRecommentTop(size);
    }

    @Override
    public List<ArticleDTO> indexArticleClickTop(Integer size) {
        return (List) articleDAO.indexArticleClickTop(size);
    }

    @Override
    public List<ArticleDTO> getByCategoryId(Long categoryId, Integer size) {
        return (List) articleDAO.getByCategoryId(categoryId, size);
    }

    @Override
    public List<TimeaxisDTO> getTimeaxis() {
        List<TimeaxisDTO> timeaxisDTOList = new ArrayList<>();
        List<TimeaxisDO> tempTimeaxisDOList = (List) articleDAO.getTimeaxisYear();
        if (tempTimeaxisDOList != null && tempTimeaxisDOList.size() > 0) {
            List<TimeaxisDTO> tempTimeaxisDTOList = BeanUtils.copy(tempTimeaxisDOList, TimeaxisDTO.class);
            for (TimeaxisDTO timeaxis : tempTimeaxisDTOList) {
                String year = timeaxis.getYearColumn();
                List<Object> timeaxisDetailDTOList = articleDAO.getTimeaxisDetailByYear(year);
                timeaxis.setRows(timeaxisDetailDTOList);
                timeaxisDTOList.add(timeaxis);
            }
        }
        return timeaxisDTOList;
    }
}
