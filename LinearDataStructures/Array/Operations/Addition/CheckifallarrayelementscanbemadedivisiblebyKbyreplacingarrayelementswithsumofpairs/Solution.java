import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static boolean check(int[] arr, int k) {
		for(int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			while(arr[i] < (k * temp))
				arr[i]*= 2;
			if((arr[i] % k) != 0) return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());
		if(sol.check(arr, k)) System.out.println("TRUE");
		else System.out.println("FALSE");
	}
}
