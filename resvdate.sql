create table dateinfo(
	d_num number not null,
	rdate varchar(30) not null,
	tprimary number,
	time_num number,
	CONSTRAINT tnum FOREIGN KEY(tprimary, time_num) REFERENCES hospresvtime(tprimary, time_num),
	CONSTRAINT dn PRIMARY KEY(d_num, rdate)
)

drop table dateinfo

select * from dateinfo;
select * from hospresvtime order by tprimary, time_num;
select * from hosinfo;
select * from HOSPRESVTIME where fintreat = 2;
select tprimary from dateinfo where d_num = (select d_num from hosinfo where d_num=22) and rdate='2021-12-13'
select tprimary from hospresvtime where tprimary in (select tprimary from dateinfo where d_num = (select d_num from hosinfo where d_num=22)) order by tprimary, time_num
select hst.* from hospresvtime hst, dateinfo di where di.d_num = 22 and di.rdate='2021-12-16' and di.tprimary = hst.tprimary order by hst.tprimary, hst.time_num;
update hospresvtime set user_id = 'add12U', hos_name = '¹ÎÆ®µ¿¹°º´¿ø', pet_name = '¾ß¿Ë' where tprimary = (select tprimary from dateinfo where d_num = (select d_num from hosinfo where d_num=22) and rdate='2021-12-13') and resv_time = '09:00'
select * from hospresvtime where tprimary = 23 and resv_time = '09:00'
select * from hospresvtime where user_id = 'add12U' order by tprimary, time_num
select * from petinfo pi where user_Id = 'add12U' and pi.pet_Name in(select rsv.pet_name from hospresvtime rsv where user_id = 'add12U')
select pi.* from petinfo pi, hospresvtime rsv where rsv.user_id = 'add12U' and (rsv.pet_name = pi.pet_Name) order by rsv.time_num
select pi.* from petinfo pi, hospresvtime rsv where rsv.user_id = 'add12U' and (rsv.pet_name = pi.pet_Name) order by rsv.tprimary, rsv.time_num

select di.*, hsv.* from hospresvtime hsv, dateinfo di where di.tprimary = hsv.tprimary order by hsv.tprimary, hsv.time_num
select * from hospresvtime where user_id = 'add12U' order by tprimary, time_num
select * from hospresvtime where tprimary = 1 order by tprimary, time_num
SELECT list2.* FROM (SELECT ROWNUM r, list1.* FROM (select hos.*, h.Hosp_tel FROM hospresvtime hos, dateinfo di, hosinfo h where h.user_id ='sct1234A' and di.tprimary = hos.tprimary and di.d_num = (select d_num from HOSINFO where user_id='sct1234A') and hos.user_id is not null order by hos.tprimary, hos.time_num) list1) list2 WHERE r BETWEEN 1 AND 3

SELECT list2.* FROM (SELECT ROWNUM r, list1.* FROM (select hos.*, ui.user_name, ui.user_phone FROM hospresvtime hos, dateinfo di, userInfo ui where ui.user_id = hos.user_id and di.tprimary = hos.tprimary and di.d_num = (select d_num from HOSINFO where user_id='sct1234A') and hos.user_id is not null order by hos.tprimary, hos.time_num) list1) list2 



SELECT count(*) FROM hospresvtime hos, dateinfo di where di.tprimary = hos.tprimary and di.d_num = (select d_num from HOSINFO where user_id='sct1234A') and hos.user_id is not null order by hos.tprimary, hos.time_num

SELECT list2.* FROM (SELECT ROWNUM r, list1.* FROM (select hos.* FROM hospresvtime hos, dateinfo di where di.tprimary = hos.tprimary and di.d_num = (select d_num from HOSINFO where user_id = 'sct1234A') and hos.user_id is not null order by hos.tprimary, hos.time_num) list1) list2 WHERE r BETWEEN 1 AND 3

select hos.* FROM hospresvtime hos, dateinfo di where di.tprimary = hos.tprimary and di.d_num = (select d_num from HOSINFO where user_id = 'sct1234A')