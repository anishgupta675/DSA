import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
     /*	static int getmax(int[] arr) {
		int max_val = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++)
			max_val = Math.max(arr[i], max_val);
		return max;
	}
	static int getrep(int[] arr) {
		int max_val = getmax(arr);
		int[] freq = new int[max];
		for(int i = 0; i < arr.length; i++)
			freq[arr[i]]++;
		for(int i = 0; i < max; i++)
			if(freq[i] == 3) return i;
		return 0;
	}
	static int getrep(int[] arr) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(hs.contains(arr[i])) return arr[i];
			hs.add(arr[i]);
		}
		return 0;
	} */
	static int getrep(int[] arr) {
		int element, missing_element;
		for(int i = 0; i < arr.length; i++) {
			element = arr[Math.abs(arr[i])];
			if(element < 0) return (Math.abs(arr[i]));
			else arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
		}
		return 0;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getrep(arr));
	}
}
