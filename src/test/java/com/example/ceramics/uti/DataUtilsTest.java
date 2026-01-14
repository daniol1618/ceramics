package com.example.ceramics.uti;

import com.example.ceramics.util.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.ceramics.util.DataUtils.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataUtilsTest {

    private DataUtils dataUtils;

    @BeforeEach
    void setUp() {
        dataUtils = new DataUtils();
    }


    @Test
    public void shouldReturnEvenNumbers() {
        //Given
        List<Integer> elements = List.of(1, 3, 9, 8, 7, 2222, 1, 4, 66);

        //When
        List<Integer> evenNumbers = dataUtils.evenNumbers(elements);

        //Then
        assertEquals(List.of(8, 2222, 4, 66), evenNumbers);
    }

    @Test
    public void shouldToUpperCase() {
        //Given
        List<String> elements = List.of("John", "Barbara", "Martin", "Fowler");

        //When
        var converted = dataUtils.toUpperCase(elements);

        //Then
        assertEquals(List.of("JOHN", "BARBARA", "MARTIN", "FOWLER"), converted);

    }

    @Test
    public void shouldCountNumbers() {
        //Given
        var elements = List.of(0, 1, 63, 5, 988, 752, 32, -9, 51);
        var x = 50;

        //When
        int returned = dataUtils.countNumbers(elements, x);
        //Then
        assertEquals(4, returned);
    }

    @Test
    public void shouldSumElements() {
        //Given
        int[] elements = {1, 3, 8, 9, 7, -1};
        //When
        int sum = dataUtils.sumOfNumbers(elements);
        //Then
        assertEquals(27, sum);
    }

    @Test
    public void shouldRemoveEmptyStrings() {
        //Given
        var elements = List.of("Hanna", "Barbera", "", "CARTOON", "", "Network", "-1");
        //When
        var returnedElements = dataUtils.removeAllEmptyStrings(elements);
        //Then
        assertEquals(List.of("Hanna", "Barbera", "CARTOON", "Network", "-1"), returnedElements);
    }

    @Test
    public void shouldSquareNumbers() {
        //Given
        Set<Integer> elements = new HashSet<Integer>();
        elements.add(2);
        elements.add(3);
        elements.add(5);
        elements.add(5);
        //When
        List<Integer> squaredResults = dataUtils.squaredNumbers(elements);
        //Then
        assertEquals(List.of(4, 9, 25), squaredResults);
    }

    @Test
    public void shouldGetLongestString() {
        //Given
        List<String> elements = List.of("Batman", "Robin", "Super Man");
        //When
        String longestString = dataUtils.getLongestString(elements);
        //Then
        assertEquals("Super Man", longestString);
    }

    @Test
    public void shouldGetJoinedElements() {
        //Given
        List<String> elements = List.of("H", "E", "LL", "O");
        //When
        String result = dataUtils.joinElements(elements);
        //Then
        assertEquals("H,E,LL,O", result);
    }

    @Test
    void shouldReturnUniqueValuesFromList() {
        // Given
        List<Integer> elements = List.of(2016, 2020, 2017, 2025, 2023, 2016, 2020, 2068);

        // When
        Set<Integer> result = dataUtils.getUniqueValues(elements);

        // Then
        assertEquals(Set.of(2016, 2020, 2017, 2025, 2023, 2068), result);
    }

    @Test
    public void checkIfAnyStartsWithLetterA() {
        //Given
        List<String> elements = List.of("DANIEL", "Martha", "Anna", "Hanna");
        //When
        boolean result = dataUtils.anyStartsWithLetterA(elements);
        //Then
        assertEquals(true, result);
    }

    @Test
    public void shouldGetOldersThan18() {
        //Given
        Person person1 = dataUtils.new Person("Fabriccio", 55);
        Person person2 = dataUtils.new Person("Antonela", 2);
        Person person3 = dataUtils.new Person("Bella", 18);

        List<DataUtils.Person> personas = new ArrayList<>();
        personas.add(person1);
        personas.add(person2);
        personas.add(person3);


        Person personaEsperada = dataUtils.new Person("Fabriccio", 55);
        ArrayList<Person> personasEsperadas = new ArrayList<>();
        personasEsperadas.add(personaEsperada);

        //When
        List<Person> result = dataUtils.getOldersThan18(personas);

        //Then
        assertEquals(result, personasEsperadas);
    }

    @Test
    void shouldReturnAverageAge() {
        //Given
        Person person1 = dataUtils.new Person("Fabriccio", 55);
        Person person2 = dataUtils.new Person("Antonela", 2);
        Person person3 = dataUtils.new Person("Bella", 18);

        List<DataUtils.Person> personas = new ArrayList<>();
        personas.add(person1);
        personas.add(person2);
        personas.add(person3);
        // When
        int average = dataUtils.getAverageAge(personas);

        // Then
        assertEquals(25, average);
    }

}
