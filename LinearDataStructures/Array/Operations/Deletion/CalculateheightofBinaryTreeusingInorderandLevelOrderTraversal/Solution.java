import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int height;
	static int search(int[] arr, int start, int end, int value) {
		for(int i = start; i <= end; i++)
			if(arr[i] == value) return i;
		return -1;
	}
	static int getheight(int[] in, int[] level, int start, int end, int n) {
		if(start > end) return 0;
		int get_index = search(in, start, end, level[0]);
		if(get_index == -1) return 0;
		int left_count = get_index - start;
		int right_count = end - get_index;
		int[] new_left_level = new int[left_count];
		int[] new_right_level = new int[right_count];
		int k = 0, l_height = 0, r_height = 0;
		for(int i = 0; i < n; i++) {
			for(int j = start; j < get_index; j++) {
				if(level[i] == in[j]) {
					new_left_level[k] = level[i];
					k++;
					break;
				}
			}
		}
		k = 0;
		for(int i = 0; i < n; i++) {
			for(int j = get_index + 1; j <= end; j++) {
				if(level[i] == in[j]) {
					new_right_level[k] = level[i];
					k++;
					break;
				}
			}
		}
		if(left_count > 0) l_height = getheight(in, new_left_level, start, get_index - 1, left_count);
		if(right_count > 0) r_height = getheight(in, new_right_level, get_index + 1, end, right_count);
		height = Math.max(l_height + 1, r_height + 1);
		new_left_level = null;
		new_right_level = null;
		return height;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream dis = new DataInputStream(System.in);
		int n = Integer.parseInt(dis.readLine());
		int[] in = new int[n];
		int[] level = new int[n];
		for(int i = 0; i < n; i++)
			in[i] = Integer.parseInt(dis.readLine());
		for(int i = 0; i < n; i++)
			level[i] = Integer.parseInt(dis.readLine());
		System.out.println(sol.getheight(in, level, 0, n - 1, n));
	}
}
