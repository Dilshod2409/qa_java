package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Feline feline;

    @Test
    void getSoundReturnsMeow() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodDelegatesToPredator() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        when(feline.eatMeat()).thenReturn(expected);

        Cat cat = new Cat(feline);

        List<String> actual = cat.getFood();

        assertEquals(expected, actual);
    }
}