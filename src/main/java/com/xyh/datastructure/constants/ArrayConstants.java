package com.xyh.datastructure.constants;

/**
 * @description: 自定义数组类常量
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
public class ArrayConstants {

    private ArrayConstants() {

    }

    /**
     * 数组减小容量阈值参数
     */
    public static final int REDUCE_THRESHOLD = 4;
    /**
     * 数组扩容阈值参数
     */
    public static final int INCREASE_THRESHOLD = 2;
    /**
     * 构造函数异常信息
     */
    public static final String CONSTRUCT_ERROR = "Create array failed. Required capacity > 0";
    /**
     * 数组添加元素异常信息
     */
    public static final String ADD_ERROR = "Add element failed. Require index >= 0 && index <= size";
    /**
     * 数组获取指定索引元素异常信息
     */
    public static final String GET_ERROR = "Get element failed. Require index >= 0 && index < size";
    /**
     * 数组修改制定索引元素异常信息
     */
    public static final String SET_ERROR = "set element failed. Require index >= 0 && index < size";
    /**
     * 数组删除元素异常信息
     */
    public static final String REMOVE_ERROR = "remove element failed. Require index >= 0 && index < size";
    /**
     * 数组未按期望抛出异常
     */
    public static final String THROW_MESSAGE = "Expected getCapacity to throw, but it didn't";
}
