package com.xyh.datastructure.stack;

import com.xyh.datastructure.constants.ArrayConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @description: 自封装栈测试类
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
class ArrayStackTest {

    @Test
    void getCapacity() {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        assertEquals(10, arrayStack.getCapacity());
        arrayStack = new ArrayStack<>(16);
        assertEquals(16, arrayStack.getCapacity());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new ArrayStack<Integer>(-1), ArrayConstants.THROW_MESSAGE);
        assertEquals(ArrayConstants.CONSTRUCT_ERROR, exception.getMessage());
    }

    @Test
    void getSize() {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        assertEquals(0, arrayStack.getSize());
        arrayStack.push("a");
        assertEquals(1, arrayStack.getSize());
    }

    @Test
    void isEmpty() {
        ArrayStack<String> arrayStack = new ArrayStack<>(1);
        assertTrue(arrayStack.isEmpty());
        arrayStack.push("a");
        assertFalse(arrayStack.isEmpty());
        arrayStack.push("b");
        assertEquals(2, arrayStack.getSize());
    }

    @Test
    void push() {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        assertTrue(arrayStack.isEmpty());
        arrayStack.push("a");
        assertFalse(arrayStack.isEmpty());
        assertEquals("a", arrayStack.peek());
    }

    @Test
    void pop() {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        assertTrue(arrayStack.isEmpty());
        arrayStack.push("a");
        assertFalse(arrayStack.isEmpty());
        assertEquals("a", arrayStack.pop());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                arrayStack::pop, ArrayConstants.THROW_MESSAGE);
        assertEquals(ArrayConstants.REMOVE_ERROR, exception.getMessage());
    }

    @Test
    void peek() {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        assertTrue(arrayStack.isEmpty());
        arrayStack.push("a");
        assertFalse(arrayStack.isEmpty());
        assertEquals("a", arrayStack.peek());
        arrayStack.pop();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                arrayStack::peek, ArrayConstants.THROW_MESSAGE);
        assertEquals(ArrayConstants.GET_ERROR, exception.getMessage());
    }

    @Test
    void testToString() {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        assertEquals(String.format("ArrayStack: size = 0, capacity = 10%n[]"), arrayStack.toString());
        arrayStack.push("a");
        arrayStack.push("b");
        assertEquals(String.format("ArrayStack: size = 2, capacity = 10%n[a, b]"), arrayStack.toString());
    }
}