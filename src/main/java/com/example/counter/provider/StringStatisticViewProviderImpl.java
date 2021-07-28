package com.example.counter.provider;

import com.example.counter.domain.CharStatistic;
import com.example.counter.domain.StringStatistic;

import java.util.List;

public class StringStatisticViewProviderImpl implements StringStatisticViewProvider {

    private static final String LINE_FORMAT = "\"%s\" - %d\n";

    public String provideView(StringStatistic stringStatistic) {
        String string = stringStatistic.getString();
        List<CharStatistic> charStatistics = stringStatistic.getCharStatistics();
        StringBuilder statisticView = new StringBuilder(string + '\n');

        charStatistics.forEach((charStatistic ->
                statisticView.append(String.format(LINE_FORMAT,
                        charStatistic.getCharacter(),
                        charStatistic.getNumberOfOccurrences()))));

        return statisticView.toString();
    }
}
