package com.lhernandez.fibonacci.app.controllers;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhernandez.fibonacci.app.dto.GetOccurrencesDto;
import com.lhernandez.fibonacci.app.handlers.GetOccurrencesHandler;

@RestController
@RequestMapping("/fibonacci")
public class GetOccurrencesController {

    private final GetOccurrencesHandler handler;

    public GetOccurrencesController(GetOccurrencesHandler handler){
        this.handler=handler;
    }

    @GetMapping("/occurrences")
    @Operation(
            summary = "Get Fibonacci numbers ordered by occurrences",
            description = "Returns a list of Fibonacci numbers sorted by the number of times they were requested."
    )
    @ApiResponse(responseCode = "200", description = "Occurrences retrieved successfully")
    public ResponseEntity<List<GetOccurrencesDto>>getOccurences(){
        return this.handler.apply();
    }
    
}
