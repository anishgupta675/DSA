import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int N = (int) 2e5 + 10;
	static int[] bit = new int[N];
	static int[] idx = new int[N];
	static void update(int idx, int val, int[] bitt) {
		while(idx < N) {
			bitt[idx]+= val;
			idx+= idx & (-idx);
		}
	}
	static int sum(int idx, int[] bitt) {
		int res = 0;
		while(idx > 0) {
			res+= bitt[idx];
			idx-= idx & (-idx);
		}
		return res;
	}
	static Vector<Integer> performqueries(Vector<Integer> A, int[][] B) {
		A.insertElementAt(0, 0);
		int n = (int) A.size();
		for(int i = 0; i < n; i++)
			update(i, A.elementAt(i), bit);
		Vector<Integer> ans = new Vector<>();
		for(int[] i : B) {
			int type = i[0], x = i[1], v = i[2];
			if(type == 1) {
				update(n, x, bit);
				A.add(x);
				n++;
			} else if(type == 2) {
				int id = x + sum(x, idx);
				update(id, -A.elementAt(id), bit);
				A.set(id, v);
				update(id, v, bit);
			} else if(type == 3) {
				int id = x + sum(x, idx);
				update(id, -A.elementAt(id), bit);
				update(x, 1, idx);
				A.set(id, 0);
			} else {
				int xx = x + sum(x, idx);
				int vv = v + sum(v, idx);
				ans.add(sum(vv, bit) - sum(xx - 1, bit));
			}
		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		Vector<Integer> A = new Vector<>();
		for(int i = 0; i < n; i++) {
			int data = Integer.parseInt(in.readLine());
			A.add(data);
		}
		n = Integer.parseInt(in.readLine());
		int[][] B = new int[n][3];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++)
				B[i][j] = Integer.parseInt(in.readLine());
		}
		Vector<Integer> ans = performqueries(A, B);
		for(int i : ans)
			System.out.println(i);
	}
}
