package com.zywork.ali;

/**
 * 阿里云邮件推送配置类<br/>
 * 创建于2019-04-19<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
public class AliyunMailConfig extends AliyunBaseConfig {

    /**
     * 可用区
     */
    private String regionId;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

}
