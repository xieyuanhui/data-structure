package com.xyh.datastructure.queue;

import com.xyh.datastructure.constants.ArrayConstants;
import com.xyh.datastructure.constants.QueueConstants;
import com.xyh.datastructure.utils.CommonMethods;

/**
 * @description: 自封装循环队列
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * 队列元素存储数组
     */
    private E[] data;
    /**
     * 队首索引
     */
    private int front;
    /**
     * 队尾索引
     */
    private int tail;
    /**
     * 队列元素数量
     */
    private int size;

    /**
     * 带参构造函数
     *
     * @param capacity 队列容量
     */
    public LoopQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(ArrayConstants.CONSTRUCT_ERROR);
        }
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 无参构造函数
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * 获取队列容量
     *
     * @return 队列容量
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 获取队列元素数量
     *
     * @return 队列元素数量
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断队列是否为空
     *
     * @return 队列是否为空
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 元素入队
     *
     * @param e 待入队元素
     */
    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * QueueConstants.INCREASE_THRESHOLD);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 元素出队
     *
     * @return 出队元素
     */
    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException(QueueConstants.DEQUEUE_ERROR);
        }
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == (getCapacity() / QueueConstants.REDUCE_THRESHOLD) && (getCapacity() / QueueConstants.INCREASE_THRESHOLD) != 0) {
            resize(getCapacity() / QueueConstants.INCREASE_THRESHOLD);
        }
        return res;
    }

    /**
     * 获取队首元素
     *
     * @return 队首元素
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException(QueueConstants.GET_ERROR);
        }
        return data[front];
    }

    /**
     * 自封装循环队列转字符串
     *
     * @return 字符串
     */
    @Override
    public String toString() {
        CommonMethods methods = new CommonMethods();
        return methods.sysArrayToString(data, size, getCapacity(), "LoopQueue");
    }

    /**
     * 数组扩容
     *
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
}
