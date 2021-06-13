import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int getrem(int[] arr) {
		int sum = 0, multiplier = arr.length % 2 == 0 ? -1 : 1;
		for(int i = 0; i < arr.length; i++) {
			sum+= arr[i] * multiplier;
			multiplier*= (arr.length - 1 - i) / (i + 1) * (-1);
		}
		return sum;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getrem(arr));
	}
}
