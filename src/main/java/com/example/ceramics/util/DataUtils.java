package com.example.ceramics.util;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class to handle data utilizing Streams
 */
public class DataUtils {

    /*
    Given a List<Integer>, return a new list containing only even numbers.
    */
    public List<Integer> evenNumbers(List<Integer> elements) {

        return elements.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
    }

    /*
    Given a List<String>, convert all strings to uppercase.
    */
    public List<String> toUpperCase(List<String> elements) {
        return elements.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList());
    }

}
