package com.zywork.dao;

import java.io.Serializable;
import java.util.List;

/**
 * DAO接口，定义了常用的DAO方法，实现CRUD操作<br/>
 * 由Service调用DAO时，需要传递DO对象进来，并返回DO对象到Service<br/>
 * 创建于2019-02-28<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
public interface BaseDAO {
    int save(Object var1);

    int saveBatch(List<Object> var1);

    int removeById(Serializable var1);

    int removeByIds(Serializable[] var1);

    int update(Object var1);

    int updateBatch(List<Object> var1);

    Object getById(Serializable var1);

    Integer getVersionById(Serializable var1);

    List<Object> listById(Serializable var1);

    List<Object> listAll();

    List<Object> listAllByCondition(Object var1);

    List<Object> listPageByCondition(Object var1);

    Long countByCondition(Object var1);
}
