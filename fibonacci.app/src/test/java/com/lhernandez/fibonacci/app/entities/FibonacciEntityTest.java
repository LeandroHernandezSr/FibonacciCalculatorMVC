package com.lhernandez.fibonacci.app.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FibonacciEntityTest {

    @Test
    void constructor_DefaultValues_ShouldBeNull() {
        FibonacciEntity entity = new FibonacciEntity();

        assertNull(entity.getId());
        assertNull(entity.getNumber());
        assertNull(entity.getNthNumber());
        assertNull(entity.getOccurrences());
    }

    @Test
    void setId_ShouldReturnSameValue() {
        FibonacciEntity entity = new FibonacciEntity();

        entity.setId(1L);

        assertEquals(1L, entity.getId());
    }

    @Test
    void setNumber_ShouldReturnSameValue() {
        FibonacciEntity entity = new FibonacciEntity();

        entity.setNumber(10);

        assertEquals(10, entity.getNumber());
    }

    @Test
    void setNthNumber_ShouldReturnSameValue() {
        FibonacciEntity entity = new FibonacciEntity();

        entity.setNthNumber(7L);

        assertEquals(7, entity.getNthNumber());
    }

    @Test
    void setOccurrences_ShouldReturnSameValue() {
        FibonacciEntity entity = new FibonacciEntity();

        entity.setOccurrences(3);

        assertEquals(3, entity.getOccurrences());
    }

    @Test
    void fullEntity_ShouldKeepAllValues() {
        FibonacciEntity entity = new FibonacciEntity();

        entity.setId(5L);
        entity.setNumber(21);
        entity.setNthNumber(8L);
        entity.setOccurrences(2);

        assertAll(
                () -> assertEquals(5L, entity.getId()),
                () -> assertEquals(21, entity.getNumber()),
                () -> assertEquals(8, entity.getNthNumber()),
                () -> assertEquals(2, entity.getOccurrences())
        );
    }
}
