package com.xyh.datastructure.list;


import com.xyh.datastructure.constants.ListConstants;

/**
 * @description: 自封装链表
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
public class LinkedList<E> {

    /**
     * 链表节点类
     */
    private class Node {
        /**
         * 节点元素
         */
        E e;
        /**
         * 下一个节点
         */
        Node next;

        /**
         * 带参构造函数
         *
         * @param e 节点元素
         * @param next 下一个节点
         */
        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        /**
         * 带参构造函数
         *
         * @param e 节点元素
         */
        Node(E e) {
            this(e, null);
        }

        /**
         * 无参构造函数
         */
        Node() {
            this(null, null);
        }

        /**
         * 节点转字符串
         *
         * @return 字符串
         */
        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 脏节点，放置于头节点前面，方便对头节点操作
     */
    private Node dummyHead;
    /**
     * 链表节点数量
     */
    private int size;

    /**
     * 构造函数
     */
    public LinkedList() {
        this.dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取链表元素数量
     *
     * @return 链表元素数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return 链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 链表指定索引处添加元素
     *
     * @param index 链表索引
     * @param e 待添加元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(ListConstants.ADD_ERROR);
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;
    }

    /**
     * 链表表头添加元素
     *
     * @param e 待添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 链表表尾添加元素
     *
     * @param e 待添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表指定索引处元素
     *
     * @param index 链表索引
     * @return 链表元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(ListConstants.GET_ERROR);
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表表头元素
     *
     * @return 链表表头元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表表尾元素
     *
     * @return 链表表尾元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表指定索引处元素
     *
     * @param index 链表索引
     * @param e 修改元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(ListConstants.SET_ERROR);
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 判断链表是否包含某个元素
     *
     * @param e 查找元素
     * @return 是否包含查找元素
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除链表指定索引处元素
     * @param index 链表索引
     * @return 删除元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(ListConstants.REMOVE_ERROR);
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node del = pre.next;
        pre.next = del.next;
        del.next = null;
        size--;
        return del.e;
    }

    /**
     * 删除链表表头元素
     *
     * @return 删除元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链表表头元素
     *
     * @return 删除元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除链表第一次出现的指定元素
     *
     * @param e 指定元素
     */
    public void removeElement(E e) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.e.equals(e)) {
                break;
            }
            pre = pre.next;
        }
        if (pre.next != null) {
            Node del = pre.next;
            pre.next = del.next;
            del.next = null;
            size--;
        }
    }

    /**
     * 自封装链表转字符串
     *
     * @return 字符串
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinkedList: size = %d%n", size));
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
