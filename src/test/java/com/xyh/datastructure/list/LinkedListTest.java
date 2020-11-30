package com.xyh.datastructure.list;

import com.xyh.datastructure.constants.ArrayConstants;
import com.xyh.datastructure.constants.ListConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @description: 自封装链表测试类
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
class LinkedListTest {

    @Test
    void getSize() {
        LinkedList<String> linkedList = new LinkedList<>();
        assertEquals(0, linkedList.getSize());
        linkedList.addLast("a");
        assertEquals(1, linkedList.getSize());
    }

    @Test
    void isEmpty() {
        LinkedList<String> linkedList = new LinkedList<>();
        assertTrue(linkedList.isEmpty());
        linkedList.addLast("a");
        assertFalse(linkedList.isEmpty());
    }

    @Test
    void add() {
        LinkedList<String> linkedList = new LinkedList<>();
        assertTrue(linkedList.isEmpty());
        linkedList.add(0, "a");
        linkedList.add(1, "b");
        assertEquals(2, linkedList.getSize());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> linkedList.add(3, "c"), ArrayConstants.THROW_MESSAGE);
        assertEquals(ListConstants.ADD_ERROR, exception.getMessage());
    }

    @Test
    void addFirst() {
        LinkedList<String> linkedList = new LinkedList<>();
        assertTrue(linkedList.isEmpty());
        linkedList.addFirst("a");
        linkedList.addFirst("b");
        assertEquals(2, linkedList.getSize());
        assertEquals("b", linkedList.getFirst());
    }

    @Test
    void addLast() {
        LinkedList<String> linkedList = new LinkedList<>();
        assertTrue(linkedList.isEmpty());
        linkedList.addLast("a");
        linkedList.addLast("b");
        assertEquals(2, linkedList.getSize());
        assertEquals("a", linkedList.getFirst());
    }

    @Test
    void get() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("a");
        linkedList.addLast("b");
        assertEquals("a", linkedList.get(0));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> linkedList.get(3), ArrayConstants.THROW_MESSAGE);
        assertEquals(ListConstants.GET_ERROR, exception.getMessage());
    }

    @Test
    void getFirst() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("a");
        linkedList.addLast("b");
        assertEquals("a", linkedList.getFirst());
    }

    @Test
    void getLast() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("a");
        linkedList.addLast("b");
        assertEquals("b", linkedList.getLast());
    }

    @Test
    void set() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("a");
        linkedList.addLast("b");
        linkedList.set(1, "c");
        assertEquals("c", linkedList.getLast());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> linkedList.set(3, "c"), ArrayConstants.THROW_MESSAGE);
        assertEquals(ListConstants.SET_ERROR, exception.getMessage());
    }

    @Test
    void contains() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("a");
        linkedList.addLast("b");
        assertTrue(linkedList.contains("a"));
        assertFalse(linkedList.contains("c"));
    }

    @Test
    void remove() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("a");
        linkedList.addLast("b");
        assertEquals(2, linkedList.getSize());
        linkedList.remove(0);
        assertEquals(1, linkedList.getSize());
        assertEquals("b", linkedList.get(0));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> linkedList.remove(3), ArrayConstants.THROW_MESSAGE);
        assertEquals(ListConstants.REMOVE_ERROR, exception.getMessage());
    }

    @Test
    void removeFirst() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("a");
        linkedList.addLast("b");
        assertEquals(2, linkedList.getSize());
        linkedList.removeFirst();
        assertEquals(1, linkedList.getSize());
        assertEquals("b", linkedList.getFirst());
    }

    @Test
    void removeLast() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("a");
        linkedList.addLast("b");
        assertEquals(2, linkedList.getSize());
        linkedList.removeLast();
        assertEquals(1, linkedList.getSize());
        assertEquals("a", linkedList.getFirst());
    }

    @Test
    void removeElement() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("a");
        linkedList.addLast("a");
        linkedList.addLast("b");
        assertEquals(3, linkedList.getSize());
        linkedList.removeElement("c");
        assertEquals(3, linkedList.getSize());
        linkedList.removeElement("a");
        assertEquals(2, linkedList.getSize());
    }

    @Test
    void testToString() {
        LinkedList<String> linkedList = new LinkedList<>();
        assertEquals(String.format("LinkedList: size = 0%nNULL"), linkedList.toString());
        linkedList.addLast("a");
        linkedList.addLast("b");
        assertEquals(String.format("LinkedList: size = 2%na->b->NULL"), linkedList.toString());
    }
}