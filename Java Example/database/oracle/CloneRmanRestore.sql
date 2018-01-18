SET VERIFY OFF
connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
spool E:\app\Administrator\admin\orcl17\scripts\CloneRmanRestore.log append
startup nomount pfile="E:\app\Administrator\admin\orcl17\scripts\init.ora";
@E:\app\Administrator\admin\orcl17\scripts\rmanRestoreDatafiles.sql;
spool off
