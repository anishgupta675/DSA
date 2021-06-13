import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
class Solution {
	static int getmin(int[] arr) {
		int min_index = 0, min_val = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < min_val) {
				min_index = i;
				min_val = arr[i];
			}
		}
		return min_index;
	}
	static int[] getlimit(int[] arr, int req_sum) {
		int min_index = getmin(arr);
		if(arr[min_index] < 0) {
			for(int i = 0; i < arr.length; i++)
				arr[i]+= Math.abs(arr[min_index]);
			req_sum+= arr.length * Math.abs(arr[min_index]);
		}
		int curr_sum = 0, low = 0, high = 0;
		for(int i = 0; i < arr.length; i++) {
			if(curr_sum < req_sum) {
				curr_sum+= arr[i];
				high++;
			}
			if(curr_sum == req_sum) return new int[] {low, high};
			if(curr_sum > req_sum) {
				curr_sum-= arr[low];
				low++;
			}
		}
		return null;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int req_sum = Integer.parseInt(in.readLine());
		int[] pair = sol.getlimit(arr, req_sum);
		if(pair == null) System.out.println("Sum not found");
		else System.out.print(pair[0] + " " + pair[1]);
	}
}
