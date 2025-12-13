package com.lhernandez.fibonacci.app.controllers;

import com.lhernandez.fibonacci.app.dto.ApiResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhernandez.fibonacci.app.dto.NthNumberResponseDto;
import com.lhernandez.fibonacci.app.dto.NumberDto;
import com.lhernandez.fibonacci.app.handlers.NthNumberHandler;

@RestController
@RequestMapping("/fibonacci")
public class CalculateNthNumberController {

    private final NthNumberHandler handler;

    public CalculateNthNumberController(NthNumberHandler handler){
        this.handler=handler;
    }

    @PostMapping("/get-nth-number")
    @Operation(
            summary = "Get Nth Fibonacci number",
            description = "Returns the Fibonacci number corresponding to the provided N value."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Fibonacci number calculated successfully",
            content = @Content(schema = @Schema(implementation = NthNumberResponseDto.class))
    )
    public ResponseEntity<ApiResponseDto<NthNumberResponseDto>>calculate(@RequestBody NumberDto dto){
        return this.handler.apply(dto);
    }

}
