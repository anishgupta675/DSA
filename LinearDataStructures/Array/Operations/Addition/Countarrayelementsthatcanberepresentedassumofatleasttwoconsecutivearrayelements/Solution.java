import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static boolean nearestpower(double n) {
		if(n == 1.0) return true;
		if(n < 1.0) return false;
		double temp = n;
		return nearestpower(temp / 2.0);
	}
	static int findcount(int[] arr) {
		int ans = 0;
		int[] cnt = new int[arr.length + 1];
		for(int i : arr)
			++cnt[i];
		for(int i = 0; i < arr.length; i++) {
			int sum = 0;
			for(int j = i; j < arr.length; j++) {
				sum+= arr[j];
				if (i == j) continue;
				if(sum <= arr.length) {
					ans+= cnt[sum];
					cnt[sum] = 0;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.findcount(arr));
	}
}
