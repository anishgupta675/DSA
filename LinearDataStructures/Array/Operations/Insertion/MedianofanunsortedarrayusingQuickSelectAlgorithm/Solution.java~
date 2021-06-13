import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int a, b;
	static int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		return arr;
	}
	static int partition(int[] arr, int low, int high) {
		int last = arr[high], i = low, j = low;
		while(j < high) {
			if(arr[j] < last) {
				arr = swap(arr, i, j);
				i++;
			}
			j++;
		}
		arr = swap(arr, i, high);
		return i;
	}
	static int random(int[] arr, int low, int high) {
		int n = high - low + 1;
		int pivot = (int)(Math.random() % n);
		arr = swap(arr, low + pivot, high);
		return partition(arr, low, high);
	}
	static int medianutil(int[] arr, int low, int high, int k) {
		if(low <= high) {
			int index = random(arr, low, high);
			if(index == k) {
				b = arr[index];
				if(a != -1) return Integer.MIN_VALUE;
			} else if(index == (k - 1)) {
				a = arr[index];
				if(b != -1) return Integer.MIN_VALUE;
			}
			if(index >= k) return medianutil(arr, low, (index - 1), k);
			else return medianutil(arr, (index + 1), high, k);
		}
		return Integer.MIN_VALUE;
	}
	static int getmedian(int[] arr) {
		int ans;
		a = -1;
		if((arr.length) % 2 == 1) ans = medianutil(arr, 0, (arr.length - 1), (arr.length / 2));
		else ans = (a + medianutil(arr, 0, (arr.length - 1), (arr.length / 2))) / 2;
		return ans;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getmedian(arr));
	}
}
