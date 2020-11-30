package com.xyh.datastructure.queue;

import com.xyh.datastructure.array.Array;
import com.xyh.datastructure.utils.CommonMethods;

/**
 * @description: 自封装队列
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
public class ArrayQueue<E> implements Queue<E> {
    /**
     * 自封装数组
     */
    private final Array<E> array;

    /**
     * 带参构造函数
     *
     * @param capacity 队列容量
     */
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 无参构造函数
     */
    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * 获取队列容量
     *
     * @return 队列容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 获取队列元素数量
     *
     * @return 队列元素数量
     */
    @Override
    public int getSize() {
        return array.size();
    }

    /**
     * 判断队列是否为空
     *
     * @return 队列是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 元素入队
     *
     * @param e 待入队元素
     */
    @Override
    public void enQueue(E e) {
        array.addLast(e);
    }

    /**
     * 元素出队
     *
     * @return 出队元素
     */
    @Override
    public E deQueue() {
        return array.removeFirst();
    }

    /**
     * 获取队首元素
     *
     * @return 队首元素
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    /**
     * 自封装队列转字符串
     *
     * @return 字符串
     */
    @Override
    public String toString() {
        CommonMethods methods = new CommonMethods();
        return methods.arrayToString(array, "ArrayQueue");
    }
}
