-- 16.PLSqlFunction.sql
/*
plsql의 종류
1. 익명 블록
	- 이름 없음, 재사용 고려 X, 단순 문법

2. procedure
	- procedure 키워드
	- in/out/inout
	- 재사용, 실행 후 out 데이터 활용
	- return 키워드 미존재
	- 호출 방법 
		1. sql 실행창에서 execute 
		2. java 언어인 경우 jdbc api로 실행
		3. 또 다른 procedure 내에서 실행
		* 일반 함수 호출과 사용하는 방법이 다름
	
3. function
	- funcation 키워드
	- 재사용
	- 반환값 표현, return 키워드
	- 절대 기존 함수명들과 중복 불가
	- 참고
		함수 종류 : 내장 함수 & 사용자 정의 함수
    - 프로시저와 다른 문법
        - 리턴 타입 선언 + 리턴 값
        - return 키워드 활용
*/

-- 1. emp table의 사번으로 사원 이름(리턴 값, 이름의 타입이 리턴타입) 검색 로직 함수 
CREATE OR REPLACE FUNCTION 
RETURN
IS
BEGIN
END;
/

-- 사용
SELECT emp_info(7369) FROM EMP;

-- 2.? %type 사용해서 사원명으로 해당 사원의 직무(job) 반환하는 함수 
-- 함수명 : emp_job
create function emp_job(no number)
return varchar2
is
	v_job emp.job%type;
begin
	select job
    into v_job
	from emp
	where empno = no;
	
	return v_job;
end;
/

select emp_job(7369) from dual;

-- 3.? 특별 보너스를 지급하기 위한 함수
-- 급여를 200% 인상해서 지급(sal*2)
-- 함수명 : cal_bonus
create function cal_bonus(no number)
return number
is
	v_bonus number;
begin
	select sal*2
		into v_bonus
	from emp
	where empno=no;
	
	return v_bonus;
end;
/

select cal_bonus(7369) 보너스 from dual;

-- 4.? 부서 번호를 입력 받아 최고 급여액을 반환하는 함수
-- 함수명 : s_max_sal
CREATE OR REPLACE FUNCTION s_max_sal(no NUMBER)
RETURN NUMBER
IS
    v_sal emp.sal%type;
BEGIN
    SELECT MAX(sal)
        INTO v_sal
    FROM EMP
    WHERE deptno = no;
    RETURN v_sal;
END;
/
SELECT s_max_sal(10) FROM dual;

-- 5. ? 부서 번호를 입력 받아 부서별 평균 급여를 구해주는 함수
-- 함수명 : avg_sal
-- 함수 내부에서 avg() 호출 가능
CREATE OR REPLACE FUNCTION avg_sal(no NUMBER)
RETURN NUMBER
IS
    v_avg emp.sal%type;
BEGIN
    SELECT AVG(sal)
        INTO v_avg
    FROM EMP
    WHERE deptno = no;
    
    RETURN v_avg;
END;
/
SELECT avg_sal(30) FROM dual;


-- 존재하는 함수 삭제 명령어
-- drop funcation 함수명

-- 6. 존재하는 함수 삭제 명령어
-- drop function 함수명;

-- 함수 내용 검색
DESC user_source;

-- 7. dept table은 pk(deptno) 설정되어 있음, dept에 새로운 데이터 저장 함수 : insert_dept
/* 
1. 필요 sql : insert into dept values(?, ?, ?);
2. 실행 경우의 수
	1. 정상
		insert 완료
	2. 비정상 실행
        ??
3. 설계
	데이터 무결성 문제 발생 시 자동 데이터 변경 후 insert
	dup_val_on_index : exception 활용
*/
create or replace procedure insert_dept
(v_deptno dept.deptno%type, 
 v_dname dept.dname%type, 
 v_loc dept.loc%type)
is
begin
	insert into dept values(v_deptno, v_dname, v_loc);
	exception
		when dup_val_on_index then
			insert into dept values(v_deptno+10, v_dname, v_loc);
end;
/
execute insert_dept3 (40, 'a', 'a');

-- 8. procedure 또는 function에 문제 발생시 show error로 메세지 출력하기
show error



