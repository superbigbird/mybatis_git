package com.java.pojo;

import lombok.Data;

/**
 * description：
 * author：丁鹏
 * date：10:53
 */
@Data
public class Order {
    private Long orderId;//订单主键
    private String remark;//订单描述
    private String orderNo;//订单编号
    private Float cost;//订单金额
    private String createTime;//创建时间
    private Long userId;//用户id
}
