package com.xyh.datastructure.utils;

import com.xyh.datastructure.array.Array;

/**
 * @description: 通用方法
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
public class CommonMethods<E> {

    /**
     * 基于Java自带数组的数据结构转字符串
     *
     * @param data 带转换数组
     * @param size 数组中元素数量
     * @param name 数据结构名称
     * @return 字符串
     */
    public String sysArrayToString(E[] data, int size, int length, String name) {
        StringBuilder res = new StringBuilder();
        res.append(String.format("%s: size = %d, capacity = %d%n", name, size, length));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    /**
     * 基于自封装数组的数据结构转字符串
     *
     * @param array 自封装数组
     * @param name 数据结构名称
     * @return 字符串
     */
    public String arrayToString(Array array, String name) {
        StringBuilder res = new StringBuilder();
        res.append(String.format("%s: size = %d, capacity = %d%n", name, array.size(), array.getCapacity()));
        res.append('[');
        for (int i = 0; i < array.size(); i++) {
            res.append(array.get(i));
            if (i != array.size() - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
