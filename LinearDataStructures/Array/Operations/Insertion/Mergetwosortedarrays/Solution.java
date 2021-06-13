import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int[] merge(int[] arr1, int[] arr2) {
		int i = 0, j = 0, k = 0;
		int n1 = arr1.length;
		int n2 = arr2.length;
		int n3 = n1 + n2;
		int[] arr3 = new int[n3];
		while(i < n1 && j < n2) {
			if(arr1[i] <= arr2[j]) {
				arr3[k] = arr1[i];
				i++;
			} else {
				arr3[k] = arr2[j];
				j++;
			}
			k++;
		}
		while(i < n1) {
			arr3[k] = arr1[i];
			i++;
			k++;
		}
		while(j < n2) {
			arr3[k] = arr2[j];
			j++;
			k++;
		}
		return arr3;
	}
	static void printlist(int[] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
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
		int[] arr3 = sol.merge(arr1, arr2);
		sol.printlist(arr3);
	}
}
