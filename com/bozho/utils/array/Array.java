package com.bozho.utils.array;

/**
 * Created by Bozhidar Ganev on 16.12.17.
 *
 * This class provides a wrapper around common operations done to arrays.
 */
public class Array {
    /**
     * This method removes an element from a non-primitive type array.
     * If the element is not present it returns the same array.
     * If the element is present it removes the first occurrence.
     *
     * The method is used like this:
     * Integer[] testArray = new Integer[]{1, 2, 3};
     * Integer[] newArray = Array.remove(testArray, 2, Integer.class); //newArray = [1, 3];
     *
     * @param array is the array from which we will remove elements
     * @param e is the element to be removed
     * @param c is the class of the array and the element
     * @param <T> is the type of the array and element
     * @return the resulting array
     */
    public static <T> T[] remove(T[] array, T e, Class<T> c) {
        int i = 0;
        for(; i < array.length; i ++)
            if (array[i].equals(e))
                break;

        if (i == array.length) return array;
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) java.lang.reflect.Array.newInstance(c, array.length - 1);
        System.arraycopy(array, 0, newArray, 0, i);
        System.arraycopy(array, i + 1, newArray, i, array.length - i - 1);
        return newArray;
    }
}
