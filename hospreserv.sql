create table hospresvtime(
	tprimary number,
	time_num number,
	resv_time varchar2(20),
	user_id varchar2(20),
	hos_name varchar2(100),
	pet_name varchar2(20),
	resvdate varchar2(50),
	treatreport varchar2(1000),
	fintreat number,
	CONSTRAINT ruid FOREIGN KEY(user_id) REFERENCES userInfo(user_id),
	CONSTRAINT tkey PRIMARY KEY(tprimary, time_num)
)


update hospresvtime set fintreat = 2 where tprimary = ? and time_num = ?
drop table hospresvtime
select * from hospresvtime order by tprimary, time_num;
SELECT LAST_NUMBER FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'T_SEQ';
ALTER SEQUENCE T_SEQ INCREMENT BY -23;
select * from USER_SEQUENCES;
SELECT T_SEQ.NEXTVAL FROM DUAL;
SELECT T_SEQ.CURRVAL FROM DUAL;
ALTER SEQUENCE T_SEQ INCREMENT BY 1;

insert into hospresvtime
select t_seq.currval, level, '33'
from dual
connect by level <= 5

delete from hosinfo
delete from HOSPRESVTIME
delete from dateinfo
drop sequence t_seq;
create sequence t_seq;
drop sequence h_seq;
create sequence h_seq;

SELECT list2.* FROM (SELECT ROWNUM r, list1.* FROM (select * from hospresvtime where tprimary = 1 order by tprimary, time_num) list1) list2 WHERE r BETWEEN 1 AND 3

drop table hospresvtime
insert into HOSPRESVTIME values(T_SEQ.NEXTVAL, 1, '11');
insert into HOSPRESVTIME values(T_SEQ.CURRVAL, 2, '22');
insert into HOSPRESVTIME values(T_SEQ.NEXTVAL, 0, '11');
insert into hospresvtime
select t_seq.currval, level, '33'
from dual
connect by level <= 5

MERGE INTO hospresvtime hrv 
USING hosinfo hin
 ON (hin.tprimary = hrv.tprimary) 
 WHEN MATCHED THEN
 update set hrv.resv_time = '22'
-- delete where hin.tprimary = hrv.tprimary
 WHEN NOT MATCHED THEN INSERT (hrv.tprimary, hrv.time_num, hrv.resv_time) VALUES (hin.tprimary, 1, '11');
select * from hospresvtime where tprimary = 1 order by tprimary, time_num

select pi.* from petinfo pi, hospresvtime rsv where rsv.user_id = 'add12U' and rsv.user_id = pi.user_id and (rsv.pet_name = pi.pet_Name) order by rsv.tprimary, rsv.time_num
select * from hospresvtime where user_id = 'add12U' order by tprimary, time_num