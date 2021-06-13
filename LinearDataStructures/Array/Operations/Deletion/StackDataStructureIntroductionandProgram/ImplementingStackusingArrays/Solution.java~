import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Stack {
	static final int MAX = 1000;
	int top;
	int[] a = new int[MAX];
	boolean isEmpty() {
		return (top < 0);
	}
	Stack() {
		top = -1;
	}
	boolean push(int x) {
		if(top >= (MAX - 1)) return false;
		else {
			a[++top] = x;
			return true;
		}
	}
	int pop() {
		if(top < 0) return 0;
		else {
			int x = a[top--];
			return x;
		}
	}
	int peek() {
		if(top < 0) return 0;
		else {
			int x = a[top];
			return x;
		}
	}
}
class Solution {
	static void printlist(Stack s) {
		Stack s_new = s;
		while(s_new.isEmpty()) {
			System.out.print(s.peek() + " ");
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
