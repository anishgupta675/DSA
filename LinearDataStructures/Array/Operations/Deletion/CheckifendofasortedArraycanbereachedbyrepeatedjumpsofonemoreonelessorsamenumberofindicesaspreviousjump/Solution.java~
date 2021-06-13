import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int check(int[][] memo, int[] arr, int i, int j) {
		if(i == (arr.length - 1)) return 1;
		if(memo[i][j] != -1) return memo[i][j];
		int flag = 0, k;
		for(k = i + 1; k < arr.length; k++) {
			if(arr[k] - arr[i] > j + 1) break;
			if(arr[k] - arr[i] >= j - 1 && arr[k] - arr[i] <= j + 1) flag = check(memo, arr, k, arr[k] - arr[i]);
			if(flag != 0) break;
		}
		memo[i][j] = flag;
		return memo[i][j];
	}
	static boolean checkarray(int[] arr, int k) {
		int[][] memo = new int[arr.length][arr.length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++)
				memo[i][j] = -1;
		}
		int start_index = 1;
		if(check(memo, arr, start_index, k) != 0) return true;
		return false;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		if(checkarray(arr, 1)) System.out.println("Yes");
		else System.out.println("No");
	}
}
