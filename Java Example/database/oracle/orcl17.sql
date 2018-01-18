set verify off
ACCEPT sysPassword CHAR PROMPT 'Enter new password for SYS: ' HIDE
ACCEPT systemPassword CHAR PROMPT 'Enter new password for SYSTEM: ' HIDE
ACCEPT sysmanPassword CHAR PROMPT 'Enter new password for SYSMAN: ' HIDE
ACCEPT dbsnmpPassword CHAR PROMPT 'Enter new password for DBSNMP: ' HIDE
host E:\app\Administrator\product\11.2.0\dbhome_1\bin\orapwd.exe file=E:\app\Administrator\product\11.2.0\dbhome_1\database\PWDorcl17.ora force=y
@E:\app\Administrator\admin\orcl17\scripts\CloneRmanRestore.sql
@E:\app\Administrator\admin\orcl17\scripts\cloneDBCreation.sql
@E:\app\Administrator\admin\orcl17\scripts\postScripts.sql
@E:\app\Administrator\admin\orcl17\scripts\lockAccount.sql
@E:\app\Administrator\admin\orcl17\scripts\postDBCreation.sql
