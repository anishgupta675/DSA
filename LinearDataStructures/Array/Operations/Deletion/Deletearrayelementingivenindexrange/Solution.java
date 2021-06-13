import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] delrange(int[] arr, int l, int r) {
		int j = 0;
		for(int i = 0; i < arr.length; i++) {
			if(i <= l || i >= r) {
				arr[j] = arr[i];
				j++;
			}
		}
		int[] new_arr = new int[j];
		for(int i = 0; i < j; i++)
			new_arr[i] = arr[i];
		return new_arr;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int l = Integer.parseInt(in.readLine());
		int r = Integer.parseInt(in.readLine());
		int[] new_arr = sol.delrange(arr, l, r);
		for(int i = 0; i < new_arr.length; i++)
			System.out.print(new_arr[i] + " ");
	}
}
