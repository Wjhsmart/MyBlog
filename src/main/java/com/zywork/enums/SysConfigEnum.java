package com.zywork.enums;

/**
 * 系统配置名称枚举类，每增加一个系统配置名称，增加一个枚举<br/>
 *
 * 创建于2018-12-17<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
public enum SysConfigEnum {

    ALIYUN_SMS_CONFIG("aliyun_sms_config"),
    ALIYUN_MAIL_CONFIG("aliyun_mail_config"),
    ALIYUN_OSS_CONFIG("aliyun_oss_config"),
    QINIU_OSS_CONFIG("qiniu_oss_config"),
    DEFAULT_DISTRIBUTION_CONFIG("default_distribution_config");

    private String value;

    SysConfigEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
