package com.interview.codekata;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

public class UnexpectedDemandTest extends TestCase {

    public void test_order_fulfillable() {

        UnexpectedDemand fulfillOrder = new UnexpectedDemand();
        Assert.assertEquals(2, fulfillOrder.filledOrders(Arrays.asList(30,10), 40));

    }

}