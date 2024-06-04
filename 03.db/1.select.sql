-- 1.select
/*
1.기본 검색
1-1.단순 검색
	select절 속성명[ , ..]
	from절 table명;
	- 실행 순서 : from 절 -> select 절

1-2.정렬 포함 검색
	select절
	from절
	order by절
	- 실행 순서 : from절 -> select절 -> order by절
	
1-3.조건식 포함 검색
	selec3t절
	from절
	where절
	- 실행 순서 : from절 -> where절-> select절
	
1-4.조건식과 정렬 포함 검색
	select절
	from절
	where절
	order by절
	- 실행 순서 : from절 -> where절 -> select절 -> order by절

2. 환경구축
2-1. Oracle DB 설치
	OracleXE112_Win64.zip 압축해제
	OracleXE112_Win64\DISK1\setup.exe 실행
	Next -> I accept ... -> Next -> Next -> 경로확인 C:\
	-> manager -> Next -> Install -> Finish

2-2. 설치 확인 
	SQL Command Line
	CONNECT SYSTEM
	SHOW USER
	SELECT * FROM TAB;

	USER 세팅(SCOTT)
		@C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin\scott.sql
		SHOW USER
		alter user SCOTT identified by TIGER;
		CONNECT SCOTT/TIGER
		SHOW USER
		SELECT * FROM TAB;
*/

-- 1.cmd 창 조절


-- 2.계정 모든 table 검색


-- 3.emp table의 모든 정보 검색


-- 4.emp table의 구조 보기
/* 
[data type]
/*
1. VARCHAR2(10)
    - 가변적인 문자열 타입
    - 영어는 1btye, 한글은 2byte
    - 자바 - String
    
2. NUMBER(2)
    - 정수 최대 2자리
    
3. NUMBER(4,2)
    - 소수점 이하 두자리 포함해서 전체 자리수가 4자리인 수

4. DATE
    - 날짜를 표현하는 타입
*/

/*
[field]
empno : 사원번호
ename : 사원이름, 사원명
job : 업무
mgr : 사원을 관리하는 매니저 번호
hiredate : 입사일
sal : 급여
comm : 커미션, 보너스
deptno : 부서 번호
*/

-- 5.emp table의 사번(empno)과 이름(ename) 검색
SELECT empno, ename
FROM EMP;

-- 6.emp table의 입사일(hiredate) 검색
SELECT hiredate
FROM EMP;

-- 7.emp table의 검색(empno -> 사번 별칭 부여)
SELECT empno AS 사번, ename 사원명
FROM EMP;

-- 8.emp table에서 부서번호 검색시 중복 데이터 제거 후 검색
SELECT empno, deptno
FROM EMP;

SELECT empno, DISTINCT deptno
FROM EMP;

SELECT DISTINCT empno, deptno
FROM EMP;

-- 순서 : order
-- 9.데이터를 오름차순(asc)으로 검색(정렬)
SELECT ename
FROM EMP
ORDER BY ename ASC;

SELECT ename
FROM EMP
ORDER BY ename DESC;

-- ?사고력
-- order by 절이 정말 가장 마지막에 실행되는 걸까?
SELECT empno AS 사번
FROM EMP
ORDER BY 사번 ASC;

-- ?사번을 오름차순으로 정렬해서 사번만 검색
SELECT empno
FROM EMP
ORDER BY empno ASC;

-- 10.emp table에서 deptno 내림차순 정렬 적용하여 ename과 deptno 검색
SELECT ename, deptno
FROM EMP
ORDER BY deptno DESC;

SELECT ename, deptno
FROM EMP
ORDER BY ename DESC, deptno DESC;

-- ?empno와 deptno 검색(단, deptno는 오름차순)
SELECT empno, deptno
FROM EMP
ORDER BY empno ASC, deptno ASC;

SELECT empno, deptno
FROM EMP
ORDER BY deptno ASC, empno ASC;


-- 11. 입사일(date 타입의 hiredate) 검색
SELECT ename, hiredate
FROM EMP
ORDER BY hiredate ASC;

-- 연산
-- 12. emp table의 모든 직원명(ename), 월급여(sal), 연봉(comm 제외) 검색
-- 단 sal 컴럼값은 comm을 제외한 sal만으로 연봉 검색
SELECT ename, sal, sal * 12 AS YEARSAL
FROM EMP;

-- 13.comm 포함 연봉 검색(년 급여 + comm) 검색
-- NULL 값을 포함한 연산 -> NULL
-- NVL(컬럼명, 대체값)

SELECT ename, sal, (sal * 12 + comm) AS YEARSAL
FROM EMP;

SELECT ename, sal, comm
FROM EMP;

-- NVL 활용하여 comm 포함 연봉 계산
SELECT ename, sal, (sal * 12 + NVL(comm,0)) AS YEARSAL
FROM EMP;

-- 조건식 : where
-- 14.comm이 null인 사원 검색(ename, comm)
SELECT ename, comm
FROM EMP
WHERE comm IS NULL;

SELECT ename, comm
FROM EMP
WHERE comm = NULL;

SELECT ename, comm
FROM EMP
WHERE NVL(comm, -9999) = -9999;	

-- 15.comm이 null이 아닌 사원 검색(ename, comm)
SELECT ename, comm
FROM EMP
WHERE comm IS NOT NULL;


-- 16.?ename, 전체연봉(comm제외), 전체연봉(comm포함) 검색


-- 17.emp table에서 deptno 값이 20인 직원 모든 정보 출력
SELECT *
FROM EMP
WHERE deptno = 20;

-- ?검색 결과 sal 내림차순으로 정렬검색
SELECT *
FROM EMP
WHERE deptno = 20
ORDER BY sal DESC;

-- 18.?emp table에서 ename이 smith(SMITH)에 해당하는 deptno값은?
SELECT deptno
FROM EMP
WHERE ename = 'SMITH';


-- 19.sal가 900이상(>=)인 직원들의 이름(ename), sal 검색
SELECT ename, sal
FROM EMP
WHERE sal >= 900;


-- 20.deptno가 10이고(and) job이 매니저(MANAGER)인 사원이름 검색 
SELECT ename
FROM EMP
WHERE deptno = 10 AND job = 'MANAGER';


-- 21.?deptno가 10이거나 job이 매니저(MANAGER)인 사원이름(ename) 검색
-- or 연산자
SELECT ename
FROM EMP
WHERE deptno = 10 OR job = 'MANAGER';

-- 22. deptno가 10이 아닌 모든 사원명(ename) 검색
-- 아니다 : not, !=, <>
SELECT ename, deptno
FROM EMP
WHERE deptno != 10;

SELECT ename, deptno
FROM EMP
WHERE deptno <> 10;

SELECT ename, deptno
FROM EMP
WHERE NOT deptno = 10;

-- 23.sal이 2000 이하(sal<=2000)이거나 3000 이상인(sal>=3000) 사원명(ename) 검색
SELECT ename, sal
FROM EMP
WHERE sal <= 2000 OR sal >= 3000;

-- 24.comm이 300 or 500 or 1400인 사원명, comm 검색
SELECT ename, comm
FROM EMP
WHERE comm = 300 OR comm = 500 OR comm = 1400;

-- IN 연산자
SELECT ename, comm
FROM EMP
WHERE comm IN (300, 500, 1400);

-- 25.?comm이 300 or 500 or 1400이 아닌(not) 사원명, comm 검색
SELECT ename, comm
FROM EMP
WHERE comm NOT IN (300, 500, 1400);

-- 26.81년도에 입사한 사원 이름 검색
-- hiredate
SELECT ename, hiredate 
FROM emp;

SELECT ename, hiredate 
FROM emp
WHERE hiredate >= '81/1/1' and hiredate <= '81/12/31';

-- 컬럼명 BETWEEN ~ AND 
SELECT ename, hiredate 
FROM emp
WHERE hiredate BETWEEN '81/1/1' AND '81/12/31';

-- 27.ename이 M으로 시작되는 모든 사원번호(empno), 이름(ename) 검색  
-- LIKE : 음절단위로 자리수 표기 // _ : 한 음절, % : 음절개수 무관
SELECT empno, ename
FROM EMP
WHERE ename LIKE 'M%';

-- 28.ename이 M으로 시작되는 전체 자리수가 두음절의 사원번호, 이름 검색
ELECT empno, ename
FROM EMP
WHERE ename LIKE 'M_';

-- 29.두번째 음절의 단어가 M인 모든 사원명 검색 
SELECT empno, ename
FROM EMP
WHERE ename LIKE '_M%';

-- 30.단어가 M을 포함한 모든 사원명 검색 
SELECT empno, ename AS "M이 포함되는 사람이름"
FROM EMP
WHERE ename LIKE '%M%';
