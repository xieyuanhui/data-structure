package com.xyh.datastructure.queue;

import com.xyh.datastructure.constants.ArrayConstants;
import com.xyh.datastructure.constants.QueueConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @description:
 * @author: LitheLight
 * @createDate: 2020/12/3
 * @modifiedBy:
 */
class LinkedListQueueTest {

    @Test
    void getSize() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        assertEquals(0, queue.getSize());
        queue.enQueue("a");
        assertEquals(1, queue.getSize());
    }

    @Test
    void isEmpty() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        assertTrue(queue.isEmpty());
        queue.enQueue("a");
        assertFalse(queue.isEmpty());
    }

    @Test
    void enQueue() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        assertEquals(0, queue.getSize());
        queue.enQueue("a");
        queue.enQueue("b");
        assertEquals(2, queue.getSize());
        assertEquals("a", queue.getFront());
    }

    @Test
    void deQueue() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enQueue("a");
        queue.enQueue("b");
        assertEquals(2, queue.getSize());
        String del = queue.deQueue();
        assertEquals(1, queue.getSize());
        assertEquals("a", del);
        assertEquals("b", queue.getFront());
        queue.deQueue();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                queue::deQueue, ArrayConstants.THROW_MESSAGE);
        assertEquals(QueueConstants.DEQUEUE_ERROR, exception.getMessage());
    }

    @Test
    void getFront() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enQueue("a");
        queue.enQueue("b");
        assertEquals("a", queue.getFront());
        queue.deQueue();
        queue.deQueue();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                queue::getFront, ArrayConstants.THROW_MESSAGE);
        assertEquals(QueueConstants.GET_ERROR, exception.getMessage());
    }

    @Test
    void testToString() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        assertEquals("LinkedListQueue: front NULL tail", queue.toString());
        queue.enQueue("a");
        queue.enQueue("b");
        assertEquals("LinkedListQueue: front a->b->NULL tail", queue.toString());
    }
}