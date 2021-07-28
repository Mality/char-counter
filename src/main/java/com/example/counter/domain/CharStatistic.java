package com.example.counter.domain;

import java.util.Objects;

public class CharStatistic {

    private final char character;
    private final int numberOfOccurrences;

    public CharStatistic(char character, int numberOfOccurrences) {
        this.character = character;
        this.numberOfOccurrences = numberOfOccurrences;
    }

    public char getCharacter() {
        return character;
    }

    public int getNumberOfOccurrences() {
        return numberOfOccurrences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CharStatistic that = (CharStatistic) o;
        return character == that.character && numberOfOccurrences == that.numberOfOccurrences;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, numberOfOccurrences);
    }

    @Override
    public String toString() {
        return "CharStatistic{" +
                "character=" + character +
                ", numberOfOccurrences=" + numberOfOccurrences +
                '}';
    }
}
