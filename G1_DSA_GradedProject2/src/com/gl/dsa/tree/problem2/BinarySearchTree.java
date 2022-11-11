package com.gl.dsa.tree.problem2;

public class BinarySearchTree {

	public Node node;
	Node prevNode = null;
	Node headNode = null;

	// Function to to convert the binary
	// search tree into a skewed tree in
	// increasing / decreasing order
	public void convertBSToSkewedTree(Node root, int order) {

		// Base Case
		if (root == null) {
			return;
		}

		// Condition to check the order
		// in which the skewed tree to
		// maintained
		if (order > 0) {
			convertBSToSkewedTree(root.right, order);
		} else {
			convertBSToSkewedTree(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		// Condition to check if the root Node
		// of the skewed tree is not defined
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		// Similarly recurse for the left / right
		// subtree on the basis of the order required
		if (order > 0) {
			convertBSToSkewedTree(leftNode, order);
		} else {
			convertBSToSkewedTree(rightNode, order);
		}
	}

	// Function to traverse the right
	// skewed tree using recursion
	public void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

}
