package com.zywork.service;

import com.zywork.dto.ArticleCategoryDTO;

import java.util.List;

/**
 * ArticleCategoryService服务接口<br/>
 *
 * 创建于2019-03-04<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
public interface ArticleCategoryService extends BaseService {

    List<ArticleCategoryDTO> catchGgetAll();
}
