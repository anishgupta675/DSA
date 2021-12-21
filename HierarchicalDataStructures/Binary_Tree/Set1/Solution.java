// Binary Tree (Introduction)

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

public class Solution {
	Node root;

	Solution(int key) {
		root = new Node(key);
	}

	Solution() {
		root = null;
	}

	public static void main(String[] args) throws IOException {}
}
