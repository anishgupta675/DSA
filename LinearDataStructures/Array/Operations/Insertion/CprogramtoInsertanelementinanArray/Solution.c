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
void append(int arr[], int n, int key, int index) {
	if(index >= n) return;
	while((n - 1) > index)
		arr[n - 1] = arr[n - 2];
	arr[index] = key;
}
void printlist(int arr[], int n) {
	for(int i = 0; i < n; i++)
		printf("%d ", arr[i]);
}
int main() {
	int n, key;
	scanf("%d", &n);
	int* arr = (int *) malloc(n * sizeof(int));
	for(int i = 0; i < n; i++) {
		scanf("%d", &key);
		append(arr, n, key, i);
	}
	printlist(arr, n);
	return 0;
}
