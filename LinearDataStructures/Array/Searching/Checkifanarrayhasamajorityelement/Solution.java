import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
class Solution {
	static void merge(int[] arr, int low, int mid, int high) {
		int i = 0, j = 0, k = low, n1 = mid - low, n2 = high - (mid + 1);
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(i = 0; i < n1; i++)
			L[i] = arr[low + i];
		for(j = 0; j < n2; j++)
			R[j] = arr[(mid + 1) + j];
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
		sort(arr, low, mid);
		sort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}
	static boolean getmajor(int[] arr) {
		int count = 1, max_val = Integer.MIN_VALUE, temp = arr[0], curr_val = 0, flag = 0;
		for(int i = 0; i < arr.length; i++) {
			if(temp == arr[i]) count++;
			else {
				count = 1;
				temp = arr[i];
			}
			if(max_val < count) {
				max_val = count;
				curr_val = arr[i];
				if(max_val > (arr.length / 2)) {
					flag = 1;
					break;
				}
			}
		}
		return ((flag == 1) ? true : false);
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getmajor(arr));
	}
}
