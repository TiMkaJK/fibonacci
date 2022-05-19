package com.pristavka.fibonacci.controller;

import com.pristavka.fibonacci.service.FibonacciService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/fibonacci")
public class FibonacciRestController {

    private final FibonacciService fibonacciService;

    @GetMapping(path = "/{value}")
    public ResponseEntity<Integer> getFibonacci(@PathVariable(name = "value") @NonNull Integer value) {
        return ResponseEntity.ok(this.fibonacciService.getFibonacci(value));
    }
}

