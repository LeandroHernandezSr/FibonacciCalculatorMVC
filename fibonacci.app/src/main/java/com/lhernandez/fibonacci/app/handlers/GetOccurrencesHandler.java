package com.lhernandez.fibonacci.app.handlers;

import java.util.List;

import com.lhernandez.fibonacci.app.dto.ApiResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.lhernandez.fibonacci.app.dto.GetOccurrencesDto;
import com.lhernandez.fibonacci.app.services.GetOccurrenceService;

@Component
public class GetOccurrencesHandler {

    private final GetOccurrenceService getOccurrenceService;

    public GetOccurrencesHandler(GetOccurrenceService getOccurrenceService){
        this.getOccurrenceService=getOccurrenceService;
    }

    public ResponseEntity<ApiResponseDto<List<GetOccurrencesDto>>> apply(){
        return ResponseEntity.ok(
           new ApiResponseDto<>( getOccurrenceService.apply()
                   .stream()
                   .map(o->new GetOccurrencesDto(o.getNumber(),o.getOccurrences()))
                   .toList(),"Operation finished successfully")
        );
    }
}
