# include <stdlib.h>
# include <stdio.h>

int num[12] = {14, 5, 9, 7, 6, 0, 91, 4, 1, 3, 2, 8};

int comp(const void *, const void *);

int main()
{
	int i;

	printf("Original array: ");
	for(i=0; i<12; i++)
		printf("%d ", num[i]);
	printf("\n");

	qsort(num, 12, sizeof(int), comp);

	printf("Sorted array: ");
	for(i=0; i<12; i++)
		printf("%d ", num[i]);
	printf("\n");

	return 0;
}

int comp(const void *i, const void *j)
{
	return *(int *)i - *(int *)j;
}