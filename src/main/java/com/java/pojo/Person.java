package com.java.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description：
 * author：丁鹏
 * date：09:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long id;//主键
    private String uName;//用户名
    private String gender;//性别
    private String zhiYe;//职业
    private String address;//地址
    private String phone;//手机号
}
