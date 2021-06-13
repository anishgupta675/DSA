import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[][] findpair(int[] arr, int low, int high, int sum) {
		int j = 0, count = 0;
		while(low < high) {
			if(arr[low] + arr[high] == sum) count++;
			if(arr[low] + arr[high] > sum) high--;
			else low++;
		}
		int[][] pair = new int[count][2];
		while(low < high) {
			if(arr[low] + arr[high] == sum) {
				pair[j][0] = arr[low];
				pair[j][1] = arr[high];
				j++;
			}
			if(arr[low] + arr[high] > sum) high--;
			else low++;
		}
		return pair;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int sum = Integer.parseInt(in.readLine());
		int[][] pair = sol.findpair(arr, 0, (arr.length - 1), sum);
		for(int i = 0; i < pair.length; i++) {
			for(int j = 0; j < 2; j++)
				System.out.print(pair[i][j] + " ");
		}
	}
}
