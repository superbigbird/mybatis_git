package com.java.pojo;

import lombok.Data;

/**
 * description：老公实体类
 * author：丁鹏
 * date：10:13
 */
@Data
public class Husband {

    public Long husId;//老公主键
    private String hName;//老公名
    private String gender;//性别
    private Integer age;//年龄

    private Wife wife;//老婆

}
