import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int search(int[] arr, int low, int high, int key) {
		if(arr[low] == key) return low;
		if(arr[high] == key) return high;
		int mid = (low + high) / 2;
		if(arr[mid] == key) return mid;
		if(arr[mid] > key) return search(arr, (low + 1), (mid - 1), key);
		return search(arr, (mid + 1), (high - 1), key);
	}
	static int[] append(int[] arr, int key) {
		if(arr.length == 0) return arr;
		if(key >= arr[arr.length - 1]) return arr;
		if(arr.length == 1 && arr[0] == 0) {
			arr[0] = key;
			return arr;
		}
		if(arr[0] == 0 && arr[arr.length - 1] == 0) {
			arr[0] = key;
			return arr;
		}
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] > arr[i + 1] && arr[i + 1] == 0)
				arr[i + 1] = key;
			else {
				if(arr[i] <= key && arr[i + 1] >= key) {
					if(((arr.length - 1) - (i + 1)) == 0) arr[i + 1] = key;
					else {
						for(int j = (i + 2); j < arr.length - 1; i++)
							arr[j + 1] = arr[j];
						arr[i + 1] = key;
					}
				}
			}
		}
		return arr;
	}
	static int[] delete(int[] arr, int key) {
		if(arr.length == 0) return arr;
		key = search(arr, 0, (arr.length - 1), key);
		for(int i = key; i < arr.length - 1; i++)
			arr[i] = arr[i + 1];
		arr[arr.length - 1] = 0;
		return arr;
	}
	static void printlist(int[] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			int key = Integer.parseInt(in.readLine());
			arr = sol.append(arr, key);
		}
		int key = Integer.parseInt(in.readLine());
		arr = sol.delete(arr, key);
		sol.printlist(arr);
	}
}
