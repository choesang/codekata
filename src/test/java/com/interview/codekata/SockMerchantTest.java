package com.interview.codekata;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SockMerchantTest {

    SockMerchant sockMerchant;

    @Before
    public void setUp() {
        sockMerchant = new SockMerchant();
    }

    @Test
    public void count_pairs_of_socks_for_all_colors() {
        assertEquals(3, sockMerchant.countPairs(9, new int[]{10,20,20,10,10,30,50,10,20}));
        assertEquals(4, sockMerchant.countPairs(10, new int[]{1,1,3,1,2,1,3,3,3,3}));
    }

}