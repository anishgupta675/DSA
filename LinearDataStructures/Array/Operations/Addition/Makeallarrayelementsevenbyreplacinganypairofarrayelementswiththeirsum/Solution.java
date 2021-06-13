import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int findcount(int[] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++)
			if((arr[i] % 2) != 0) count++;
		if((count % 2) != 0) return ((count / 2) + 2);
		return (count / 2);
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.findcount(arr));
	}
}
