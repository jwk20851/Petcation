create table hosinfo(
	Hosp_name varchar2(100),
	Hosp_tel varchar2(50),
	Hosp_time varchar2(50),
	Hosp_address1 varchar2(150),
	Hosp_address2 varchar2(150),
	Hosp_stop varchar2(50),
	Hosp_reason	varchar2(200),
	Hosp_ReserveTime varchar2(50),
	Hosp_grade float,
	Review_num int,
	d_num number not null,
	rdate varchar(30),
	user_id varchar2(20),
	CONSTRAINT ud2 FOREIGN KEY(user_id) REFERENCES userInfo(user_id),
	CONSTRAINT dn2 FOREIGN KEY(d_num, rdate) REFERENCES dateinfo(d_num, rdate)
)

insert into hospresvtime(tprimary, time_num, resv_time)
select h.tprimary, 1, '2222' from HOSINFO h
where h.tprimary = tprimary;
select h.* from hosinfo h where h.d_num in (select d_num from DATEINFO) and h.Hosp_name like '%�ϰ�%' or h.Hosp_address1 like '%�ϰ�%' or h.Hosp_address2 like '%�ϰ�%'
select * from HOSINFO where Hosp_address1 is null or Hosp_address2 is null;

insert into hosinfo(tprimary) values(1);
delete from HOSINFO

drop table hosinfo;
update HOSPRESVTIME set resv_time = '22' where tprimary = 1 and time_num = 2;
select Hosp_name from HOSINFO group by Hosp_name, Hosp_address1;

select * from HOSINFO where rownum <= 1000;
select * from HOSINFO where Hosp_name = '���Ͻ��������� ��Ÿ�ʵ� ���';
select * from HOSINFO where Hosp_name = '�ϰ������';
delete from HOSINFO where Hosp_name = '���Ͻ��������� ��Ÿ�ʵ� ���' and Hosp_tel = '031-5173-1487' and user_id='java1234A'