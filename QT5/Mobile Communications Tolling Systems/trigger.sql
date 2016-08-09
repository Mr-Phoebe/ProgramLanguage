
if (object_id('tgr_MS_insert', 'tr') is not null)
    drop trigger tgr_MS_insert
go
create trigger tgr_MS_insert
on MS
    instead of insert --插入触发
as
with A(id) as 
(
select IMEI from inserted except select IMEI from MS
)
insert into MS(IMEI,MSISDN,UserName,MSCompany,gsmMspSense,gsmMsHeight,gsmMspFout,MZONE)(select inserted.IMEI,inserted.MSISDN,inserted.UserName,inserted.MSCompany ,inserted.gsmMspSense,inserted.gsmMsHeight ,inserted.gsmMspFout ,inserted.MZONE from inserted,A where inserted.IMEI =A.id);
update MS set MS.MSISDN=inserted.MSISDN,MS.UserName=inserted.UserName,MS.MSCompany=inserted.MSCompany,MS.gsmMspSense=inserted.gsmMspSense,MS.gsmMsHeight=inserted.gsmMsHeight,MS.gsmMspFout=inserted.gsmMspFout,MS.MZONE=inserted.MZONE from MS,inserted where MS.IMEI = inserted.IMEI
go

if (object_id('tgr_MSC_insert', 'tr') is not null)
    drop trigger tgr_MSC_insert
go
create trigger tgr_MSC_insert
on MSC
    instead of insert --插入触发
as
with A(id) as 
(
select MscID from inserted except select MscID from MSC
)
insert into MSC(MscID,MscName, MscCompany,MscLongitude ,MscLatitude,MscAltitude)(select inserted.MscID,inserted.MscName,inserted.MscCompany,inserted.MscLongitude ,inserted.MscLatitude,inserted.MscAltitude from inserted,A where inserted.MscID =A.id);
update MSC set MSC.MscName=inserted.MscName,MSC.MscCompany=inserted.MscCompany,MSC.MscLongitude=inserted.MscLongitude,MSC.MscLatitude=inserted.MscLatitude,MSC.MscAltitude=inserted.MscAltitude from MSC,inserted where MSC.MscID = inserted.MscID
go

if (object_id('tgr_BSC_insert', 'tr') is not null)
    drop trigger tgr_BSC_insert
go
create trigger tgr_BSC_insert
on BSC
    instead of insert --插入触发
as
with A(id) as 
(
select BscID from inserted except select BscID from BSC
)
insert into BSC(BscID,BscName,BscCompany,Longitude,Latitude,MscID)(select inserted.BscID,inserted.BscName,inserted.BscCompany,inserted.Longitude ,inserted.Latitude,inserted.MscID from inserted,A where inserted.BscID =A.id);
update BSC set BSC.BscName=inserted.BscName,BSC.BscCompany=inserted.BscCompany,BSC.Longitude=inserted.Longitude,BSC.Latitude=inserted.Latitude,BSC.MscID=inserted.MscID from BSC,inserted where BSC.BscID = inserted.BscID
go


if (object_id('tgr_BTS_insert', 'tr') is not null)
    drop trigger tgr_BTS_insert
go
create trigger tgr_BTS_insert
on BTS
    instead of insert --插入触发
as
with A(id) as 
(
select BtsName from inserted except select BtsName from BTS
)
insert into BTS(BtsName,BscID,Longitude,Latitude ,Altitude, BtsCompany ,BtsPower)(select inserted.BtsName,inserted.BscID,inserted.Longitude,inserted.Latitude ,inserted.Altitude,inserted.BtsCompany,inserted.BtsPower from inserted,A where inserted.BtsName =A.id);
update BTS set BTS.BscID=inserted.BscID,BTS.Longitude=inserted.Longitude,BTS.Latitude=inserted.Latitude,BTS.Altitude=inserted.Altitude,BTS.BtsCompany=inserted.BtsCompany,BTS.BtsPower=inserted.BtsPower from BTS,inserted where BTS.BtsName = inserted.BtsName
go



if (object_id('tgr_CELL_insert', 'tr') is not null)
    drop trigger tgr_CELL_insert
go
create trigger tgr_CELL_insert
on CELL
    instead of insert --插入触发
as
with A(id) as 
(
select CellID from inserted except select CellID from CELL
)
insert into CELL( CellID,BtsName ,AreaName, LAC ,Longitude,Latitude,Direction,Radious,Bcch)(select inserted.CellID,inserted.BtsName,inserted.AreaName,inserted.LAC ,inserted.Longitude,inserted.Latitude,inserted.Direction,inserted.Radious,inserted.Bcch from inserted,A where inserted.CellID =A.id);
update CELL set CELL.BtsName=inserted.BtsName,CELL.AreaName=inserted.AreaName,CELL.LAC=inserted.LAC,CELL.Longitude=inserted.Longitude,CELL.Latitude=inserted.Latitude,CELL.Direction=inserted.Direction,CELL.Radious=inserted.Radious ,CELL.Bcch=inserted.Bcch  from CELL,inserted where CELL.BtsName = inserted.BtsName
go



if (object_id('tgr_FREQ_insert', 'tr') is not null)
    drop trigger tgr_FREQ_insert
go
create trigger tgr_FREQ_insert
on FREQ
    instead of insert --插入触发
as
with A(id,ff) as 
(
select CellID,Freq from inserted except select CellID,Freq from FREQ
)
insert into FREQ(CellID ,Freq)(select inserted.CellID,inserted.Freq from inserted,A where inserted.CellID =A.id and inserted.Freq = A.ff);
go


if (object_id('tgr_Antenna_insert', 'tr') is not null)
    drop trigger tgr_Antenna_insert
go
create trigger tgr_Antenna_insert
on Antenna
    instead of insert --插入触发
as
with A(id) as 
(
select CellID from inserted except select CellID from Antenna
)
insert into Antenna(CellID,AntennaHigh ,HalfPAngle,MaxAttenuation ,Gain,AntTilt ,Pt,MsPwr)(select inserted.CellID,inserted.AntennaHigh,inserted.HalfPAngle,inserted.MaxAttenuation ,inserted.Gain,inserted.AntTilt,inserted.Pt,inserted.MsPwr from inserted,A where inserted.CellID =A.id);
update Antenna set Antenna.AntennaHigh=inserted.AntennaHigh,Antenna.HalfPAngle=inserted.HalfPAngle,Antenna.MaxAttenuation=inserted.MaxAttenuation,Antenna.Gain=inserted.Gain,Antenna.AntTilt=inserted.AntTilt,Antenna.Pt=inserted.Pt,Antenna.MsPwr=inserted.MsPwr from Antenna,inserted where Antenna.CellID = inserted.CellID
go


if (object_id('tgr_DATAS_insert', 'tr') is not null)
    drop trigger tgr_DATAS_insert
go
create trigger tgr_DATAS_insert
on DATAS
    instead of insert --插入触发
as 
with A(dd,tt,id) as 
(
select DATE,TIME,CellID from inserted except select DATE,TIME,CellID from DATAS
)
insert into DATAS(DATE,TIME,CellID,nTCH ,traff,rate ,thtraff ,callnum ,congsnum ,callcongs)(select inserted.DATE,inserted.TIME,inserted.CellID,inserted.nTCH ,inserted.traff,inserted.rate ,inserted.thtraff ,inserted.callnum ,inserted.congsnum ,inserted.callcongs from inserted,A where inserted.DATE=A.dd and inserted.TIME=A.tt and inserted.CellID=A.id);
update DATAS set DATAS.nTCH=inserted.nTCH,DATAS.traff=inserted.traff,DATAS.rate=inserted.rate ,DATAS.thtraff=inserted.thtraff ,DATAS.callnum=inserted.callnum ,DATAS.congsnum=inserted.congsnum ,DATAS.callcongs=inserted.callcongs from DATAS,inserted where DATAS.DATE=inserted.DATE AND DATAS.TIME = inserted.TIME AND DATAS.CellID = inserted.CellID
go


if (object_id('tgr_neighbor_insert', 'tr') is not null)
    drop trigger tgr_neighbor_insert
go
create trigger tgr_neighbor_insert
on neighbor
    instead of insert --插入触发
as
with A(id,adj) as 
(
select CellID,AdjcellId from inserted except select CellID,AdjcellId from neighbor
)
insert into neighbor(CellId,AdjcellId,CellLac,Adjcelllac)(select inserted.CellID,inserted.AdjcellId,inserted.CellLac,inserted.Adjcelllac from inserted,A where inserted.CellID =A.id and inserted.AdjcellId = A.adj);
update neighbor set neighbor.CellLac=inserted.CellLac,neighbor.Adjcelllac=inserted.Adjcelllac from neighbor,inserted where neighbor.AdjcellId=inserted.AdjcellId  AND neighbor.CellID = inserted.CellID
go




if (object_id('tgr_detectInfo_insert', 'tr') is not null)
    drop trigger tgr_detectInfo_insert
go
create trigger tgr_detectInfo_insert
on detectInfo
    instead of insert --插入触发
as
with A(num,id) as 
(
select keyNum,CellID from inserted except select keyNum,CellID from detectInfo
)
insert into detectInfo(keyNum,CellID,Latitude,Longitude,RxLev)(select inserted.keyNum,inserted.CellID,inserted.Latitude,inserted.Longitude,inserted.RxLev from inserted,A where inserted.CellID =A.id and inserted.keyNum = A.num);
update detectInfo set detectInfo.Latitude=inserted.Latitude,detectInfo.Longitude=inserted.Longitude,detectInfo.RxLev=inserted.RxLev from detectInfo,inserted where detectInfo.keyNum=inserted.keyNum  AND detectInfo.CellID = inserted.CellID
go




















insert into MSC values('6666','12223','hjk',111.123,123.123,2000)



select * from BSC
select * from BTS

delete from MSC where MscID='6666'

insert into MS values('350996406261649','33333333333','jkl','54jj',555,7.77,8.88,'no')

create table classes
(id int,
name varchar(20))

create table student
(
name varchar(20),
id int,
temp int,
idd int)


go
create trigger tgr_classes_insert
on classes
    for insert --插入触发
as
    --定义变量
    declare @id int, @name varchar(20), @temp int;
    --在inserted表中查询已经插入记录信息
    select @id = id, @name = name from inserted;
    set @name = @name + convert(varchar, @id);
    set @temp = @id / 2;    
    insert into student values(@name, 18 + @id, @temp, @id);
    print '添加学生成功！';
go

insert into classes values(53,'shihui');

select * from student
select * from classes
