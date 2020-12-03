package com.xyh.datastructure.stack;

import com.xyh.datastructure.constants.ArrayConstants;
import com.xyh.datastructure.constants.ListConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @description: 自封装基于链表的栈测试类
 * @author: LitheLight
 * @createDate: 2020/12/3
 * @modifiedBy:
 */
class LinkedListStackTest {

    @Test
    void getSize() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        assertEquals(0, stack.getSize());
        stack.push("a");
        assertEquals(1, stack.getSize());
    }

    @Test
    void isEmpty() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        assertTrue(stack.isEmpty());
        stack.push("a");
        assertFalse(stack.isEmpty());
    }

    @Test
    void push() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        assertEquals(0, stack.getSize());
        stack.push("a");
        stack.push("b");
        assertEquals(2, stack.getSize());
    }

    @Test
    void pop() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("a");
        stack.push("b");
        assertEquals(2, stack.getSize());
        String del = stack.pop();
        assertEquals(1, stack.getSize());
        assertEquals("b", del);
        stack.pop();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                stack::pop, ArrayConstants.THROW_MESSAGE);
        assertEquals(ListConstants.REMOVE_ERROR, exception.getMessage());
    }

    @Test
    void peek() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("a");
        stack.push("b");
        assertEquals("b", stack.peek());
        stack.pop();
        stack.pop();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                stack::peek, ArrayConstants.THROW_MESSAGE);
        assertEquals(ListConstants.GET_ERROR, exception.getMessage());
    }

    @Test
    void testToString() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        assertEquals("LinkedListStack: top " + String.format("LinkedList: size = 0%nNULL"), stack.toString());
        stack.push("a");
        stack.push("b");
        assertEquals("LinkedListStack: top " + String.format("LinkedList: size = 2%na->b->NULL"), stack.toString());
    }
}