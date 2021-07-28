package com.example.counter.validator;

public class StringValidator {

    public void validateString(String string) {
        if (string == null) {
            throw new IllegalArgumentException("String is null");
        }
        if (string.isEmpty()) {
            throw new IllegalArgumentException("String is empty");
        }
    }
}
