package com.xyh.datastructure.queue;

import com.xyh.datastructure.constants.ArrayConstants;
import com.xyh.datastructure.constants.QueueConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @description: 自封装循环队列测试类
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
class LoopQueueTest {

    @Test
    void getCapacity() {
        LoopQueue<String> loopQueue = new LoopQueue<>();
        assertEquals(10, loopQueue.getCapacity());
        loopQueue = new LoopQueue<>(16);
        assertEquals(16, loopQueue.getCapacity());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LoopQueue<String>(-1), ArrayConstants.THROW_MESSAGE);
        assertEquals(ArrayConstants.CONSTRUCT_ERROR, exception.getMessage());
    }

    @Test
    void getSize() {
        LoopQueue<String> loopQueue = new LoopQueue<>();
        assertEquals(0, loopQueue.getSize());
        loopQueue.enQueue("a");
        assertEquals(1, loopQueue.getSize());
    }

    @Test
    void isEmpty() {
        LoopQueue<String> loopQueue = new LoopQueue<>();
        assertTrue(loopQueue.isEmpty());
        loopQueue.enQueue("a");
        assertFalse(loopQueue.isEmpty());
    }

    @Test
    void enQueue() {
        LoopQueue<String> loopQueue = new LoopQueue<>(1);
        assertEquals(0, loopQueue.getSize());
        loopQueue.enQueue("a");
        assertEquals(1, loopQueue.getSize());
        loopQueue.enQueue("b");
        assertEquals(2, loopQueue.getSize());
    }

    @Test
    void deQueue() {
        LoopQueue<String> loopQueue = new LoopQueue<>();
        loopQueue.enQueue("a");
        loopQueue.enQueue("b");
        assertEquals(2, loopQueue.getSize());
        String res = loopQueue.deQueue();
        assertEquals(1, loopQueue.getSize());
        assertEquals("a", res);
        loopQueue.deQueue();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                loopQueue::deQueue, ArrayConstants.THROW_MESSAGE);
        assertEquals(QueueConstants.DEQUEUE_ERROR, exception.getMessage());
    }

    @Test
    void getFront() {
        LoopQueue<String> loopQueue = new LoopQueue<>();
        loopQueue.enQueue("a");
        loopQueue.enQueue("b");
        assertEquals("a", loopQueue.getFront());
        loopQueue.deQueue();
        loopQueue.deQueue();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                loopQueue::getFront, ArrayConstants.THROW_MESSAGE);
        assertEquals(QueueConstants.GET_ERROR, exception.getMessage());
    }

    @Test
    void testToString() {
        LoopQueue<String> loopQueue = new LoopQueue<>();
        assertEquals(String.format("LoopQueue: size = 0, capacity = 10%nfront [] tail"), loopQueue.toString());
        loopQueue.enQueue("a");
        loopQueue.enQueue("b");
        assertEquals(String.format("LoopQueue: size = 2, capacity = 10%nfront [a, b] tail"), loopQueue.toString());
    }
}