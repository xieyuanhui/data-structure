package com.xyh.datastructure.utils;

import com.xyh.datastructure.array.Array;

/**
 * @description: 通用方法
 * @author: LitheLight
 * @createDate: 2020/11/30
 * @modifiedBy:
 */
public class CommonMethods {
    /**
     * 通用基于数组数据结构转字符串
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
