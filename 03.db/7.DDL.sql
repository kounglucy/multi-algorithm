-- 7.DDL.sql
-- table 생성(create)과 삭제(drop), table 구조 수정(alter)

-- DDL(Data Definition Language)
/*  CRUD
	- C : create, 데이터 생성
		- 이미 존재 하는 table에 데이터를 새롭게 저장, insert
	- R : read, 존재하는 데이터 검색
		- select
	- U : update, 존재하는 데이터 수정
		- update
	- D : delete, 존재하는 데이터 삭제
		- delete  
*/

-- Oracle Data Type : 자바 타입   = varchar2,char : String
-- 	            			     = number(전체자리수[, 소수점이하자리]) : 정수, 실수
-- 			            	     = date : java.util.Date, java.sql.Date, String
/* 참고 : 
	문자열 표현하는 타입
	- varchar2[최대 메모리] : char[고정사이즈메모리] 
  * varchar2
	- 범위 설정없이 선언시 자동 점유 사이즈

  * number 
	- 자릿수 제한없이 선언시 자리 자동 설정 

 [1] table 생성 명령어
    create table table명(
		컬럼명1 컬럼타입[(사이즈)] [제약조건] ,
		컬럼명2....
    ); 

[2] table 삭제 명령어
	drop table table명;

[3] table 구조 수정 명령어
    alter table table명 변경명령어;
*/

-- table 삭제
-- 1. table삭제 

-- 2. table 생성  
-- name(varchar2), age(number) 컬럼 보유한 people table 생성

-- 3. 서브 쿼리 활용해서 emp01 table 생성(이미 존재하는 table기반으로 생성)
-- emp table의 모든 데이터로 emp01 생성

-- data 복제 없이 table구조만 복제

-- 4. 서브쿼리 활용해서 특정 컬럼(empno)만으로 emp02 table 생성

-- 5. ? deptno=10 조건문 반영해서 empno, ename, deptno로 emp03 table 생성

-- 6. ?데이터 insert없이 table 구조로만 새로운 emp04 table생성시 

-- *** alter
/* 데이터 구조 변경
1. 미존재하는 컬럼 추가
2. 존재하는 컬럼 삭제
3. 존재하는 컬럼의 타입(사이즈) 변경
	경우의 수 1 : 기존 사이즈보다 작게 수정
		- 이미 데이터가 존재할 경우
			데이터가 변경하고자 하는 사이즈보다 작다
			데이터가 변경하고자 하는 사이즈보다 크다
		- 데이터가 없을 수도 있음
			
	경우의 수 2 : 기존 사이즈보다 크게 수정
		- 이미 데이터가 존재할 경우
			데이터가 변경하고자 하는 사이즈보다 작다
			데이터가 변경하고자 하는 사이즈보다 크다
		- 데이터가 없을 수도 있음
		
	경우의 수 3 : 타입 자체를 수정 ..
*/
	
-- emp01 table로 실습해 보기

-- 7. emp01 table에 job이라는 특정 컬럼 추가(job varchar2(10))
-- 이미 데이터를 보유한 table에 새로운 job컬럼 추가 가능 
-- add() : 컬럼 추가 함수

-- 8. 이미 존재하는 컬럼 사이즈 변경
-- 데이터 미 존재 컬럼의 사이즈 수정
-- modify / change column

-- job컬럼 데이터의 최고 사이즈 확인

-- 데이터 사이즈보다 작게 수정

-- 10. job 컬럼 삭제 
-- 데이터 존재시에도 자동 삭제 

-- 11. emp01을 test01로 table 이름 변경

-- 12. table의 순수 데이터만 완벽하게 삭제
