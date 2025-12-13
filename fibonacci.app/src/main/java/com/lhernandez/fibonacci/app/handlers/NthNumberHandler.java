package com.lhernandez.fibonacci.app.handlers;

import java.util.List;
import java.util.Optional;

import com.lhernandez.fibonacci.app.dto.ApiResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.lhernandez.fibonacci.app.dto.NthNumberResponseDto;
import com.lhernandez.fibonacci.app.dto.NumberDto;
import com.lhernandez.fibonacci.app.entities.FibonacciEntity;
import com.lhernandez.fibonacci.app.services.CalculateNthNumberService;
import com.lhernandez.fibonacci.app.services.GetFibonacciByNumberService;
import com.lhernandez.fibonacci.app.services.IncrementOccurrenceService;
import com.lhernandez.fibonacci.app.services.SaveFibonacciNumberService;

@Component
public class NthNumberHandler {

    private final CalculateNthNumberService calculateNthNumberService;
    private final GetFibonacciByNumberService getFibonacciByNumberService;
    private final IncrementOccurrenceService incrementOccurrenceService;
    private final SaveFibonacciNumberService saveFibonacciNumberService;

    public NthNumberHandler(CalculateNthNumberService calculateNthNumberService,
        GetFibonacciByNumberService getFibonacciByNumberService,
        IncrementOccurrenceService incrementOccurrenceService,
        SaveFibonacciNumberService saveFibonacciNumberService
    ){
        this.calculateNthNumberService=calculateNthNumberService;
        this.getFibonacciByNumberService=getFibonacciByNumberService;
        this.incrementOccurrenceService=incrementOccurrenceService;
        this.saveFibonacciNumberService=saveFibonacciNumberService;
    }

    public ResponseEntity<ApiResponseDto<NthNumberResponseDto>>apply(NumberDto dto){
        try{
            Optional<FibonacciEntity>optFibonacciEntity=getFibonacciByNumberService.apply(dto.number());

            if (optFibonacciEntity.isPresent()){
                FibonacciEntity entity=optFibonacciEntity.get();
                entity.setOccurrences(incrementOccurrenceService.apply(entity.getOccurrences()));
                saveFibonacciNumberService.apply(entity);
                return ResponseEntity.ok(new ApiResponseDto<>(new NthNumberResponseDto(entity.getNthNumber()),"Operation finished successfully"));
            }

            FibonacciEntity entity=new FibonacciEntity();

            entity.setNumber(dto.number());
            entity.setNthNumber(calculateNthNumberService.apply(dto.number()));
            entity.setOccurrences(1);

            saveFibonacciNumberService.apply(entity);

            return ResponseEntity.ok(new ApiResponseDto<>(new NthNumberResponseDto(entity.getNthNumber()),"Operation finished successfully"));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(new ApiResponseDto<>(List.of(e.getMessage()),"An error occurred"));
        }
    }
}
