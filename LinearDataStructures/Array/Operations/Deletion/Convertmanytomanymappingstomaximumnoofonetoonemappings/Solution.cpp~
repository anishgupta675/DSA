#include<bits/stdc++.h>
#include<windows.h>
#include<iostream>
#include<stdio.h>
#include<math.h>
#include<process.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#include<iomanip>
#include<fstream>
#include<stdarg.h>
#include<errno.h>
#include<vector>
#include<algorithm>
#include<stdint.h>
#include<inttypes.h>
#include<stdbool.h>
using namespace std;
class Solution {
	public:
		int getmax(vector<pair<int, int>> &v, int n1, int n2) {
			int ans = 0;
			bool *is_paired = new bool[n1];
			vector<set<int>> mapping(n1 + 1);
			memset(is_paired, sizeof(is_paired), false);
			for(int i = 0; i < v.size(); i++)
				mapping[v[i].first].insert(v[i].second);
			while(true) {
				int lowest = -1;
				for(int i = 0; i <= n1; i++) {
					if(mapping[i].size() > 0) {
						if(lowest == -1) lowest = i;
						else if(mapping[i].size() < mapping[lowest].size()) lowest = i;
					}
				}
				if(lowest == -1) break;
				is_paired[lowest] = true;
				int remove = *mapping[lowest].begin();
				for(int i = 0; i <= n1; i++) {
					mapping[i].erase(remove);
					if(i == lowest) mapping[i].clear();
				}
				ans++;
			}
			return ans;
		}
		int main() {
			int n, n1, n2;
			cin >> n1;
			int *arr1 = (int *) malloc(n1 * sizeof(int));
			for(int i = 0; i < n1; i++)
				cin >> arr1[i];
			cin >> n2;
			int *arr2 = (int *) malloc(n2 * sizeof(int));
			for(int i = 0; i < n2; i++)
				cin >> arr2[i];
			cin >> n;
			vector<pair<int, int>> v;
			for(int i = 0; i < n; i++) {
				int data1, data2;
				cin >> data1 >> data2;
				v.push_back(make_pair(data1, data2));
			}
			cout << getmax(v, n1, n2) << endl;
			return 0;
		}
};
