create table userInfo (
	user_id varchar2(20) not null,
	user_pw varchar2(20) not null,
	user_email varchar2(254) not null,
	user_name varchar2(20) not null,
	user_nickname varchar2(20) not null,
	user_phone int not null,
	user_postcode int not null,
	user_address varchar2(150) not null,
	user_detailaddress varchar2(150) not null,
	user_regDate varchar2(20) not null,
	user_authority int,
	review_num int,
	bookmark int,
	CONSTRAINT ud PRIMARY KEY (user_id)
)
drop table userInfo;

delete from USERINFO;

select * from USERINFO;

UPDATE userInfo SET user_authority=3 WHERE user_id = 'sct1234A';
UPDATE userInfo SET user_authority=2 WHERE user_id = 'abc1234A';
UPDATE userInfo SET user_authority=3 WHERE user_id = 'java1234A';

commit

update userInfo set user_pw = 'abc1234*A' where user_id = 'sct' and user_email = 'snes5821@naver.com';