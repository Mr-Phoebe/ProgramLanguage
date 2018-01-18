<HTML>
<HEAD>
<TITLE>±‰¡ø≤‚ ‘</TITLE>
</HEAD>
<BODY>
<FONT SIZE=5>
<?php

    $name = 'user1';

    if(isset($name)):
        echo $name;
    else:
        echo "Not exist!";

    //$sex = '';
    //$sex = 0;
    //$sex = 0.0;
    //$sex = null;
    //$sex = false;
    $sex = array();
    if(empty($sex)):
        echo "Not empty";
    else:
        echo "empty";

    echo gettype($sex);
?>
</FONT>
</BODY>
</HTML> 