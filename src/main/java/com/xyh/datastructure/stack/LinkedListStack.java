package com.xyh.datastructure.stack;

import com.xyh.datastructure.list.LinkedList;

/**
 * @description: 自封装基于链表的栈
 * @author: LitheLight
 * @createDate: 2020/12/3
 * @modifiedBy:
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E pop() {
        return linkedList.removeLast();
    }

    @Override
    public E peek() {
        return linkedList.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedListStack: top ");
        res.append(linkedList);
        return res.toString();
    }
}
