import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
public class Solution {
    public static void main (String [] args) throws IOException {
        Solution sol = new Solution();
	DataInputStream in = new DataInputStream(System.in);
	int n = Integer.parseInt(in.readLine());
	int[] inp_arr = new int[n];
	for(int i = 0; i < n; i++)
		inp_arr[i] = Integer.parseInt(in.readLine());
        System.out.println(getSumOfAllUniqueSubArrays(inp_arr));
    }
    private static int getSumOfAllUniqueSubArrays (int [] arr) {
        HashMap <Integer, Integer> hm = new HashMap <> ();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (hm.containsKey(sum)) { hm.put(sum, (hm.get(sum) + 1)); }
                else { hm.put(sum, 1); }
            }
        }
        sum = 0;
        for (Map.Entry <Integer, Integer> et : hm.entrySet()) {
            if (et.getValue() == 1) { sum += et.getKey(); }
        }
        return (sum);
    }
}
/* import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static int findsum(int[] arr) {
		int sum = 0;
		for(int i = 0; i < (1 << (arr.length)); i++) {
			for(int j = 0; j < arr.length; j++)
				if((i & (1 << j)) != 0) sum+= arr[j];
		}
		return sum;
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());
		System.out.println(sol.findsum(arr));
	}
} */
