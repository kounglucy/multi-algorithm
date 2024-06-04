-- 4.selectGroupFunction.sql
-- 그룹함수란? 다수의 행 데이터를 한번에 처리
-- 장점 : 함수 연산시 null 데이터를 함수 내부적으로 사전에 고려해서 
-- null값 보유한 field는 함수 로직 연산시 제외, sql 문장 작업 용이
/*
1. count() : 개수 확인 함수
2. sum() : 합계 함수
3. avg() : 평균
4. max(), min() : 최대값, 최소값
*/


/* 기본 문법
1. select절
2. from 절
3. where절

 * 그룹함수시 사용되는 문법
1. select절 : 검색하고자 하는 속성
2. from절	: 검색 table
3. group by 절 : 특정 조건별 그룹화하고자 하는 속성
4. having 절 : 그룹함수 사용시 조건절
5. order by절 : 검색된 데이터를 정렬

* 실행 순서 : 2 -> 3 -> 4 -> 1 -> 5
*/

-- 1. count() : 개수 확인 함수
--  emp table의 직원이 몇명?
SELECT COUNT(empno)
FROM EMP;

SELECT COUNT(*)
FROM EMP;

-- ? comm 받는 직원 수만 검색 
SELECT COUNT(comm)
FROM EMP;

-- 2. sum() : 합계 함수
--  ? 모든 사원의 월급여(sal)의 합
SELECT SUM(sal)
FROM EMP;

-- ? 모든 직원이 받는 comm 합
SELECT SUM(COMM)
FROM EMP;

-- ?  MANAGER인 직원들의  월급여의 합 
SELECT SUM(SAL)
FROM EMP 
WHERE job = 'MANAGER';

-- ? job 종류 counting[절대 중복 불가 = distinct]
--  데이터 job 확인
SELECT  COUNT(DISTINCT JOB )
FROM EMP;  

-- 3. avg() : 평균
-- ? emp table의 모든 직원들의 급여 평균 검색
SELECT avg (sal)
FROM EMP;

-- ? 커미션 받는 사원수, 총 커미션 합, 평균 구하기
SELECT COUNT( comm),   SUM(comm), AVG(comm)
FROM EMP;

-- 4. max(), min() : 최대값, 최소값
--  숫자, date 타입에 사용 가능
-- 최대 급여, 최소 급여 검색
SELECT MAX (sal), MIN(sal)
FROM EMP;

-- ?최근 입사한 사원의 입사일과, 가장 오래된 사원의 입사일 검색
--  오라클의 date 즉 날짜를 의미하는 타입도 연산 가능
--  max(), min() 함수 사용해 보기
SELECT MAX(hiredate), MIN(hiredate)
FROM EMP;

-- max, min 값을 갖는 사람이 오늘로 부터 몇일(일수) 일했는가?
SELECT MIN(SYSDATE - hiredate), MAX(SYSDATE - hiredate)
FROM EMP;

-- *** group by
/* 
group by절
- 특정 컬럼값을 기준으로 그룹화
  10번 부서끼리, 20번 부서끼리..
*/

--  부서별 커미션 받는 사원수 
SELECT *
FROM DEPT;

SELECT COUNT(comm)
FROM EMP 
WHERE   deptno = 40;

--  step01 : 기본
SELECT deptno, COUNT(comm)
FROM EMP
GROUP BY deptno;

--  step02 : 정렬
SELECT deptno, COUNT(comm)
FROM EMP
GROUP BY deptno
ORDER BY deptno ASC;

--  step03 : 주의할점!
SELECT ename, deptno, COUNT(comm)
FROM EMP
GROUP BY deptno
ORDER BY deptno ASC;

-- ? 부서별(group by deptno) (월급여) 평균 구함(avg())]
SELECT depno, AVG(sal)
FROM EMP
GROUP BY  deptno;

-- ? 소속 부서별 급여 총액과 평균 급여 검색[deptno 오름차순 정렬]
SELECT depno, SUM(sal), AVG(sal)
FROM EMP
GROUP BY deptno
ORDER BY deptno ASC;

-- ? 부서별 최대 급여, 최소 급여 검색
SELECT deptno, MAX(sal), MIN(sal)
FROM EMP 
GROUP BY deptno;

--  *** having
--  그룹함수 사용시 조건문

-- 1. ? 부서별(group by) 사원의 수(count(*))와 커미션(count(comm)) 받는 사원의 수
SELECT deptno, COUNT(*), COUNT(comm)
FROM EMP

--  조건 추가
-- 2. ? 부서별 그룹을 지은후(group by deptno), 
--  부서별 평균 급여(avg())가 2000 이상인 부서의 번호와 평균 급여 검색 
SELECT deptno, AVG(sal)
FROM EMP
GROUP BY deptno;

--  step01 : 기본 
SELECT deptno, AVG(sal)
FROM EMP
GROUP BY deptno
HAVING AVG(sal) >= 2000;

--  step02 :  정렬 
SELECT deptno, AVG(sal)
FROM EMP
GROUP BY deptno
HAVING AVG(sal) >= 2000
ORDER BY deptno ASC;

--  step03 : avg(sal) 평균급여라는 별칭 부여, 평균 급여로 정렬
SELECT deptno, AVG(sal) AS 평균급여
FROM EMP
GROUP BY deptno
HAVING AVG(sal) >= 2000
ORDER BY 평균급여 ASC;

--  step04 : 눈으로만 생각하고 표현해 보기
/*
select deptno, avg(sal) 평균급여
from emp
group by deptno
having 평균급여 >= 2000
order by 평균급여 asc; 
*/

SELECT deptno, AVG(sal) AS 평균급여
FROM EMP
WHERE sal > 1000
GROUP BY deptno
HAVING AVG(sal) >= 2000
ORDER BY 평균급여 ASC;

-- 3. 부서별 급여중 최대값(max)과 최소값(min)을 구하되 최대 급여가 2900이상(having)인 부서만 출력
SELECT deptno, MAX(sal), MIN(sal)
FROM EMP
GROUP BY deptno
HAVING max(sal) >= 2900;

-- 그렇다면 최종적으로 6절의 순서는?
************************************
1 FROM 
2 WEHRE
3 GROUP BY
4 HAVING
5 SELECT
6 ORDER BY

-- 다중 그룹
SELECT deptno, SUM(sal)
FROM EMP
GROUP BY deptno;

   DEPTNO   SUM(SAL)
---------- ----------
        30       9400
        20       6775
        10       8750

-- 각 그룹의 직업별 SUM(sal)
SELECT deptno, job, SUM(sal)
FROM EMP
GROUP BY deptno, job
ORDER BY deptno ASC;

    DEPTNO   SUM(SAL)
---------- ----------
        20        800
        30       5600
        20       2975
        30        950
        10       5000
        30       2850
        10       1300
        10       2450
        20       3000

--  rollup : 중간 합계
SELECT SUM(sal)
FROM EMP
GROUP BY ROLLUP(deptno);

SELECT SUM(sal)
FROM EMP;

--  전체 급여 합만 출력
SELECT deptno, job, SUM(sal)
FROM EMP
GROUP BY ROLLUP(deptno, job);

--  부서별 급여 합만 출력
SELECT deptno, job, SUM(sal)
FROM EMP
GROUP BY deptno, ROLLUP(job);

--  GROUP BY ROLLUP(A, B, C)
SELECT deptno, job, ename, SUM(sal)
FROM EMP
GROUP BY ROLLUP(deptno, job, ename);


--  GROUP BY ROLLUP(A, (B, C))
SELECT deptno, job, ename, SUM(sal)
FROM EMP

--  GROUP BY A, ROLLUP((B, C))
SELECT deptno, job, ename, SUM(sal)
FROM EMP
GROUP BY deptno, ROLLUP((job, ename));

--  ?
/*
10	MANAGER		2450
10	PRESIDENT	5000
10	합계			8750
10	평균			2917
20	CLERK		800
20	ANALYST		3000
20	MANAGER		2975
20	합계			6775
20	평균			2258
30	CLERK		950
30	MANAGER		2850
30	SALESMAN	5600
30	합계			9400
30	평균			1567
전체	합계			24925
전체	평균			2077
*/

--  GROUPING

--  GROUPING_ID

--  숫자 GROUP

--  GROUPING, GROUPING_ID, 숫자 GROUP 종합
