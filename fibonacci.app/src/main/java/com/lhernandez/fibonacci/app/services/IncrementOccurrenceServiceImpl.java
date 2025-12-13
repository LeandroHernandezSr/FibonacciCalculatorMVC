package com.lhernandez.fibonacci.app.services;

import org.springframework.stereotype.Service;

@Service
public class IncrementOccurrenceServiceImpl implements IncrementOccurrenceService{

    @Override
    public Integer apply(Integer occurrence) {
        if (occurrence == null) throw new IllegalArgumentException("The occurrence cannot be null!");
        return occurrence+1;
    }
    
}
