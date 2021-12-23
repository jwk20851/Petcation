CREATE TABLE petinfo(
pet_Num VARCHAR2(20) PRIMARY KEY,
user_Id VARCHAR2(20) NOT NULL,
pet_Kind VARCHAR2(20) NOT NULL,
pet_Name VARCHAR2(20),
pet_Age int NOT NULL,
pet_Breed VARCHAR2(20),
pet_Gender VARCHAR2(20),
pet_Weight float(20),
pet_Disease VARCHAR2(20),
pet_Infodetail VARCHAR2(20),
pet_Filename VARCHAR2(100),
CONSTRAINT petid FOREIGN KEY(user_Id) REFERENCES userInfo(user_id)
)


insert into petinfo(pet_Num, user_Id, pet_Kind, pet_Name, pet_Age) values('3', 'add12U', '강아지', '멍멍', 1);
insert into petinfo(pet_Num, user_Id, pet_Kind, pet_Name, pet_Age) values('4', 'add12U', '고양이', '야옹', 2);
insert into petinfo(pet_Num, user_Id, pet_Kind, pet_Name, pet_Age) values('없음', 'add12U', '없음', '없음', 0);
insert into petinfo(pet_Num, user_Id, pet_Kind, pet_Name, pet_Age) values('없음', 'resv1234A', '없음', '없음', 0);
insert into petinfo(pet_Num, user_Id, pet_Kind, pet_Name, pet_Age) values('5', 'resv1234A', '고양이', '캣', 10);

delete from petinfo;
select * from petinfo pi where user_Id='add12U' and pi.pet_Name in(select rsv.pet_name from hospresvtime rsv where user_id = 'add12U');

CREATE SEQUENCE petnum_seq;

select * from petinfo
DROP TABLE petinfo

CREATE SEQUENCE petnum_seq;
drop SEQUENCE petnum_seq
DELETE FROM petinfo WHERE pet_Num = '16'

select * from petinfo
DROP TABLE petinfo
SELECT * FROM petinfo ORDER BY pet_Num DESC
