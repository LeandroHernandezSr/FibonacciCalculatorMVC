package com.lhernandez.fibonacci.app.services;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lhernandez.fibonacci.app.entities.FibonacciEntity;
import com.lhernandez.fibonacci.app.repository.FibonacciJpaRepository;

@Service
public class GetFibonacciByNumberServiceImpl implements GetFibonacciByNumberService{

    private final FibonacciJpaRepository repository;

    public GetFibonacciByNumberServiceImpl(FibonacciJpaRepository repository){
        this.repository=repository;
    }

    @Override
    @Cacheable(
        cacheNames = "fibonacci-by-number",
        key = "#number"
    )  
    public Optional<FibonacciEntity> apply(Integer number) {
        if (number == null) throw new IllegalArgumentException("Number cannot be null!");
        return this.repository.findByNumber(number);
    }

}
