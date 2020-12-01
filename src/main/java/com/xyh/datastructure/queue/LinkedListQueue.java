package com.xyh.datastructure.queue;

import com.xyh.datastructure.list.LinkedList;

/**
 * @description: 自封装基于链表的队列
 * @author: LitheLight
 * @createDate: 2020/12/1
 * @modifiedBy:
 */
public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> linkedList;

    public LinkedListQueue() {
        linkedList = new LinkedList<E>();
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
    public void enQueue(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E deQueue() {
        return linkedList.removeFirst();
    }

    @Override
    public E getFront() {
        return linkedList.getFirst();
    }
}
