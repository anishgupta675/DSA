import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int findsum(int[] arr, int low, int high) {
		int sum = 0;
		for(int i = low; i < (high + 1); i++)
			sum+= arr[i];
		return sum;
	}
	static int search(int[] arr, int q) {
		for(int i = 0; i < arr.length; i++)
			if(arr[i] == q) return i;
		return -1;
	}
	static int[] findqueries(int[] arr, int[] q) {
		for(int i = 0; i < q.length; i++)
			q[i] = Math.min(findsum(arr, 0, search(arr, q[i])), findsum(arr, search(arr, q[i]), (arr.length - 1)));
		return q;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int m = Integer.parseInt(in.readLine());
		int[] arr = new int[m];
		for(int i = 0; i < m; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int n = Integer.parseInt(in.readLine());
		int[] q = new int[n];
		for(int i = 0; i < n; i++)
			q[i] = Integer.parseInt(in.readLine());
		q = sol.findqueries(arr, q);
		for(int i = 0; i < n; i++)
			System.out.print(q[i] + " ");
	}
}
