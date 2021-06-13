import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
class Solution {
	static int getpoint(int[] arr, int low, int high) {
		if(low > high) return -1;
		if(arr[low] == low) return low;
		if(arr[high] == high) return high;
		int mid = (low + high) / 2;
		if(arr[mid] == mid) return mid;
		if(arr[mid] > mid) return getpoint(arr, low + 1, mid - 1);
		return getpoint(arr, mid + 1, high - 1);
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getpoint(arr, 0, n - 1));
	}
}
