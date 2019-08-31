package com.zywork.service;

import com.zywork.service.BaseService;

/**
 * SysConfigService服务接口<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://wjhsmart.vip 危锦辉
 * @version 1.0
 */
public interface SysConfigService extends BaseService {

    /**
     * 根据配置名称查询配置信息，配置信息封装成对应的JavaBean，并进行redis缓存
     * @param name 配置名
     * @param tClass 配置JSON值对应的JavaBean
     * @param <T>
     * @return
     */
    <T> T getByName(String name, Class<T> tClass);

}
