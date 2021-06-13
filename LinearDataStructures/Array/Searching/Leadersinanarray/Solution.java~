import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static List<Integer> getleader(int[] arr) {
		int max_val = arr[arr.length - 1];
		List<Integer> leader = new ArrayList<Integer>();
		leader.add(arr[arr.length - 1]);
		for(int i = arr.length - 1; i >= 0; i--) {
			if(arr[i] > max_val) {
				leader.add(arr[i]);
				max_val = arr[i];
			}
		}
		return leader;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		List<Integer> list = sol.getleader(arr);
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
	}
}
