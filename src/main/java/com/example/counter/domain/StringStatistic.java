package com.example.counter.domain;

import java.util.List;
import java.util.Objects;

public class StringStatistic {

    private final String string;
    private final List<CharStatistic> charStatistics;

    public StringStatistic(String string, List<CharStatistic> charStatistics) {
        this.string = string;
        this.charStatistics = charStatistics;
    }

    public String getString() {
        return string;
    }

    public List<CharStatistic> getCharStatistics() {
        return charStatistics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StringStatistic that = (StringStatistic) o;
        return Objects.equals(string, that.string) &&
                Objects.equals(charStatistics, that.charStatistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string, charStatistics);
    }

    @Override
    public String toString() {
        return "StringStatistic{" +
                "string='" + string + '\'' +
                ", characterStatistics=" + charStatistics +
                '}';
    }
}
