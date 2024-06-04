-- 9.integrity.sql
-- DB 강제 제약 설정

/* dept : emp
1. 공통컬럼 : deptno
2. 어떤 table의 deptno가 종속적인지?
	- 제시하는 table : 
	- 사용하는 table :
3. 제약 사항
	1. dept의 deptno값은 중복 불허, 반드시 값이 있어야만 함
		- 중복 불허 : 
		- 반드시 값이 있어야 함 : 
		- primary key(기본키), pk : 
		
	2. emp의 deptno는 반드시 dept의 deptno에서 제시한 데이터에 한해서만 사용 가능
		- deptno : 종속 참조(foreign key(외래키), fk)
		
4. 제약조건 선언 위치
	4-1. 컬럼 레벨 단위
		- 컬럼선언 라인에 제약조건 설정 

	4-2. 테이블 레벨 단위 
		- 모든 컬럼 선언 직후 별도로 제약조건 설정
        
	- 참고 : table 복제시 제약조건은 반영 x, 차후에 명시적으로 추가 설정
			
5. 오라클 table
	5-1. user_constraints
		- 제약조건 정보 보유 table
		- 개발자가 table의 데이터값 직접 수정 불가
		- select constraint_name, constraint_type, table_name 
			from user_constraints;

6. 이미 존재하는 table의 제약조건 수정(추가, 삭제)명령어
	6-1. 제약조건 추가
		alter table 테이블명 add constraint 제약조건명 제약조건(컬럼명);
	
	6-2. 제약조건 삭제(drop)
		- table삭제 
		alter table 테이블명 cascade constraint;
		
	6-3. 제약조건 임시 비활성화
		alter table 테이블명 disable constraint;
		
	6-4. 제약조건 활성화
		alter table 테이블명 enable constraint;
*/

-- 1. 오라클 db에 설정한 table의 제약조건 정보를 보유하고 있는
-- 오라클 :  user_constraints 
SELECT *
FROM  user_constraints;

/* constraint_type : 제약조건 정보 컬럼
	P : 기본키, Primary key, 주키
	R : 참조 or 관계 (reference or relation), 외래키
*/

-- 2. 제약 조건 명시
DROP TABLE EMP02;

CREATE TABLE EMP02(
	empno NUMBER(4) CONSTRAINT emp02_empno_nn NOT NULL,
	ename VARCHAR(10)
);

-- 3. 확인
-- 에러 : ORA-01400: cannot insert NULL into ("SCOTT"."EMP02"."EMPNO")
INSERT INTO EMP02 (ename) VALUES ('multi');

-- 4. 오라클 엔진이 제약조건명 자동 지정
DROP TABLE EMP02;

CREATE TABLE EMP02(
	empno NUMBER(4) UNIQUE,
	ename VARCHAR(10)
);

SELECT * 
FROM user_constraints;

-- SYS_C007042

INSERT INTO EMP02 VALUES (1, 'multi');
INSERT INTO EMP02 VALUES (1, 'multi');

-- 
DELETE FROM user_constraints
WHERE CONSTRAINT_TYPE = 'C';

SELECT * 
FROM user_constraints;

-- 5. pk설정 : 선언 위치에 따른 구분 학습
-- 컬럼 레벨
DROP TABLE EMP02;

CREATE TABLE EMP02(
	empno NUMBER(4) CONSTRAINT emp02_pk PRIMARY KEY,
	ename VARCHAR(10)
);

-- table 레벨
DROP TABLE EMP02;

CREATE TABLE EMP02(
	empno NUMBER(4),
	ename VARCHAR(10)
);

ALTER TABLE EMP02
ADD CONSTRAINT emp02_pk PRIMARY KEY (empno);

-- 6. 외래키[참조키]
-- 컬럼 레벨  
DROP TABLE EMP02;

CREATE TABLE EMP02(
	empno NUMBER(4) PRIMARY KEY,
	ename VARCHAR(10) NOT NULL,
  deptno NUMBER(4) CONSTRAINT emp02_deptno_fk REFERENCES DEPT(deptno)
);

INSERT INTO EMP02 VALUES (9999, 'DEV', 10);

SELECT * 
FROM EMP02;

-- 에러 : ORA-02291: integrity constraint (SCOTT.EMP02_DEPTNO_FK) violated - parent key not found
INSERT INTO EMP02 VALUES (8888, 'IT', 50);

 -- table 레벨
ALTER TABLE EMP02
ADD FOREIGN KEY (deptno) REFERENCES DEPT(deptno);

-- 7. 6번의 내용을 table 레벨 단위로 설정해 보기
DROP TABLE EMP02;

CREATE TABLE EMP02(
  empno NUMBER(4) PRIMARY KEY,
  ename VARCHAR(10) NOT NULL,
  deptno NUMBER(4), 
  CONSTRAINT emp02_deptno_fk FOREIGN KEY (deptno) REFERENCES DEPT(deptno)
);

-- 8. emp01과 dept01 table 생성
/* as 로 기존 table 복제할 경우엔 제약조건은 반영되지 않음
따라서 alter 명령어로 추가 적용 필수*/
drop table dept01;
drop table emp01;
create table dept01 as select * from dept;
create table emp01 as select * from emp;

-- 9. 존재하는 table에 제약조건 추가
-- dept01 : 주(부모), emp01 : 종(자식)
SELECT *
FROM user_constraints
WHERE table_name = 'DEPT01';

ALTER TABLE DEPT01
ADD CONSTRAINT dept01_pk PRIMARY KEY (deptno);

SELECT *
FROM user_constraints
WHERE table_name = 'DEPT01';

SELECT *
FROM user_constraints
WHERE table_name = 'DEPT01';

ALTER TABLE EMP01
ADD CONSTRAINT emp01_pk PRIMARY KEY (empno);

ALTER TABLE EMP01
ADD CONSTRAINT emp01_deptno_fk FOREIGN KEY (deptno) REFERENCES DEPT01(deptno);

SELECT *
FROM user_constraints
WHERE table_name = 'EMP01';

-- 10. 
-- emp01이 이미 참조하는 데이터가 있는 dept01 table 삭제해보기 
-- ORA-02449: unique/primary keys in table referenced by foreign keys
DROP TABLE DEPT01;

-- ORA-02292: integrity constraint (SCOTT.EMP01_DEPTNO_FK) violated - child record found
DELETE FROM DEPT01
WHERE deptno = 10;

-- 11.참조되는 컬럼 데이터라 하더라도 삭제 가능한 명령어
DROP TABLE DEPT01 CASCADE CONSTRAINT;

SELECT * 
FROM EMP01;

SELECT * 
FROM DEPT01;


drop table dept01;
drop table emp01;
create table dept01 as select * from dept;
create table emp01 as select * from emp;

ALTER TABLE DEPT01
ADD CONSTRAINT dept01_pk PRIMARY KEY (deptno);

ALTER TABLE EMP01
ADD CONSTRAINT emp01_pk PRIMARY KEY (empno);

ALTER TABLE EMP01
ADD CONSTRAINT emp01_deptno_fk FOREIGN KEY (deptno) REFERENCES DEPT01(deptno) ON DELETE CASCADE;

DELETE FROM DEPT01
WHERE deptno = 10;

SELECT * 
FROM DEPT01;

SELECT * 
FROM EMP01;

-- 12. check : 데이터의 유효 유무 검증 제약조건 
-- age값이 1~100까지만 DB에 저장
DROP TABLE EMP01;

CREATE TABLE EMP01(
	ename VARCHAR2(10),
  age NUMBER(3) CONSTRAINT emp01_age_ck CHECK(age BETWEEN 1 AND 200)
);

-- 에러 : ORA-02290: check constraint (SCOTT.EMP01_AGE_CK) violated
INSERT INTO EMP01 VALUES ('IT', 201);

-- 13.? gender라는 컬럼에는 데이터가 M 또는 F만 저장되어야 함
DROP TABLE EMP01;

CREATE TABLE EMP01(
	ename VARCHAR2(10),
  gender char(1) CONSTRAINT emp01_gender_ck CHECK(gender IN('M', 'F'))
);

-- 에러 : ORA-02290: check constraint (SCOTT.EMP01_GENDER_CK) violated
INSERT INTO EMP01 VALUES ('IT', 'T');

-- 14. default : insert시에 데이터를 생략해도 자동으로 db에 저장되는 기본값 
DROP TABLE EMP01;

CREATE TABLE EMP01(
	ename VARCHAR2(10),
  grade CHAR(1) DEFAULT 'S'
);

INSERT INTO EMP01 VALUES ('DEV', 'M');

SELECT * 
FROM EMP01;

INSERT INTO EMP01(ename) VALUES ('IT');
INSERT INTO EMP01(ename) VALUES ('IT2');
INSERT INTO EMP01(ename) VALUES ('IT3');
INSERT INTO EMP01(ename) VALUES ('IT4');

SELECT * 
FROM EMP01;
