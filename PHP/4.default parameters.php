<HTML>
<HEAD>
<TITLE>有默认参数的函数</TITLE>
</HEAD>
<BODY>
<FONT SIZE=5>
<?
	function printColored($Text, $Color="black")		//定义function函数
	{
		print("<FONT COLOR=\"$Color\">$Text</FONT>");	//获取字符串的内容和颜色
	}
	printColored("这是黑颜色的字！");			//调用function函数
	print("<BR><BR>\n");
	printColored("这是蓝颜色的字！", "blue");			//调用function函数
	print("<BR>\n");
?>
</SIZE>
</BODY>
</HTML>