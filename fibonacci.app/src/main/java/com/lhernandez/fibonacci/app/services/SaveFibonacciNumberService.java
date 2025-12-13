package com.lhernandez.fibonacci.app.services;

import com.lhernandez.fibonacci.app.entities.FibonacciEntity;

public interface SaveFibonacciNumberService {
    FibonacciEntity apply(FibonacciEntity fibonacciEntity);
}
