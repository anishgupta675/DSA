import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int partition(int[] arr) {
		int[] min = new int[arr.length];
		int mini = Integer.MAX_VALUE;
		for(int i = arr.length - 1; i >= 0; i--) {
			mini = Math.min(mini, arr[i]);
			min[i] = mini;
		}
		int maxi = Integer.MIN_VALUE;
		int ind = -1;
		for(int i = 0; i < arr.length - 1; i++) {
			maxi = Math.max(maxi, arr[i]);
			if(maxi < min[i + 1]) {
				ind = i;
				break;
			}
		}
		return ind;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		for(int i = 0; i < n; i++) {
			if((i - 1) == sol.partition(arr)) System.out.println();
			System.out.print(arr[i] + " ");
		}
	}
}
