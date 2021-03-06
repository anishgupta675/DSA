import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int search(int[] arr, int key) {
		for(int i = 0; i < arr.length; i++)
			if(arr[i] == key) return i;
		return -1;
	}
	static int[] append(int[] arr, int key, int index) {
		if(index >= arr.length) return null;
		int n = arr.length;
		while((n - 1) > index)
			arr[n - 1] = arr[n - 2];
		arr[index] = key;
		return arr;
	}
	static int[] delete(int[] arr, int key) {
		int index = search(arr, key);
		int[] temp = new int[arr.length - 1];
		List list = Arrays.asList(arr);
		list.remove(index);
		for(int i = 0; i < temp.length; i++)
			temp[i] = (Integer)list.get(i);
		return arr;
	}
	static void printlist(int[] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			int key = Integer.parseInt(in.readLine());
			arr = sol.append(arr, key, i);
		}
		sol.printlist(arr);
		int key = Integer.parseInt(in.readLine());
		arr = sol.delete(arr, key);
		sol.printlist(arr);
	}
}
