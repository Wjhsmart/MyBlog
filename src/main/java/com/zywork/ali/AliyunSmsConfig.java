package com.zywork.ali;

/**
 * 阿里云短信配置类<br/>
 * 创建于2019-04-19<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
public class AliyunSmsConfig extends AliyunBaseConfig {

    // 短信签名，必填
    private String signName;

    /**
     * 可用区
     */
    private String regionId;

    public AliyunSmsConfig() {}

    public AliyunSmsConfig(String accessKeyId, String accessKeySecret, String signName) {
        super(accessKeyId, accessKeySecret);
        this.signName = signName;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }


    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

}
