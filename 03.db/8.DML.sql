-- 8.DML.sql
/* 
- DML : Data Mainpulation Language
            데이터 조작 언어
	   (select/insert/update/delete 모두 다 DML)
		- 이미 존재하는 table에 데이터 저장, 수정, 삭제, 검색

- 영구 저장
	1. insert/update/delete 문장에만 영향을 줌
	2. sql문장을 실행시킨 프로그램상에서만 영향을 줌(DML 작업한 sw상에서만 commit / rollback 유효)
	3. 가급적 sql문장 backup시 insert 문장이 있을 경우 습관적으로 마지막에 commit; 필수(*)
	4. 저장시 : commit
	   복원시 : rollback
       
- 참고 : sql 작업을 편리하게 지원하는 tool들은 auto commit 기능 내포
	
	
1. insert 
	1-1. 모든 컬럼에 데이터 저장
		table 구조상의 컬럼 순서에 맞게 모든 데이터 저장시 사용
		insert into table명 values(데이터값1, ...)

	1-2. 특정 컬럼에만 데이터 저장
		명확하게 컬럼명 기술 
		insert into table명 (컬럼명1,...) values(컬럼과매핑될데이터1...)

2. update 
	2-1. 모든 table(다수의 row)의 데이터 한번에 수정
		where조건문 없는 문장
		update table명 set 컬럼명=수정데이타;

	2-2. 특정 row값만 수정
		where조건문으로 처리하는 문장
		update table명 set 컬럼명=수정데이타 where 조건sql;
        
3. delete
    3-1. table 데이터 삭제
        delete from 테이블명;
*/

--  *** insert 
-- 1. 컬럼명 기술없이 데이터 입력
DESC PEOPLE;

CREATE TABLE people(
		name varchar2(20),
    age number(3));
    
INSERT INTO PEOPLE VALUES('brother', 25);

SELECT * 
FROM PEOPLE;

-- 에러 발생 : 컬럼 순서 맞지 않기 때문
INSERT INTO PEOPLE VALUES(26, 'hansol');

-- 2. 컬럼명 기술후 데이터 입력 
INSERT INTO PEOPLE(age, name) VALUES(26, 'hansol');

-- 3. 다중 table에 한번에 데이터 insert하기 : INSERT ALL
DROP TABLE emp01;
DROP TABLE emp02;

CREATE TABLE EMP01 AS SELECT empno, ename, deptno FROM EMP
WHERE 1 = 0;

CREATE TABLE EMP02 AS SELECT empno, ename, deptno FROM EMP
WHERE 1 = 0;

SELECT * 
FROM EMP01;

SELECT * 
FROM EMP02;

INSERT ALL 
		INTO EMP01 (empno, ename, deptno) VALUES (empno, ename, deptno)
		INTO EMP02 (empno, ename, deptno) VALUES (empno, ename, deptno)
SELECT empno, ename, deptno FROM EMP;

SELECT * 
FROM EMP01;

SELECT * 
FROM EMP02;

-- 4. ? 부서 번호가 10인 데이터는 emp01에 저장, 
--  부서 번호가 20 or 30인 데이터는 emp02에 저장
--  조건 표현 : when~then
TRUNCATE TABLE EMP01;
TRUNCATE TABLE EMP02;

INSERT ALL 
		WHEN deptno = 10 THEN
			INTO EMP01 (empno, ename, deptno) VALUES (empno, ename, deptno)
		WHEN deptno = 20 OR deptno = 30 THEN
    	INTO EMP02 (empno, ename, deptno) VALUES (empno, ename, deptno)
SELECT empno, ename, deptno FROM EMP;

SELECT * 
FROM EMP01;

SELECT * 
FROM EMP02;

--  *** update
-- 1. 테이블의 모든 행 변경
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP;
SELECT * FROM EMP01;

UPDATE EMP01 SET deptno = 60;

SELECT *
FROM EMP01;

--  30이전의 데이터로 복원
ROLLBACK;

-- 2. emp01 table의 모든 사원의 급여를 10%(sal*1.1) 인상하기
UPDATE EMP01 SET sal = sal * 1.1;

-- ? emp table로 부터 empno, sal, hiredate, ename 순으로 table 생성
DROP TABLE EMP01;

CREATE TABLE EMP01 AS SELECT empno, sal, hiredate, ename FROM EMP;

SELECT * FROM EMP01;

-- 3. emp01의 모든 사원의 입사일을 오늘로 바꿔주세요
UPDATE EMP01 SET hiredate = SYSDATE;

SELECT * FROM EMP01;

--  4. 급여가 3000이상인 사원의 급여만 10%인상
UPDATE EMP01 SET sal = sal * 1.1
WHERE sal >= 3000;

SELECT * FROM EMP01;

-- 5. ?emp01 table 사원의 급여가 1000이상인 사원들의 급여만 500원씩 삭감 
UPDATE EMP01 SET sal = sal - 500
WHERE sal >= 1000;

SELECT * FROM EMP01;

-- 6. ?emp01 table에 DALLAS(dept의 loc)에 위치한 부서의 소속 사원들의 급여를 1000인상
DROP TABLE EMP01;

CREATE TABLE EMP01 AS SELECT * FROM EMP;

UPDATE EMP01 SET sal = sal + 1000
WHERE deptno = (SELECT deptno
                               FROM DEPT
                               WHERE loc = 'DALLAS');

SELECT * FROM EMP01;

-- 7. emp01 table의 SMITH 사원의 부서 번호를 30으로, 직급은 MANAGER 수정
SELECT ename, deptno, job
FROM EMP01
WHERE ename = 'SMITH';

UPDATE EMP01
SET deptno = 30, job = 'MANAGER'
WHERE ename = 'SMITH';

- *** 
DROP TABLE EMP03;

CREATE TABLE EMP03 AS SELECT empno, sal, hiredate, ename FROM EMP;

SELECT * FROM EMP03;

-- 문제 발생 : deptno 컬럼이 EMP03에 존재 X때문에 --> ALTER 사용하면?
UPDATE EMP03 SET sal = sal + 1000
WHERE deptno = (SELECT deptno
                FROM DEPT
                WHERE loc = 'DALLAS');

-- 문제 해결 
-- 1) EMP03 테이블에 deptno 컬럼 추가
DESC EMP03;
ALTER TABLE EMP03 ADD(deptno number(3));
DESC EMP03;

-- 2) EMP03 deptno컬럼에 EMP 테이블의 deptno 가져 와서 Insert!
SELECT * FROM EMP03;

INSERT ALL
		INTO EMP03 (deptno) VALUES (deptno)
		SELECT deptno FROM EMP;

SELECT * FROM EMP03;

--  *** delete 
-- 8. table 모든 데이터 삭제
SELECT * FROM EMP01;

DELETE FROM EMP01;

SELECT * FROM EMP01;

-- 9. 특정 row 삭제(where 조건식 기준)
-- emp01 에서 10번만 삭제
DELETE FROM EMP01
WHERE deptno = 10;

-- 10. ? emp01 table에서 comm 존재 자체가 없는(null) 사원 모두 삭제
SELECT * FROM EMP01;

DELETE FROM EMP01
WHERE comm IS NULL;

SELECT * FROM EMP01;

-- 11. ? emp01 table에서 comm이 null이 아닌 사원 모두 삭제
SELECT * FROM EMP01;

DELETE FROM EMP01
WHERE comm IS NOT NULL;

SELECT * FROM EMP01;

ROLLBACK;

-- 12. ? emp01 table에서 부서명이 RESEARCH 부서에 소속된 사원 삭제 
DELETE FROM EMP01
WHERE deptno = (SELECT deptno
								FROM DEPT
                WHERE dname = 'RESEARCH');
                
SELECT  * FROM EPM01;
  
-- 13. table 내용 삭제
-- insert/update/delete 문장에 한해서만 commit과 rollback 명령어 적용 가능

--  *** merge[병합]
-- 14. 병합을 위한 test table생성 및 데이터 insert
--  ex 판매 관련 table
drop table produce01;
drop table produce02;
drop table produce_total;

create table produce01(
	판매번호 varchar2(5), 
	제품번호 char(4),
	수량 number(3),
	금액 number(5)
);
create table produce02(
	판매번호 varchar2(5), 
	제품번호 char(4),
	수량 number(3),
	금액 number(5)
);
create table produce_total(
	판매번호 varchar2(5), 
	제품번호 char(4),
	수량 number(3),
	금액 number(5)
);
--  test용 데이터 insert
insert all
	into produce01 values('101', '1000', 1, 500)
	into produce01 values('102', '1001', 1, 400)
	into produce01 values('103', '1003', 1, 300)
	into produce02 values('201', '1004', 1, 500)
	into produce02 values('202', '1005', 1, 600)
	into produce02 values('203', '1006', 1, 700)
select * from dual;


--  merge 작업 : produce01과 produce_total 병합
--  문제 분석
SELECT * FROM produce01;
SELECT * FROM produce_total;

MERGE INTO produce_total t
USING produce01 p1
ON (t.판매번호 = p1.판매번호)
WHEN MATCHED THEN
	UPDATE SET t.수량 = t.수량 + p1.수량
WHEN NOT MATCHED THEN
	INSERT VALUES (p1.판매번호, p1.제품번호, p1.수량, p1.금액);

--  실행 결과 확인
-- ? produce02 table과 produce_total table 병합
SELECT * FROM produce_total;

MERGE INTO produce_total t
USING produce02 p2
ON (t.판매번호 = p2.판매번호)
WHEN MATCHED THEN
	UPDATE SET t.수량 = t.수량 + p2.수량
WHEN NOT MATCHED THEN
	INSERT VALUES (p2.판매번호, p2.제품번호, p2.수량, p2.금액);

SELECT * FROM produce_total;
