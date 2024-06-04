/*  
문제풀이
*/

/*
부서번호가 10번인 사원번호, 이름, 월급 출력
*/
SELECT empno, ename, sal
FROM EMP
WHERE deptno = 10;

/*
사원번호가 7369인 사람의 이름, 입사일, 부서 번호 출력
*/
SELECT ename, hiredate, deptno
FROM EMP
WHERE empno = 7369;


/*
이름이 ALLEN인 사람의 정보 출력
*/
SELECT *
FROM EMP
WHERE ename = 'ALLEN';


/*
입사일이 83/01/12인 사원의 이름, 부서번호, 월급 출력
*/
SELECT ename, deptno, sal
FROM EMP
WHERE hiredate = '83/01/12';

SELECT ename, hiredate
FROM emp;

/*
직업이 MANAGER가 아닌 사람의 모든 정보를 출력
*/
SELECT *
FROM EMP
WHERE job != 'MANAGER';


/*
입사일이 81/04/02 이후에 입사한 사원의 정보 출력
*/
SELECT *
FROM EMP
WHERE hiredate >= '81/04/02';


/*
급여가 800이상인 사람의 이름, 급여, 부서번호 출력
*/
SELECT ename, sal, deptno
FROM EMP
WHERE sal >= 800;


/*
부서번호가 20번 이상인 사원의 보든 정보 출력
*/
SELECT *
FROM EMP
WHERE deptno >= 20;


/*
이름이 K로 시작하는 사람의 모든정보 출력
*/
SELECT *
FROM EMP
WHERE ename LIKE 'K%';


/*
입사일이 81/12/09 보다 먼저 입사한 사람들의 모든 정보 출력
*/
SELECT *
FROM EMP
WHERE hiredate < '81/12/09';


/*
입사번호가 7698보다 작거나 같은 사람들의 입사번호와 이름 출력
*/
SELECT empno, ename
FROM EMP
WHERE empno <= 7698;


/*
입사일이 81/04/02보다 늦고  82/12/09보다 빠른 사원의 이름, 월급, 부서번호 출력
*/
SELECT ename, sal, deptno, hiredate
FROM EMP
WHERE hiredate > '81/04/02' and hiredate < '82/12/09';

SELECT ename, sal, deptno, hiredate
FROM EMP
WHERE hiredate between '81/04/03' and '82/12/09';


/*
급여가 1600보다 크고[초과] 3000보다 작은[미만] 사람의 이름, 직업, 급여 출력
*/
SELECT ename, job, sal
FROM EMP
WHERE sal > 1600 and sal < 3000;


/*
사원번호가 7654와 7782사이 이외의 사원의 모든 정보 출력
*/
SELECT *
FROM EMP
WHERE NOT empno BETWEEN 7654 AND 7782;


/*
직업이 MANAGER와 SALESMAN인 사람의 모든 정보 출력
*/
SELECT *
FROM EMP
WHERE job = 'MANAGER' OR job = 'SALESMAN';

SELECT *
FROM EMP
WHERE job IN ('MANAGER', 'SALESMAN');


/**16.
부서번호와 20,30번을 제외한 모든 사람의 이름, 사원번호, 부서번호 출력
*/
SELECT ename, empno, deptno
FROM EMP
WHERE NOT deptno IN (20, 30);


/*
이름이 S로 시작하는 사원의 사원번호, 이름, 입사일, 부서번호 출력
*/
SELECT empno, ename, hiredate, deptno
FROM EMP
WHERE ename LIKE 'S%';


/*
이름중 S자가 들어가 있는 사람만 모든 정보 출력
*/
SELECT *
FROM EMP
WHERE ename LIKE '%S%';


/*
이름이 S로 시작하고 마지막 글자가 T인 사람의 정보 출력(단, 이름은 전체 5자)
*/
SELECT *
FROM EMP
WHERE ename LIKE 'S___T';


/*
커미션이 null인 사원의 정보를출력
*/
SELECT *
FROM EMP
WHERE comm IS NULL;


/*
커미션이 null이 아닌 사원의 정보 출력하
*/
SELECT *
FROM EMP
WHERE NOT comm IS NULL;


/*
부서번호가 30번이고 급여가 1500이상인 사람의 이름, 부서, 월급(sal) 출력
*/
SELECT ename, deptno, sal
FROM EMP
WHERE deptno = 30 AND sal >= 1500;


/*
이름의 첫글자가 K로 시작하거나 부서번호가 30인 사람의 사원번호, 이름, 부서번호 출력
*/
SELECT empno, ename, deptno
FROM EMP
WHERE ename LIKE 'K%' OR deptno = 30;


/*
급여가 1500이상이고 부서번호가 30번인 사원중 직업이 MANAGER인 사람의 정보 출력
*/
SELECT *
FROM EMP
WHERE sal >= 1500 AND deptno = 30 AND job = 'MANAGER';



/*
부서번호가 30인 사람중 사원번호 정렬
*/
SELECT *
FROM EMP
WHERE deptno = 30
ORDER BY empno ASC;


/*
급여가 많은 순으로 정렬
*/
SELECT ename, sal
FROM EMP
ORDER BY sal DESC;


/*
부서번호로 오름차순 -> 급여가 많은 사람 순 출력
*/
SELECT ename, sal
FROM EMP
ORDER BY deptno ASC, sal DESC;


/*
부서번호로 내림차순 -> 급여순으로 내림차순
*/
SELECT ename, sal, deptno
FROM EMP
ORDER BY deptno DESC, sal DESC;

