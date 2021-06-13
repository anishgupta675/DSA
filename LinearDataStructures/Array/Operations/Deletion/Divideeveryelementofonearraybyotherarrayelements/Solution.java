import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] calculate(int[] arr1, int[] arr2) {
		int m = 1;
		for(int i = 0; i < arr2.length; i++)
			if(arr2[i] != 0) m*= arr2[i];
		for(int i = 0; i < arr1.length; i++) {
			int x = (int)Math.floor(arr1[i] / m);
			arr1[i] = x;
		}
		return arr1;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n1 = Integer.parseInt(in.readLine());
		int[] arr1 = new int[n1];
		for(int i = 0; i < n1; i++)
			arr1[i] = Integer.parseInt(in.readLine());
		int n2 = Integer.parseInt(in.readLine());
		int[] arr2 = new int[n2];
		for(int i = 0; i < n2; i++)
			arr2[i] = Integer.parseInt(in.readLine());
		arr1 = sol.calculate(arr1, arr2);
		for(int i = 0; i < n1; i++)
			System.out.print(arr1[i] + " ");
	}
}
