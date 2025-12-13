package com.lhernandez.fibonacci.app.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import com.lhernandez.fibonacci.app.dto.ApiResponseDto;
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
        ResponseEntity<ApiResponseDto<List<GetOccurrencesDto>>> expectedResponse = ResponseEntity.ok(
                new ApiResponseDto<>(dtoList,"Operation finished successfully")
        );

        when(handler.apply()).thenReturn(expectedResponse);

        ResponseEntity<ApiResponseDto<List<GetOccurrencesDto>>> response = controller.getOccurences();

        assertNotNull(response);
        assertEquals(expectedResponse, response);
        assertEquals(2, response.getBody().data().size());
        assertEquals(5, response.getBody().data().get(0).number());
        assertEquals(2, response.getBody().data().get(0).occurrences());

        verify(handler, times(1)).apply();
    }
}
