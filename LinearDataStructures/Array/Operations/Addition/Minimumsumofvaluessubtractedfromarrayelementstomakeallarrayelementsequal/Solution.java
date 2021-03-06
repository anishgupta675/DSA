import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int findmin(int[] arr) {
		int min = arr[0];
		for(int i = 0; i < arr.length; i++)
			if(arr[i] < min) min = arr[i];
		return min;
	}
	static int minimizesum(int[] arr) {
		int sum = 0, min = findmin(arr);
		for(int i = 0; i < arr.length; i++)
			sum+= (arr[i] - min);
		return sum;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.minimizesum(arr));
	}
}
		
