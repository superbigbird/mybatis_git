package com.java.pojo;

import lombok.Data;

/**
 * description：老婆实体类
 * author：丁鹏
 * date：10:15
 */
@Data
public class Wife {

    private Long wifeId;//老婆id
    private String wifeName;//老婆名
    private String sex;//性别
    private Integer nianLin;//年龄
    private Long husId;//老公id

}
