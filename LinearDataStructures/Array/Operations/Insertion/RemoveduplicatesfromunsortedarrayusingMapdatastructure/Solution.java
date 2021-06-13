import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] remove(int[] arr) {
		int j = 0, count = 0;
		HashMap<Integer, Boolean> hash_map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			if(hash_map.get(arr[i]) == null) count++;
			hash_map.put(arr[i], true);
		}
		int[] new_arr = new int[count];
		hash_map.clear();
		for(int i = 0; i < arr.length; i++) {
			if(hash_map.get(arr[i]) == null) {
				new_arr[j] = arr[i];
				j++;
			}
			hash_map.put(arr[i], true);
		}
		return new_arr;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int[] new_arr = sol.remove(arr);
		for(int i = 0; i < new_arr.length; i++)
			System.out.print(new_arr[i] + " ");
	}
}
