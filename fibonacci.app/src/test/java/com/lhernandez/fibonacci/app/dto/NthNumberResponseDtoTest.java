package com.lhernandez.fibonacci.app.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NthNumberResponseDtoTest {

    @Test
    void constructor_ShouldSetValueCorrectly() {
        NthNumberResponseDto dto = new NthNumberResponseDto(10L);

        assertEquals(10, dto.nthNumber());
    }

    @Test
    void equalsAndHashCode_SameValues_ShouldBeEqual() {
        NthNumberResponseDto dto1 = new NthNumberResponseDto(7L);
        NthNumberResponseDto dto2 = new NthNumberResponseDto(7L);

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void equals_DifferentValues_ShouldNotBeEqual() {
        NthNumberResponseDto dto1 = new NthNumberResponseDto(7L);
        NthNumberResponseDto dto2 = new NthNumberResponseDto(8L);

        assertNotEquals(dto1, dto2);
    }

    @Test
    void toString_ShouldContainFieldNameAndValue() {
        NthNumberResponseDto dto = new NthNumberResponseDto(5L);

        String result = dto.toString();

        assertTrue(result.contains("nthNumber=5"));
    }

    @Test
    void record_AllowsNullValue() {
        NthNumberResponseDto dto = new NthNumberResponseDto(null);

        assertNull(dto.nthNumber());
    }
}
