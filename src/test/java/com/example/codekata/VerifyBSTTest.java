package com.example.codekata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VerifyBSTTest {

	Tree tree;
	VerifyBST verifyBST;

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

		verifyBST = new VerifyBST();
	}

	@Test
	public void is_binary_search_tree() {
		assertTrue(verifyBST.isBST(tree, tree.left, tree.right));
	}

	@Test
	public void is_not_binary_search_tree() {
		tree.left.left = new Tree(100);
		assertFalse(verifyBST.isBST(tree, tree.left, tree.right));
	}

}
