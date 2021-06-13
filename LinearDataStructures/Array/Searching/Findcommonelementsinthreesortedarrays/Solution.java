import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] remove(int[] arr) {
		int j = 0;
		List<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			if(map.get(arr[i]) == null) {
				list.add(arr[i], j);
				map.put(arr[i], true);
				j++;
			} else continue;
		}
		int[] new_arr = new int[list.size()];
		for(int i = 0; i < new_arr.length; i++)
			new_arr[i] = list.get(i);
		return new_arr;
	}
	static int getmax(int[] arr) {
		int max = arr[0];
		for(int i = 0; i < arr.length; i++)
			max = Math.max(arr[i], max);
		return max;
	}
	static int[] getunion(int[] arr1, int[] arr2, int[] arr3) {
		int max = Integer.MIN_VALUE;
		int res1 = 1, res2 = 1, res3 = 1;
		for(int i = 0; i < arr1.length; i++) {
			max = Math.max(arr1[i], max);
			if(arr1[i] != arr1[res1 - 1]) {
				arr1[res1] = arr1[i];
				res1++;
			}
		}
		for(int i = 0; i < arr2.length; i++) {
			max = Math.max(arr2[i], max);
			if(arr2[i] != arr2[res2 - 1]) {
				arr2[res2] = arr2[i];
				res2++;
			}
		}
		for(int i = 0; i < arr3.length; i++) {
			max = Math.max(arr3[i], max);
			if(arr3[i] != arr3[res3 - 1]) {
				arr3[res3] = arr3[i];
				res3++;
			}
		}
		int[] freq = new int[max + 1];
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < arr1.length; i++)
			freq[arr1[i]]++;
		for(int i = 0; i < arr2.length; i++)
			freq[arr2[i]]++;
		for(int i = 0; i < arr3.length; i++)
			freq[arr3[i]]++;
		for(int i = 0; i < max; i++)
			if(freq[i] == 3) list.add(i);
		int[] new_arr = new int[list.size()];
		for(int i = 0; i < new_arr.length; i++)
			new_arr[i] = list.get(i);
		return new_arr;
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
		int n3 = Integer.parseInt(in.readLine());
		int[] arr3 = new int[n3];
		for(int i = 0; i < n3; i++)
			arr3[i] = Integer.parseInt(in.readLine());
		int[] new_arr = sol.getunion(arr1, arr2, arr3);
		for(int i = 0; i < new_arr.length; i++)
			System.out.print(new_arr[i] + " ");
	}
}
