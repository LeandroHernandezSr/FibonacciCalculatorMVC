package com.lhernandez.fibonacci.app.services;


import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

@Service
public class CalculateNthNumberServiceImpl implements CalculateNthNumberService{

    @Override
    @Cacheable(
        cacheNames = "fibonacci-by-number",
        key = "#number"
    )   
    public Long apply(Integer number) {

        if (number == 0L) return 0L;
        if (number == 1L) return  1L;

        long a = 0L;
        long b = 1L;
        long c = 0L;

        for (int i = 2; i <= number; i++){
            c = a + b;
            a = b;     
            b = c;     
        }

        return c;
        
    }

}
