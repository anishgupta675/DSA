// Iterative Delete

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;

public class Solution {
	static class treeNode {
		int data;
		treeNode left;
		treeNode right;
		public treeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static void inorder(treeNode root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	static treeNode insert(treeNode root, int key) {
		if(root == null) {
			treeNode temp;
			temp = new treeNode(key);
			return temp;
		}
		if(key < root.data) root.left = insert(root.left, key);
		else root.right = insert(root.right, key);
		return root;
	}

	static treeNode deleteIterative(treeNode root, int key) {
		treeNode curr = root;
		treeNode prev = null;

		while(curr != null && curr.data != key) {
			prev = curr;
			if(key < curr.data) curr = curr.left;
			else curr = curr.right;
		}

		if(curr == null) {
			System.out.print("Key " + key + " not found in the" + "  provided BST.\n");
			return root;
		}

		if(curr.left == null || curr.right == null) {
			treeNode newCurr = null;
			if(curr.left == null) newCurr = curr.right;
			else newCurr = curr.left;

			if(prev == null) return newCurr;

			if(curr == prev.left) prev.left = newCurr;
			else prev.right = newCurr;

		} else {
			treeNode p = null;
			treeNode temp;

			temp = curr.right;
			while(temp.left != null) {
				p = temp;
				temp = temp.left;
			}

			if(p != null) p.left = temp.right;

			else curr.right = temp.right;

			curr.data = temp.data;
		}
		return root;
	}

	public static void main(String[] args) throws IOException {}
}
