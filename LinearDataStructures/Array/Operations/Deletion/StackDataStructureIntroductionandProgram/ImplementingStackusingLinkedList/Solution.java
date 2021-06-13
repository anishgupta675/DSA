import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	StackNode root;
	static class StackNode {
		int data;
		StackNode next;
		StackNode(int data) {
			this.data = data;
		}
	}
	public boolean isEmpty() {
		if(root == null) return true;
		else return false;
	}
	public void push(int data) {
		StackNode new_node = new StackNode(data);
		if(root == null) root = new_node;
		else {
			StackNode temp = root;
			root = new_node;
			new_node.next = temp;
		}
	}
	public int pop() {
		int popped = Integer.MIN_VALUE;
		if(root != null) {
			popped = root.data;
			root = root.next;
		}
		return popped;
	}
	public int peek() {
		if(root == null) return Integer.MIN_VALUE;
		else return root.data;
	}
	static void printlist(Stack s) {
		Stack s_new = s;
		while (s_new.isEmpty()) {
			System.out.print(s_new.peek() + " ");
			s_new.pop();
		}
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		Stack s = new Stack();
		for(int i = 0; i < n; i++) {
			int data = Integer.parseInt(in.readLine());
			s.push(data);
		}
		printlist(s);
		n = Integer.parseInt(in.readLine());
		for(int i = 0; i < n; i++)
			s.pop();
		printlist(s);
	}
}
