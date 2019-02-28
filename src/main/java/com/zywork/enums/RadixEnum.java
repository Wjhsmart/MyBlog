package com.zywork.enums;

/**
 * 常用进制枚举<br/>
 * 创建于2019-02-28<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
public enum RadixEnum {
    BINARY(2),
    OCTAL(8),
    DECIMAL(10),
    HEX(16);

    private Integer value;

    RadixEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
