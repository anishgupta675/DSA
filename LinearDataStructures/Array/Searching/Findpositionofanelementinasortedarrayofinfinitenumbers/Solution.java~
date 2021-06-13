import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int binarysearch(int[] arr, int low, int high, int x) {
		if(low > high) return -1;
		if(arr[low] == x) return low;
		if(arr[high] == x) return high;
		int mid = high - ((low + high) / 2);
		if(arr[mid] == x) return mid;
		if(arr[mid] > x) return binarysearch(arr, low, (mid - 1), x);
		return binarysearch(arr, (mid + 1), high, x);
	}
	static int search(int[] arr, int low, int high, int x) {
		if(binarysearch(arr, low, high, x) != -1) return binarysearch(arr, low, high, x);
		return search(arr, high, (high * 2), x);
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		List<Integer> list = new ArrayList<Integer>();
		while(true) {
			int data = Integer.parseInt(in.readLine());
			list.add(data);
		}
		int x = Integer.parseInt(in.readLine());
	     	int[] arr = new int[list.size()];
		for(int i = 0; i < arr.length; i++)
			arr[i] = list.get(i);
		System.out.println(sol.search(arr, 0, 1, x));
	}
}
