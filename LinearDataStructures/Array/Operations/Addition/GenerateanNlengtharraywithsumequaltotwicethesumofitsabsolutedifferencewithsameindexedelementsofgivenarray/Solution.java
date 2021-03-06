import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int nearestpower(int n) {
		int c = 0;
		while(n > 1) {
			n = n >> 1;
			c++;
		}
		while(c > 0) {
			n = n << 1;
			c--;
		}
		return n;
	}
	static int[] generate(int[] arr) {
		int[] brr = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
			brr[i] = nearestpower(arr[i]);
		return brr;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		arr = sol.generate(arr);
		for(int i = 0; i < n; i++)
			System.out.println(arr[i] + " ");
	}
}
