package com.pristavka.fibonacci.controller;

import com.pristavka.fibonacci.service.FibonacciService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/fibonacci")
public class FibonacciRestController {

    private final FibonacciService fibonacciService;

    @GetMapping(path = "/{value}")
    public ResponseEntity<Integer> getFibonacci(@PathVariable(name = "value") @NonNull Integer value) {
        return ResponseEntity.ok(this.fibonacciService.getFibonacci(value));
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity exception(NoSuchElementException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }
}

