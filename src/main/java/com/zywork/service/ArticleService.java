package com.zywork.service;

import com.zywork.dto.ArticleDTO;
import com.zywork.dto.PagerDTO;
import com.zywork.dto.TimeaxisDTO;
import com.zywork.query.ArticleQuery;

import java.util.List;

/**
 * ArticleService服务接口<br/>
 *
 * 创建于2019-03-05<br/>
 *
 * @author http://wjhsmart.vip 危锦辉
 * @version 1.0
 */
public interface ArticleService extends BaseService {

    /**
     * 用户端分页查询
     * @param queryObj
     * @return
     */
    PagerDTO userListPageByCondition(ArticleQuery queryObj);

    /**
     * 首页文章
     * @param size
     * @return
     */
    List<ArticleDTO> indexArticleTop(Integer size);

    /**
     * 首页推荐文章
     * @param size
     * @return
     */
    List<ArticleDTO> indexArticleRecommentTop(Integer size);

    /**
     * 首页点击排行文章
     * @param size
     * @return
     */
    List<ArticleDTO> indexArticleClickTop(Integer size);

    /**
     * 根据分类id查询文章信息
     * @param categoryId
     * @param size
     * @return
     */
    List<ArticleDTO>  getByCategoryId(Long categoryId, Integer size);

    /**
     * 获取时间轴数据
     * @return
     */
    List<TimeaxisDTO> getTimeaxis();
}
