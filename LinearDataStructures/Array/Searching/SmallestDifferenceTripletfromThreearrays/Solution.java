import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
class Solution {
	static void merge(int[] arr, int low, int mid, int high) {
		int i = 0, j = 0, k = low;
		int n1 = mid - low;
		int n2 = high - mid + 1;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(i = 0; i < n1; i++)
			L[i] = arr[i];
		for(j = 0; j < n2; j++)
			R[j] = arr[mid + i];
		i = 0; j = 0; k = low;
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while(i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	static void sort(int[] arr, int low, int high) {
		if(low >= high) return;
		int mid = (low + high) / 2;
		sort(arr, low, mid - 1);
		sort(arr, mid, high);
		merge(arr, low, mid, high);
	}
	static int getmin(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
	static int getmax(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}
	static int[] getsmall(int[] arr1, int[] arr2, int[] arr3) {
		sort(arr1, 0, arr1.length);
		sort(arr2, 0, arr2.length);
		sort(arr3, 0, arr3.length);
		int i = 0, j = 0, k = 0, res_min = 0, res_mid = 0, res_max = 0, diff = Integer.MAX_VALUE;
		while(i < arr1.length && j < arr2.length && k < arr3.length) {
			int sum = arr1[i] + arr2[j] + arr3[k];
			int min_val = getmin(arr1[i], arr2[j], arr3[j]);
			int max_val = getmax(arr1[i], arr2[j], arr3[k]);
			if(min_val == arr1[i]) i++;
			else if(min_val == arr2[j]) j++;
			else k++;
			if(diff > (max_val - min_val)) {
				diff = max_val = min_val;
				res_min = min_val;
				res_mid = sum - (max_val + min_val);
				res_max = max_val;
			}
		}
		return new int[] {res_min, res_mid, res_max};
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr1 = new int[n];
		for(int i = 0; i < n; i++)
			arr1[i] = Integer.parseInt(in.readLine());
		int[] arr2 = new int[n];
		for(int i = 0; i < n; i++)
			arr2[i] = Integer.parseInt(in.readLine());
		int[] arr3 = new int[n];
		for(int i = 0; i < n; i++)
			arr3[i] = Integer.parseInt(in.readLine());
		int[] res = sol.getsmall(arr1, arr2, arr3);
		System.out.print(res[0] + " " + res[1] + " " + res[2]);
	}
}
