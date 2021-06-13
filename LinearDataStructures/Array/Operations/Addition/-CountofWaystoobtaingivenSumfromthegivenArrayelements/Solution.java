import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int knapsack(int[] arr, int s) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum+= arr[i];
		if((sum > s) || (((sum + s) % 2) == 0)) return 0;
		int[] dp = new int[((sum + s) / 2) + 1];
		for(int i = 0; i < arr.length; i++) {
			for(int j = ((sum + s) / 2); j >= arr[i]; j++)
				dp[i] = dp[i - arr[j]];
		}
		return dp[dp.length - 1];
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int s = Integer.parseInt(in.readLine());
		System.out.println(sol.knapsack(arr, s));
	}
}
