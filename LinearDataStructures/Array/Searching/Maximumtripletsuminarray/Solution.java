import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
class Solution {
	static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	static int findPivot(int[] arr, int low, int high) {
		int pivot = arr[high];
		int p_index = low;
		for(int i = low; i < high; i++) {
			if(arr[i] <= pivot) {
				swap(arr[i], arr[p_index]);
				p_index++;
			}
		}
		swap(arr[p_index], arr[high]);
		return p_index;
	}
	static int findRandomPivot(int[] arr, int low, int high) {
		int n = high - low + 1, p_index = findPivot(arr, low, high) % n;
		swap(arr[high], arr[low + p_index]);
		int pivot = arr[high];
		p_index = low;
		for(int i = low; i < high; i++) {
			if(arr[i] <= pivot) {
				swap(arr[i], arr[p_index]);
				p_index++;
			}
		}
		swap(arr[p_index], arr[high]);
		return p_index;
	}
	static int[] kLargest(int[] arr, int low, int high, int k) {
		if(low == high) return null;
		int j = 0, p_index = findRandomPivot(arr, low, high);
		int[] triplet = new int[k];
		if(k == p_index) {
			for(int i = (arr.length - p_index); i < arr.length; i++)
				triplet[j++] = arr[i];
		} else if(k < p_index) return kLargest(arr, low, p_index - 1, k);
		return kLargest(arr, p_index + 1, high, k);
	}
	static int getmaxsum(int[] arr) {
		int[] triplet = kLargest(arr, 0, arr.length - 1, 3);
		if(triplet == null) return 0;
		return (triplet[0] + triplet[1] + triplet[2]);
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getmaxsum(arr));
	}
}
