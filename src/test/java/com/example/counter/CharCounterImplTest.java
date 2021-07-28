package com.example.counter;

import com.example.counter.cache.LRUCacheProvider;
import com.example.counter.domain.CharStatistic;
import com.example.counter.domain.StringStatistic;
import com.example.counter.provider.StringStatisticProvider;
import com.example.counter.provider.StringStatisticViewProvider;
import com.example.counter.validator.StringValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CharCounterImplTest {

    @Mock
    StringStatisticProvider mockedStringStatisticProvider;

    @Mock
    StringStatisticViewProvider mockedStringStatisticViewProvider;

    @Mock
    LRUCacheProvider<String, String> mockedLRUCacheProvider;

    @Mock
    StringValidator mockedStringValidator;

    @InjectMocks
    CharCounterImpl charCounter;

    @Test
    void countCharsShouldReturnResultWhenSunnyDay() {
        String string = "How are you?";
        String expected = "How are you?\n" +
                "\"H\" - 1\n" +
                "\"o\" - 2\n" +
                "\"w\" - 1\n" +
                "\" \" - 2\n" +
                "\"a\" - 1\n" +
                "\"r\" - 1\n" +
                "\"e\" - 1\n" +
                "\"y\" - 1\n" +
                "\"u\" - 1\n" +
                "\"?\" - 1\n";

        when(mockedLRUCacheProvider.containsKey(string)).thenReturn(false);

        List<CharStatistic> charStatistics = new ArrayList<>();
        charStatistics.add(new CharStatistic('H', 1));
        charStatistics.add(new CharStatistic('o', 2));
        charStatistics.add(new CharStatistic('w', 1));
        charStatistics.add(new CharStatistic(' ', 2));
        charStatistics.add(new CharStatistic('a', 1));
        charStatistics.add(new CharStatistic('r', 1));
        charStatistics.add(new CharStatistic('e', 1));
        charStatistics.add(new CharStatistic('y', 1));
        charStatistics.add(new CharStatistic('u', 1));

        StringStatistic stringStatistic = new StringStatistic(string, charStatistics);

        when(mockedStringStatisticProvider.provideStringStatistic(string)).thenReturn(stringStatistic);
        when(mockedStringStatisticViewProvider.provideView(stringStatistic)).thenReturn(expected);

        String actual = charCounter.countChars(string);

        assertSame(expected, actual);

        verify(mockedLRUCacheProvider).put(string, expected);
    }

    @Test
    void countCharsShouldReturnResultWhenCachedString() {
        String string = "How are you?";
        String expected = "How are you?\n" +
                "\"H\" - 1\n" +
                "\"o\" - 2\n" +
                "\"w\" - 1\n" +
                "\" \" - 2\n" +
                "\"a\" - 1\n" +
                "\"r\" - 1\n" +
                "\"e\" - 1\n" +
                "\"y\" - 1\n" +
                "\"u\" - 1\n" +
                "\"?\" - 1\n";

        when(mockedLRUCacheProvider.containsKey(string)).thenReturn(true);
        when(mockedLRUCacheProvider.get(string)).thenReturn(expected);

        String actual = charCounter.countChars(string);

        assertSame(expected, actual);

        verify(mockedStringValidator).validateString(string);
        verifyNoInteractions(mockedStringStatisticProvider);
        verifyNoInteractions(mockedStringStatisticViewProvider);
    }

    @Test
    void countCharsShouldThrowIllegalArgumentExceptionWhenIncorrectString() {
        String string = "";

        Exception expected = new IllegalArgumentException("String in empty");
        doThrow(expected).when(mockedStringValidator).validateString(string);

        Exception actual = assertThrows(IllegalArgumentException.class, () ->
                charCounter.countChars(string));

        assertSame(expected, actual);

        verifyNoInteractions(mockedStringStatisticProvider);
        verifyNoInteractions(mockedStringStatisticViewProvider);
        verifyNoInteractions(mockedLRUCacheProvider);
    }
}
