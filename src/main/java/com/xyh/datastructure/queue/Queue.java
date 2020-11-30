package com.xyh.datastructure.queue;

/**
 * @description: 自封装队列接口
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
public interface Queue<E> {

    /**
     * 获取队列元素数量
     *
     * @return 队列元素数量
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return 队列是否为空
     */
    boolean isEmpty();

    /**
     * 队列添加元素
     *
     * @param e 待入队元素
     */
    void enQueue(E e);

    /**
     * 队列元素出队
     *
     * @return 待出队元素
     */
    E deQueue();

    /**
     * 获取队列队首元素
     *
     * @return 队首元素
     */
    E getFront();
}
