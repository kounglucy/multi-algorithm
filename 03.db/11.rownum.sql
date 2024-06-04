-- 11.rownum.sql
-- oracle 자체적으로 제공하는 컬럼
-- table당 자동 생성 객체
-- 검색시 검색된 데이터 순서대로 rownum값 자동 반영(1부터 시작)
SELECT rownum, empno
FROM emp;
/*
rownum
1			7369
2			7499
3			7521
4			7566
5			7654
6			7698
7			7782
8			7839
9			7844
10		    7900
11		    7902
12		    7934
*/

-- ? dept의 deptno를 내림차순(desc)으로 검색, rownum
SELECT rownum, deptno
FROM DEPT
ORDER BY deptno DESC;

--? deptno의 값이 오름차순으로 정렬해서 30번 까지만 검색, rownum 포함해서 검색
SELECT rownum, deptno
FROM DEPT
WHERE deptno <= 30
ORDER BY deptno ASC;

SELECT rownum, deptno
FROM DEPT
WHERE rownum <= 3
ORDER BY deptno ASC;

-emp table
--? deptno의 값을 오름차순으로 정렬해서 상위 3개의 데이터만 검색, rownum, ename 포함해서 검색
/* 
1	10	CLARK
2	10	MILLER
3	10	KING
*/

SELECT rownum, deptno, ename 
FROM EMP 
ORDER BY deptno ASC;

/*
8	10	KING
7	10	CLARK
12	10	MILLER
11	20	FORD
1	20	SMITH
4	20	JONES
10	30	JAMES
9	30	TURNER
5	30	MARTIN
3	30	WARD
2	30	ALLEN
6	30	BLAKE
*/

SELECT rownum, deptno, ename
FROM (SELECT rownum, deptno, ename 
        FROM EMP 
        ORDER BY deptno ASC)
WHERE rownum < 4;

-- ?
SELECT rownum, deptno, ename, empno, sal
FROM (SELECT * 
        FROM EMP 
        ORDER BY deptno ASC);
-- ?
SELECT rownum, deptno, ename, empno, sal
FROM (SELECT * 
        FROM EMP 
        ORDER BY deptno ASC)
WHERE rownum < 4;


SELECT rownum, empno, ename, job, hiredate, sal, deptno 
        FROM EMP 
        ORDER BY deptno ASC;

-- 해결책 : 인라인 뷰
-- 검색한 결과의 순번을 순차적으로 적용 후 재정렬 
-- 인라인 view : sql의 from 절에 view 문장

	
-- ?1. emp  table의 입사일이 신입(내림)부터 5명의 사원만 검색 
-- 힌트 rownum 컬럼, view 도 사용해서 활용 
-- 인라인 뷰 형식의 쿼리문
/*
1	MILLER	82/01/23
2	JAMES	81/12/03
3	FORD	81/12/03
4	KING	81/11/17
5	MARTIN	81/09/28
*/

SELECT rownum, ename, hiredate
FROM (SELECT ename, hiredate
        FROM EMP
        ORDER BY hiredate DESC)
WHERE rownum < 6;
-- ?2. 인라인 뷰를 사용하여 급여를 많이 받는 순서대로 3명만 이름과 급여 검색 
/*
KING	5000
FORD	3000
JONES	2975
*/

SELECT ename, sal
FROM (SELECT ename, sal
			FROM EMP
      ORDER BY SAL DESC)
WHERE rownum < 4;