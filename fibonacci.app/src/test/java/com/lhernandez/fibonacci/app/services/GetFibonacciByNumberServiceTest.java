package com.lhernandez.fibonacci.app.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lhernandez.fibonacci.app.entities.FibonacciEntity;
import com.lhernandez.fibonacci.app.repository.FibonacciJpaRepository;

@ExtendWith(MockitoExtension.class)
class GetFibonacciByNumberServiceTest {

    @Mock
    private FibonacciJpaRepository repository;

    @InjectMocks
    private GetFibonacciByNumberServiceImpl service;

    private FibonacciEntity entity;

    @BeforeEach
    void setUp() {
        entity = new FibonacciEntity();
        entity.setNumber(10);
        entity.setNthNumber(5L);
        entity.setOccurrences(1);
    }

    @Test
    void apply_WhenNumberExists_ShouldReturnOptionalWithEntity() {
        when(repository.findByNumber(10)).thenReturn(Optional.of(entity));

        Optional<FibonacciEntity> result = service.apply(10);

        assertTrue(result.isPresent());
        assertEquals(entity, result.get());
        verify(repository, times(1)).findByNumber(10);
    }

    @Test
    void apply_WhenNumberDoesNotExist_ShouldReturnEmptyOptional() {
        when(repository.findByNumber(20)).thenReturn(Optional.empty());

        Optional<FibonacciEntity> result = service.apply(20);

        assertTrue(result.isEmpty());
        verify(repository, times(1)).findByNumber(20);
    }

    @Test
    void apply_WhenNumberIsNull_ShouldThrowException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.apply(null)
        );

        assertEquals("Number cannot be null!", exception.getMessage());
        verify(repository, never()).findByNumber(any());
    }
}
