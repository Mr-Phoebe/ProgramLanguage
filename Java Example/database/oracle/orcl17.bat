OLD_UMASK=`umask`
umask 0027
mkdir E:\app\Administrator\admin\orcl17\adump
mkdir E:\app\Administrator\admin\orcl17\dpdump
mkdir E:\app\Administrator\admin\orcl17\pfile
mkdir E:\app\Administrator\cfgtoollogs\dbca\orcl17
mkdir E:\app\Administrator\flash_recovery_area
mkdir E:\app\Administrator\flash_recovery_area\orcl17
mkdir E:\app\Administrator\oradata\orcl17
mkdir E:\app\Administrator\product\11.2.0\dbhome_1\database
umask ${OLD_UMASK}
set ORACLE_SID=orcl17
set PATH=%ORACLE_HOME%\bin;%PATH%
E:\app\Administrator\product\11.2.0\dbhome_1\bin\oradim.exe -new -sid ORCL17 -startmode manual -spfile 
E:\app\Administrator\product\11.2.0\dbhome_1\bin\oradim.exe -edit -sid ORCL17 -startmode auto -srvcstart system 
E:\app\Administrator\product\11.2.0\dbhome_1\bin\sqlplus /nolog @E:\app\Administrator\admin\orcl17\scripts\orcl17.sql
