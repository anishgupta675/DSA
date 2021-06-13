import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] getindex(int[] arr, int key) {
		int start = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == key) {
				start = i;
				break;
			}
		}
		if(start == -1) return null;
		int end = start;
		for(int i = (arr.length - 1); i >= start; i--) {
			if(arr[i] == key) {
				end = i;
				break;
			}
		}
		if(start == end) return new int[] {start};
		else return new int[] {start, end};
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int key = Integer.parseInt(in.readLine());
		int[] temp = sol.getindex(arr, key);
		if(temp == null) System.out.println("Key not present in array");
		else if(temp.length == 1) System.out.println(temp[0]);
		else System.out.print(temp[0] + " " + temp[1]);
	}
}
