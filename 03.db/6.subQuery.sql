-- 6.subQuery.sql
-- select문 내에 포함된 또 다른 select문 작성 방법
-- 참고 : join 또는 subquery로 동일한 결과값 검색

-- 문법 : 비교 연산자(대소비교, 동등비교) 오른쪽에 () 안에 select문 작성 
-- 	   : create 및 insert 에도 사용 가능
-- 	   : test 위해서 원본이 아닌 복사본 table활용 권장 
-- 실행순서 : sub query가 main 쿼리 이전에 실행
SELECT deptno 
FROM EMP e
WHERE ename = 'SMITH';

SELECT dname 
FROM DEPT d
WHERE deptno = 20;

-- 1. SMITH라는 직원 부서명 검색
SELECT dname
FROM EMP e, DEPT d
WHERE ename = 'SMITH' AND e.deptno = d.deptno;

-- 서브쿼리
SELECT dname 
FROM DEPT d
WHERE deptno = (SELECT deptno 
                FROM EMP e
                WHERE ename = 'SMITH');

-- 2. SMITH와 동일한 직급(job)을 가진 사원들 검색(SMITH 포함)
SELECT c.ename
FROM EMP e, EMP c
WHERE e.ename = 'SMITH' AND e.job = c.job;

SELECT ename
FROM emp
WHERE job = (SELECT job
						 FROM EMP
						 WHERE ename = 'SMITH');

-- 3. SMITH와 급여가 동일하거나 더 많은(>=) 사원명과 급여 검색
-- SMITH 제외해서 검색하기
-- 서브쿼리 : 메인쿼리 -> 서브쿼리
SELECT ename, sal
FROM EMP
WHERE sal >= (SELECT sal
              FROM EMP
              WHERE ename = 'SMITH') AND ename != 'SMITH';

-- 4. DALLAS에 근무하는 사원의 이름, 부서 번호 검색
SELECT ename, deptno
FROM EMP e
WHERE deptno = (SELECT deptno
                FROM DEPT e
                WHERE loc = 'DALLAS');

SELECT ename, e.deptno
FROM EMP e, DEPT d
WHERE d.loc = 'DALLAS' AND e.deptno = d.deptno;

-- 5. 평균 급여보다 더 많이 받는(>) 사원만 검색
SELECT *
FROM EMP 
WHERE sal > (SELECT AVG(sal)
						FROM emp);
            
-- WHERE 서브쿼리 : 일반 서브쿼리
-- SELECT 서브쿼리 : 스칼라 서브쿼리(단 하나의 값을 반환)
-- ? 직원의 이름, 부서번호, 부서명
SELECT ename, e.deptno, dname
FROM EMP e, DEPT d
WHERE e.deptno = d.deptno;


SELECT e.ename, e.deptno, (SELECT d.dname
													FROM DEPT d
													WHERE e.deptno = d.deptno)
FROM EMP e;

-- 3. FROM 서브쿼리 : 인라인 뷰
-- ? EMP : 각 부서별GROUP BY 최대 연봉MAX()을 받는 사람들의 정보 출력
SELECT deptno, MAX(sal)
FROM emp
GROUP BY deptno;

SELECT e.ename, e.deptno, e.sal
FROM EMP e, (SELECT deptno, MAX(sal) AS max_sal
              FROM emp
              GROUP BY deptno) i
WHERE e.deptno = i.deptno AND e.sal = i.max_sal;

-- 6.급여가 3000이상 사원이 소속된 부서에 속한  사원이름, 급여 검색
-- 급여가 3000이상 사원의 부서 번호
SELECT ename, sal, deptno 
FROM EMP 
WHERE sal >= 3000;

-- 7. in 연산자를 이용하여 부서별로 가장 급여를 많이 받는 사원의 정보(사번, 사원명, 급여, 부서번호) 검색
-- 사번, 사원명, 급여, 부서번호 

-- 부서별로 가장 급여를 많이 받는 사원
	
-- 부서번호 내림차순 정렬

-- 8. 직급(job)이 MANAGER인 사람이 속한 부서의 부서 번호와 부서명(dname)과 지역검색(loc)

-- 연산자 정리
-- any

-- all

-- exits, not exists
