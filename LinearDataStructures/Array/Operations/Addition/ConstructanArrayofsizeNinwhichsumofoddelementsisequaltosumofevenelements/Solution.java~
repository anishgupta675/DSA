import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] construct(int n) {
		if(n % 4 != 0) return null;
		int[] arr = new int[n];
		for(int i = 0; i <= (n / 2); i++)
			arr[i] = (i + 1) * 2;
		for(int i = (n / 2) + 1; i < (n - 1); i++)
			arr[i] = arr[i - (n / 2)] - 1;
		arr[n - 1] = (n / 2) - 1 + n;
		return arr;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = sol.construct(n);
		if (arr == null) System.out.println("-1");
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
