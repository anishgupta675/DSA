import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int getsum(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum+= arr[i];
		return sum;
	}
	static int getequilibrium(int[] arr) {
		int res = Integer.MIN_VALUE, prefix_sum = 0, suffix_sum = getsum(arr);
		for(int i = 0; i < arr.length; i++) {
			prefix_sum+= arr[i];
			if(prefix_sum == suffix_sum) res = Math.max(prefix_sum, res);
			suffix_sum-= arr[i];
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getequilibrium(arr));
	}
}
