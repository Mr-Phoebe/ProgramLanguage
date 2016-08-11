create table "MS"
(
 "IMEI" varchar(20) not null,
"MSISDN" varchar(20),
"UserName" varchar(20),
"MSCompany" varchar(20),
"gsmMspSense" int,
"gsmMsHeight" float,
"gsmMspFout" float,
"MZONE" varchar(10),
primary key("IMEI")
)

create table "MSC"
(
 "MscID" int not null,
"MscName" varchar(20),
"MscCompany" varchar(20),
"MscLongitude" float,
"MscLatitude" float,
"MscAltitude" int,
primary key("MscID")
)

create table "BSC"
(
"BscID" int not null,
"BscName" varchar(20),
"BscCompany" varchar(20),
"Longitude" float,
"Latitude" float,
"MscID" int not null,
primary key("BscID"),
foreign key ("MscID") references "MSC"
)

create table "BTS"
(
"BtsName" varchar(20) not null,
"BscID" int not null,
"Longitude" float,
"Latitude" float,
"Altitude" int,
"BtsCompany" varchar(20),
"BtsPower" int,
primary key("BtsName"),
foreign key("BscID") references "BSC"
)

create table "CELL"
(
"CellID" int not null,
"BtsName" varchar(20),
"AreaName" varchar(20),
"LAC" int,
"Longitude" float,
"Latitude" float,
"Direction" int,
"Radious" int,
"Bcch" int,
primary key("CellID"),
foreign key("BtsName") references "BTS"
)

create table "FREQ"
(
"CellID" int not null,
"Freq" int,
primary key("CellID","Freq")
)

create table "Antenna"
(
"CellID" int not null,
"AntennaHigh" int,
"HalfPAngle" int,
"MaxAttenuation" int,
"Gain" int,
"AntTilt" int,
"Pt" int,
"MsPwr" int,
primary key("CellID")
)

create table "neighbor"
(
"CellID" int not null,
"AdjcellId" int not null,
"CellLac" int,
"Adjcelllac" int,
primary key("CellID","AdjcellId")
)

create table DATAS
(
"DATE" int not null,
"TIME" int not null,
"CellID" int not null,
"nTCH" int,
"traff" float,
"rate" float,
"thtraff" float,
"callnum" int,
"congsnum" int,
"callcongs" float,
primary key("DATE","TIME","CellID"),
foreign key("CellID") references "CELL"
)

create table "detectInfo"
(
"keyNum" int not null,
"CellID" int not null,
"Latitude" float,
"Longitude" float,
"RxLev" float,
primary key("keyNum","CellID"),
foreign key("CellID") references "CELL"
)


select * from MS

select * from MSC

select * from BSC

select * from BTS

select * from CELL 

select * from FREQ

select * from Antenna

select * from neighbor

select * from DATAS 

select * from detectInfo

select distinct CellID from CELL

select * from GG 

delete from MS

delete from MSC

delete from BSC

delete from BTS

delete from CELL 

delete from FREQ

delete from Antenna

delete from neighbor

delete from DATAS

delete from detectInfo

delete from GG


select count(*) from CELL,FREQ where CELL.CellID=FREQ.CellID and CELL.CellID = 9011

select * from CELL where CELL.CellID = 9011


drop proc shihui

go
create proc shihui(
@id varchar(20)
--@name varchar(20) out
)
as
select * from MS where IMEI = @id ;

	exec shihui 350996406261649
	
	declare @name varchar(20);
	declare @id varchar(20);
	set @id='350996406261649'
	exec shihui @id,@name; 

	select @name


	select CellID,Longitude,Latitude from CELL

create table "Distance"
(
"CellID1" int not null,
"CellID2" int not null,
"distance" float,
primary key("CellID1","CellID2")
)

insert into Distance values(123456,54321,1.667766)

select * from Distance

delete from Distance

if (object_id('tgr_Distance_insert', 'tr') is not null)
    drop trigger tgr_Distance_insert
go
create trigger tgr_Distance_insert
on Distance
    instead of insert --≤Â»Î¥•∑¢
as
with A(id,adj) as 
(
select CellID1,CellID2 from inserted except select CellID1,CellID2 from Distance
)
insert into Distance(CellID1,CellID2,distance)(select inserted.CellID1,inserted.CellID2,inserted.distance from inserted,A where inserted.CellID1 =A.id and inserted.CellID2 = A.adj);
update Distance set Distance.distance=inserted.distance from Distance,inserted where Distance.CellID1=inserted.CellID1  AND Distance.CellID2 = inserted.CellID2
go