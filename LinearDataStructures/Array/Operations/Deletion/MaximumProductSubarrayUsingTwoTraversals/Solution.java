import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int getmax(int[] arr) {
		int ans = Integer.MAX_VALUE, max_val = 1, min_val = 1, prev_max;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0) {
				max_val*= arr[i];
				min_val = Math.min(1, min_val * arr[i]);
			} else if(arr[i] == 0) {
				min_val = 1;
				max_val = 0;
			} else if(arr[i] < 0) {
				prev_max = max_val;
				max_val = min_val * arr[i];
				min_val = prev_max * arr[i];
			}
			ans = Math.max(ans, max_val);
			if(max_val <= 0) max_val = 1;
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
		System.out.println(sol.getmax(arr));
	}
}
