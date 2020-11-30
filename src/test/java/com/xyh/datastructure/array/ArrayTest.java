package com.xyh.datastructure.array;

import com.xyh.datastructure.constants.ArrayConstants;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @description: 自封装数组测试类
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
class ArrayTest {

    private static final Logger logger = Logger.getLogger(ArrayTest.class);

    @BeforeEach
    void setUp() {
        logger.info("----------测试前摇----------");
    }

    @AfterEach
    void tearDown() {
        logger.info("----------测试后摇----------");
    }

    @Test
    void getCapacity() {
        Array<Integer> array = new Array<>(16);
        assertEquals(16, array.getCapacity());
        array = new Array<>();
        assertEquals(10, array.getCapacity());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Array<Integer>(-1),
                ArrayConstants.THROW_MESSAGE);
        assertEquals(ArrayConstants.CONSTRUCT_ERROR, exception.getMessage());
    }

    @Test
    void size() {
        Array<Integer> array = new Array<>(16);
        assertEquals(0, array.size());
        array.addLast(0);
        assertEquals(1, array.size());
    }

    @Test
    void isEmpty() {
        Array<Integer> array = new Array<>();
        assertTrue(array.isEmpty());
        array.addLast(1);
        assertFalse(array.isEmpty());
    }

    @Test
    void add() {
        Array<Integer> array = new Array<>();
        array.add(0, 1);
        array.add(1, 2);
        assertEquals(2, array.size());
        assertEquals(2, array.get(1));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> array.add(3, 3),
                ArrayConstants.THROW_MESSAGE);
        assertEquals(ArrayConstants.ADD_ERROR, exception.getMessage());
    }

    @Test
    void addLast() {
        Array<Integer> array = new Array<>();
        array.addLast(1);
        array.addLast(2);
        assertEquals(2, array.size());
        assertEquals(1, array.get(0));
    }

    @Test
    void addFirst() {
        Array<Integer> array = new Array<>();
        array.addFirst(1);
        array.addFirst(2);
        assertEquals(2, array.size());
        assertEquals(2, array.get(0));
    }

    @Test
    void get() {
        Array<Integer> array = new Array<>();
        array.add(0, 1);
        array.add(1, 2);
        assertEquals(2, array.get(1));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> array.get(3),
                ArrayConstants.THROW_MESSAGE);
        assertEquals(ArrayConstants.GET_ERROR, exception.getMessage());
    }

    @Test
    void getFirst() {
        Array<Integer> array = new Array<>();
        array.add(0, 1);
        array.add(1, 2);
        assertEquals(1, array.getFirst());
    }

    @Test
    void getLast() {
        Array<Integer> array = new Array<>();
        array.add(0, 1);
        array.add(1, 2);
        assertEquals(2, array.getLast());
    }

    @Test
    void set() {
        Array<Integer> array = new Array<>();
        array.add(0, 1);
        array.add(1, 2);
        array.set(0, 3);
        assertEquals(3, array.getFirst());
    }

    @Test
    void find() {
        Array<Integer> array = new Array<>();
        array.add(0, 1);
        array.add(1, 2);
        assertEquals(1, array.find(2));
    }

    @Test
    void contains() {
        Array<Integer> array = new Array<>();
        array.add(0, 1);
        array.add(1, 2);
        assertTrue(array.contains(1));
        assertFalse(array.contains(3));
    }

    @Test
    void remove() {
        Array<Integer> array = new Array<>();
        array.add(0, 1);
        array.add(1, 2);
        Integer res = array.remove(1);
        assertEquals(2, res);
        assertEquals(1, array.size());
    }

    @Test
    void removeFirst() {
        Array<Integer> array = new Array<>();
        array.add(0, 1);
        array.add(1, 2);
        Integer res = array.removeFirst();
        assertEquals(1, res);
        assertEquals(1, array.size());
    }

    @Test
    void removeLast() {
        Array<Integer> array = new Array<>();
        array.add(0, 1);
        array.add(1, 2);
        Integer res = array.removeLast();
        assertEquals(2, res);
        assertEquals(1, array.size());
    }

    @Test
    void testToString() {
        Array<Integer> array = new Array<>();
        array.add(0, 1);
        assertEquals(String.format("Array: size = 1, capacity = 10%nfront [1] tail"), array.toString());
        array.add(1, 2);
        assertEquals(String.format("Array: size = 2, capacity = 10%nfront [1, 2] tail"), array.toString());
    }
}