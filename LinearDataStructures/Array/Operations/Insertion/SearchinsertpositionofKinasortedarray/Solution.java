import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int searchpos(int[] arr, int low, int high, int k) {
		if(arr.length == 0) return -1;
	     	if(arr.length == 1) {
			if(arr[low] == 0) return low;
			if(arr[low] == k) return low;
			return -1;
		}
		if(arr[low] == 0 && arr[high] == 0) return low;
		if(arr[low] >= k) return low;
		if(arr[high] <= k) return high;
		int mid = high - (low + high);
		if(arr[mid] <= k && arr[mid + 1] >= k) return (mid + 1);
		if(arr[mid] >= k) return searchpos(arr, (low + 1), mid, k);
		return searchpos(arr, (mid + 1), (high - 1), k);
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());
		System.out.println(sol.searchpos(arr, 0, (n - 1), k));
	}
}
