package com.example.codekata;

/**
 * 
 * @author choesang
 *	Checks if a given tree is a Binary Search Tree
 */
public class VerifyBST {

//	recursively loop through the tree and check left < parent and right > parent 
	public boolean isBST(Tree node, Tree leftNode, Tree rightNode) {
		if (leftNode == null && rightNode == null) {
			return true;
		}

		if (isGreaterThan(node, leftNode) && isLessThan(node, rightNode)) {
			return isBST(node.left, leftNode.left, leftNode.right) && isBST(node.right, rightNode.left, rightNode.right);
		}
		return false;
	}

	public boolean isGreaterThan(Tree node, Tree left) {
		return left == null || node.value > left.value;
	}

	public boolean isLessThan(Tree node, Tree right) {
		return right == null || node.value < right.value;
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
