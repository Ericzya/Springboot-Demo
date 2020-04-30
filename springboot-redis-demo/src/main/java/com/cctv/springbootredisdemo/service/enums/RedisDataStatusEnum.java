package com.cctv.springbootredisdemo.service.enums;

/**
 * @ClassName: RedisDataStatusEnum
 * @Description: Redis状态码枚举
 * @Author: Eric.Zhang
 * @Date: 2020/4/30 10:26
 * @version: 1.0
 */
public enum RedisDataStatusEnum {
    /**
     * 不存在
     */
    UNEXIST(-2),
    /**
     * 永不过期
     */
    NEVER_EXPIRED(-1),
    /**
     * 普通
     */
    NORMAL(0),
    ;

    /**
     * 状态
     */
    private Integer status;

    RedisDataStatusEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
