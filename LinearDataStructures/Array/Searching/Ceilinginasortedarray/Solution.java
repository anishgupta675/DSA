import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int getlimit(int[] arr, int low, int high, int x) {
		if(x <= arr[low]) return low;
		if(x > arr[high]) return -1;
		int mid = (low + high) / 2;
		if(arr[mid] == x) return mid;
		else if(arr[mid] < x) {
			if(mid + 1 <= high && x <= arr[mid + 1]) return mid + 1;
			return getlimit(arr, mid + 1, high, x);
		} else {
			if(mid - 1 >= low && x > arr[mid - 1]) return mid;
			return getlimit(arr, low, mid - 1, x);
		}
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int x = Integer.parseInt(in.readLine());
		System.out.println(sol.getlimit(arr, 0, n - 1, x));
	}
}
