package com.example.codekata;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UniqueSubStringsTest {
	
	private UniqueSubStrings uniqueSubStrings;

	@Before
	public void setUp() throws Exception {
		uniqueSubStrings = new UniqueSubStrings();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPermutate() {
		
		String text = "abababababababababababababababababab";
		Set<String> permutate = uniqueSubStrings.permutate(text);
		
//		assertEquals(71, permutate.size());
		
		
	}

}
