
drop proc DaoRu

create proc DaoRu
as
bulk insert MS from 'D:\MS.txt'  with(   FIELDTERMINATOR='\t', FIRE_TRIGGERS, ROWTERMINATOR='\n',firstrow=2,Batchsize = 50);

bulk insert MSC from 'D:\MSC.txt'  with(   FIELDTERMINATOR='\t', FIRE_TRIGGERS, ROWTERMINATOR='\n',firstrow=2);

bulk insert BSC from 'D:\BSC.txt'  with(   FIELDTERMINATOR='\t', FIRE_TRIGGERS, ROWTERMINATOR='\n',firstrow=2);

bulk insert BTS from 'D:\BTS.txt'  with(   FIELDTERMINATOR='\t', FIRE_TRIGGERS, ROWTERMINATOR='\n',firstrow=2);

bulk insert CELL from 'D:\CELL.txt'  with(   FIELDTERMINATOR='\t', FIRE_TRIGGERS, ROWTERMINATOR='\n',firstrow=2);

bulk insert FREQ from 'D:\FREQ.txt'  with(   FIELDTERMINATOR='\t', FIRE_TRIGGERS, ROWTERMINATOR='\n',firstrow=2);

exec inDATAS;

bulk insert detectInfo from 'D:\detectInfo.txt'  with(   FIELDTERMINATOR='\t', FIRE_TRIGGERS, ROWTERMINATOR='\n',firstrow=2);

bulk insert neighbor from 'D:\neighbor.txt'  with(   FIELDTERMINATOR='\t', FIRE_TRIGGERS, ROWTERMINATOR='\n',firstrow=2);

bulk insert Antenna from 'D:\Antenna.txt'  with(   FIELDTERMINATOR='\t', FIRE_TRIGGERS, ROWTERMINATOR='\n',firstrow=2);

exec DaoRu


create table GG 
(
"DATE" int not null,
"TIME" int not null,
"CellID" int not null,
"nTCH" int,
"traff" float,
"rate" varchar(20),
"thtraff" float,
"callnum" int,
"congsnum" int,
"callcongs" varchar(20),
primary key("DATE","TIME","CellID"),
foreign key("CellID") references "CELL"
)

drop proc inDATAS2

create proc inDATAS
as
delete from GG
bulk insert GG from 'D:\DATAS.txt'  with(   FIELDTERMINATOR='\t', FIRE_TRIGGERS, ROWTERMINATOR='\n',firstrow=2);
update GG set rate = null where traff=0;
update GG set callcongs = null where callnum=0;
insert into DATAS(DATE,TIME, CellID, nTCH, traff,rate,thtraff,callnum,congsnum,callcongs)(select * from GG);

exec inDATAS



create proc inDATAS2
as
delete from GG
bulk insert GG from 'D:\DATAS.txt'  with(   FIELDTERMINATOR='\t', FIRE_TRIGGERS, ROWTERMINATOR='\n',firstrow=2);
update GG set rate = null where traff=0;
update GG set callcongs = null where callnum=0;
update GG set rate =cast(thtraff/traff as varchar(20)) where traff != 0;
update GG set callcongs =cast((congsnum*1.0/callnum*1.0) as varchar(20)) where callnum != 0;
insert into DATAS(DATE,TIME, CellID, nTCH, traff,rate,thtraff,callnum,congsnum,callcongs)(select * from GG);

exec inDATAS2



CREATE PROCEDURE congsCell
	-- Add the parameters for the stored procedure here
	@rate int,
	@day int,
	@hour int
AS
BEGIN
	select avg(traff) from DATAS
	where @rate < 
	and @day = DATE
	and TIME / 100 between @hour and @hour + 14
END

GO



select * from DATAS order by CellID


create table "H_Datas"
(
 "bdate" int not null,
"btime" int not null,
"CellID" int not null,
"H_traff" float,
"H_callcongs" float,
"H_rate" float,
primary key("bdate","btime","CellID")
)

drop proc countCongs

create proc countCongs
as
delete from H_Datas;
with A (D,TT,C,t,tht,ca,co) as 
(
select DATE,TIME/10000,CellID,traff,thtraff,callnum,congsnum from DATAS
)
insert into H_Datas(bdate,btime,CellID,H_traff,H_callcongs,H_rate)(select D,TT,C,avg(t),(sum(co)*1.0)/(sum(ca)*1.0),(sum(tht)*1.0)/(sum(t)*1.0) from A group by D,TT,C);

exec countCongs
--建小时级话务数据表

select * from H_Datas

delete from H_Datas


drop  proc H_datas_out1

-- 符合条件的小区时间段内所有值
CREATE PROCEDURE H_datas_out1
	@rate float,
	@day1 int,
	@hour1 int,
	@day2 int,
	@hour2 int
AS
BEGIN
	select * from H_Datas
	where CellID in
	(
    select CellID from H_Datas
	where @rate < H_rate
	and ((bdate >@day1 and bdate <@day2)
	or (@day1!=@day2 and bdate=@day1 and btime>=@hour1)or(@day1!=@day2 and bdate=@day2 and btime<=@hour2)or(@day1=@day2 and bdate=@day1 and btime>=@hour1 and bdate<=@hour2))
	) and  ((bdate >@day1 and bdate <@day2)
	or (@day1!=@day2 and bdate=@day1 and btime>=@hour1)or(@day1!=@day2 and bdate=@day2 and btime<=@hour2)or(@day1=@day2 and bdate=@day1 and btime>=@hour1 and bdate<=@hour2))
	order by CellID,bdate,btime
END

GO

--符合条件的小区超过rate的查询结果
CREATE PROCEDURE H_datas_out2
	@rate float,
	@day1 int,
	@hour1 int,
	@day2 int,
	@hour2 int
AS
BEGIN
    select * from H_Datas
	where @rate < H_rate
	and ((bdate >@day1 and bdate <@day2)
	or (@day1!=@day2 and bdate=@day1 and btime>=@hour1)or(@day1!=@day2 and bdate=@day2 and btime<=@hour2)or(@day1=@day2 and bdate=@day1 and btime>=@hour1 and bdate<=@hour2))
	order by CellID,bdate,btime
END

GO


create table "H_result"
(
 "bdate" int not null,
"btime" int not null,
"CellID" int not null,
"H_traff" float,
"H_callcongs" float,
"H_rate" float,
primary key("bdate","btime","CellID")
)


drop proc finder

create proc finder2
	@rate float,
	@day1 int,
	@hour1 int,
	@day2 int,
	@hour2 int
as
delete from H_result;
insert into H_result exec H_datas_out2 @rate,@day1,@hour1,@day2,@hour2

exec finder1 0.8,71014,8,71015,23


create proc finder1
	@rate float,
	@day1 int,
	@hour1 int,
	@day2 int,
	@hour2 int
as
delete from H_result;
insert into H_result exec H_datas_out1 @rate,@day1,@hour1,@day2,@hour2

select * from H_result
	order by CellID,bdate,btime
