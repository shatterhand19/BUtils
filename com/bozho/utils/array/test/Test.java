package com.bozho.utils.array.test;

import com.bozho.utils.array.Array;

import java.util.Arrays;

/**
 * Created by Bozhidar Ganev on 16.12.17.
 */
public class Test {
    public static void main(String[] args) {
        Integer[] testGenericArray = new Integer[] {1, 2, 3, 6, 3, 2, 6, 7};
        System.out.println(Arrays.toString(Array.remove(testGenericArray, 3, Integer.class)));
        System.out.println(Arrays.toString(Array.remove(testGenericArray, 1, Integer.class)));
        System.out.println(Arrays.toString(Array.remove(testGenericArray, 7, Integer.class)));

        Integer[] newArray = Array.remove(testGenericArray, 3, Integer.class);
        System.out.println(Arrays.toString(newArray));
        System.out.println(newArray[0] instanceof Integer);
    }
}
