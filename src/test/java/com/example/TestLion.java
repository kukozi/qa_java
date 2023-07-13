package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class TestLion {
    private Lion testLion;
    private String sex;
    private boolean hasMane;

    public TestLion(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void initLion() throws Exception {
        MockitoAnnotations.initMocks(this);
        testLion = new Lion(sex);
    }

    @Parameterized.Parameters
    public static Object[][] lionTestSet() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testGetKittens() {
        int expectedResult = 1;
        int actualResult = testLion.getKittens();
        Assert.assertEquals("Wrong int returned", expectedResult, actualResult);
    }

    @Test
    public void testDoesHaveMane() {
        Assert.assertEquals("Wrong int returned", hasMane, testLion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        Assert.assertEquals("Wrong list returned", List.of("Животные", "Птицы", "Рыба"), testLion.getFood());
    }

    @Test
    public void testLionWrongSexPassed() throws Exception {
        String exceptionMessage = "Используйте допустимые значения пола животного - самей или самка";
        Exception exception = Assert.assertThrows(Exception.class, () -> new Lion("Лев-квир"));
        Assert.assertEquals("Exception handled improperly", exceptionMessage, exception.getMessage());
    }

}