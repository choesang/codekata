package com.example.codekata;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FlattenListTest {

	@Test
	public void test() {
		FlattenList flattenList = FlattenList.getList(Arrays.asList(
				Arrays.asList(6, 8),
				Arrays.asList(4)
		));
		
		assertEquals(new Integer(6), flattenList.next());
		assertEquals(new Integer(8), flattenList.next());
		assertEquals(new Integer(4), flattenList.next());
		assertEquals(false, flattenList.hasNext());
	}

}
