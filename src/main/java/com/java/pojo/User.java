package com.java.pojo;

import lombok.Data;

import java.util.List;

/**
 * description：
 * author：丁鹏
 * date：10:55
 */
@Data
public class User {
    private Long id;//用户主键
    private String uName;//用户名
    private String phone;//手机号码
    private String address;//地址

    private List<Order> orderList;//多个订单
}
