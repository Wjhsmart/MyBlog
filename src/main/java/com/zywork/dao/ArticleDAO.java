package com.zywork.dao;

import com.zywork.dto.ArticleDTO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.zywork.query.PageQuery;

import java.util.List;

/**
 * ArticleDAO数据访问接口<br/>
 *
 * 创建于2019-03-05<br/>
 *
 * @author http://wjhsmart.vip 危锦辉
 * @version 1.0
 */
@Repository
public interface ArticleDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    /**
     * 用户端分页查询
     * @param queryObj 查询条件
     * @return
     */
    List<Object> userListPageByCondition(@Param("query") Object queryObj);

    /**
     * 首页文章
     * @param size 个数
     * @return
     */
    List<Object> indexArticleTop(@Param("size") Integer size);

    /**
     * 首页推荐文章
     * @param size 个数
     * @return
     */
    List<Object> indexArticleRecommentTop(@Param("size") Integer size);

    /**
     * 首页点击排行文章
     * @param size 个数
     * @return
     */
    List<Object> indexArticleClickTop(@Param("size") Integer size);

    /**
     * 根据分类id获取文章列表
     * @param categoryId 分类id
     * @return
     */
    List<Object> getByCategoryId(@Param("categoryId") Long categoryId, @Param("size") Integer size);

    /**
     * 获取时间轴的年份
     * @return
     */
    List<Object> getTimeaxisYear();

    /**
     * 根据年份获取时间轴详细信息
     * @param year
     * @return
     */
    List<Object> getTimeaxisDetailByYear(@Param("year") String year);
}
