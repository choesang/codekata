package com.interview.codekata;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BitOperatorANDTest {

    @Test
    public void test_bit_wise_and_power_2(){

        BitOperatorAND bitOperatorAND = new BitOperatorAND();
        assertEquals(4, bitOperatorAND.countPairs(List.of(1,2,1,3)));
    }

}