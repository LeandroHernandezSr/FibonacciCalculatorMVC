package com.lhernandez.fibonacci.app.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetOccurrencesDtoTest {

    @Test
    void constructor_ShouldSetValuesCorrectly() {
        GetOccurrencesDto dto = new GetOccurrencesDto(5, 3);

        assertEquals(5, dto.number());
        assertEquals(3, dto.occurrences());
    }

    @Test
    void equalsAndHashCode_SameValues_ShouldBeEqual() {
        GetOccurrencesDto dto1 = new GetOccurrencesDto(8, 2);
        GetOccurrencesDto dto2 = new GetOccurrencesDto(8, 2);

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void equals_DifferentValues_ShouldNotBeEqual() {
        GetOccurrencesDto dto1 = new GetOccurrencesDto(8, 2);
        GetOccurrencesDto dto2 = new GetOccurrencesDto(8, 3);

        assertNotEquals(dto1, dto2);
    }

    @Test
    void toString_ShouldContainFieldNamesAndValues() {
        GetOccurrencesDto dto = new GetOccurrencesDto(13, 1);

        String result = dto.toString();

        assertTrue(result.contains("number=13"));
        assertTrue(result.contains("occurrences=1"));
    }

    @Test
    void record_AllowsNullValues() {
        GetOccurrencesDto dto = new GetOccurrencesDto(null, null);

        assertNull(dto.number());
        assertNull(dto.occurrences());
    }
}