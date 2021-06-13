import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
class Solution {
	static int getmajor(int[] arr) {
		int count = 0, max_val = Integer.MIN_VALUE, temp = arr[0], curr_val = 0, flag = 0;
		for(int i = 0; i < arr.length; i++) {
			if(temp == arr[i]) count++;
			else {
				count = 1;
				temp = arr[i];
			}
			if(max_val < count) {
				max_val = count;
				curr_val = arr[i];
				if(max_val > (arr.length / 2)) {
					flag = 1;
					break;
				}
			}
		}
		return ((flag == 1) ? curr_val : -1);
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getmajor(arr));
	}
}
