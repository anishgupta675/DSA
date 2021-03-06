import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] construct(int[] arr, int m) {
		int sum = 0;
		int[] sum_arr = new int[arr.length];
		for(int i = 0; i < (m / 2) + 1; i++)
			sum+= arr[i];
		sum_arr[0] = sum;
		for(int i = 1; i < arr.length; i++) {
			if(i - (m / 2) - 1 >= 0) sum-= arr[i - (m / 2) - 1];
			if(i + (m / 2) < arr.length) sum+= arr[i + (m / 2)];
			sum_arr[i] = sum;
		}
		return sum_arr;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		arr = sol.construct(arr, m);
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
