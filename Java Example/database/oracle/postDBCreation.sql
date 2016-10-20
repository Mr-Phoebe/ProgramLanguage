SET VERIFY OFF
connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
spool E:\app\Administrator\admin\orcl17\scripts\postDBCreation.log append
select 'utl_recomp_begin: ' || to_char(sysdate, 'HH:MI:SS') from dual;
execute utl_recomp.recomp_serial();
select 'utl_recomp_end: ' || to_char(sysdate, 'HH:MI:SS') from dual;
execute dbms_swrf_internal.cleanup_database(cleanup_local => FALSE);
commit;
connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
create spfile='E:\app\Administrator\product\11.2.0\dbhome_1\database\spfileorcl17.ora' FROM pfile='E:\app\Administrator\admin\orcl17\scripts\init.ora';
shutdown immediate;
connect "SYS"/"&&sysPassword" as SYSDBA
startup ;
host E:\app\Administrator\product\11.2.0\dbhome_1\bin\emca.bat -config dbcontrol db -silent -DB_UNIQUE_NAME orcl17 -PORT 1521 -EM_HOME E:\app\Administrator\product\11.2.0\dbhome_1 -LISTENER LISTENER -SERVICE_NAME orcl17 -SID orcl17 -ORACLE_HOME E:\app\Administrator\product\11.2.0\dbhome_1 -HOST localhost -LISTENER_OH E:\app\Administrator\product\11.2.0\dbhome_1 -LOG_FILE E:\app\Administrator\admin\orcl17\scripts\emConfig.log;
spool off
