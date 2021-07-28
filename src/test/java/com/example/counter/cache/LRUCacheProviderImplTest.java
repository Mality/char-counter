package com.example.counter.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LRUCacheProviderImplTest {

    private static final int CACHE_CAPACITY = 3;

    LRUCacheProvider<String, String> lruCacheProvider;

    @BeforeEach
    void init() {
        lruCacheProvider = new LRUCacheProviderImpl<>(CACHE_CAPACITY);
    }

    @Test
    void getShouldReturnResultIf1CachedString() {
        lruCacheProvider.put("d2o", "d2o\n" +
                "\"d\" - 1\n" +
                "\"2\" - 1\n" +
                "\"o\" - 1\n");

        String actual = lruCacheProvider.get("d2o");

        assertEquals("d2o\n" +
                "\"d\" - 1\n" +
                "\"2\" - 1\n" +
                "\"o\" - 1\n", actual);
    }

    @Test
    void getShouldReturnResultIf2CachedStrings() {
        lruCacheProvider.put("0h", "0h\n" +
                "\"0\" - 1\n" +
                "\"h\" - 1\n");
        lruCacheProvider.put("aa", "aa\n" +
                "\"a\" - 2\n");

        String actual = lruCacheProvider.get("aa");

        assertEquals("aa\n" +
                "\"a\" - 2\n", actual);
    }

    @Test
    void putShouldDeleteLastStringsIfExceedCapacity() {
        lruCacheProvider.put("0h", "0h\n" +
                "\"0\" - 1\n" +
                "\"h\" - 1\n");
        lruCacheProvider.put("aa", "aa\n" +
                "\"a\" - 2\n");
        lruCacheProvider.put("d2o", "d2o\n" +
                "\"d\" - 1\n" +
                "\"2\" - 1\n" +
                "\"o\" - 1\n");
        lruCacheProvider.put("4", "4\n" +
                "\"4\" - 1\n");

        assertFalse(lruCacheProvider.containsKey("0h"));
        assertTrue(lruCacheProvider.containsKey("aa"));
    }

    @Test
    void putShouldShouldReplaceCacheIfStringRepeated() {
        lruCacheProvider.put("0h", "0h\n" +
                "\"0\" - 1\n" +
                "\"h\" - 1\n");
        lruCacheProvider.put("aa", "aa\n" +
                "\"a\" - 2\n");
        lruCacheProvider.put("d2o", "d2o\n" +
                "\"d\" - 1\n" +
                "\"2\" - 1\n" +
                "\"o\" - 1\n");
        lruCacheProvider.put("0h", "0h\n" +
                "\"0\" - 1\n" +
                "\"h\" - 1\n");
        lruCacheProvider.put("4", "4\n" +
                "\"4\" - 1\n");

        assertTrue(lruCacheProvider.containsKey("0h"));
        assertFalse(lruCacheProvider.containsKey("aa"));
    }

    @Test
    void containsKeyReturnFalseIfCacheIsEmpty() {
        String string = "abc";

        boolean actual = lruCacheProvider.containsKey(string);

        assertFalse(actual);
    }

    @Test
    void containsKeyShouldReturnFalseIfNoSuchString() {
        lruCacheProvider.put("0h", "0h\n" +
                "\"0\" - 1\n" +
                "\"h\" - 1\n");
        lruCacheProvider.put("aa", "aa\n" +
                "\"a\" - 2\n");

        boolean actual = lruCacheProvider.containsKey("ya");

        assertFalse(actual);
    }

    @Test
    void containsKeyShouldReturnFalseIfContainsSuchString() {
        lruCacheProvider.put("d2o", "d2o\n" +
                "\"d\" - 1\n" +
                "\"2\" - 1\n" +
                "\"o\" - 1\n");
        lruCacheProvider.put("4", "4\n" +
                "\"4\" - 1\n");

        boolean actual = lruCacheProvider.containsKey("d2o");

        assertTrue(actual);
    }
}
