import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int getk(int[] arr, int k) {
		HashSet<Integer> hs = new HashSet<>();
		int count = 0;
		for(int i = 0; i < arr.length; i++)
			hs.add(arr[i]);
		int max_val = Arrays.stream(arr).max().getAsInt();
		int min_val = Arrays.stream(arr).min().getAsInt();
		for(int i = (min_val + 1); i < max_val; i++) {
			if(!hs.contains(i)) count++;
			if(count == k) return i;
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
		int k = Integer.parseInt(in.readLine());
		System.out.println(sol.getk(arr, k));
	}
}
