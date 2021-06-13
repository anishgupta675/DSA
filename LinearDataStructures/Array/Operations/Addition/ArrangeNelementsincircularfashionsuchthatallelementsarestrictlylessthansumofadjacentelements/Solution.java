import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	static int[] reverse(int[] arr) {
		for(int i = 0, j = (arr.length - 1); i <= j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return arr;
	}
	static void split(int[] arr) {
		if(arr.length <= 1) return;
		int mid = arr.length / 2;
		int[] left = new int[mid];
		int[] right = new int[arr.length - mid];
		for(int i = 0; i < mid; i++)
			left[i] = arr[i];
		for(int i = mid; i < arr.length; i++)
			right[i - mid] = arr[i];
		split(left);
		split(right);
		merge(arr, left, right);
	}
	static void merge(int[] arr, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		while((i < left.length) && j < (right.length)) {
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while(i < left.length) {
			arr[k] = left[i];
			k++;
			i++;
		}
		while(j < right.length) {
			arr[k] = right[j];
			k++;
			j++;
		}
	}
     	static int[] mergesort(int[] arr) {
		split(arr);
		return arr;
	}
     /*	static int[] arrange(int[] arr) {
		arr = mergesort(arr);
		int mid = (int)Math.ceil(arr.length / 2.0);
		int[] left = new int[mid];
		int[] right = new int[arr.length - mid];
		int k = 0;
		for(int i = 0; i < arr.length; i++) {
			if(i % 2 == 0) left[i / 2] = arr[i];
			else {
				right[k] = arr[i];
				k++;
			}
		}
		mergesort(left);
		mergesort(right);
		right = reverse(right);
		for(int i = 0; i < mid; i++)
			arr[i] = left[i];
		for(int i = mid; i < arr.length; i++)
			arr[i] = right[i - mid];
		return arr;
	} */
	static int[] arrange(int[] arr) {
		arr = mergesort(arr);
		int[] brr = new int[arr.length];
		int low = 0, high = arr.length - 1;
		for(int i = 0; i < arr.length; i++) {
			if(i % 2 == 0) brr[low++] = arr[i];
			else brr[high--] = arr[i];
		}
		for(int i = 0; i < arr.length; i++) {
			if(i == 0)
				if((brr[i + 1] + brr[arr.length - 1]) <= brr[i]) return null;
			else if(i == (arr.length - 1))
				if((brr[0] + brr[i - 1]) <= brr[i]) return null;
			else
				if((brr[i - 1] + brr[i + 1]) <= brr[i]) return null;
		}
		return brr;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		if(arr == null) throw new IllegalArgumentException("Empty Array");
		arr = sol.arrange(arr);
		if(arr == null) System.out.println("-1");
		else {
			for(int i = 0; i < n; i++)
				System.out.print(arr[i] + " ");
		}
	}
}
