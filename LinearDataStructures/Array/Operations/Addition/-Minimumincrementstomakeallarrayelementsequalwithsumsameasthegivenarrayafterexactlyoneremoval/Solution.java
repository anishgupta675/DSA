import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static boolean minimize(int[] arr) {
		if(arr.length == 1) return false;
		int sum = arr[0], sec_max = Integer.MIN_VALUE, max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >= max) {
				sec_max = max;
				max = arr[i];
			} else if(arr[i] > sec_max) sec_max = arr[i];
			sum+= arr[i];
		}
		if((sec_max * (arr.length - 1)) > sum) return false;
		if(sum % (arr.length - 1) != 0) return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		if(sol.minimize(arr)) System.out.println("YES");
		else System.out.println("NO");
	}
}
