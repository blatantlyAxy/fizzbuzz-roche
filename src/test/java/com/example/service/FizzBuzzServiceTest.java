package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzServiceTest {
    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Test
    void testGenerateFizzBuzzWithPositiveIntegersAndLimitReturnsOK() {
        int int1 = 3;
        int int2 = 5;
        int limit = 15;
        String str1 = "Fizz";
        String str2 = "Buzz";

        var expected = List.of("1", "2", "Fizz", "4", "Buzz", "Fizz",
                "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
        var actual = fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2);
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateFizzBuzzWithMinimumRangeReturnsOk() {
        int int1 = 3;
        int int2 = 5;
        int limit = 1;
        String str1 = "Fizz";
        String str2 = "Buzz";

        var expected = List.of("1");
        var actual = fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2);
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateFizzBuzzWithLargeLimitDoesNotCrash() {
        int int1 = 3;
        int int2 = 5;
        int limit = 5000000;
        String str1 = "Fizz";
        String str2 = "Buzz";

        assertDoesNotThrow(() ->fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2));
    }

    @Test
    void testGenerateFizzBuzzWithNegativeOrZeroLimitReturnsEmptyArray() {
        int int1 = 3;
        int int2 = 5;
        int limit = -5;
        String str1 = "Fizz";
        String str2 = "Buzz";

        var expected = Collections.emptyList();
        var actual = fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2);
        assertEquals(expected, actual);

        limit = 0;
        actual = fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2);
        assertEquals(expected, actual);
    }


    @Test
    void testGenerateFizzBuzzWithConflictingMultiplesReturnsOk() {
        int int1 = 4;
        int int2 = 8;
        int limit = 16;
        String str1 = "Fizz";
        String str2 = "Buzz";

        var expected = List.of("1", "2", "3", "Fizz", "5", "6",
                "7", "FizzBuzz", "9", "10", "11", "Fizz", "13", "14", "15", "FizzBuzz");
        var actual = fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2);
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateFizzBuzzWithSameStringValuesReturnsOk() {
        int int1 = 2;
        int int2 = 3;
        int limit = 7;
        String str1 = "Fizz";
        String str2 = "Fizz";

        var expected = List.of("1", "Fizz", "Fizz", "Fizz", "5", "FizzFizz", "7");
        var actual = fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2);
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateFizzBuzzWithZeroDivisionThrowsRuntimeException() {
        int int1 = 4;
        int int2 = 0;
        int limit = 16;
        String str1 = "Fizz";
        String str2 = "Buzz";

        assertThatThrownBy(() -> fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2)).isInstanceOf(RuntimeException.class);

    }
}
