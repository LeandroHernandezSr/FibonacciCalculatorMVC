package com.lhernandez.fibonacci.app.services;

import java.util.Optional;

import com.lhernandez.fibonacci.app.entities.FibonacciEntity;

public interface GetFibonacciByNumberService {
    Optional<FibonacciEntity> apply(Integer number);
}
