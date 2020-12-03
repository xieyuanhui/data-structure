package com.xyh.datastructure.queue;

import com.xyh.datastructure.constants.QueueConstants;

/**
 * @description: 自封装基于链表的队列
 * @author: LitheLight
 * @createDate: 2020/12/1
 * @modifiedBy:
 */
public class LinkedListQueue<E> implements Queue<E> {

    /**
     * 链表节点
     */
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 队首节点
     */
    private Node head;
    /**
     * 队尾节点
     */
    private Node tail;
    /**
     * 队列元素数量
     */
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enQueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException(QueueConstants.DEQUEUE_ERROR);
        }
        Node delNode = head;
        head = head.next;
        delNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException(QueueConstants.GET_ERROR);
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedListQueue: front ");
        Node cur = head;
        while (cur != null) {
            res.append(cur.e).append("->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
