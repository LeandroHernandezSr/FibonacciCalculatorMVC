package com.lhernandez.fibonacci.app.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.lhernandez.fibonacci.app.dto.ApiResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.lhernandez.fibonacci.app.dto.NthNumberResponseDto;
import com.lhernandez.fibonacci.app.dto.NumberDto;
import com.lhernandez.fibonacci.app.handlers.NthNumberHandler;

@ExtendWith(MockitoExtension.class)
class CalculateNthNumberControllerTest {

    @Mock
    private NthNumberHandler handler;

    @InjectMocks
    private CalculateNthNumberController controller;

    private NumberDto numberDto;

    @BeforeEach
    void setUp() {
        numberDto = new NumberDto(10);
    }

    @Test
    void calculate_ShouldCallHandlerAndReturnResponse() {
        NthNumberResponseDto responseDto = new NthNumberResponseDto(55L);
        ResponseEntity<ApiResponseDto<NthNumberResponseDto>> expectedResponse = ResponseEntity.ok(new ApiResponseDto<>(responseDto,"Operation finished successfully"));

        when(handler.apply(numberDto)).thenReturn(expectedResponse);

        ResponseEntity<ApiResponseDto<NthNumberResponseDto>> response = controller.calculate(numberDto);

        assertNotNull(response);
        assertEquals(expectedResponse, response);
        assertEquals(55, response.getBody().data().nthNumber());

        verify(handler, times(1)).apply(numberDto);
    }
}