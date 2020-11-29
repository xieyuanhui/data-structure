package com.xyh.datastructure.stack;

/**
 * @description: 自封装栈接口
 * @author: LitheLight
 * @createDate: 2020/11/29
 * @modifiedBy:
 */
public interface Stack<E> {
    /**
     * 获取栈的元素数量
     *
     * @return 栈元素数量
     */
    int getSize();

    /**
     * 判断栈是否为空
     *
     * @return 栈是否为空
     */
    boolean isEmpty();

    /**
     * 往栈中添加元素
     *
     * @param e 待添加元素
     */
    void push(E e);

    /**
     * 弹出栈订元素
     *
     * @return 出栈元素
     */
    E pop();

    /**
     * 获取栈顶元素
     *
     * @return 栈订元素
     */
    E peek();
}
