import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int arr_size = 51;
	static int[] dp = new int[arr_size];
	static boolean[] v = new boolean[arr_size];
	static int getmax(int[] arr, int i) {
		if(i >= (arr.length - 1)) return 0;
		if(v[i]) return dp[i];
		v[i] = true;
		dp[i] = Math.max(arr[i] + arr[i + 1] + getmax(arr, (i + 3)), getmax(arr, (i + 1)));
		return dp[i];
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getmax(arr, 0));
	}
}
