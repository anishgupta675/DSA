import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int findmax(int[] arr, int low, int high) {
		int index = 0, max = arr[0];
		for(int i = low; i < high; i++) {
			if(arr[i] > max) {
				index = i;
				max = arr[i];
			}
		}
		return index;
	}
	static int findmin(int[] arr, int low, int high) {
		int index = 0, min = arr[0];
		for(int i = low; i < high; i++) {
			if(arr[i] < min) {
				index = i;
				min = arr[i];
			}
		}
		return index;
	}
	static int[][] findprearr(int[] arr, int qn) {
		int[][] pre_arr = new int[qn][2];
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) {
				pre_arr[i][0] = arr[i];
				pre_arr[i][1] = arr[i];
			} else {
				pre_arr[i][0] = Math.max(pre_arr[i - 1][0], arr[i]);
				pre_arr[i][1] = Math.min(pre_arr[i - 1][1], arr[i]);
			}
		}
		return pre_arr;
	}
	static int[][] findsufarr(int[] arr, int qn) {
		int[][] suf_arr = new int[qn][2];
		for(int i = (arr.length - 1); i >= 0; i--) {
			if(i == (arr.length - 1)) {
				suf_arr[i][0] = arr[i];
				suf_arr[i][1] = arr[i];
			} else {
				suf_arr[i][0] = Math.max(suf_arr[i + 1][0], arr[i]);
				suf_arr[i][1] = Math.min(suf_arr[i + 1][1], arr[i]);
			}
		}
		return suf_arr;
	}
	static int[] findrange(int[][] pre_arr, int[][] suf_arr, int n, int l, int r) {
		int max, min;
		if((l == 0) && (r == (n - 1))) return null;
		else if(l == 0) {
			max = suf_arr[r + 1][0];
			min = suf_arr[r + 1][1];
		} else if(r == (n - 1)) {
			max = pre_arr[l - 1][0];
			min = pre_arr[l - 1][1];
		} else {
			max = Math.max(pre_arr[l - 1][0], suf_arr[r + 1][0]);
			min = Math.min(pre_arr[l - 1][1], suf_arr[r + 1][1]);
		}
		return new int[] {max, min};
	}
	static int[][] getqueries(int[] arr, int[][] q) {
		int n = arr.length;
		int qn = q.length;
		int[][] qf = new int[qn][2];
		int pre_arr[][] = findprearr(arr, qn);
		int suf_arr[][] = findsufarr(arr, qn);
		for(int i = 0; i < qn; i++) {
			int l = q[i][0];
			int r = q[i][1];
			qf[i] = findrange(pre_arr, suf_arr, n, l, r);
		}
		return qf;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int m = Integer.parseInt(in.readLine());
		int[] arr = new int[m];
		for(int i = 0; i < m; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int n = Integer.parseInt(in.readLine());
		int[][] q = new int[n][2];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2; j++)
				q[i][j] = Integer.parseInt(in.readLine());
		}
		int[][] qf = sol.getqueries(arr, q);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2; i++)
				if(qf[i] == null) System.out.print("No maximum or minimum value");
				else System.out.print(qf[i][j] + " ");
			System.out.print("\n");
		}
	}
}
