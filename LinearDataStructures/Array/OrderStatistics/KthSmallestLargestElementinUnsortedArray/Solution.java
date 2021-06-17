import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
class Solution {
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for(int j = low; j <= high; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}
	static void sort(int[] arr, int low, int high) {
		if(low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}
	static int[] getk(int[] arr, int k) {
		sort(arr, 0, arr.length - 1);
		return new int[] {arr[k - 1], arr[arr.length - k]};
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());
		int[] kpair= sol.getk(arr, k);
		System.out.print(kpair[0] + " " + kpair[1]);
	}
}
