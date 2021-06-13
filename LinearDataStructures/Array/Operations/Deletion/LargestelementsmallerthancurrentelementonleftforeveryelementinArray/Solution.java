import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] getmax(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int curr_ans = -1;
			for(int j = i - 1; j >= 0; j--)
				if(arr[j] > curr_ans && arr[j] < arr[i]) curr_ans = arr[j];
			arr[i] = curr_ans;
		}
		return arr;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		arr = sol.getmax(arr);
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
