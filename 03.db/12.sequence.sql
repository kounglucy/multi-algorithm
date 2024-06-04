-- 12.sequence.sql
/*
1. 시퀀스 (mysql에서는 auto increment)
	: 순차적인 순법을 자동으로 반영할수 있는 매우 유용한 기술
	: 기본은 1씩 자동 증가
		- 증가치, 최대값 추가 설정도 가능
		- 권장 : 하나의 시퀀스를 다수의 table에서 사용 비추
	: 개념, 필요성, 문법(create, drop, nextval, currval)

2. 대표적인 활용 영역
	- 게시물 글번호에 주로 사용

3. 특징
	- 중복 불가 
*/	
     
-- 1. sequence 생성 명령어
CREATE SEQUENCE seq_test_no1;

-- 2. insert
-- 기본적으로 생성한 경우 1씩 자동 증가
drop table seq_test;

create table seq_test(
	no1 number(2),
	no2 number(2)
);
INSERT INTO seq_test VALUES (seq_test_no1.nextval, 10);

-- sequence값 검색
SELECT seq_test_no1.currval FROM DUAL;

-- 3. 다수의 table에서 하나의 seq를 공동 사용?
create table seq_test2(
	no1 number(2),
	no2 number(2)
);

INSERT INTO seq_test2 VALUES (seq_test_no1.nextval, 1);
INSERT INTO seq_test2 VALUES (seq_test_no1.nextval, 2);

INSERT INTO seq_test VALUES (seq_test_no1.nextval, 6);
INSERT INTO seq_test VALUES (seq_test_no1.nextval, 7);

SELECT * FROM seq_test;
SELECT * FROM seq_test2;

-- 4. 시작 index 지정 및 증가치도 지정하는 seq 생성 명령어
drop sequence seq_test_no1;

CREATE SEQUENCE seq_test_no1
START WITH 10
INCREMENT BY 2
MAXVALUE 40;

INSERT INTO seq_test VALUES (seq_test_no1.nextval, 10);
INSERT INTO seq_test VALUES (seq_test_no1.nextval, 16);
