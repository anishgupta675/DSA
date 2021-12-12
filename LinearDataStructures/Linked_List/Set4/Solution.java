// Convert a given Binary Tree to Doubly Linked List

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class Solution {
	Node root;

	Node head;

	void BToDLL(Node root) {
		if(root == null) return;

		BToDLL(root.right);

		root.right = head;

		if(head != null) head.left = root;

		head = root;

		BToDLL(root.left);
	}

	void printList(Node head) {
		System.out.println("Extracted Double Linked List is : ");
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
	}

	public static void main(String[] args) throws IOException {}
}
