package com.bozho.utils.collections;

import java.util.List;

/**
 * Created by Bozhidar Ganev on 15.12.17.
 *
 * This class provides methods for easier work with maps.
 */
public class Map {
    /**
     * Puts an array of keys of type K in a map, adding a default value to each.
     *
     * @param map is the map to which we add keys and values
     * @param keys is the array of keys
     * @param defaultValue is the default value
     * @param <K> is the type of the keys
     * @param <V> is the type of the values
     */
    public static <K, V> void putKeysDefault(java.util.Map<K, V> map, K[] keys, V defaultValue) {
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], defaultValue);
        }
    }

    /**
     * Puts an array of keys of type K in a map, adding a value of type V for each.
     * The values and keys are correspondingly assign : keys[0] - values[0], keys[1] - values[1], etc.
     *
     * If the two arrays are different sizes IllegalArgumentException is thrown.
     * 
     * @param map is the map to which we add keys and values
     * @param keys is the array of keys
     * @param values is the array of values
     * @param <K> is the type of the keys
     * @param <V> is the type of the values
     */
    public static <K, V> void putKeysValues(java.util.Map<K, V> map, K[] keys, V[] values) {
        if (keys.length != values.length) throw new IllegalArgumentException("The keys and the values arrays have different sizes");
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
    }

    /**
     * Puts a list of keys of type K in a map, adding a default value to each.
     *
     * @param map is the map to which we add keys and values
     * @param keys is the list of keys
     * @param defaultValue is the default value
     * @param <K> is the type of the keys
     * @param <V> is the type of the values
     */
    public static <K, V> void putKeysDefault(java.util.Map<K, V> map, List<K> keys, V defaultValue) {
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), defaultValue);
        }
    }

    /**
     * Puts an list of keys of type K in a map, adding a value of type V for each.
     * The values and keys are correspondingly assign : keys.get(0) - values.get(0), keys.get(1) - values.get(1), etc.
     *
     * If the two lists are different sizes IllegalArgumentException is thrown.
     *
     * @param map is the map to which we add keys and values
     * @param keys is the list of keys
     * @param values is the list of values
     * @param <K> is the type of the keys
     * @param <V> is the type of the values
     */
    public static <K, V> void putKeysDefault(java.util.Map<K, V> map, List<K> keys, List<V> values) {
        if (keys.size() != values.size()) throw new IllegalArgumentException("The keys and the values lists have different sizes");
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
    }
}
