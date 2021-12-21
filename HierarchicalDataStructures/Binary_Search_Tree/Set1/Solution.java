// Binary Search Tree (Search and Insertion)

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;

public class Solution {
	public static void main(String[] args) throws IOException {}
}

class Node {
	Node left;
	int val;
	Node right;
	Node(int val) {
		this.val = val;
	}
}

class BST {
	Node root;

	public void insert(int key) {
		Node node = new Node(key);
		if(root == null) {
			root = node;
			return;
		}
		Node prev = null;
		Node temp = root;
		while(temp != null) {
			if(temp.val > key) {
				prev = temp;
				temp = temp.left;
			} else if(temp.val < key) {
				prev = temp;
				temp = temp.right;
			}
		}
		if(prev.val > key) prev.left = node;
		else prev.right = node;
	}

	public void inorder() {
		Node temp = root;
		Stack<Node> stack = new Stack<>();
		while(temp != null || !stack.isEmpty()) {
			if(temp != null) {
				stack.add(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				System.out.print(temp.val + " ");
				temp = temp.right;
			}
		}
	}
}
