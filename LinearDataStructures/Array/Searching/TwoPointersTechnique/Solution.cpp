#include<iostream>
#include<fstream>
#include<iomanip>
#include<stdio.h>
#include<math.h>
#include<process.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#include<errno.h>
#include<inttypes.h>
#include<stdbool.h>
using namespace std;
class Solution {
	public:
		bool checksum(int *arr, int n, int x) {
			int i = 0, j = n - 1;
			while(i > j) {
				if(arr[i] + arr[j] == x) return true;
				if(arr[i] + arr[j] < x) i++;
				else j--;
			}
			return false;
		}
		int main() {
			Solution sol;
			int n, x;
			std::cin >> n;
			int *arr = (int *) malloc(n * sizeof(int));
			for(int i = 0; i < n; i++)
				cin >> arr[i];
			std::cin >> x;
			std::cout << sol.checksum(arr, n, x) << std::endl;
			return 0;
		}
};
