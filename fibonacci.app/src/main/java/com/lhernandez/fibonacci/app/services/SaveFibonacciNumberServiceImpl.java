package com.lhernandez.fibonacci.app.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.lhernandez.fibonacci.app.entities.FibonacciEntity;
import com.lhernandez.fibonacci.app.repository.FibonacciJpaRepository;

@Service
public class SaveFibonacciNumberServiceImpl implements SaveFibonacciNumberService{

    private final FibonacciJpaRepository repository;

    public SaveFibonacciNumberServiceImpl(FibonacciJpaRepository repository){
        this.repository=repository;
    }

    @Override
    @CacheEvict(
        cacheNames = "fibonacci-by-number",
        key = "#fibonacciEntity.nthNumber",
        beforeInvocation = true
    )
    public FibonacciEntity apply(FibonacciEntity fibonacciEntity) {
        if (fibonacciEntity == null) throw new IllegalArgumentException("The entity cannot be null!");
        return repository.save(fibonacciEntity);
    }

}
