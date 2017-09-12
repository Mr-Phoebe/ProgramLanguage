<HTML>
<HEAD>
<TITLE>for的高级运用</TITLE>
</HEAD>
<BODY>
<?
	/* 
	** 打印必要的说明文字 
	*/
	print("<B>距离星期一还有几天？</B>\n");
	print("<OL>\n");
	for($currentDate = date("U"); 			//定义$currentDate时间格式
		date("l", $currentDate) != "Monday"; 	//判断是不是当前系统时间是Monday
		$currentDate += (60 * 60 * 24))		//当前时间加上1天
	{
		/* 
		** 打印时间名称 
		*/
		print("<LI>" . date("l", $currentDate) . "\n");
	}

	print("</OL>\n");
?>
</BODY>
</HTML>