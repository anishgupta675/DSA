// Deletion

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;

public class Solution {
	static Node start;

	static class Node {
		int data;
		Node next;
		Node prev;
	};

	static Node insert(Node start, int value) {
		if(start == null) {
			Node new_node = new Node();
			new_node.data = value;
			new_node.next = new_node.prev = new_node;
			start = new_node;
			return start;
		}

		Node last = (start).prev;

		Node new_node = new Node();
		new_node.data = value;

		new_node.next = start;

		(start).prev = new_node;

		new_node.prev = last;

		last.next = new_node;
		return start;
	}

	static Node deleteNode(Node start, int key) {
		if(start == null) return null;

		Node curr = start, prev_1 = null;
		while(curr.data != key) {
			if(curr.next == start) {
				System.out.printf("\nList doesn't have node with value = %d", key);
				return start;
			}

			prev_1 = curr;
			curr = curr.next;
		}

		if(curr == start) {
			prev_1 = (start).prev;

			start = (start).next;

			prev_1.next = start;
			(start).prev = prev_1;
		}

		else if(curr.next == start) {
			prev_1.next = start;
			(start).prev = prev_1;
		}
		return start;
	}

	static void dispay(Node start) {
		Node temp = start;

		while(temp.next != start) {
			System.out.printf("%d ", temp.data);
			temp = temp.next;
		}
		System.out.printf("%d ", temp.data);
	}

	public static void main(String[] args) throws IOException {}
}
