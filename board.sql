DROP TABLE board1 PURGE;
DROP TABLE bookmark PURGE;
DROP TABLE viewnotice PURGE;

CREATE TABLE board1(
	num NUMBER PRIMARY KEY NOT NULL,
	writer VARCHAR2(10) DEFAULT NULL, 
	phonenum VARCHAR2(30) DEFAULT NULL,
	petname VARCHAR2(30) DEFAULT NULL,	
	rate NUMBER NOT NULL,	
	title VARCHAR2(50) DEFAULT NULL,
	reg_date TIMESTAMP(9), 
	readcount NUMBER DEFAULT 0,
	content VARCHAR2(4000) NOT NULL 
);

drop TABLE board1
CREATE TABLE bookmark(
	num NUMBER PRIMARY KEY NOT NULL, 
	hosname VARCHAR2(200) NOT NULL,
	tel VARCHAR2(200),
	addr VARCHAR2(400) NOT NULL
);
drop table bookmark

CREATE TABLE viewnotice(
	num NUMBER PRIMARY KEY NOT NULL, 
	checkbox VARCHAR2(60),
	title VARCHAR2(50) NOT NULL,
	content VARCHAR2(4000) NOT NULL, 
	noticefile VARCHAR2(60),
	readcount NUMBER DEFAULT 0,
	writer VARCHAR2(10) DEFAULT NULL, 
	reg_date TIMESTAMP(9) 
);
drop table viewnotice
drop table viewamtm
CREATE TABLE viewamtm(
	num NUMBER PRIMARY KEY NOT NULL, 
	checkbox VARCHAR2(60),
	title VARCHAR2(50) NOT NULL,
	content VARCHAR2(4000) NOT NULL, 
	noticefile VARCHAR2(60),	
	writer VARCHAR2(10) DEFAULT NULL, 
	answer VARCHAR2(10) DEFAULT NULL, 
	reg_date TIMESTAMP(9) 
);

CREATE TABLE hosreview(

   num NUMBER PRIMARY KEY, -- 번호
   content VARCHAR2(50), -- 내용
   rate NUMBER, -- 평점
   id VARCHAR2(50), -- 아이디
   writedate VARCHAR2(30) --작성일
);

   CREATE SEQUENCE hosreserve_seq;
   CREATE SEQUENCE hosreview_seq;

	CREATE SEQUENCE board1_seq;
	
	CREATE SEQUENCE bookmark_seq;
	
	CREATE SEQUENCE viewnotice_seq;
	
	CREATE SEQUENCE viewamtm_seq;
	
	
	drop SEQUENCE board1_seq;
	drop SEQUENCE bookmark_seq;
		drop SEQUENCE viewnotice_seq;
		drop SEQUENCE viewamtm_seq;

	
	
	SELECT list2.*
	from ( 
		select ROWNUM r, board1.*
		from board1
	)list2
	where r between 1 and 5
	
	
	
	from board1;
	
	DELETE board1;
	
	SELECT * FROM board1
	SELECT * FROM bookmark
	
	SELECT COUNT(*) FROM board1
		