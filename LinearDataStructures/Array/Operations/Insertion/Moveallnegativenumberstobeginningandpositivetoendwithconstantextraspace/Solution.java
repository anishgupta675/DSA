import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] shift(int[] arr, int left, int right) {
		while(left <= right) {
			if(arr[left] < 0 && arr[right] < 0) left++;
			else if(arr[left] > 0 && arr[right] < 0) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			} else if(arr[right] > 0 && arr[right] > 0) right--;
			else {
				left++;
				right--;
			}
		}
		return arr;
	}
	static void printlist(int[] arr, int right) {
		for(int i = 0; i <= right; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		sol.printlist(sol.shift(arr, 0, (n - 1)), (n - 1));
	}
}
