import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int getstep(int[] arr) {
		if(arr.length == 1) return 0;
		int max_step = arr[1] - arr[0];
		for(int i = 0; i < arr.length - 1; i++)
			max_step = Math.max(arr[i + 1] - arr[i], max_step);
		return max_step;
	}
	static int search(int[] arr, int k, int x) {
		int i = 0;
		while(i < arr.length) {
			if(arr[i] == x) return i;
			i+= Math.max(1, Math.abs(arr[i] - x) / k);
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int k = sol.getstep(arr);
		int x = Integer.parseInt(in.readLine());
		System.out.println(sol.search(arr, k, x));
	}
}
