import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
class Solution {
	static int getmax(int[] arr) {
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getmax(arr));
	}
}
