import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int getpivot(int[] arr) {
		int left_sum = 0;
		for(int i = 0; i < arr.length; i++) {
			left_sum+= arr[i];
			int right_sum = 0;
			for(int j = i + 1; j < arr.length; j++)
				right_sum+= arr[j];
			if(left_sum == right_sum) return i + 1;
		}
		return -1;
	}
	static int[][] split(int[] arr) {
		int pivot = getpivot(arr);
		if(pivot == -1 || pivot == arr.length) return null;
		int[] row = new int[pivot];
		int[] column = new int[arr.length - pivot];
		int[][] split_arr = new int[2][];
		for(int i = 0; i < row.length; i++)
			row[i] = arr[i];
		for(int i = 0; i < column.length; i++)
			column[i] = arr[pivot + i];
		split_arr[0] = row;
		split_arr[1] = column;
		return split_arr;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int[][] split_arr = sol.split(arr);
		if(split_arr == null) throw new IllegalArgumentException("Not Possible");
		else {
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < split_arr[i].length; j++)
					System.out.print(split_arr[i][j] + " ");
				System.out.println();
			}
		}
	}
}
