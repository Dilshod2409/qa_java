package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ParameterizedTests {

    @ParameterizedTest(name = "Пол = {0}, есть грива = {1}")
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void lionConstructorSetsManeBySex(String sex, boolean expectedMane) throws Exception {
        Lion lion = new Lion(sex, mock(Feline.class));
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @ParameterizedTest(name = "Количество котят = {0}")
    @ValueSource(ints = {0, 1, 2, 5, 10, 100})
    void felineGetKittensReturnsGivenCount(int count) {
        Feline feline = new Feline();
        assertEquals(count, feline.getKittens(count));
    }
}