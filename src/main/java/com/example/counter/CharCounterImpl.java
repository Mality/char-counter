package com.example.counter;

import com.example.counter.cache.LRUCacheProvider;
import com.example.counter.domain.StringStatistic;
import com.example.counter.provider.StringStatisticProvider;
import com.example.counter.provider.StringStatisticViewProvider;
import com.example.counter.validator.StringValidator;

public class CharCounterImpl implements CharCounter {

    private final StringStatisticProvider stringStatisticProvider;
    private final StringStatisticViewProvider stringStatisticViewProvider;
    private final LRUCacheProvider<String, String> lruCacheProvider;
    private final StringValidator stringValidator;

    public CharCounterImpl(StringStatisticProvider stringStatisticProvider,
                           StringStatisticViewProvider stringStatisticViewProvider,
                           LRUCacheProvider<String, String> lruCacheProvider,
                           StringValidator stringValidator) {
        this.stringStatisticProvider = stringStatisticProvider;
        this.stringStatisticViewProvider = stringStatisticViewProvider;
        this.lruCacheProvider = lruCacheProvider;
        this.stringValidator = stringValidator;
    }

    public String countChars(String string) {
        stringValidator.validateString(string);

        String stringStatisticView;
        if (lruCacheProvider.containsKey(string)) {
            stringStatisticView = lruCacheProvider.get(string);
        } else {
            StringStatistic stringStatistic = stringStatisticProvider.provideStringStatistic(string);
            stringStatisticView = stringStatisticViewProvider.provideView(stringStatistic);
        }

        lruCacheProvider.put(string, stringStatisticView);

        return stringStatisticView;
    }
}
