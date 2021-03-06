import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int findsum(int[] arr, int low, int high) {
		int sum = 0;
		for(int i = low; i < (high + 1); i++)
			sum+= arr[i];
		return sum;
	}
	static int findreverse(int n) {
		int reverse = 0;
		for(int i = n; i > 0; i/= 10)
			reverse = (reverse * 10) + (i % 10);
		return reverse;
	}
	static int prefixsum(int[] arr) {
		int i, leftsum = 0, rightsum = findsum(arr, 0, (arr.length - 1));
		for(i = 0; i < arr.length; i++) {
			rightsum-= arr[i];
			if(leftsum == findreverse(rightsum)) return i;
			leftsum+= arr[i];
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.prefixsum(arr));
	}
}
