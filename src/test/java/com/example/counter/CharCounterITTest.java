package com.example.counter;

import com.example.counter.cache.LRUCacheProviderImpl;
import com.example.counter.provider.StringStatisticProvider;
import com.example.counter.provider.StringStatisticProviderImpl;
import com.example.counter.provider.StringStatisticViewProvider;
import com.example.counter.provider.StringStatisticViewProviderImpl;
import com.example.counter.validator.StringValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharCounterITTest {

    CharCounter charCounter;

    @BeforeEach
    void initCharCounter() {
        StringStatisticProvider stringStatisticProvider = new StringStatisticProviderImpl();
        StringStatisticViewProvider stringStatisticViewProvider = new StringStatisticViewProviderImpl();
        LRUCacheProviderImpl<String, String> lruCacheProvider = new LRUCacheProviderImpl<>(10);
        StringValidator stringValidator = new StringValidator();
        charCounter = new CharCounterImpl(stringStatisticProvider,
                stringStatisticViewProvider,
                lruCacheProvider,
                stringValidator);
    }

    @Test
    void countCharsShouldReturnResultWhen1AlphabeticSymbol() {
        String string = "p";
        String expected = "p\n" +
                "\"p\" - 1\n";

        String actual = charCounter.countChars(string);
        
        assertEquals(expected, actual);
    }

    @Test
    void countCharsShouldReturnResultWhen1NonAlphabeticSymbol() {
        String string = ".";
        String expected = ".\n" +
                "\".\" - 1\n";

        String actual = charCounter.countChars(string);

        assertEquals(expected, actual);
    }

    @Test
    void countCharsShouldReturnResultWhen1NumericSymbol() {
        String string = "4";
        String expected = "4\n" +
                "\"4\" - 1\n";

        String actual = charCounter.countChars(string);

        assertEquals(expected, actual);
    }

    @Test
    void countCharsShouldReturnResultWhen2AlphabeticAndNumericSymbols() {
        String string = "0h";
        String expected = "0h\n" +
                "\"0\" - 1\n" +
                "\"h\" - 1\n";

        String actual = charCounter.countChars(string);

        assertEquals(expected, actual);
    }

    @Test
    void countCharsShouldReturnResultWhenLength2() {
        String string = "/l";
        String expected = "/l\n" +
                "\"/\" - 1\n" +
                "\"l\" - 1\n";

        String actual = charCounter.countChars(string);

        assertEquals(expected, actual);
    }

    @Test
    void countCharsShouldReturnResultWhen2SameSymbols() {
        String string = "aa";
        String expected = "aa\n" +
                "\"a\" - 2\n";

        String actual = charCounter.countChars(string);

        assertEquals(expected, actual);
    }

    @Test
    void countCharsShouldReturnResultWhenLength3() {
        String string = "d2o";
        String expected = "d2o\n" +
                "\"d\" - 1\n" +
                "\"2\" - 1\n" +
                "\"o\" - 1\n";

        String actual = charCounter.countChars(string);

        assertEquals(expected, actual);
    }

    @Test
    void countCharsShouldReturnResultWhenLength5() {
        String string = "'d22d";
        String expected = "'d22d\n" +
                "\"'\" - 1\n" +
                "\"d\" - 2\n" +
                "\"2\" - 2\n";

        String actual = charCounter.countChars(string);

        assertEquals(expected, actual);
    }

    @Test
    void countCharsShouldReturnResultWhenLength12() {
        String string = "hello world!";
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

        String actual = charCounter.countChars(string);

        assertEquals(expected, actual);
    }

    @Test
    void countCharsShouldReturnResultWhenLength19() {
        String string = "junit5 tests assert";
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

        String actual = charCounter.countChars(string);

        assertEquals(expected, actual);
    }

    @Test
    void countCharsShouldReturnResultWhenCached() {
        String string1 = "fg.ddm3fgg9";
        String string2 = ";vmsd.d.mm/4";
        String string3 = "..fg/df.fjj";

        charCounter.countChars(string1);
        charCounter.countChars(string2);
        charCounter.countChars(string3);

        String expected = ";vmsd.d.mm/4\n" +
                "\";\" - 1\n" +
                "\"v\" - 1\n" +
                "\"m\" - 3\n" +
                "\"s\" - 1\n" +
                "\"d\" - 2\n" +
                "\".\" - 2\n" +
                "\"/\" - 1\n" +
                "\"4\" - 1\n";

        String actual = charCounter.countChars(string2);

        assertEquals(expected, actual);
    }
}
