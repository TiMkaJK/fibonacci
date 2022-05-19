package com.pristavka.fibonacci.service.impl;

import com.pristavka.fibonacci.service.FibonacciService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class FibonacciServiceImpl implements FibonacciService {

    private List<Integer> fibonacciValues = new ArrayList<>();

    @Override
    public Integer getFibonacci(Integer value) {

        fibonacciValues.add(1);
        fibonacciValues.add(2);

        do {
            createFibonacciValues();
        } while (fibonacciValues.get(fibonacciValues.size() - 1) <= value);

        if (fibonacciValues.contains(value)) {
            return fibonacciValues.get(fibonacciValues.size() - 1);
        } else {
            throw new NoSuchElementException("Its not a Fibonacci value");
        }
    }

    private void createFibonacciValues() {
        fibonacciValues.add(createFibonacciValue());
    }

    private Integer createFibonacciValue() {
        return fibonacciValues.get(fibonacciValues.size() - 2) + fibonacciValues.get(fibonacciValues.size() - 1);
    }
}

