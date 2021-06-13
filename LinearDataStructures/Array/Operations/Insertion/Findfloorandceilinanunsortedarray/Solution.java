import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int getfloor(int[] arr, int x) {
		int min_val = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > x) continue;
			min_val = Math.min(min_val, (x - arr[i]));
		}
		return (x - min_val);
	}
	static int getceil(int[] arr, int x) {
		int min_val = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < x) continue;
			min_val = Math.min(min_val, (arr[i] - x));
		}
		return (x + min_val);
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int x = Integer.parseInt(in.readLine());
		System.out.println(sol.getfloor(arr, x));
		System.out.println(sol.getceil(arr, x));
	}
}
