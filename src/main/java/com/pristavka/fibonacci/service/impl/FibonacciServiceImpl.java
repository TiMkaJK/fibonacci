package com.pristavka.fibonacci.service.impl;

import com.pristavka.fibonacci.repository.ResultRepository;
import com.pristavka.fibonacci.repository.StatisticsRepository;
import com.pristavka.fibonacci.service.FibonacciService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class FibonacciServiceImpl implements FibonacciService {

    private final ResultRepository resultRepository;
    private final StatisticsRepository statisticsRepository;

    @Override
    public Integer getFibonacci(Integer requestValue) {
        return createFibonacciValues(0, 1, requestValue);
    }

    private Integer createFibonacciValues(Integer firstValue, Integer secondValue, Integer requestValue) {

        int result = firstValue + secondValue;

        if (result >= requestValue) {
            if (Objects.equals(result, requestValue)) {
                return secondValue + result;
            } else {
                throw new NoSuchElementException("Its not a Fibonacci requestValue");
            }
        }

        return createFibonacciValues(secondValue, result, requestValue);
    }
}

