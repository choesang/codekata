package com.interview.codekata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElevatorSuperstitionTest {

    ElevatorSuperstition elevatorSuperstition;

    @Before
    public void setUp() {
        elevatorSuperstition = new ElevatorSuperstition();
    }

    @Test
    public void get_lucky_elevator_number() {
        assertEquals(10, elevatorSuperstition.getLuckyFloorNumber(9));
        assertEquals(17, elevatorSuperstition.getLuckyFloorNumber(15));
    }
}