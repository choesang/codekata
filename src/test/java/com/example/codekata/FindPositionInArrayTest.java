package com.example.codekata;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FindPositionInArrayTest {

	private FindPositionInArray findPositionInArray;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		findPositionInArray = new FindPositionInArray();
		int[] data = {1,4,5,7,9,12};
		int computeLocation = FindPositionInArray.computeLocation(4, 6, data);
		assertEquals(1, computeLocation);
	}

}
