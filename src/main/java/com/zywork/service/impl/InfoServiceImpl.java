package com.zywork.service.impl;

import com.zywork.common.BeanUtils;
import com.zywork.common.redis.InfoRedisUtils;
import com.zywork.dao.InfoDAO;
import com.zywork.dos.InfoDO;
import com.zywork.dto.InfoDTO;
import com.zywork.service.AbstractBaseService;
import com.zywork.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * InfoServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@Service(value = "infoService")
public class InfoServiceImpl extends AbstractBaseService implements InfoService {

    private InfoDAO infoDAO;

    private InfoRedisUtils infoRedisUtils;

    @Autowired
    public void setInfoDAO(InfoDAO infoDAO) {
        super.setBaseDAO(infoDAO);
        this.infoDAO = infoDAO;
    }

    @Autowired
    public void setInfoRedisUtils(InfoRedisUtils infoRedisUtils) {
        this.infoRedisUtils = infoRedisUtils;
    }

    @PostConstruct
    public void init() {
        super.init(InfoDO.class, InfoDTO.class);
    }

    @Override
    public InfoDTO catchGetInfo() {
        InfoDTO infoDTO = new InfoDTO();
        if (infoRedisUtils.exists()) {
            infoDTO = BeanUtils.copy(infoRedisUtils.get(), InfoDTO.class);
        } else {
            infoDTO = BeanUtils.copy(infoDAO.getInfo(), InfoDTO.class);
            infoRedisUtils.store(BeanUtils.copy(infoDAO.getInfo(), InfoDO.class));
        }
        return infoDTO;
    }
}
