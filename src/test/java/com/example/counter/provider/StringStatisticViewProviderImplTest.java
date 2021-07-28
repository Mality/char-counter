package com.example.counter.provider;

import com.example.counter.domain.CharStatistic;
import com.example.counter.domain.StringStatistic;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringStatisticViewProviderImplTest {

    private final StringStatisticViewProvider stringStatisticViewProvider = new StringStatisticViewProviderImpl();

    @Test
    void provideStringStatisticViewShouldReturnResultWhen1AlphabeticSymbol() {
        String string = "p";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('p', 1));

        StringStatistic stringStatistic = new StringStatistic(string, charStatistics);

        String expected = "p\n" +
                "\"p\" - 1\n";
        String actual = stringStatisticViewProvider.provideView(stringStatistic);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticViewShouldReturnResultWhen1NonAlphabeticSymbol() {
        String string = ".";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('.', 1));

        StringStatistic stringStatistic = new StringStatistic(string, charStatistics);

        String expected = ".\n" +
                "\".\" - 1\n";
        String actual = stringStatisticViewProvider.provideView(stringStatistic);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticViewShouldReturnResultWhen1NumericSymbol() {
        String string = "4";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('4', 1));

        StringStatistic stringStatistic = new StringStatistic(string, charStatistics);

        String expected = "4\n" +
                "\"4\" - 1\n";
        String actual = stringStatisticViewProvider.provideView(stringStatistic);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticViewShouldReturnResultWhen2AlphabeticAndNumericSymbols() {
        String string = "0h";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('0', 1));
        charStatistics.add(new CharStatistic('h', 1));

        StringStatistic stringStatistic = new StringStatistic(string, charStatistics);

        String expected = "0h\n" +
                "\"0\" - 1\n" +
                "\"h\" - 1\n";
        String actual = stringStatisticViewProvider.provideView(stringStatistic);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticViewShouldReturnResultWhenLength2() {
        String string = "/l";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('/', 1));
        charStatistics.add(new CharStatistic('l', 1));

        StringStatistic stringStatistic = new StringStatistic(string, charStatistics);

        String expected = "/l\n" +
                "\"/\" - 1\n" +
                "\"l\" - 1\n";
        String actual = stringStatisticViewProvider.provideView(stringStatistic);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticViewShouldReturnResultWhen2SameSymbols() {
        String string = "aa";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('a', 2));

        StringStatistic stringStatistic = new StringStatistic(string, charStatistics);

        String expected = "aa\n" +
                "\"a\" - 2\n";
        String actual = stringStatisticViewProvider.provideView(stringStatistic);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticViewShouldReturnResultWhenLength3() {
        String string = "d2o";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('d', 1));
        charStatistics.add(new CharStatistic('2', 1));
        charStatistics.add(new CharStatistic('o', 1));

        StringStatistic stringStatistic = new StringStatistic(string, charStatistics);

        String expected = "d2o\n" +
                "\"d\" - 1\n" +
                "\"2\" - 1\n" +
                "\"o\" - 1\n";
        String actual = stringStatisticViewProvider.provideView(stringStatistic);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticViewShouldReturnResultWhenLength5() {
        String string = "'d22d";

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('\'', 1));
        charStatistics.add(new CharStatistic('d', 2));
        charStatistics.add(new CharStatistic('2', 2));

        StringStatistic stringStatistic = new StringStatistic(string, charStatistics);

        String expected = "'d22d\n" +
                "\"'\" - 1\n" +
                "\"d\" - 2\n" +
                "\"2\" - 2\n";
        String actual = stringStatisticViewProvider.provideView(stringStatistic);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticViewShouldReturnResultWhenLength12() {
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

        StringStatistic stringStatistic = new StringStatistic(string, charStatistics);

        String expected = "hello world!\n" +
                "\"h\" - 1\n" +
                "\"e\" - 1\n" +
                "\"l\" - 3\n" +
                "\"o\" - 2\n" +
                "\" \" - 1\n" +
                "\"w\" - 1\n" +
                "\"r\" - 1\n" +
                "\"d\" - 1\n" +
                "\"!\" - 1\n";
        String actual = stringStatisticViewProvider.provideView(stringStatistic);

        assertEquals(expected, actual);
    }

    @Test
    void provideStringStatisticViewShouldReturnResultWhenLength19() {
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

        StringStatistic stringStatistic = new StringStatistic(string, charStatistics);

        String expected = "junit5 tests assert\n" +
                "\"j\" - 1\n" +
                "\"u\" - 1\n" +
                "\"n\" - 1\n" +
                "\"i\" - 1\n" +
                "\"t\" - 4\n" +
                "\"5\" - 1\n" +
                "\" \" - 2\n" +
                "\"e\" - 2\n" +
                "\"s\" - 4\n" +
                "\"a\" - 1\n" +
                "\"r\" - 1\n";
        String actual = stringStatisticViewProvider.provideView(stringStatistic);

        assertEquals(expected, actual);
    }
}
