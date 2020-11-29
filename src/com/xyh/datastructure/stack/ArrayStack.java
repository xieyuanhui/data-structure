package com.xyh.datastructure.stack;

import com.xyh.datastructure.array.Array;

/**
 * @description: 自封装栈类
 * @author: LitheLight
 * @createDate: 2020/11/29
 * @modifiedBy:
 */
public class ArrayStack<E> implements Stack<E> {
    /**
     * 自定义数组
     */
    private Array<E> array;

    /**
     * 带参构造函数
     *
     * @param capacity 栈容量
     */
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 无参构造函数
     */
    public ArrayStack() {
        array = new Array<>();
    }

    /**
     * 获取栈容量
     *
     * @return 栈容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 获取栈元素数量
     *
     * @return 栈元素数量
     */
    @Override
    public int getSize() {
        return array.size();
    }

    /**
     * 判断栈是否为空
     *
     * @return 栈是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 栈中添加元素
     *
     * @param e 待添加元素
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 弹出栈元素
     *
     * @return 待弹出元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 获取栈顶元素
     *
     * @return 栈顶元素
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 自封装栈转字符串
     *
     * @return 栈转化后的字符串
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("ArrayStack: size = %d, capacity = %d\n", array.size(), array.getCapacity());
        res.append('[');
        for (int i = 0; i < array.size(); i++) {
            res.append(array.get(i));
            if (i != array.size() - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
