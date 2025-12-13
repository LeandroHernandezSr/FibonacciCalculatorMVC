package com.lhernandez.fibonacci.app.handlers;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

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
import com.lhernandez.fibonacci.app.entities.FibonacciEntity;
import com.lhernandez.fibonacci.app.services.CalculateNthNumberService;
import com.lhernandez.fibonacci.app.services.GetFibonacciByNumberService;
import com.lhernandez.fibonacci.app.services.IncrementOccurrenceService;
import com.lhernandez.fibonacci.app.services.SaveFibonacciNumberService;

@ExtendWith(MockitoExtension.class)
class NthNumberHandlerTest {

    @Mock
    private CalculateNthNumberService calculateNthNumberService;

    @Mock
    private GetFibonacciByNumberService getFibonacciByNumberService;

    @Mock
    private IncrementOccurrenceService incrementOccurrenceService;

    @Mock
    private SaveFibonacciNumberService saveFibonacciNumberService;

    @InjectMocks
    private NthNumberHandler handler;

    private NumberDto numberDto;
    private FibonacciEntity existingEntity;

    @BeforeEach
    void setUp() {
        numberDto = new NumberDto(10);

        existingEntity = new FibonacciEntity();
        existingEntity.setNumber(10);
        existingEntity.setNthNumber(55L);
        existingEntity.setOccurrences(2);
    }

    @Test
    void apply_WhenNumberExists_ShouldIncrementOccurrencesAndReturnNthNumber() {
        when(getFibonacciByNumberService.apply(10)).thenReturn(Optional.of(existingEntity));
        when(incrementOccurrenceService.apply(2)).thenReturn(3);
        when(saveFibonacciNumberService.apply(existingEntity)).thenReturn(existingEntity);

        ResponseEntity<ApiResponseDto<NthNumberResponseDto>> response = handler.apply(numberDto);

        assertNotNull(response);
        assertEquals(55, response.getBody().data().nthNumber());
        assertEquals(3, existingEntity.getOccurrences());

        verify(getFibonacciByNumberService, times(1)).apply(10);
        verify(incrementOccurrenceService, times(1)).apply(2);
        verify(saveFibonacciNumberService, times(1)).apply(existingEntity);
        verify(calculateNthNumberService, never()).apply(any());
    }

    @Test
    void apply_WhenNumberDoesNotExist_ShouldCalculateAndSave() {
        when(getFibonacciByNumberService.apply(10)).thenReturn(Optional.empty());
        when(calculateNthNumberService.apply(10)).thenReturn(55L);
        when(saveFibonacciNumberService.apply(any(FibonacciEntity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        ResponseEntity<ApiResponseDto<NthNumberResponseDto>> response = handler.apply(numberDto);

        assertNotNull(response);
        assertEquals(55, response.getBody().data().nthNumber());

        verify(getFibonacciByNumberService, times(1)).apply(10);
        verify(calculateNthNumberService, times(1)).apply(10);
        verify(saveFibonacciNumberService, times(1)).apply(any(FibonacciEntity.class));
        verify(incrementOccurrenceService, never()).apply(any());
    }
}