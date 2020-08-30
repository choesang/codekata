package com.interview;

import com.interview.codekata.JumpingOnClouds;
import org.junit.Assert;
import org.junit.Test;

public class JumpingOnCloudsTest{

    @Test
    public void count_number_of_hops() {
        JumpingOnClouds jumpingOnClouds = new JumpingOnClouds();
        int[] clouds_0 = {0,0,1,0,0,1,0};
        Assert.assertEquals(4, jumpingOnClouds.count(clouds_0, 0, 0));
        int[] clouds_1 = {0,0,0,1,0,0};
        Assert.assertEquals(3, jumpingOnClouds.count(clouds_1, 0, 0));
    }

}