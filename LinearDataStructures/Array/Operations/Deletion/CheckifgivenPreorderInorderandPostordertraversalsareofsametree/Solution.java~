import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.regex.*;
import java.util.concurrent.*;
class Solution {
	static boolean checktree(int[] preorder, int s1, int[] inorder, int s2, int[] postorder, int s3, int n) {
		if(n == 0) return true;
		if(n == 1) return ((preorder[s1] == inorder[s2]) && (inorder[s2] == postorder[s3]));
		int index = -1;
		for(int i = s2; i < (s2 + n); ++i) {
			if(inorder[i] == preorder[s1]) {
				index = i;
				break;
			}
		}
		if(index == -1) return false;
		index-= s2;
		boolean res1 = checktree(preorder, (s1 + 1), inorder, s2, postorder, s3, index);
		boolean res2 = checktree(preorder, (s1 + index + 1), inorder, (s2 + index + 1), postorder, (s3 + index), (n - index - 1));
		return (res1 && res2);
	}
	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		DataInputStream in = new DataInputStream(System.in);
		int n1 = Integer.parseInt(in.readLine());
		int[] inorder = new int[n1];
		for(int i = 0; i < n1; i++)
			inorder[i] = Integer.parseInt(in.readLine());
		int n2 = Integer.parseInt(in.readLine());
		int[] preorder = new int[n2];
		for(int i = 0; i < n2; i++)
			preorder[i] = Integer.parseInt(in.readLine());
		int n3 = Integer.parseInt(in.readLine());
		int[] postorder = new int[n3];
		for(int i = 0; i < n3; i++)
			postorder[i] = Integer.parseInt(in.readLine());
		if((n1 == n2) && (n2 == n3)) {
			boolean res = checktree(preorder, 0, inorder, 0, postorder, 0, n1);
			System.out.println(((res) ? "Yes" : "No"));
		} else System.out.println("No");
	}
}
