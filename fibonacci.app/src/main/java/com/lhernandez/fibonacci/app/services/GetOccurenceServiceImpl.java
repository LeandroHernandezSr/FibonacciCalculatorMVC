package com.lhernandez.fibonacci.app.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lhernandez.fibonacci.app.entities.FibonacciEntity;
import com.lhernandez.fibonacci.app.repository.FibonacciJpaRepository;

@Service
public class GetOccurenceServiceImpl implements GetOccurrenceService{

    private final FibonacciJpaRepository repository;

    public GetOccurenceServiceImpl(FibonacciJpaRepository repository){
        this.repository=repository;
    }

    @Override
    public List<FibonacciEntity> apply() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(FibonacciEntity::getOccurrences).reversed())
                .toList();
    }

}
