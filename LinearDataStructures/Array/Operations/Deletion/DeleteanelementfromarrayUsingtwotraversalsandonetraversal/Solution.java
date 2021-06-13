import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	// One Traversal
	static int[] s_delete(int[] arr, int n, int x) {
		int i;
		for(i = 0; i < n; i++)
			if(arr[i] == x) break;
		if(i < n) {
			n--;
			for(int j = i; j < n; j++)
				arr[j] = arr[j + 1];
		}
		int[] new_arr = new int[n];
		for(i = 0; i < n; i++)
			new_arr[i] = arr[i];
		return new_arr;
	}
	// Two Traversals
	static int[] m_delete(int[] arr, int n, int x) {
		if(arr[n - 1] == x) n--;
		else { int prev = arr[n - 1], i;
			for(i = (n - 2); i >= 0 && arr[i] != x; i--) {
				int curr = arr[i];
				arr[i] = prev;
				prev = curr;
			}
			if(i < 0) n = 0;
			else arr[i] = prev;
			n--;
		}
		int[] new_arr = new int[n];
		for(int i = 0; i < new_arr.length; i++)
			new_arr[i] = arr[i];
		return new_arr;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int x = Integer.parseInt(in.readLine());
		int y = Integer.parseInt(in.readLine());
		int[] s_new_arr = sol.s_delete(arr, n, x);
		int[] m_new_arr = sol.m_delete(s_new_arr, (s_new_arr.length), y);
		for(int i = 0; i < m_new_arr.length; i++)
			System.out.print(m_new_arr[i] + " ");
	}
}
