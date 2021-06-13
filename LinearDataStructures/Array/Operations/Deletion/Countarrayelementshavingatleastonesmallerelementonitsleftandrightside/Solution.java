import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int getcount(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			while(!stack.isEmpty() && arr[i] < stack.peek()) {
				if(stack.size() > 1) count++;
				stack.pop();
			}
			stack.add(arr[i]);
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getcount(arr));
	}
}
