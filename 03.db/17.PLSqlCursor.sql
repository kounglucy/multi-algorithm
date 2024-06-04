-- 17.PLSqlCursor.sql
/* 
1. 용도
	- 여러 개의 행을 처리하고자 할 때 사용
	- 참고
		: 컴퓨터의 마우스 포인터의 커서와 동일한 개념
			
2. 문법
declare
cursor <cursor_name> is <select statement>;
begin
	for 변수 IN  <cursor_name>
	loop 
		
	end loop;  
end;
/
*/
-- cursor for
-- 1.  emp table의 사번, 이름 검색
declare
	cursor emp_cursor is SELECT empno, ename FROM EMP;
begin
	for emp_data IN emp_cursor loop
		dbms_output.put_line(emp_data.empno || ' ' || emp_data.ename);
	end loop;  	
end;
/

-- 2. dept의 모든 지역정보를 검색[cursor 기능 부여]
declare
	cursor dept_cursor is SELECT loc FROM DEPT;
begin
	for v_loc IN dept_cursor loop
		dbms_output.put_line(v_loc.loc);
	end loop;  	
end;
/

-- 3.? 부서 번호에 해당하는 사번, 사원명 검색
-- create or replace procedure emp_info(v_deptno emp.deptno%type)
create or replace procedure emp_info(v_deptno emp.deptno%type)
is 
	cursor emp_cursor is SELECT empno, ename FROM EMP WHERE deptno = v_deptno;
begin
	for emp_data IN emp_cursor loop
		dbms_output.put_line(emp_data.empno || ' ' || emp_data.ename);
	end loop;  	
end;
/

/*
7782 CLARK
7839 KING
7934 MILLER
*/
exec emp_info(10)
/*
7369 SMITH
7566 JONES
7902 FORD
*/
exec emp_info(20)
/*
7499 ALLEN
7521 WARD
7654 MARTIN
7698 BLAKE
7844 TURNER
7900 JAMES
*/
exec emp_info(30)
