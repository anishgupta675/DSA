import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int search(int[] arr, int x) {
		for(int i = 0; i < arr.length; i++)
			if(arr[i] == x) return i;
		return -1;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int x = Integer.parseInt(in.readLine());
		System.out.println(sol.search(arr, x));
	}
}
