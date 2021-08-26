package ru.devray.schools.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;

public class StringUtilTest {

    StringUtil util;

    @BeforeEach
    public void setUp(){
        util = new StringUtil();
    }

    @Test
    void testConversionMethodReturnsCorrectType(){
        String result = util.convertIntArray(new int[]{0,9});
        Assertions.assertEquals(result.getClass(), String.class);
        Assertions.assertTrue(result.length() > 0);
    }

    @ParameterizedTest
    @MethodSource({"dataProvider", "dataProvider2"})
    void parameterizedTest(int[] numberArray){
        String result = util.convertIntArray(numberArray);
        System.out.println(result);
        Assertions.assertTrue(result.matches("[-?\\d+\\s*]+"));
    }

    public static Set<int[]> dataProvider(){
        return Set.of(
            new int[]{0, 10, 90,9, 12323},
            new int[]{0},
            new int[]{0, -10, -90,9}
        );
    }

    public static Set<int[]> dataProvider2(){
        return Set.of(
            new int[]{0, 10},
            new int[]{0,1},
            new int[]{}
        );
    }

    @Test
    void negativeTestExample(){
        Assertions.assertThrows(
                NullPointerException.class,
                ()->util.convertIntArray(null)
        );
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3",
            "0, -10, -10",
            "21, 20, 41"})//CSV .csv - comma separated value
    public void testCalculatorAdd(int i1, int i2, int expectedResult){
        int result = util.addNumbers(i1, i2);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv")
    public void testCalculatorAddWithExternalData(int i1, int i2, int expectedResult){
        int result = util.addNumbers(i1, i2);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Alex", "Bob", "Charlie"})
    public void testParameterizedValues(String input){
        System.out.println(input);
    }

}
