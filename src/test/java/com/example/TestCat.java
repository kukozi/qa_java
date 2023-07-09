package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {
    @Mock
    private Feline testFeline;

    @Test
    public void testGetSound() {
        Cat testCat = new Cat(testFeline);
        String expectedResult = "Мяу";
        String actualResult = testCat.getSound();
        Assert.assertEquals("Wrong string returned", expectedResult, actualResult);
    }

    @Test
    public void testGetFood() throws Exception {
        Cat testCat = new Cat(testFeline);
        testCat.getFood();
        Mockito.verify(testFeline).eatMeat();
    }

}