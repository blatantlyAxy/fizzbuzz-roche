package com.example.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGenerateFizzBuzzReturnsOK() throws Exception {
        int int1 = 3;
        int int2 = 5;
        int limit = 15;
        String str1 = "Fizz";
        String str2 = "Buzz";

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fizzbuzz")
                        .param("int1", String.valueOf(int1))
                        .param("int2", String.valueOf(int2))
                        .param("limit", String.valueOf(limit))
                        .param("str1", str1)
                        .param("str2", str2))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
    }

    @Test
    public void testGenerateFizzBuzzWithMissingParametersThrowsInvalidRequestException() throws Exception {
        int int1 = 3;
        int limit = 15;
        String str1 = "Fizz";
        String str2 = "Buzz";

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fizzbuzz")
                        .param("int1", String.valueOf(int1))
                        .param("limit", String.valueOf(limit))
                        .param("str1", str1)
                        .param("str2", str2))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void testGenerateFizzBuzzWithInvalidParametersThrowsInvalidRequestException() throws Exception {
        int int1 = 3;
        int int2 = 5;
        String limit = "abc";
        String str1 = "Fizz";
        String str2 = "Buzz";

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fizzbuzz")
                        .param("int1", String.valueOf(int1))
                        .param("int1", String.valueOf(int2))
                        .param("limit", limit)
                        .param("str1", str1)
                        .param("str2", str2))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void testGenerateFizzBuzzWithZeroDivisionExitsGracefully() throws Exception{
        int int1 = 4;
        int int2 = 0;
        int limit = 16;
        String str1 = "Fizz";
        String str2 = "Buzz";

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fizzbuzz")
                        .param("int1", String.valueOf(int1))
                        .param("int2", String.valueOf(int2))
                        .param("limit", String.valueOf(limit))
                        .param("str1", str1)
                        .param("str2", str2))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
