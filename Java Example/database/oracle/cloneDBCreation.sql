SET VERIFY OFF
connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
spool E:\app\Administrator\admin\orcl17\scripts\cloneDBCreation.log append
Create controlfile reuse set database "orcl17"
MAXINSTANCES 8
MAXLOGHISTORY 1
MAXLOGFILES 16
MAXLOGMEMBERS 3
MAXDATAFILES 100
Datafile 
'E:\app\Administrator\oradata\orcl17\SYSTEM01.DBF',
'E:\app\Administrator\oradata\orcl17\SYSAUX01.DBF',
'E:\app\Administrator\oradata\orcl17\UNDOTBS01.DBF',
'E:\app\Administrator\oradata\orcl17\USERS01.DBF'
LOGFILE GROUP 1 ('E:\app\Administrator\oradata\orcl17\redo01.log') SIZE 51200K,
GROUP 2 ('E:\app\Administrator\oradata\orcl17\redo02.log') SIZE 51200K,
GROUP 3 ('E:\app\Administrator\oradata\orcl17\redo03.log') SIZE 51200K RESETLOGS;
exec dbms_backup_restore.zerodbid(0);
shutdown immediate;
startup nomount pfile="E:\app\Administrator\admin\orcl17\scripts\initorcl17Temp.ora";
Create controlfile reuse set database "orcl17"
MAXINSTANCES 8
MAXLOGHISTORY 1
MAXLOGFILES 16
MAXLOGMEMBERS 3
MAXDATAFILES 100
Datafile 
'E:\app\Administrator\oradata\orcl17\SYSTEM01.DBF',
'E:\app\Administrator\oradata\orcl17\SYSAUX01.DBF',
'E:\app\Administrator\oradata\orcl17\UNDOTBS01.DBF',
'E:\app\Administrator\oradata\orcl17\USERS01.DBF'
LOGFILE GROUP 1 ('E:\app\Administrator\oradata\orcl17\redo01.log') SIZE 51200K,
GROUP 2 ('E:\app\Administrator\oradata\orcl17\redo02.log') SIZE 51200K,
GROUP 3 ('E:\app\Administrator\oradata\orcl17\redo03.log') SIZE 51200K RESETLOGS;
alter system enable restricted session;
alter database "orcl17" open resetlogs;
exec dbms_service.delete_service('seeddata');
exec dbms_service.delete_service('seeddataXDB');
alter database rename global_name to "orcl17";
ALTER TABLESPACE TEMP ADD TEMPFILE 'E:\app\Administrator\oradata\orcl17\TEMP01.DBF' SIZE 20480K REUSE AUTOEXTEND ON NEXT 640K MAXSIZE UNLIMITED;
select tablespace_name from dba_tablespaces where tablespace_name='USERS';
select sid, program, serial#, username from v$session;
alter database character set INTERNAL_CONVERT ZHS16GBK;
alter database national character set INTERNAL_CONVERT AL16UTF16;
alter user sys account unlock identified by "&&sysPassword";
alter user system account unlock identified by "&&systemPassword";
alter system disable restricted session;
