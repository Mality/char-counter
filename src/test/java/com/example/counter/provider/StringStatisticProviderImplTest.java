package com.example.counter.provider;

import com.example.counter.domain.CharStatistic;
import com.example.counter.domain.StringStatistic;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringStatisticProviderImplTest {

    private final StringStatisticProvider stringStatisticProvider = new StringStatisticProviderImpl();

    @Test
    void provideStringStatisticShouldReturnResultWhen1AlphabeticSymbol() {
        String string = "p";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('p', 1));

        StringStatistic expected = new StringStatistic(string, charStatistics);
        StringStatistic actual = stringStatisticProvider.provideStringStatistic(string);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticShouldReturnResultWhen1NonAlphabeticSymbol() {
        String string = ".";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('.', 1));

        StringStatistic expected = new StringStatistic(string, charStatistics);
        StringStatistic actual = stringStatisticProvider.provideStringStatistic(string);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticShouldReturnResultWhen1NumericSymbol() {
        String string = "4";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('4', 1));

        StringStatistic expected = new StringStatistic(string, charStatistics);
        StringStatistic actual = stringStatisticProvider.provideStringStatistic(string);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticShouldReturnResultWhen2AlphabeticAndNumericSymbols() {
        String string = "0h";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('0', 1));
        charStatistics.add(new CharStatistic('h', 1));

        StringStatistic expected = new StringStatistic(string, charStatistics);
        StringStatistic actual = stringStatisticProvider.provideStringStatistic(string);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticShouldReturnResultWhenLength2() {
        String string = "/l";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('/', 1));
        charStatistics.add(new CharStatistic('l', 1));

        StringStatistic expected = new StringStatistic(string, charStatistics);
        StringStatistic actual = stringStatisticProvider.provideStringStatistic(string);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticShouldReturnResultWhen2SameSymbols() {
        String string = "aa";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('a', 2));

        StringStatistic expected = new StringStatistic(string, charStatistics);
        StringStatistic actual = stringStatisticProvider.provideStringStatistic(string);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticShouldReturnResultWhenLength3() {
        String string = "d2o";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('d', 1));
        charStatistics.add(new CharStatistic('2', 1));
        charStatistics.add(new CharStatistic('o', 1));

        StringStatistic expected = new StringStatistic(string, charStatistics);
        StringStatistic actual = stringStatisticProvider.provideStringStatistic(string);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticShouldReturnResultWhenLength5() {
        String string = "'d22d";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('\'', 1));
        charStatistics.add(new CharStatistic('d', 2));
        charStatistics.add(new CharStatistic('2', 2));

        StringStatistic expected = new StringStatistic(string, charStatistics);
        StringStatistic actual = stringStatisticProvider.provideStringStatistic(string);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticShouldReturnResultWhenLength12() {
        String string = "hello world!";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('h', 1));
        charStatistics.add(new CharStatistic('e', 1));
        charStatistics.add(new CharStatistic('l', 3));
        charStatistics.add(new CharStatistic('o', 2));
        charStatistics.add(new CharStatistic(' ', 1));
        charStatistics.add(new CharStatistic('w', 1));
        charStatistics.add(new CharStatistic('r', 1));
        charStatistics.add(new CharStatistic('d', 1));
        charStatistics.add(new CharStatistic('!', 1));

        StringStatistic expected = new StringStatistic(string, charStatistics);
        StringStatistic actual = stringStatisticProvider.provideStringStatistic(string);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticShouldReturnResultWhenLength19() {
        String string = "junit5 tests assert";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('j', 1));
        charStatistics.add(new CharStatistic('u', 1));
        charStatistics.add(new CharStatistic('n', 1));
        charStatistics.add(new CharStatistic('i', 1));
        charStatistics.add(new CharStatistic('t', 4));
        charStatistics.add(new CharStatistic('5', 1));
        charStatistics.add(new CharStatistic(' ', 2));
        charStatistics.add(new CharStatistic('e', 2));
        charStatistics.add(new CharStatistic('s', 4));
        charStatistics.add(new CharStatistic('a', 1));
        charStatistics.add(new CharStatistic('r', 1));

        StringStatistic expected = new StringStatistic(string, charStatistics);
        StringStatistic actual = stringStatisticProvider.provideStringStatistic(string);

        assertEquals(expected, actual);
    }
}
