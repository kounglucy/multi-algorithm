-- 15.PLSqlProcedure.sql
/* 
	1. 저장 프로시저
    2. 문법
        2-1. 생성
            - 이미 동일한 이름의 procedure가 존재할 경우 error 발생 
            create procedure 이름
            is
            begin
            end;
            /
    
        2-2. 생성 및 치환
            - 미 존재할 경우 생성, 존재할 경우 치환
            create or replace procedure
            is
            begin
            end;
            /
*/


-- 1. procedure 정보 확인 sql문장
desc user_source;
select * from user_source;

-- 2. 실습을 위한 test table
drop table dept01;
create table dept01 as select * from dept;
drop table emp01;
create table emp01 as select * from emp;

-- 3. emp01의 부서 번호가 20인 모든 사원의 job을 STUDENT로 변경하는 프로시저 생성
-- 에러 발생 출력
show error

-- 4. 실습 및 확인
create or replace procedure update_20
is
begin
    UPDATE EMP01 SET job = 'STUDENT'		
  	WHERE deptno = 20;
end;
/

SELECT ename, deptno, job
FROM EMP01;

execute update_20;

SELECT ename, deptno, job
FROM EMP01;

-- 5. emp01의 부서 번호가 20인 모든 사원의 job을 STUDENT로 변경하는 프로시저 생성

-- 6.? 사번, 급여를 입력받아서 해당 직원의 희망급여를 변경하는 프로시저 
-- update_sal( , )
create or replace procedure update_sal(v_empno emp01.empno%type, v_sal emp01.sal%type)
is
begin
    UPDATE EMP01 SET sal = 	v_sal
  	WHERE empno = v_empno;
end;
/

SELECT empno, sal 
FROM EMP01;

execute update_sal(7369, 2000);

SELECT empno, sal 
FROM EMP01;

-- 7. 사번으로 이름과 급여 검색하기
/* 
프로시저 이름 : info_empinfo
필요한 데이터 : 사번 
반환하는 데이터 : 이름과 급여
문법 : in mode - 사번, out mode - 이름, 급여
프로시저 이외에 필요한 변수 - 이름과 급여를 대입받아서 사용하고자 변수
개발 코드 
	1. 프로시저
	2. 변수 두개 
*/
/*
create or replace procedure info_empinfo
(v_empno IN emp01.empno%type,
 v_ename OUT emp01.ename%type,
 v_sal OUT emp01.sal%type)
 is 
 begin
	select ename, sal
		into v_ename, v_sal
	from emp01
	where empno=v_empno;
 end;
 /
 */
 -- 프로시저 실행 결과값을 대입받을 변수 선언
 variable v_ename varchar2(20);
 variable v_sal number;
 
 -- 프로 시저 호출(값을 대입받을 out mode에 선언된 변수 적용)
 execute info_empinfo(7369, :v_ename, :v_sal)
 
 -- 변수 값을 출력
print v_ename;
print v_sal;

-- 8. 이미 저장된 프로시저를 활용하는 새로운 프로시저
declare
		v_ename emp01.ename%type;
    v_sal emp01.sal%type;
begin
		info_empinfo(7369, v_ename, v_sal);
    dbms.output.put_line(v_ename || ' ' || v_sal);
end;
/

-- 9. ? review 문제 만들고 답안
-- 제약조건 : dept01 table 활용하기 
create or replace procedure info_deptloc
(v_dname IN dept01.dname%type,
 v_loc OUT dept01.loc%type)
 is 
 begin
  select loc
  into v_loc
  from dept01
  where dname = v_dname;
 end;
 /

-- 프로시저 실행 결과값을 대입받을 변수 선언
variable v_loc varchar2(20);

-- 프로 시저 호출(값을 대입받을 out mode에 선언된 변수 적용)
execute info_deptloc('SALES', :v_loc);

-- 변수 값을 출력
print v_loc;