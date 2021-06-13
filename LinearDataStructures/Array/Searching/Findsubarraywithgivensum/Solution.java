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
	static int[] getsum(int[] arr, int given_sum) {
		min_index = getmin(arr)
		if(arr[min_index] < 0) {
			for(int i = 0; i < arr.length; i++)
				arr[i]+= Math.abs(arr[min_index]);
			given_sum+= arr.length * Math.abs(arr[min_index]);
		}
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int given_sum = Integer.parseInt(in.readLine());
	}
}
