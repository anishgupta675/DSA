import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int findsum(int[] arr, int low, int high) {
		int sum = 0;
		for(int i = low; i < high + 1; i++)
			sum+= arr[i];
		return sum;
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
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
			}
			k++;
		}
		if(i < left.length) {
			arr[k] = left[i];
			k++;
			i++;
		}
		if(j < right.length) {
			arr[k] = right[j];
			k++;
			j++;
		}
	}
	static int[] mergesort(int[] arr) {
		split(arr);
		return arr;
	}
	static int findk(int[] arr, int n) {
		for(int i = 0; i < arr.length; i++)
			if((findsum(arr, 0, i) + (arr[i] * (arr.length - (i + 1)))) == n) return i;
		return -1;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int sum = Integer.parseInt(in.readLine());
		int k = sol.findk(arr,sum);
		if(k == -1) System.out.println("Not possible");
		else System.out.println(k);
	}
}
