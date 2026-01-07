package com.example.ceramics.uti;

import com.example.ceramics.util.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

}
