package com.example.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzService {

    public List<String> generateFizzBuzz(int int1, int int2, int limit, String str1, String str2) throws ArithmeticException{
        return IntStream.rangeClosed(1, limit)
                .mapToObj(i -> {
                    var sb = new StringBuilder();
                    if( i % int1 != 0 && i % int2 != 0) {
                        return String.valueOf(i);
                    }
                    if (i % int1 == 0) {
                        sb.append(str1);
                    }
                    if (i % int2 == 0) {
                        sb.append(str2);
                    }

                    return sb.toString();
                })
                .collect(Collectors.toList());
    }
}
