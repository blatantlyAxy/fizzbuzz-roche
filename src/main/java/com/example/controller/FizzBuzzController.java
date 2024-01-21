package com.example.controller;

import com.example.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerErrorException;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1")
public class FizzBuzzController {

    private final FizzBuzzService fizzBuzzService;

    @Autowired
    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping(value = "/fizzbuzz", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> generateFizzBuzz(
            @RequestParam int int1,
            @RequestParam int int2,
            @RequestParam int limit,
            @RequestParam String str1,
            @RequestParam String str2) {
        //TODO: implement logging
        try {
            return new ResponseEntity<>(fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2), HttpStatus.OK);
        } catch (ArithmeticException e) {
            var faultyParams = String.valueOf(int1) + int2;
            return new ResponseEntity<>(List.of(faultyParams), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
