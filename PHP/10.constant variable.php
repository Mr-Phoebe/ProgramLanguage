<HTML>
<HEAD>
<TITLE>³£Á¿</TITLE>
</HEAD>
<BODY>
<FONT SIZE=5>
<?php

    define('HOST','127.0.0.1');
    define('USER','root');
    define('PASS','123');

    if(defined('PASS')):
        echo "YES";
    else:
        echo "NO";

    echo __FILE__.'-->'.__LINE__;
    echo M_PI;

    function show()
    {
        echo 'My name is'.__FUNCTION__.' !!<br>';
    }

    show();
?>
</FONT>
</BODY>
</HTML> 