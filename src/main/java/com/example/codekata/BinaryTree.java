package com.example.codekata;

public class BinaryTree {
	static Node root;

	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);

		if (root == null) {
			root = newNode;
		} else {

			Node focusNode = root;
			Node parent;

			while (true) {
				parent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.addNode(5, "n0");
		binaryTree.addNode(1, "n1");
		binaryTree.addNode(2, "n2");
		binaryTree.addNode(3, "n3");
		binaryTree.addNode(4, "n4");
		binaryTree.addNode(5, "n5");
		binaryTree.addNode(6, "n6");
		
		System.out.println("InOrderTraversal: ");
		inOrderTraverseTree(root);
		System.out.println("PreOrderTraversal: ");
		preOrderTraverseTree(root);
		System.out.println("postOrderTraverseTree: ");
		postOrderTraverseTree(root);
		
		System.out.println("find node 4: " + findNode(3));
	}
	
	private static boolean remove(int key) {
		
		Node focusNode = root;
		
		return false;
	}
	
	private static Node findNode(int key) {
		Node focusNode = root;
		while (key != focusNode.key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
			
			if (focusNode == null) {
				return null;
			}
		}
		return focusNode;
	}

	private static void inOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	private static void preOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode);
			preOrderTraverseTree(focusNode.leftChild);
			preOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	private static void postOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}

	public class Node {
		int key;
		String name;

		Node leftChild;
		Node rightChild;

		/**
		 * @param key
		 * @param name
		 */
		public Node(int key, String name) {
			super();
			this.key = key;
			this.name = name;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Node [key=" + key + ", name=" + name + "]";
		}

	}

}
