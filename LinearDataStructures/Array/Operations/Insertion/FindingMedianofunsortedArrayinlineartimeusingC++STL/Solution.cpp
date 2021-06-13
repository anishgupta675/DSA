#include<bits/stdc++.h>
#include<iostream>
#include<stdio.h>
#include<math.h>
#include<process.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#include<stdarg.h>
#include<errno.h>
#include<inttypes.h>
#include<stdbool.h>
using namespace std;
class Solution {
	public:
		double findMedian(vector<int> a, int n) {
			if(n % 2 == 0) {
				nth_element(a.begin(), a.begin() + n / 2, a.end());
				nth_element(a.begin(), a.begin() + (n - 1) / 2, a.end());
				return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0;
			}
			nth_element(a.begin(), a.begin() + n / 2, a.end());
			return (double)a[n / 2];
		}
		int main() {
			Solution sol;
			int n, val;
			cin >> n;
			vector<int> arr;
			for(int i = 0; i < n; i++) {
				cin >> val;
				arr.push_back(val);
			}
			cout << sol.findMedian(arr, arr.size()) << endl;
			return 0;
		}
};
