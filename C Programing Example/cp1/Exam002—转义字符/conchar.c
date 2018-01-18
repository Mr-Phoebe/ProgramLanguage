# include <stdio.h>

void main()
{
	/* 换行符'\n'，用于输出换行 */
	printf("How are you?\n");
	printf("I am fine.\n\n");

	/* 横向跳格符'\t'，使跳到下一个输出区 */
	printf("How are you?\t");
	printf("I am fine.\n\n");

	/* 退格符'\b'，使当前的输出位置退一格，即输出的起始位置左移一位 */
	printf(" How are you?\n");
	printf(" \bI am fine.\n\n");

	/* 回车符'\r'，使当前输出位置回到本行开头 */
	printf("                I am fine.");
	printf("\rHow are you?\n\n");

	/* 多个转义字符的混合运用 */
	printf("note:\n  a s\ti\b\bk\rp\n");
	getchar();
}