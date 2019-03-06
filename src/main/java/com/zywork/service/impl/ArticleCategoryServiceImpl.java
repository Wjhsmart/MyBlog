package com.zywork.service.impl;

import com.zywork.common.redis.ArticleCategoryRedisUtils;
import com.zywork.dao.ArticleCategoryDAO;
import com.zywork.dos.ArticleCategoryDO;
import com.zywork.dto.ArticleCategoryDTO;
import com.zywork.service.AbstractBaseService;
import com.zywork.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * ArticleCategoryServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-04<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@Service(value = "articleCategoryService")
public class ArticleCategoryServiceImpl extends AbstractBaseService implements ArticleCategoryService {

    private ArticleCategoryDAO articleCategoryDAO;

    private ArticleCategoryRedisUtils articleCategoryRedisUtils;

    @Autowired
    public void setArticleCategoryDAO(ArticleCategoryDAO articleCategoryDAO) {
        super.setBaseDAO(articleCategoryDAO);
        this.articleCategoryDAO = articleCategoryDAO;
    }

    @Autowired
    public void setArticleCategoryRedisUtils(ArticleCategoryRedisUtils articleCategoryRedisUtils) {
        this.articleCategoryRedisUtils = articleCategoryRedisUtils;
    }

    @PostConstruct
    public void init() {
        super.init(ArticleCategoryDO.class, ArticleCategoryDTO.class);
    }

    @Override
    public List<ArticleCategoryDTO> catchGgetAll() {
        List<ArticleCategoryDTO> articleCategoryDTOList = new ArrayList<>();
        if (articleCategoryRedisUtils.exists()) {
            articleCategoryDTOList = articleCategoryRedisUtils.get();
        } else {
            articleCategoryDTOList = (List) articleCategoryDAO.getAll();
        }
        return articleCategoryDTOList;
    }
}
