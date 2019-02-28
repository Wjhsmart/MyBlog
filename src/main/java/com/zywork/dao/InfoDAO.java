package com.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * InfoDAO数据访问接口<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@Repository
public interface InfoDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    Object getInfo();
}
