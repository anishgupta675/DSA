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
	}

	static Node newNode(int item) {
		Node temp = new Node();
		temp.key = item;
		temp.left = temp.right = null;
		return temp;
	}

	static void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.key + " ");
			inorder(root.right);
		}
	}

	static Node insert(Node node, int key) {
		
		if(node == null) return newNode(key);

		if(key < node.key) node.left = insert(node.left, key);
		else node.right = insert(node.right, key);

		return node;
	}

	static Node deleteNode(Node root, int k) {
		if(root == null) return root;

		if(root.key > k) {
			root.left = deleteNode(root.left, k);
			return root;
		} else if(root.key < k) {
			root.right = deleteNode(root.right, k);
			return root;
		}

		if(root.left == null) {
			Node temp = root.right;
			return temp;
		} else if(root.right == null) {
			Node temp = root.left;
			return temp;
		}

		else {
			Node succParent = root;

			Node succ = root.right;

			while(succ.left != null) {
				succParent = succ;
				succ = succ.left;
			}

			if(succParent != root) succParent.left = succ.right;
			else succParent.right = succ.right;

			root.key = succ.key;

			return root;
		}
	}

	public static void main(String[] args) throws IOException {}
}
