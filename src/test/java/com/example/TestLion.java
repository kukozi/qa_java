package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class TestLion {
    private String sex = "Самец";
    @Mock
    private Feline testFeline;
    private Lion testLion;
    @Before
    public void initLion() throws Exception {
        testLion = new Lion(sex, testFeline);
    }
    @Test
    public void testGetKittens() {
        Mockito.when(testFeline.getKittens()).thenReturn(1);
        int expectedResult = 1;
        int actualResult = testLion.getKittens();
        Assert.assertEquals("Wrong int returned", expectedResult, actualResult);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> foodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(testFeline.getFood("Хищник")).thenReturn(foodList);
        Assert.assertEquals("Wrong list returned", foodList, testLion.getFood());
    }

    @Test
    public void testLionWrongSexPassed() throws Exception {
        String exceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = Assert.assertThrows(Exception.class, () -> new Lion("Лев-квир", testFeline));
        Assert.assertEquals("Exception handled improperly", exceptionMessage, exception.getMessage());
    }

}