package com.xyh.datastructure.array;

import com.xyh.datastructure.constants.ArrayConstants;
import com.xyh.datastructure.utils.CommonMethods;

/**
 * @description: 自封装数组类
 * @author: LitheLight
 * @createDate: 2020/11/27
 * @modifiedBy:
 */
public class Array<E> {
    /**
     * 数据存储数组
     */
    private E[] data;
    /**
     * 数组元素数量
     */
    private int size;

    /**
     * 带参构造函数
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(ArrayConstants.CONSTRUCT_ERROR);
        }
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组容量
     *
     * @return 数组容量
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 获取数组中元素数量
     *
     * @return 数组元素数量
     */
    public int size() {
        return this.size;
    }

    /**
     * 判断数组是否为空
     *
     * @return 数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在数组指定索引处插入元素
     *
     * @param index 数组索引
     * @param e 待插入元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(ArrayConstants.ADD_ERROR);
        }
        if (size == data.length) {
            resize(data.length * ArrayConstants.INCREASE_THRESHOLD);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 在数组末尾插入元素
     *
     * @param e 待插入元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在数组开头插入元素
     *
     * @param e 待插入元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 获取数组index索引处的元素
     *
     * @param index 数组索引
     * @return index索引处元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(ArrayConstants.GET_ERROR);
        }
        return data[index];
    }

    /**
     * 获取数组第一个元素
     *
     * @return 数组第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取数组最后一个元素
     *
     * @return 数组最后一个元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改数组index索引处元素的值
     *
     * @param index 数组索引
     * @param e 待修改的元素值
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(ArrayConstants.SET_ERROR);
        }
        data[index] = e;
    }

    /**
     * 查找元素在数组中第一次出现位置的索引
     *
     * @param e 待查找元素
     * @return 数组索引（元素未在数组中出现返回-1）
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 判断数组中是否包含某个元素
     *
     * @param e 待判断元素
     * @return 是否包含某个元素
     */
    public boolean contains(E e) {
        return find(e) >= 0;
    }

    /**
     * 删除数组index索引处的元素
     *
     * @param index 数组索引
     * @return 删除元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(ArrayConstants.REMOVE_ERROR);
        }
        E delElement = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // 释放空间，防止内存泄露
        data[size] = null;
        // 数组元素数量小于容量四分之一时数组减小容量
        if (size == data.length / ArrayConstants.REDUCE_THRESHOLD && data.length / ArrayConstants.INCREASE_THRESHOLD != 0) {
            resize(data.length / 2);
        }
        return delElement;
    }

    /**
     * 删除数组中第一个元素
     *
     * @return 删除元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     *
     * @return 删除元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 自封装Array转字符串方法
     *
     * @return 字符串
     */
    @Override
    public String toString() {
        CommonMethods methods = new CommonMethods();
        return methods.sysArrayToString(data, size, getCapacity(), "Array");
    }

    /**
     * 数组扩容
     *
     * @param newCapacity 数组扩容之后容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
