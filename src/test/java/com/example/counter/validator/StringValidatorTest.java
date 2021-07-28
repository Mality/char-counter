package com.example.counter.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringValidatorTest {

    private final StringValidator stringValidator = new StringValidator();

    @Test
    void validateStringShouldThrowsIllegalArgumentExceptionWhenStringIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                stringValidator.validateString(null));
        assertEquals("String is null", exception.getMessage());
    }

    @Test
    void validateStringShouldThrowsIllegalArgumentExceptionWhenStringIsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                stringValidator.validateString(""));
        assertEquals("String is empty", exception.getMessage());
    }

    @Test
    void validateStringShouldNotThrowsExceptionWhenStringNotForbidden() {
        assertDoesNotThrow(() -> stringValidator.validateString("abc"));
    }
}
