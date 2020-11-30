package com.xyh.datastructure.constants;

/**
 * @description: 自封装队列常量
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
public class QueueConstants {

    /**
     * 私有构造函数
     */
    private QueueConstants() {

    }

    /**
     * 队列减小容量阈值参数
     */
    public static final int REDUCE_THRESHOLD = 4;
    /**
     * 队列扩容阈值参数
     */
    public static final int INCREASE_THRESHOLD = 2;
    /**
     * 出队错误
     */
    public static final String DEQUEUE_ERROR = "Cannot dequeue from an empty queue.";
    /**
     * 获取队首元素错误
     */
    public static final String GET_ERROR = "Queue is empty.";
}
