package com.lhernandez.fibonacci.app.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberDtoTest {

    @Test
    void constructor_ShouldSetValueCorrectly() {
        NumberDto dto = new NumberDto(6);

        assertEquals(6, dto.number());
    }

    @Test
    void equalsAndHashCode_SameValues_ShouldBeEqual() {
        NumberDto dto1 = new NumberDto(9);
        NumberDto dto2 = new NumberDto(9);

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void equals_DifferentValues_ShouldNotBeEqual() {
        NumberDto dto1 = new NumberDto(9);
        NumberDto dto2 = new NumberDto(10);

        assertNotEquals(dto1, dto2);
    }

    @Test
    void toString_ShouldContainFieldNameAndValue() {
        NumberDto dto = new NumberDto(3);

        String result = dto.toString();

        assertTrue(result.contains("number=3"));
    }

    @Test
    void record_AllowsNullValue() {
        NumberDto dto = new NumberDto(null);

        assertNull(dto.number());
    }
}
