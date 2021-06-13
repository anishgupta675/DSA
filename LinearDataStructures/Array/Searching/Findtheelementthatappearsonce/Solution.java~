import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int getelement(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++) {
			int count = map.containsKey(arr[i]) ? map.get(arr[i]) : 0;
			map.put(arr[i], count + 1);
		}
		for(Map.Entry map_element : map.entrySet())
			if((int)(map_element.getValue()) == 1) return ((int)map_element.getKey());
		return 0;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getelement(arr));
	}
}
