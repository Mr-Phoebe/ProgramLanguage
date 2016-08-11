# include <stdio.h>
# include <stdlib.h>

void main()
{
	FILE *fp;
	int i = 156;
	long l = 9701076L;
	double d = 3.456;

	if((fp=fopen("test", "w"))==NULL)
	{
		printf("不能打开文件.\n");
		exit(0);
	}

	fwrite(&i, sizeof(int), 1, fp);
	fwrite(&l, sizeof(long), 1, fp);
	fwrite(&d, sizeof(double), 1, fp);

	rewind(fp);

	fread(&i, sizeof(int), 1, fp);
	fread(&l, sizeof(long), 1, fp);
	fread(&d, sizeof(double), 1, fp);

	printf("i = %d\n", i);
	printf("l = %ld\n", l);
	printf("d = %f\n", d);

	fclose(fp);
}