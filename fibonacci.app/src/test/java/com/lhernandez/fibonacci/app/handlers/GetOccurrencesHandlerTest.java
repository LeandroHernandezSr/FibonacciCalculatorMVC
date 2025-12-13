package com.lhernandez.fibonacci.app.handlers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.lhernandez.fibonacci.app.dto.GetOccurrencesDto;
import com.lhernandez.fibonacci.app.entities.FibonacciEntity;
import com.lhernandez.fibonacci.app.services.GetOccurrenceService;

@ExtendWith(MockitoExtension.class)
class GetOccurrencesHandlerTest {

    @Mock
    private GetOccurrenceService getOccurrenceService;

    @InjectMocks
    private GetOccurrencesHandler handler;

    private List<FibonacciEntity> entities;

    @BeforeEach
    void setUp() {
        FibonacciEntity e1 = new FibonacciEntity();
        e1.setNumber(5);
        e1.setOccurrences(2);

        FibonacciEntity e2 = new FibonacciEntity();
        e2.setNumber(8);
        e2.setOccurrences(1);

        entities = List.of(e1, e2);
    }

    @Test
    void apply_WhenServiceReturnsEntities_ShouldReturnListOfDTOs() {
        when(getOccurrenceService.apply()).thenReturn(entities);

        ResponseEntity<List<GetOccurrencesDto>> response = handler.apply();

        assertNotNull(response);
        assertEquals(2, response.getBody().size());

        GetOccurrencesDto dto1 = response.getBody().get(0);
        assertEquals(5, dto1.number());
        assertEquals(2, dto1.occurrences());

        GetOccurrencesDto dto2 = response.getBody().get(1);
        assertEquals(8, dto2.number());
        assertEquals(1, dto2.occurrences());

        verify(getOccurrenceService, times(1)).apply();
    }

    @Test
    void apply_WhenServiceReturnsEmptyList_ShouldReturnEmptyDTOList() {
        when(getOccurrenceService.apply()).thenReturn(List.of());

        ResponseEntity<List<GetOccurrencesDto>> response = handler.apply();

        assertNotNull(response);
        assertTrue(response.getBody().isEmpty());
        verify(getOccurrenceService, times(1)).apply();
    }
}