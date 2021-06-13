import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static Object[] remove(int[] arr) {
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		for(int i = 0; i < arr.length; i++)
			set.add(arr[i]);
		Object[] new_arr = set.toArray();
		return new_arr;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		Object[] new_arr = sol.remove(arr);
		for(int i = 0; i < new_arr.length; i++)
			System.out.print(new_arr[i] + " ");
	}
}
