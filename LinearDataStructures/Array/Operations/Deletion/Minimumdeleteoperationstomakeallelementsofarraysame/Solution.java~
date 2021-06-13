import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int getmin(int[] arr) {
		HashMap<Integer, Integer> freq = new HashMap<>();
		for(int i = 0; i < arr.length; i++)
			freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
		int max_freq = Integer.MIN_VALUE;
		for(Map.Entry<Integer, Integer> entry : freq.entrySet())
			max_freq = Math.max(max_freq, entry.getValue());
		return (arr.length - max_freq);
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getmin(arr));
	}
}
