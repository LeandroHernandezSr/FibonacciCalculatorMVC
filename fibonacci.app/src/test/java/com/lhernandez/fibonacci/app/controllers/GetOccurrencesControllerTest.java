package com.lhernandez.fibonacci.app.controllers;

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
import com.lhernandez.fibonacci.app.handlers.GetOccurrencesHandler;

@ExtendWith(MockitoExtension.class)
class GetOccurrencesControllerTest {

    @Mock
    private GetOccurrencesHandler handler;

    @InjectMocks
    private GetOccurrencesController controller;

    private List<GetOccurrencesDto> dtoList;

    @BeforeEach
    void setUp() {
        dtoList = List.of(
                new GetOccurrencesDto(5, 2),
                new GetOccurrencesDto(8, 1)
        );
    }

    @Test
    void getOccurences_ShouldCallHandlerAndReturnResponse() {
        ResponseEntity<List<GetOccurrencesDto>> expectedResponse = ResponseEntity.ok(dtoList);

        when(handler.apply()).thenReturn(expectedResponse);

        ResponseEntity<List<GetOccurrencesDto>> response = controller.getOccurences();

        assertNotNull(response);
        assertEquals(expectedResponse, response);
        assertEquals(2, response.getBody().size());
        assertEquals(5, response.getBody().get(0).number());
        assertEquals(2, response.getBody().get(0).occurrences());

        verify(handler, times(1)).apply();
    }
}
