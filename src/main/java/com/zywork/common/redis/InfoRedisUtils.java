package com.zywork.common.redis;

import com.zywork.common.RedisUtils;
import com.zywork.dos.InfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用于操作系统信息相关的redis类<br/>
 *
 * 创建于2019-02-28<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@Component
public class InfoRedisUtils {

    private static final String INFO = "sys::sys_info";

    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存储系统信息
     * @param infoDO
     */
    public void store(InfoDO infoDO) {
        RedisUtils.save(redisTemplate, INFO, infoDO);
    }

    /**
     * 判断是否缓存了系统信息
     * @return
     */
    public Boolean exists() {
        return RedisUtils.exists(redisTemplate, INFO);
    }

    /**
     * 从缓存获取系统信息
     * @return
     */
    @SuppressWarnings({"unchecked"})
    public InfoDO get() {
        return (InfoDO) RedisUtils.get(redisTemplate, INFO);
    }

    /**
     * 删除缓存的系统信息
     */
    public void del() {
        RedisUtils.delete(redisTemplate, INFO);
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
