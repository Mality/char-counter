package com.example.counter.provider;

import com.example.counter.domain.CharStatistic;
import com.example.counter.domain.StringStatistic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StringStatisticProviderImpl implements StringStatisticProvider {

    public StringStatistic provideStringStatistic(String string) {
        List<CharStatistic> charStatistics = provideCharStatistics(string);
        return new StringStatistic(string, charStatistics);
    }

    private List<CharStatistic> provideCharStatistics(String string) {
        Map<Character, Integer> charOccurrences = new LinkedHashMap<>();

        string.chars().forEach(curChar -> charOccurrences.merge((char) curChar, 1, Integer::sum));

        List<CharStatistic> charStatistics = new ArrayList<>();
        charOccurrences.forEach((key, value) -> charStatistics.add(new CharStatistic(key, value)));
        return charStatistics;
    }
}
