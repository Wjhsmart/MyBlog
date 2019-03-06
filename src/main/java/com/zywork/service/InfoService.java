package com.zywork.service;

import com.zywork.dto.InfoDTO;

/**
 * InfoService服务接口<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
public interface InfoService extends BaseService {

    /**
     * 获取系统信息并缓存
     * @return
     */
    InfoDTO catchGetInfo();
}
