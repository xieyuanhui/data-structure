package com.xyh.datastructure.constants;

/**
 * @description: 自封装列表常量
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
public class ListConstants {

    /**
     * 私有构造函数
     */
    private ListConstants() {

    }

    /**
     * 链表添加元素错误
     */
    public static final String ADD_ERROR = "Add element failed. Require index >= 0 && index <= size";
    /**
     * 链表获取元素错误
     */
    public static final String GET_ERROR = "Get element failed. Require index >= 0 && index < size";
    /**
     * 链表修改元素错误
     */
    public static final String SET_ERROR = "Set element failed. Require index >= 0 && index < size";
    /**
     * 链表删除元素错误
     */
    public static final String REMOVE_ERROR = "Remove element failed. Require index >= 0 && index < size";
}
