import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] getfreq(int[] arr) {
		int[] map = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
			map[arr[i]]++;
		int freq = 0;
		for(int i = 0; i < arr.length; i++) {
			freq+= map[arr[i]];
			if(map[arr[i]] != 0) arr[i] = freq;
			map[arr[i]] = 0;
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
		arr = sol.getfreq(arr);
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
