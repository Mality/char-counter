package com.example.counter.cache;

public interface LRUCacheProvider<K, V> {

    V put(K key, V value);

    V get(Object key);

    boolean containsKey(Object key);
}
