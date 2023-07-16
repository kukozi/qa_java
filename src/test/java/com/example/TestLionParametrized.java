package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class TestLionParametrized {
    private Lion testLion;
    private String sex;
    private boolean hasMane;
    Feline testFeline = new Feline();

    public TestLionParametrized(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] lionTestSet() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception{
        Lion testLion = new Lion(sex, testFeline);
        Assert.assertEquals("Wrong int returned", hasMane, testLion.doesHaveMane());
    }

}