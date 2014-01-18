package com.example.codekata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VerifyBSTTest {
	Tree tree;
	@Before
	public void init() {
		//		4
		//	2		6
		//1	  3   5		7
		tree = new Tree(4);
		tree.left = new Tree(2);
		tree.right = new Tree(6);
		tree.left.left = new Tree(1);
		tree.left.right = new Tree(3);
		tree.right.left = new Tree(5);
		tree.right.right = new Tree(7);
	}

	@Test
	public void test() {
		VerifyBST verifyBST = new VerifyBST();
		assertTrue(verifyBST.isBST(tree, Integer.MAX_VALUE, Integer.MAX_VALUE));
	}

}
