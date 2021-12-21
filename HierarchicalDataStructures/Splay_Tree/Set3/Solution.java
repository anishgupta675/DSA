// Delete

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;

public class Solution {
	static class Node {
		int key;
		Node left, right;
		Node(int key) {
			this.key = key;
			this.left = null; this.right = null;
		}
	}

	Node rightRotate(Node x) {
		Node y = x.left;
		x.left = y.right;
		y.right = x;
		return y;
	}

	Node leftRotate(Node x) {
		Node y = x.right;
		x.right = y.left;
		y.left = x;
		return y;
	}

	Node splay(Node root, int key) {
		if(root == null || root.key == key) return root;

		if(root.key > key) {
			if(root.left == null) return root;

			if(root.left.key > key) {
				root.left.left = splay(root.left.left, key);

				root = rightRotate(root);
			} else if(root.left.key < key) {
				root.left.right = splay(root.left.right, key);

				if(root.left.right != null) root.left = leftRotate(root.left);
			}

			return (root.left == null) ? root: rightRotate(root);
		} else {
			if(root.right == null) return root;

			if(root.right.key > key) {
				root.right.left = splay(root.right.left, key);

				if(root.right.left != null) root.right = rightRotate(root.right);
			} else if(root.right.key < key) {
				root.right.right = splay(root.right.right, key);
				root = leftRotate(root);
			}

			return (root.right == null) ? root: leftRotate(root);
		}
	}

	Node delete_key(Node root, int key) {
		Node temp;
		if(root == null) return null;

		root = splay(root, key);

		if(key != root.key) return root;

		if(root.left == null) {
			temp = root;
			root = root.right;
		}

		else {
			temp = root;

			root = splay(root.left, key);

			root.right = temp.right;
		}

		return root;
	}

	void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.key + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void main(String[] args) throws IOException {}
}
