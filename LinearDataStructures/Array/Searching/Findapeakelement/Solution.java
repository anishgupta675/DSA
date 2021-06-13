import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
class Solution {
	static int getpeak(int[] arr, int low, int high) {
		if(low >= high) return -1;
		if(high - low == 0) return low;
		int mid = (low + high) / 2;
		if(high - low == 1) {
			if(mid == low) {
				if(arr[mid] >= arr[mid + 1]) return mid;
				else return mid + 1;
			} else {
				if(arr[mid] >= arr[mid - 1]) return mid;
				else return mid - 1;
			}
		}
		if(arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) return mid;
		if(arr[mid] < arr[mid - 1]) return getpeak(arr, low, mid - 1);
		return getpeak(arr, mid + 1, high);
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(arr[sol.getpeak(arr, 0, n - 1)]);
	}
}
