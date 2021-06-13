#include<stdio.h>
#include<assert.h>
#include<limits.h>
#include<math.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#include<stdarg.h>
#include<inttypes.h>
#include<stdbool.h>
struct pair {
	int min;
	int max;
};
struct pair getlimit(int* arr, int n) {
	int i;
	struct pair limit;
	if(n % 2 == 0) {
		if(arr[0] > arr[1]) {
			limit.max = arr[0];
			limit.min = arr[1];
		} else {
			limit.min = arr[0];
			limit.max = arr[1];
		}
		i = 2;
	} else {
		limit.min = arr[0];
		limit.max = arr[0];
		i = 1;
	}
	while(i < (n - 1)) {
		if(arr[i] > arr[i + 1]) {
			if(arr[i] > limit.max) limit.max = arr[i];
			if(arr[i] < limit.min) limit.min = arr[i + 1];
		} else {
			if(arr[i + 1] > limit.max) limit.max = arr[i + 1];
			if(arr[i] < limit.min) limit.min = arr[i];
		}
		i+= 2;
	}
	return limit;
}
int main() {
	int n;
	scanf("%d", &n);
	int *ptr = (int *) malloc(n * sizeof(int));
	for(int i = 0; i < n; i++)
		scanf("%d", &ptr[i]);
	struct pair limit = getlimit(ptr, n);
	printf("%d\n%d", limit.min, limit.max);
	getchar();
	return 0;
}
