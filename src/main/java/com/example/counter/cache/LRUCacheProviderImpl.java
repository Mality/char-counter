package com.example.counter.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCacheProviderImpl<K, V> extends LinkedHashMap<K, V> implements LRUCacheProvider<K, V> {

    private final int capacity;

    public LRUCacheProviderImpl(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        LRUCacheProviderImpl<?, ?> that = (LRUCacheProviderImpl<?, ?>) o;
        return capacity == that.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity);
    }
}
