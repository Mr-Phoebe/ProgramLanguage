<!--
 * Created by PhpStorm.
 * User: lenovo
 * Date: 2017/9/12
 * Time: 8:48
-->

<HTML>
<HEAD>
<TITLE>简单的函数</TITLE>
</HEAD>
<BODY>
<FONT SIZE=5>
<?
	function printBold($inputText)			//定义function printBold（）
    {
        print("<B>" . $inputText . "</B>");	////打印$inputText
    }
    function makeBold($inputText)       //定义function makeBold()函数
    {
        $boldedText = "<B>";
        $boldedText .= $inputText;
        $boldedText .= "</B>";
        return($boldedText);        //返回变量$boldedText
    }
	print("这行没有加重！<BR>\n");			//直接打印字符串
	printBold("这行加重了！！！");			//调用function printBold()函数
	print("<BR>\n");
    print(makeBold("这行被加重了！！！") . "<BR>\n");//调用function makeBold()函数
	print("这行没有加重！<BR>\n");			//直接打印字符串
?>
</FONT>
</BODY>
</HTML>