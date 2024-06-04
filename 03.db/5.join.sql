-- 5.join.sql

/*
1. 조인이란?
	다수의 table간에  공통된 데이터를 기준으로 검색하는 명령어
	다수의 table이란?
		동일한 table을 논리적으로 다수의 table로 간주
			- self join
		물리적으로 다른 table간의 조인

2. 사용 table 
	1. emp & dept 
	  : deptno 컬럼을 기준으로 연관되어 있음

	 2. emp & salgrade
	  : sal 컬럼을 기준으로 연관되어 있음
-- Database 옵션 - Reverse engineer - scott 선택하여 erd그리기

3. table에 별칭 사용 
	검색시 다중 table의 컬럼명이 다를 경우 table별칭 사용 불필요, 
	서로 다른 table간의 컬럼명이 중복된 경우,
	컬럼 구분을 위해 오라클 엔진에게 정확한 table 소속명을 알려줘야 함
	- table명 또는 table별칭
	- 주의사항 : 컬럼별칭 as[옵션], table별칭 as 사용 불가


4. 조인 종류 
	1. equi 조인
		 = 동등비교 연산자 사용
		 : 사용 빈도 가장 높음
		 : 테이블에서 같은 조건이 존재할 경우의 값 검색 

	2. not-equi 조인
		: 100% 일치하지 않고 특정 범위내의 데이터 조인시에 사용
		: between ~ and(비교 연산자)

	3. self 조인 
		: 동일 테이블 내에서 진행되는 조인
		: 동일 테이블 내에서 상이한 칼럼 참조
			emp의 empno[사번]과 mgr[사번] 관계

	4. outer 조인 
		: 두개 이상의 테이블이 조인될때 특정 데이터가 모든 테이블에 존재하지 않고 컬럼은 존재하나 null값을 보유한 경우
		  검색되지 않는 문제를 해결하기 위해 사용되는 조인
		  null 값이기 때문에 배제된 행을 결과에 포함 할 수 있으며 (+) 기호를 조인 조건에서 정보가 부족한 컬럼쪽에 적용
		
		: oracle DB의 sql인 경우 데이터가 null 쪽 table 에 + 기호 표기 
*/
	

-- 1. dept table의 구조 검색

-- dept, emp, salgrade table의 모든 데이터 검색

--*** 1. 동등 조인
-- = 동등 비교
-- 사원들의 이름, 사번, 부서위치 정보 검색 후 출력
SELECT ename, empno, dname
FROM EMP
INNER JOIN DEPT
ON EMP.deptno = DEPT.deptno;


SELECT ename, empno, dname
FROM EMP, DEPT
WHERE EMP.deptno = DEPT.deptno;

-- 주의1
-- ORA-00918: column ambiguously defined
SELECT ename, empno, dname
FROM EMP, DEPT
WHERE deptno = deptno;

SELECT ename, empno, dname, deptno
FROM EMP, DEPT
WHERE EMP.deptno = DEPT.deptno;

-- 주의2
-- 조건*
SELECT ename, empno, dname
FROM EMP, DEPT;

-- 2. SMITH 의 이름ename, 사번empno, 근무지역(부서위치)loc 정보를 검색
SELECT ename, empno, loc
FROM EMP e, DEPT d
WHERE ename = 'SMITH' AND e.deptno = d.deptno;

-- 3. deptno가 동일한 모든 데이터 검색
--emp & dept
SELECT *
FROM EMP e, DEPT d
WHERE e.deptno = d.deptno;

-- 4. 2+3 번 항목 결합해서 SMITH에 대한 모든 정보(ename, empno, sal, comm, deptno, loc) 검색하기
SELECT ename, empno, sal, comm, e.deptno, loc
FROM EMP e, DEPT d
WHERE ename = 'SMITH' AND e.deptno = d.deptno;

-- 5.  SMITH에 대한 이름(ename)과 부서번호(deptno), 부서명(dept의 dname) 검색하기
SELECT ename, e.deptno, dname
FROM EMP e, DEPT d
WHERE ename = 'SMITH' AND e.deptno = d.deptno;

-- 6. 뉴욕에 근무하는 사원의 이름과 급여를 검색 
-- loc='NEW YORK', ename, sal
SELECT ename, sal, loc
FROM EMP e, DEPT d
WHERE loc = 'NEW YORK' AND e.deptno = d.deptno;

-- 7. ACCOUNTING 부서(dname)에 소속된 사원의 이름과 입사일 검색
SELECT ename, hiredate
FROM EMP e, DEPT d
WHERE dname = 'ACCOUNTING' AND e.deptno = d.deptno;

-- 8. 직급이 MANAGER인 사원의 이름, 부서명 검색
SELECT ename, loc
FROM EMP e, DEPT d
WHERE job = 'MANAGER' AND e.deptno = d.deptno;

-- *** 2. not-equi 조인
-- salgrade table(급여 등급 관련 table)
-- 9. 사원의 급여가 몇등급인지 검색
-- between ~ and : 포함
SELECT ename, grade
FROM EMP e, SALGRADE s
WHERE sal BETWEEN losal AND hisal;

--? 등급이 3등급인 사원들의 이름과 급여 검색
SELECT ename, grade
FROM EMP e, SALGRADE s
WHERE grade = 3 AND  sal  BETWEEN losal AND hisal;

-- *** 3. self 조인
/*
emp 테이블을 마치 두개의 테이블인듯 연상
직원 : table -> e
매니저 : table -> m
*/

-- 11. SMITH 직원의 매니저 이름 검색
SELECT m.ename
FROM EMP e, EMP m
WHERE e.ename =  'SMITH' AND e.mgr = m.empno;

--? SMITH 직원의 메니저의 부서번호 검색
SELECT m.deptno
FROM EMP e, EMP m
WHERE e.ename = 'SMITH' AND e.mgr = m.empno;

-- 12. 매니저가 KING인 사원들의 이름과 직급 검색
SELECT e.ename, e.job, e.mgr, e.deptno
FROM EMP e, EMP m
WHERE m.ename = 'KING' AND m.empno = e.mgr;

--13. SMITH와 동일한 근무지에서 근무하는 사원의 이름 검색
-- SMITH 데이터 절대 검색 불가 - hint 부정 연산자
-- SMITH동일 근무지 - deptno로 검색
-- deptno가 일치되는 사원의 이름 -  ename
SELECT c.ename
FROM EMP s, EMP c
WHERE s.ename = 'SMITH' AND s.deptno = c.deptno AND c.ename != 'SMITH';

--*** 4. outer join 
-- 14. 모든 사원명, 메니저 명 검색, 단 메니저가 없는 사원도 검색되어야 함
SELECT e.ename, m.ename
FROM EMP e, EMP m
WHERE e.mgr(+) = m.empno;

-- 15. 모든 직원명, 부서번호, 부서명 검색
SELECT e.ename, d.deptno, d.dname
FROM EMP e, DEPT d
WHERE e.deptno (+) = d.deptno;

-- *** hr/hr 계정에서 test
--16. 직원의 이름(LAST_NAME)과 직책(job_title)을 출력(검색)
--	단, 사용되지 않는 직책이 있다면 그 직책이 정보도 검색에 포함
SELECT * 
FROM EMPLOYEES;

SELECT * 
FROM JOBS;

SELECT last_name, job_title
FROM EMPLOYEES e, JOBS j
WHERE e.job_id(+) = j.job_id;

SELECT distinct job_id
FROM EMPLOYEES;

SELECT distinct job_id
FROM JOBS;


--17. 직원들의 이름(first_name), 입사일, 부서명(department_name) 검색하기
-- 단, 부서가 없는 직원이 있다면 그 직원 정보도 검색에 포함
SELECT * 
FROM EMPLOYEES;

SELECT * 
FROM DEPARTMENTS;


SELECT first_name, hire_date, department_name
FROM EMPLOYEES e, DEPARTMENTS d
WHERE e.department_id = d.department_id(+);
