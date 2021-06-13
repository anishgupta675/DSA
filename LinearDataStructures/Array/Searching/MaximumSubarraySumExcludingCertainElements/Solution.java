import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
     /*	static boolean getindex(int[] arr, int x) {
		for(int i = 0; i < arr.length; i++)
			if(arr[i] == x) return true;
		return false;
	}
	static int getmax(int[] arr1, int[] arr2) {
		int curr_sum = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(getindex(arr2, arr1[i])) curr_sum = 0;
			curr_sum = Math.max(curr_sum + arr1[i], curr_sum);
		}
		return curr_sum;
	} */
	static boolean getindex(int[] arr, int x) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++)
			hs.add(arr[i]);
		if(hs.contains(x)) return true;
		return false;
	}
	static int getmax(int[] arr1, int[] arr2) {
		int curr_sum = 0, max_sum = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(getindex(arr2, arr1[i])) {
				curr_sum = 0;
				continue;
			}
			curr_sum = Math.max(arr1[i], curr_sum + arr1[i]);
			max_sum = Math.max(curr_sum, max_sum);
		}
		return max_sum;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n1 = Integer.parseInt(in.readLine());
		int[] arr1 = new int[n1];
		for(int i = 0; i < n1; i++)
			arr1[i] = Integer.parseInt(in.readLine());
		int n2 = Integer.parseInt(in.readLine());
		int[] arr2 = new int[n2];
		for(int i = 0; i < n2; i++)
			arr2[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getmax(arr1, arr2));
	}
}
