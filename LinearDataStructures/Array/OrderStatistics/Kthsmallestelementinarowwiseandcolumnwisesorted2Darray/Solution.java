import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
class Solution {
	static int getElementsGreaterThanOrEqual(int[][] arr, int num) {
		int ans = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i][0] > num) return ans;
			if(arr[i][arr.length - 1] <= num) {
				ans+= arr.length;
				continue;
			}
			int greater_than = 0;
			for(int jump = arr.length / 2; jump >= 1; jump/= 2) {
				while(greater_than + jump < arr.length && arr[i][greater_than + jump] <= num)
					greater_than+= jump;
			}
			ans+= greater_than + 1;
		}
		return ans;
	}
	static int getk(int[][] arr, int k) {
		int l = arr[0][0], r = arr[arr.length - 1][arr.length - 1];
		while(l <= r) {
			int mid = l + (r - l) / 2;
			int greater_than_or_equal_mid = getElementsGreaterThanOrEqual(arr, mid);
			if(greater_than_or_equal_mid >= k) r = mid - 1;
			else l = mid + 1;
		}
		return l;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(in.readLine());
		}
		int k = Integer.parseInt(in.readLine());
		System.out.println(sol.getk(arr, k));
	}
}
