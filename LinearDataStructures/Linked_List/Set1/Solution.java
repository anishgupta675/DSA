// Linked List (Introduction)

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;

public class LinkedList {
	Node head;

	static class Node {
		int data;
		Node next;
		Node(int d) {
			this.data = d;
			next = null;
		}
	}

	public void printList() {
		Node n = head;
		while(n != null) {
			System.out.println(n.data + " ");
			n = n.next;
		}
	}

	public static void main(String[] args) throws IOException {}
}
