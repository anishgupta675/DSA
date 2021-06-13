import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int getmin(String a, String b) {
		int[] f1 = new int[256];
		int[] f2 = new int[256];
		for(char c : a.toCharArray())
			f1[(int)(c)]++;
		for(char c : b.toCharArray())
			f2[(int)(c)]++;
		int min_cost = 0;
		for(int i = 0; i < 256; i++)
			min_cost+= Math.abs(f1[i], f2[i]);
		return min_cost;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		String a = in.readLine();
		String b = in.readLine();
		System.out.println(sol.getmin(a, b));
	}
}
