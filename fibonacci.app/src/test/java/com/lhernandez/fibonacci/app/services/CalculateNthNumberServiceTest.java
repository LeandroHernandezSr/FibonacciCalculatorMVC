package com.lhernandez.fibonacci.app.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculateNthNumberServiceTest {

    private CalculateNthNumberServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new CalculateNthNumberServiceImpl();
    }

    @Test
    void apply_WhenNumberIsZero_ShouldReturnZero() {
        assertEquals(0, service.apply(0));
    }

    @Test
    void apply_WhenNumberIsOne_ShouldReturnOne() {
        assertEquals(1, service.apply(1));
    }

    @Test
    void apply_WhenNumberIsTwo_ShouldReturnOne() {
        assertEquals(1, service.apply(2));
    }

    @Test
    void apply_WhenNumberIsFive_ShouldReturnFive() {
        assertEquals(5, service.apply(5));
    }

    @Test
    void apply_WhenNumberIsTen_ShouldReturnFiftyFive() {
        assertEquals(55, service.apply(10));
    }

    @Test
    void apply_LargeNumber_ShouldReturnCorrectValue() {
        assertEquals(12586269025L, service.apply(50).longValue());
    }

    @Test
    void apply_NegativeNumber_ShouldReturnZero() {
        assertEquals(0, service.apply(-1));
    }
}