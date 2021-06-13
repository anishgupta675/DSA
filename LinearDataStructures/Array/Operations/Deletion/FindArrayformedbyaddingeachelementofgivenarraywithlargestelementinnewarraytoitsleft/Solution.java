import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] getarr(int[] arr) {
		int x = 0;
		for(int i = 0; i < arr.length; i++) {
			arr[i]+= x;
			x = Math.max(x, arr[i]);
		}
		return arr;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		arr = sol.getarr(arr);
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
