package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestFeline {
    @Spy
    private Feline testFeline;

    @Test
    public void eatMeatReturnPredator() throws Exception {
        testFeline.eatMeat();
        Mockito.verify(testFeline).getFood("Хищник");
    }
    @Test
    public void getFamily() {
        String expectedResult = "Кошачьи";
        String actualResult = testFeline.getFamily();
        Assert.assertEquals("Wrong string returned", expectedResult, actualResult);
    }
    @Test
    public void getKittens() {
        int expectedResult = 1;
        int actualResult = testFeline.getKittens();
        Assert.assertEquals("Wrong int returned", expectedResult, actualResult);

    }

}