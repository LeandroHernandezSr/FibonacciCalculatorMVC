package com.lhernandez.fibonacci.app.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IncrementOccurrenceServiceTest {

    private IncrementOccurrenceServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new IncrementOccurrenceServiceImpl();
    }

    @Test
    void apply_WhenOccurrenceIsValid_ShouldReturnIncrementedValue() {
        Integer result = service.apply(5);

        assertEquals(6, result);
    }

    @Test
    void apply_WhenOccurrenceIsZero_ShouldReturnOne() {
        Integer result = service.apply(0);

        assertEquals(1, result);
    }

    @Test
    void apply_WhenOccurrenceIsNull_ShouldThrowException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.apply(null)
        );

        assertEquals("The occurrence cannot be null!", exception.getMessage());
    }
}