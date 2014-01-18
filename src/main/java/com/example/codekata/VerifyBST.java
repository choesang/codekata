package com.example.codekata;

/**
 * 
 * @author choesang
 *	Checks if a given tree is a Binary Search Tree
 */
public class VerifyBST {

//	recursively loop through the tree and check left < parent and right > parent 
	public boolean isBST(Tree t, int small, int large) {
		if (t == null) {
			return true;
		}

		if (t.value > small && t.value < large) {
			return isBST(t.left, small, t.value) && isBST(t.right, t.value, large);
		}

		return false;
	}

}

class Tree {
	public int value;
	public Tree left;
	public Tree right;

	public Tree(int value) {
		this.value = value;
		left = right = null;
	}

}
