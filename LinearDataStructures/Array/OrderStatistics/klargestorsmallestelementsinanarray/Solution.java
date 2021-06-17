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
		for(int j = low; j <= high - 1; j++) {
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
	static int[] getks(int[] arr, int k) {
		sort(arr, 0, arr.length - 1);
		int[] ksmallest = new int[k];
		for(int i = 0; i < k; i++)
			ksmallest[i] = arr[i];
		return ksmallest;
	}
	static int[] getkl(int[] arr, int k) {
		sort(arr, 0, arr.length - 1);
		int[] klargest = new int[k];
		for(int i = 0; i < k; i++)
			klargest[i] = arr[(arr.length - 1) - i];
		return klargest;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());
		int[] ksmallest = sol.getks(arr, k);
		int[] klargest = sol.getkl(arr, k);
		for(int i = 0; i < k; i++)
			System.out.print(ksmallest[i] + " ");
		System.out.println();
		for(int i = 0; i < k; i++)
			System.out.print(klargest[i] + " ");
	}
}
