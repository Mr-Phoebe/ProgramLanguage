<HTML>
<HEAD>
<TITLE>动态调用函数</TITLE>
</HEAD>
<BODY>
<FONT SIZE=5>
<?
	function write($text)		//定义function write()函数
	{
		print($text);		//打印字符串
	}

	function writeBold($text)	//定义function write()函数
	{
		print("<B>$text</B>");	//打印字符串
	}

	$myFunction = "write";		//定义变量
	$myFunction("你好!<BR>");	//由于变量后面有括号，所以找名字相同的function函数
	print("<BR>\n");
	$myFunction = "writeBold";	//定义变量
	$myFunction("再见!");		//由于变量后面有括号，所以找名字相同的function函数
	print("<BR>\n");
?>
</FONT>
</BODY>
</HTML> 