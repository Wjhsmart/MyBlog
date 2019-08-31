package com.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.zywork.common.BeanUtils;
import com.zywork.common.IOUtils;
import com.zywork.common.ReflectUtils;
import com.zywork.dao.SysConfigDAO;
import com.zywork.dos.SysConfigDO;
import com.zywork.dto.SysConfigDTO;
import com.zywork.service.AbstractBaseService;
import com.zywork.service.SysConfigService;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * SysConfigServiceImpl服务接口实现类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://wjhsmart.vip 危锦辉
 * @version 1.0
 */
@Service(value = "sysConfigService")
public class SysConfigServiceImpl extends AbstractBaseService implements SysConfigService {

    private SysConfigDAO sysConfigDAO;

    @Override
    @Cacheable(value = "sys_config", key = "#name", unless="#result == null")
    public <T> T getByName(String name, Class<T> tClass) {
        T t = null;
        SysConfigDO sysConfigDO = sysConfigDAO.getByName(name);
        if (sysConfigDO != null) {
            t = IOUtils.readJsonStrToObject(sysConfigDO.getValue(), tClass);
        }
        return t;
    }

    @Override
    @CacheEvict(value = "sys_config", key = "#dataTransferObj.name")
    public int update(Object dataTransferObj) {
        return super.update(dataTransferObj);
    }

    @Autowired
    public void setSysConfigDAO(SysConfigDAO sysConfigDAO) {
        super.setBaseDAO(sysConfigDAO);
        this.sysConfigDAO = sysConfigDAO;
    }

    @PostConstruct
    public void init() {
        super.init(SysConfigDO.class, SysConfigDTO.class);
    }
}
