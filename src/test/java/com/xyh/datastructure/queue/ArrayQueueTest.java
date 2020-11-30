package com.xyh.datastructure.queue;

import com.xyh.datastructure.constants.ArrayConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @description: 自封装队列测试类
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
class ArrayQueueTest {

    @Test
    void getCapacity() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        assertEquals(10, arrayQueue.getCapacity());
        arrayQueue = new ArrayQueue<>(16);
        assertEquals(16, arrayQueue.getCapacity());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new ArrayQueue<String>(-1), ArrayConstants.THROW_MESSAGE);
        assertEquals(ArrayConstants.CONSTRUCT_ERROR, exception.getMessage());
    }

    @Test
    void getSize() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        assertEquals(0, arrayQueue.getSize());
        arrayQueue.enQueue("a");
        assertEquals(1, arrayQueue.getSize());
    }

    @Test
    void isEmpty() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        assertTrue(arrayQueue.isEmpty());
        arrayQueue.enQueue("a");
        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    void enQueue() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(1);
        assertEquals(0, arrayQueue.getSize());
        arrayQueue.enQueue("a");
        assertEquals(1, arrayQueue.getSize());
        arrayQueue.enQueue("b");
        assertEquals(2, arrayQueue.getSize());
    }

    @Test
    void deQueue() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        arrayQueue.enQueue("a");
        arrayQueue.enQueue("b");
        assertEquals(2, arrayQueue.getSize());
        String res = arrayQueue.deQueue();
        assertEquals(1, arrayQueue.getSize());
        assertEquals("a", res);
        arrayQueue.deQueue();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                arrayQueue::deQueue, ArrayConstants.THROW_MESSAGE);
        assertEquals(ArrayConstants.REMOVE_ERROR, exception.getMessage());
    }

    @Test
    void getFront() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        arrayQueue.enQueue("a");
        arrayQueue.enQueue("b");
        assertEquals("a", arrayQueue.getFront());
        arrayQueue.deQueue();
        arrayQueue.deQueue();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                arrayQueue::getFront, ArrayConstants.THROW_MESSAGE);
        assertEquals(ArrayConstants.GET_ERROR, exception.getMessage());
    }

    @Test
    void testToString() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        assertEquals(String.format("ArrayQueue: size = 0, capacity = 10%n[]"), arrayQueue.toString());
        arrayQueue.enQueue("a");
        arrayQueue.enQueue("b");
        assertEquals(String.format("ArrayQueue: size = 2, capacity = 10%n[a, b]"), arrayQueue.toString());
    }
}