package com.example.ceramics.util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Utility class to handle data utilizing Streams
 */
public class DataUtils {

    /*
    Basic: Given a List<Integer>, return a new list containing only even numbers.
    */
    public List<Integer> evenNumbers(List<Integer> elements) {

        return elements.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
    }

    /*
    Basic: Given a List<String>, convert all strings to uppercase.
    */
    public List<String> toUpperCase(List<String> elements) {
        return elements.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList());
    }

    /*
    Basic: Given a List<Integer> and a value x, count how many numbers are greater than x.
    */
    public int countNumbers(List<Integer> elements, int x) {
        return (int) elements.stream()
                .filter(a -> a > x)
                .count();
    }

    /*
    Basic: Given an int[], compute the sum of all numbers using streams.
    */
    public int sumOfNumbers(int[] elements) {
        return Arrays.stream(elements).sum();
    }

    /*
    Basic: Given a List<String>, remove all empty ("") strings.
    */
    public List<String> removeAllEmptyStrings(List<String> elements) {
        return elements.stream()
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toList());
    }


    /*
    Intermediate: Given a Set<Integer>, return a List<Integer> containing the square of each number.
    */
    public List<Integer> squaredNumbers(Set<Integer> elements) {
        return elements.stream()
                .sorted()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }

    /*
    Given a List<String>, find the longest string.
    */
    public String getLongestString(List<String> elements) {
        Optional<String> result = elements.stream()
                .max(Comparator.comparing(s -> s.length()));
        return result.isPresent() ? result.get() : "";
    }
}