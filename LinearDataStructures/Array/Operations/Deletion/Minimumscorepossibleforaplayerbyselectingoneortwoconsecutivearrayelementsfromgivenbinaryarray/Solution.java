import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static class R {
		int x, y;
		public R(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static HashMap<R, Integer> m = new HashMap<>();
	static int getmin(int[] arr, int pos, int turn) {
		R x = new R(pos, turn);
		if(m.containsKey(x)) return m.get(x);
		if(pos >= arr.length - 1) return 0;
		if(turn == 0) {
			int ans = Math.min(getmin(arr, pos + 1, 1) + arr[pos], getmin(arr, pos + 2, 1) + arr[pos] + arr[pos + 1]);
			R v = new R(pos, turn);
			m.put(v, ans);
			return ans;
		}
		if(turn != 0) {
			int ans = Math.min(getmin(arr, pos + 1, 0), getmin(arr, pos + 2, 0));
			R v = new R(pos, turn);
			m.put(v, ans);
			return ans;
		}
		return 0;
	}
	static int countPenality(int[] arr) {
		int pos = 0, turn = 0;
		return (getmin(arr, pos, turn) + 1);
	}
	static int getans(int[] arr) {
		int sum = 0, a = countPenality(arr);
		for(int i = 0; i < arr.length; i++)
			sum+= arr[i];
		return sum;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.getans(arr));
	}
}
