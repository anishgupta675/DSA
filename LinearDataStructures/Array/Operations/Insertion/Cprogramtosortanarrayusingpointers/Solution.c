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
int *sort(int *ptr, int n) {
	for(int i = 0; i < n; i++) {
		for(int j = (i + 1); j < n; j++) {
			if(*(ptr + j) < *(ptr + i)) {
				int temp = *(ptr + i);
				*(ptr + i) = *(ptr + j);
				*(ptr + j) = temp;
			}
		}
	}
	return ptr;
}
void printlist(int *ptr, int n) {
	for(int i = 0; i < n; i++)
		printf("%d ", *(ptr + i));
}
int main() {
	int n;
	scanf("%d", &n);
	int* ptr = (int *) malloc(n * sizeof(int));
	for(int i = 0; i < n; i++)
		scanf("%d", &ptr[i]);
	ptr = sort(ptr, n);
	printlist(ptr, n);
	return 0;
}
