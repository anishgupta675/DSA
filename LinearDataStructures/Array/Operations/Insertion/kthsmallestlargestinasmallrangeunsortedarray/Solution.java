import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int getmedian(int[] arr, int i, int n) {
		if(i <= n) Arrays.sort(arr, i, n);
		else Arrays.sort(arr, n, i);
		return arr[arr.length / 2];
	}
	static int kthsmallest(int[] arr, int low, int high, int k) {
		if(k > 0 && k <= ((high - low) + 1)) {
			int i, n = (high - low) + 1;
			int[] median = new int[(n / 4) / 5];
			for(i = 0; i < n / 5; i++)
				median[i] = getmedian(arr, (low + i * 5), 5);
			if((i * 5) < n) {
				median[i] = getmedian(arr, (low + i * 5), (n % 5));
				i++;
			}
			int med_rec = (i == 1) ? median[i - 1] : kthsmallest(median, 0, (i - 1), (i / 2));
			int pos = partition(arr, low, high, med_rec);
			if((pos - low) == (k - 1)) return arr[pos];
			if((pos - low) > (k - 1)) return kthsmallest(arr, low, (pos - 1), k);
			return kthsmallest(arr, (pos + 1), high, (k - pos + low - 1));
		}
		return Integer.MAX_VALUE;
	}
	static int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}
	static int partition(int[] arr, int low, int high, int x) {
		int i;
		for(i = low; i < high; i++)
			if(arr[i] == x) break;
		arr = swap(arr, i, high);
		i = low;
		for(int j = low; j < high; j++) {
			if(arr[j] <= x) {
				arr = swap(arr, i, j);
				i++;
			}
		}
		arr = swap(arr, i, high);
		return i;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());
		System.out.println(sol.kthsmallest(arr, 0, (n - 1), k));
	}
}
