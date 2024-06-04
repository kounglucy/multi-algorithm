-- 10.view.sql
/*
emp table 에서 comm 존재자체를 다른 직군들에게 모르게 해야 할 경우
table의 데이터를 어떻게 활용 가능하게 할 것인가?
- 실제 존재 하는 table 기반으로 가상의 논리적인 table

* view 사용을 위한 필수 선행 설정
	1단계 : admin 계정으로 접속
	2단계 : view 생성해도 되는 사용자 계정에게 생성 권한 부여
		>connect system/manager
		>grant create view to SCOTT;
		>conn SCOTT/TIGER

1. view 에 대한 학습
	- 물리적으로는 미존재, 단 논리적으로 존재

2. 개념
	- 보안을 고려해야 하는 table의 특정 컬럼값 은닉
	또는 여러개의 table의 조인된 데이터를 다수 활용을 해야 할 경우
	특정 컬럼 은닉, 다수 table 조인된 결과의 새로운 테이블 자체를 
	가상으로 db내에 생성시킬수 있는 기법 

3. 문법
	- create와 drop : create view/drop view
	- crud는 table과 동일

4. view 기반으로 crud 반영시 실제 원본 table에도 반영된다.

5. 종류
	5-1. 단일 view : 별도의 조인 없이 하나의 table로 부터 파생된 view
	5-2. 복합 view : 다수의 table에 조인 작업의 결과값을 보유하는 view
	5-3. 인라인 view : sql의 from 절에 view 문장  

*/
-- 1. test table생성
DROP TABLE DEPT01 CASCADE CONSTRAINT;

CREATE TABLE DEPT01 AS SELECT * FROM DEPT;

-- 2. dept01 table상의 view를 생성
-- SCOTT 계정으로 view 생성 권한 받은 직후에만 가능
CREATE VIEW DEPT01_V AS SELECT * FROM DEPT01;

DESC DEPT01_V;

SELECT *
FROM DEPT01_V;

DROP VIEW DEPT01_V;

-- 3. ? emp table에서 comm을 제외(empno, ename, sal)한 emp01_v 라는 view 생성
DROP VIEW EMP01_V;

CREATE VIEW EMP01_V AS SELECT empno,ename,sal FROM EMP;

SELECT * 
FROM EMP01_V;

-- 4. dept01_v에 crud : dep01_v와 dept01 table 변화 동시 검색
CREATE VIEW DEPT01_V AS SELECT * FROM DEPT01;

SELECT * 
FROM DEPT01_V;

INSERT INTO DEPT01_V VALUES(50, 'DEV', 'R.O.K');

SELECT * 
FROM DEPT01_V;

SELECT * 
FROM DEPT01;

-- 
DELETE FROM DEPT01_V
WHERE deptno = 50;

SELECT * 
FROM DEPT01_V;

SELECT * 
FROM DEPT01;

-- 5. 모든 end user가 빈번히 사용하는 sql문장으로 
-- 해당 직원의 모든 정보 검색(empno, ename, deptno, loc)하기
SELECT * FROM DEPT01;
SELECT * FROM EMP01;

CREATE VIEW EMP01_DEPT01_V AS
SELECT empno, ename, e.deptno, loc
FROM EMP01 e, DEPT01 d
WHERE e.deptno = d.deptno;

SELECT * 
FROM EMP01_DEPT01_V;

-- 6. 논리적인 가상의 table이 어떤 구조로 되어 있는지 확인 가능한 oracle  자체 table
SELECT * 
FROM user_views;

/*
view_name         text_length   text
EMP01_DEPT01_V	    83	        "SELECT empno, ename, e.deptno, loc FROM EMP01 e, DEPT01 d WHERE e.deptno = d.deptno" 
EMP01               33	        SELECT empno, ename, sal FROM EMP
DEPT01_V	        41	        SELECT "DEPTNO","DNAME","LOC" FROM DEPT01
*/