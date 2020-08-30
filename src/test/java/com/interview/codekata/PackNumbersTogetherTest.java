package com.interview.codekata;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PackNumbersTogetherTest {

    PackNumbersTogether packNumbersTogether;

    @Before
    public void setUp() {
        packNumbersTogether = new PackNumbersTogether();
    }

    @Test
    public void pack_numbers_together() {
        assertEquals(Arrays.asList("5:3", "7:2", "3", "4", "7"), packNumbersTogether.packNumbers(List.of(5,5,5,7,7,3,4,7)));
        assertEquals(List.of("255:2","67","12:3","36","89:2","54","2","12","36:3"), packNumbersTogether.packNumbers(List.of(255,255,67,12,12,12,36,89,89,54,2,12,36,36,36)));
    }
}