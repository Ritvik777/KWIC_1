package com.company.adt.input;

import java.util.Arrays;
import java.util.List;

/**
 * Represenrs a line that consists of a ist of words.
 */
public class Line {

    private List<String> words;

    public Line(String line) {
        words = Arrays.asList(line.split(" "));
    }

    /**
     * Returns the word at 0-based position {@code index} in {@code this} line.
     * @param index 0-based index of the word in the line.
     * @return String representing the word at position {@code} index.
     */
    public String getWord(int index) {
        return words.get(index);
    }

    /**
     * Returns the number of words in {@code this} line.
     * @return Integer count of the number of words that make up {@code this} line.
     */
    public int getNumberOfWords() {
        return words.size();
    }
}
