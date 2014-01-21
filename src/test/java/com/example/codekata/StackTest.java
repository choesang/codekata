/**
 * 
 */
package com.example.codekata;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author choesang
 *
 */
public class StackTest {

	@Test
	public void testStack() {
		StackWithArrayList<Integer> stack = new StackWithArrayList<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		assertEquals(4, (int) stack.pop());
		assertEquals(3, (int) stack.pop());
		assertEquals(2, (int) stack.pop());
		assertEquals(1, (int) stack.pop());
	}

}
