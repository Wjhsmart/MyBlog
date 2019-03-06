package com.zywork.dao;

import com.zywork.dto.ArticleCategoryDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.zywork.query.PageQuery;

import java.util.List;

/**
 * ArticleCategoryDAO数据访问接口<br/>
 *
 * 创建于2019-03-04<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@Repository
public interface ArticleCategoryDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    List<Object> getAll();
}
