import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] getrev(int[] arr, int k) {
		for(int i = 0; i < arr.length; i++) {
			int left = i, right = Math.min(i + k - 1, arr.length - 1), temp;
			while(left < right) {
				temp = arr[left];
				arr[right] = arr[right];
				arr[right] = temp;
				left+= 1;
				right-= 1;
			}
		}
		return arr;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());
		arr = sol.getrev(arr, k);
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
