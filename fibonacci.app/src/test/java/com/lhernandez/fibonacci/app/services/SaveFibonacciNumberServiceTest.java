package com.lhernandez.fibonacci.app.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lhernandez.fibonacci.app.entities.FibonacciEntity;
import com.lhernandez.fibonacci.app.repository.FibonacciJpaRepository;

@ExtendWith(MockitoExtension.class)
class SaveFibonacciNumberServiceTest {

    @Mock
    private FibonacciJpaRepository repository;

    @InjectMocks
    private SaveFibonacciNumberServiceImpl service;

    private FibonacciEntity entity;

    @BeforeEach
    void setUp() {
        entity = new FibonacciEntity();
        entity.setNumber(10);
        entity.setNthNumber(7L);
        entity.setOccurrences(1);
    }

    @Test
    void apply_WhenEntityIsValid_ShouldSaveAndReturnEntity() {
        when(repository.save(entity)).thenReturn(entity);

        FibonacciEntity result = service.apply(entity);

        assertNotNull(result);
        assertEquals(entity, result);
        verify(repository, times(1)).save(entity);
    }

    @Test
    void apply_WhenEntityIsNull_ShouldThrowException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.apply(null)
        );

        assertEquals("The entity cannot be null!", exception.getMessage());
        verify(repository, never()).save(any());
    }
}