import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int MAX = 100000;
	static int findsum(int[] arr1, int[] arr2) {
		int sum = 0;
		int[] hash = new int[MAX];
		for(int i = 0; i < arr2.length; i++)
			hash[arr2[i]]++;
		for(int i = 1; i < MAX; i++)
			hash[i] = hash[i] + hash[i - 1];
		int maxf = hash[arr1[0]];
		for(int i = 0; i < arr1.length; i++)
			maxf = Math.max(maxf, hash[arr1[i]]);
		for(int i = 0; i < arr1.length; i++)
			sum+= (maxf == hash[arr1[i]]) ? arr1[i] : 0;
		return sum;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int m = Integer.parseInt(in.readLine());
		int[] arr1 = new int[m];
		for(int i = 0; i < m; i++)
			arr1[i] = Integer.parseInt(in.readLine());
		int n = Integer.parseInt(in.readLine());
		int[] arr2 = new int[n];
		for(int i = 0; i < n; i++)
			arr2[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.findsum(arr1, arr2));
	}
}

