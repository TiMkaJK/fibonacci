package com.pristavka.fibonacci.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FibonacciTest {

    @Autowired
    private FibonacciService fibonacciService;

    @Test
    void testFibonacci() {
        Integer requestValue = 8;
        Integer responseValue = 13;

        Integer result = this.fibonacciService.getFibonacci(requestValue);
        Assertions.assertEquals(responseValue, result);
    }
}

