package com.pristavka.fibonacci.service.impl;

import com.pristavka.fibonacci.entity.Result;
import com.pristavka.fibonacci.entity.Statistics;
import com.pristavka.fibonacci.repository.ResultRepository;
import com.pristavka.fibonacci.repository.StatisticsRepository;
import com.pristavka.fibonacci.service.FibonacciService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Service
public class FibonacciServiceImpl implements FibonacciService {

    private final ResultRepository resultRepository;
    private final StatisticsRepository statisticsRepository;

    @Transactional
    @Override
    public Integer getFibonacci(Integer requestValue) {

        Result savedResult = this.resultRepository.findByRequestValue(requestValue);

        if (Objects.nonNull(savedResult)) {

            this.statisticsRepository.findByRequestValue(requestValue)
                    .map(stat -> {
                        stat.setRequestCount(new AtomicInteger(stat.getRequestCount()).incrementAndGet());
                        return stat;
                    })
                    .map(this.statisticsRepository::save);
            return savedResult.getResponseValue();
        }

        Integer responseValue = createFibonacciValues(0, 1, requestValue);

        this.resultRepository.save(Result.builder().requestValue(requestValue).responseValue(responseValue).build());
        this.statisticsRepository.save(Statistics.builder().requestValue(requestValue).requestCount(1).build());

        return responseValue;
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

