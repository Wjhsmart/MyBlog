package com.zywork.common.redis;

import com.zywork.common.RedisUtils;
import com.zywork.dos.InfoDO;
import com.zywork.dto.ArticleCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用于操作文章分类相关的redis类<br/>
 *
 * 创建于2019-03-05<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@Component
public class ArticleCategoryRedisUtils {

    private static final String LIST_ALL = "article::listAll";

    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存储系统信息
     * @param articleCategoryDTOList
     */
    public void store(List<ArticleCategoryDTO> articleCategoryDTOList) {
        RedisUtils.save(redisTemplate, LIST_ALL, articleCategoryDTOList);
    }

    /**
     * 判断是否缓存了系统信息
     * @return
     */
    public Boolean exists() {
        return RedisUtils.exists(redisTemplate, LIST_ALL);
    }

    /**
     * 从缓存获取系统信息
     * @return
     */
    @SuppressWarnings({"unchecked"})
    public List<ArticleCategoryDTO> get() {
        return (List<ArticleCategoryDTO>) RedisUtils.get(redisTemplate, LIST_ALL);
    }

    /**
     * 删除缓存的系统信息
     */
    public void del() {
        RedisUtils.delete(redisTemplate, LIST_ALL);
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
