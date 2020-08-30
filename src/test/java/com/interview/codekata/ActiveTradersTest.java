package com.interview.codekata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ActiveTradersTest {

    ActiveTraders activeTraders;

    @Before
    public void setUp() throws Exception {

        activeTraders = new ActiveTraders();
    }

    @Test
    public void try_test() {
        System.out.println(1<<3);
    }

    @Test
    public void compute_active_traders_above_5_percentage() {

        Assert.assertEquals(List.of("Beta", "Zeta"), activeTraders.mostActive(Arrays.asList("Alpha",
          "Beta",
          "Zeta",
          "Beta",
          "Zeta",
          "Zeta",
          "Epsilon",
          "Beta",
          "Zeta",
          "Beta",
          "Zeta",
          "Beta",
          "Delta",
          "Zeta",
          "Beta",
          "Zeta",
          "Beta",
          "Zeta",
          "Beta",
          "Zeta",
          "Beta")));


    }
}