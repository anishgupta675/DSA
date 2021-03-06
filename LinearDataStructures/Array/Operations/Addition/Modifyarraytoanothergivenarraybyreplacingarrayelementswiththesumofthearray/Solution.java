import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int findmax(int[] arr) {
		int index = 0, max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				index = i;
				max = arr[i];
			}
		}
		return index;
	}
     /*	static int findsum(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum+= arr[i];
		return sum;
	} */
	static boolean modify(int[] arr) {
		int index = findmax(arr);
		int max = arr[index];
		if(max == 1) return true;
	     //	int sum = findsum(arr);
		for(int i = 0; i < arr.length; i++) {
			if(i != index) {
				max-= arr[i];
				if(max < 1) return false;
			}
		}
		arr[index] = max;
		return modify(arr);
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		if(sol.modify(arr)) System.out.println("YES");
		else System.out.println("NO");
	}
}
