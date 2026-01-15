package com.example.ceramics.util;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.*;
import java.util.stream.Collectors;

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
    Basic - Intermediate: Given a Set<Integer>, return a List<Integer> containing the square of each number.
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

    /*
    Given a List<String>, join them into a single comma-separated string.
    */

    public String joinElements(List<String> elements) {
        return elements.stream()
                .peek(s -> System.out.println(s))
                .collect(Collectors.joining(","));
    }

    /*
    Given a List<Integer> with duplicates, return a Set<Integer> with unique values.
    */
    public Set<Integer> getUniqueValues(List<Integer> elements) {
        return elements.stream()
                .peek(s -> System.out.println(s))
                .collect(Collectors.toSet());
    }

    /*
    Given a List<String>, check if any string starts with "A".
    */

    public boolean anyStartsWithLetterA(List<String> elements) {
        String letter = "A";
        return elements.stream()
                .peek(s -> System.out.println(s))
                .anyMatch(s -> String.valueOf(s.toUpperCase().charAt(0)).equals("A"));
    }

    /*
    Given a List<Person>:

    class Person {
        String name;
        int age;
    }

    Return all persons older than 18.
     */
    @AllArgsConstructor
    @EqualsAndHashCode
    public final class Person {
        String name;
        int age;
    }

    public List<Person> getOldersThan18(List<Person> people) {
        return people.stream()
                .filter(person -> person.age > 18)
                .collect(Collectors.toList());
    }

    /*Average Age
    From a List<Person>, compute the average age.*/

    public Integer getAverageAge(List<Person> personas) {
        return (int) personas.stream()
                .mapToInt(value -> value.age)
                .average()
                .orElse(0.0);
    }

    /*
        Group a List<Person> by age, returning:
        Map<Integer, List<Person>>
    */
    public Map<Integer, List<Person>> groupByAge(List<Person> personas) {
        return personas.stream()
                .collect(Collectors.groupingBy(person -> person.age));
    }

    public void sampleMap() {
        @AllArgsConstructor
        class Student {
            String name;
            Integer age;
        }
        Student student = new Student("John", 1);
        Student student2 = new Student("Charles", 8);
        Student student3 = new Student("Martin", 65);

        /*
        1. Students added to the map as values
         */
       /* Map<Integer, Student> students = new HashMap<>();

        students.put(1020, student);
        students.put(2646, student2);
        students.put(3546, student3);

        students.forEach((element, student1) -> System.out.println(element + ";" + student1.name + "," + student1.age));

        /*
        List<Student> students added to the map as values
         */

        Map<Integer, List<Student>> mappedStudents = new HashMap<>();
        List<Student> wStudentList = new ArrayList<>();
        wStudentList.add(new Student("Bella", 66));
        wStudentList.add(new Student("Natasha", 58));
        wStudentList.add(new Student("Vanessa", 98));

        List<Student> mStudentList = new ArrayList<>();
        mStudentList.add(new Student("Frank", 12));
        mStudentList.add(new Student("Charles", 5));
        mStudentList.add(new Student("Bob", 8));

        mappedStudents.put(1, wStudentList);
        mappedStudents.put(2, mStudentList);

        mappedStudents.forEach((x, y) -> {
            System.out.println(x);
            y.forEach(student1 -> System.out.println(student1.name + "," + student1.age));
        });
    }
    /*
    ADVANCED (Nested Structures & FlatMap)
    Flatten Nested Lists
    Given a List<List<Integer>>, return a flattened List<Integer>.
     */

    public List<Integer> flattenedList(List<List<Integer>> listOfListedElements) {
        return listOfListedElements.stream()
                .flatMap(x -> x.stream())
                .toList();
    }

    ;
}