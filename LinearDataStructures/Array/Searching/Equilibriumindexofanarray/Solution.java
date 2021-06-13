import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
     /*	static int getsum(int[] arr, int low, int high) {
		int sum = 0;
		for(int i = low; i < high + 1; i++)
			sum+= arr[i];
		return sum;
	}
	static int getindex(int[] arr) {
		if(arr.length == 1) return 0;
		int prefix_sum = 0, suffix_sum = getsum(arr, 1, arr.length - 1);
		for(int i = 0; i < arr.length; i++) {
			if(prefix_sum == suffix_sum) return i;
			prefix_sum+= arr[i];
			suffix_sum-= arr[i];
		}
		return -1;
	} */
	static int getindex(int[] arr) {
		int[] front = new int[arr.length];
		int[] back = new int[arr.length];
		for(int i = 0; i < front.length; i++) {
			if(i == 0) front[i] = arr[i];
			else front[i] = front[i - 1] + arr[i];
		}
		for(int i = back.length - 1; i > 0; i--) {
			if(i == back.length - 1) back[i] = arr[i];
			else back[i] = back[i + 1] + arr[i];
		}
		for(int i = 0; i < arr.length; i++)
			if(front[i] == back[i]) return i;
		return -1;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getindex(arr));
	}
}
