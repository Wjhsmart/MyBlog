package com.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zywork.dao.ArticleCommentDAO;
import com.zywork.dos.ArticleCommentDO;
import com.zywork.dto.ArticleCommentDTO;
import com.zywork.service.AbstractBaseService;
import com.zywork.service.ArticleCommentService;

import javax.annotation.PostConstruct;

/**
 * ArticleCommentServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-04<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@Service(value = "articleCommentService")
public class ArticleCommentServiceImpl extends AbstractBaseService implements ArticleCommentService {

    private ArticleCommentDAO articleCommentDAO;

    @Autowired
    public void setArticleCommentDAO(ArticleCommentDAO articleCommentDAO) {
        super.setBaseDAO(articleCommentDAO);
        this.articleCommentDAO = articleCommentDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ArticleCommentDO.class, ArticleCommentDTO.class);
    }
}
