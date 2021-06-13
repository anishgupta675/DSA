import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] construct(int[] arr) {
		int[] new_arr = new int[arr.length];
		for(int i = 0; i < new_arr.length; i++) {
			if(i % 2 == 0) new_arr[i] = -arr[i + 1];
			else new_arr[i] = -arr[i - 1];
		}
		return new_arr;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		arr = sol.construct(arr);
		for(int i = 0; i < n; i++)
			System.out.println(arr[i] + " ");
	}
}
