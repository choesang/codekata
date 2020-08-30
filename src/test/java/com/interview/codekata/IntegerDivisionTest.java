package com.interview.codekata;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IntegerDivisionTest {


    @Test
    public void minimum_operation() {
        IntegerDivision integerDivision = new IntegerDivision();
        assertEquals(3, integerDivision.minOperations(List.of(64, 30, 25, 33), 2, 2));
    }

}