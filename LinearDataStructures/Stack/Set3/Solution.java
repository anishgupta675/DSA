// Reverse a string using stack

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;

public class Solution {
	static void swap(char[] a, int index1, int index2) {
		char temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	static void reverse(char[] str) {
		int n = str.length, i;

		for(i = 0; i < n / 2; i++)
			swap(str, i, n - i - 1);
	}

	public static void main(String[] args) throws IOException {}
}
