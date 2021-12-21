// Hashing (Separate Chaining)

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;

public class Solution {
	static class Hash {
		int BUCKET

		ArrayList<Integer> table;
		public Hash(int V) {
			this.BUCKET = V;
			table = new ArrayList<Intger>(BUCKET);
		}

		public void insertItem(int x) {
			int index = this.hashFunction(x);
			table.get(index).add(x);
		}

		public void deleteItem(int key) {
			int index = this.hashFunction(x);
		}

		public int hashFunction(int x) {
			return (x % BUCKET);
		}

		void displayHash();
	}
}
