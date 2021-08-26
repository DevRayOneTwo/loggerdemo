package ru.devray.schools.tdd;

import java.util.Arrays;

public class StringUtil {
    public String convertIntArray(int[] ints) {
        return Arrays.stream(ints).mapToObj((i)->i+"").reduce((s, s1) -> s + " " + s1 ).get();
    }

    public int addNumbers(int i1, int i2){
        return i1 + i2;
    }
}
