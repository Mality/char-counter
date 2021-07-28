package com.example.counter;

import com.example.counter.cache.LRUCacheProvider;
import com.example.counter.cache.LRUCacheProviderImpl;
import com.example.counter.provider.StringStatisticProvider;
import com.example.counter.provider.StringStatisticProviderImpl;
import com.example.counter.provider.StringStatisticViewProvider;
import com.example.counter.provider.StringStatisticViewProviderImpl;
import com.example.counter.validator.StringValidator;

public class CharCounterConsoleApplication {

    private static final int CACHE_CAPACITY = 100;

    public static void main(String[] args) {
        String string = "How are you?";

        StringStatisticProvider stringStatisticProvider = new StringStatisticProviderImpl();
        StringStatisticViewProvider stringStatisticViewProvider = new StringStatisticViewProviderImpl();
        LRUCacheProvider<String, String> lruCacheProvider = new LRUCacheProviderImpl<>(CACHE_CAPACITY);
        StringValidator stringValidator = new StringValidator();
        CharCounter charCounter = new CharCounterImpl(stringStatisticProvider,
                stringStatisticViewProvider,
                lruCacheProvider,
                stringValidator);

        System.out.println(charCounter.countChars(string));
    }
}
