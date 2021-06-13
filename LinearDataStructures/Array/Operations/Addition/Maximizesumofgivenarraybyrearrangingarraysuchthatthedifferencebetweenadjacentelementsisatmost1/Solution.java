import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static long maximize(int[] arr) {
		int n = arr.length;
		int[] count = new int[n + 1];
		for(int x : arr)
			count[Math.min(x, n)]++;
		int size = 0;
		long ans = 0;
		for(int k = 1; k <= n; k++) {
			while(count[k] > 0 && size < k) {
				size++;
				ans+= size;
				count[k]--;
			}
			ans+= k * count[k];
		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.maximize(arr));
	}
}
