package com.example.counter.provider;

import com.example.counter.domain.StringStatistic;

public interface StringStatisticProvider {

    StringStatistic provideStringStatistic(String string);
}
