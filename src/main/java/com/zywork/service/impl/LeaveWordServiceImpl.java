package com.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zywork.dao.LeaveWordDAO;
import com.zywork.dos.LeaveWordDO;
import com.zywork.dto.LeaveWordDTO;
import com.zywork.service.AbstractBaseService;
import com.zywork.service.LeaveWordService;

import javax.annotation.PostConstruct;

/**
 * LeaveWordServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-06<br/>
 *
 * @author http://wjhsmart.vip 危锦辉
 * @version 1.0
 */
@Service(value = "leaveWordService")
public class LeaveWordServiceImpl extends AbstractBaseService implements LeaveWordService {

    private LeaveWordDAO leaveWordDAO;

    @Autowired
    public void setLeaveWordDAO(LeaveWordDAO leaveWordDAO) {
        super.setBaseDAO(leaveWordDAO);
        this.leaveWordDAO = leaveWordDAO;
    }

    @PostConstruct
    public void init() {
        super.init(LeaveWordDO.class, LeaveWordDTO.class);
    }
}
