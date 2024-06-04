-- 14.PLSqlSyntaxBasic.sql
/* 
1. oracle db만의 프로그래밍 개발 방법
	- 개발 방식 
	1. 프로시저 개발 - 이름 부여(재사용)
	2. 함수 개발 - 이름 부여(재사용)
		
2. 장점
	- 여러번 사용하는 sql 다수 문장을 하나로 묶을 수 있음
  - DB 자체의 언어로 컴파일 후 -> 실행 속도 향상

3. test를 위한 필수 셋팅 
	- set serveroutput on 
	
4. 필수 암기 
	1. 할당(대입) 연산자  :=
	2. 선언, 시작, 끝
		declare ~ begin ~ end; /
	declare
	
    begin

    end;
    /
	
5. oracle 자체의 언어 학습
	1. 타입 - DB 자체의 타입 + oracle만의 타입
	2. 함수 - 
	
	
6. 에러메세지 확인하기
	show errors;
*/
-- 1. 실행 결과 확인을 위한 필수 설정 명령어
set serveroutput on


-- 2. 연산을 통한 간단한 문법 습득
/* 
연산 : 타입은 반드시 수치형 
integer 
*/
-- step 01
 declare
		no integer;
begin
		no := 10;
    dbms_output.put_line(no);
end;
/		
-- step 02	
declare
		no integer;
begin
		no := 10;
    no := no/2;
    dbms_output.put_line('결과 : ' || no);
end;
/

-- step 03 : 예외처리 필요성 
declare
		no integer;
begin
    no := 10;
    no := no/0;
    dbms_output.put_line('결과1 : ' || no);
    dbms_output.put_line('결과2 : ');
    dbms_output.put_line('결과3 : ');
end;
/

-- step 04 : 예외처리 문법 적용
-- 예외 처리 : 문제 발생 시 유연하게 실행 유지를 위한 처리 기술
declare
		no integer;
begin
		no := 10;
    no := no/0;
    dbms_output.put_line('결과1 : ' || no);
    exception
    		when others then
    				dbms_output.put_line('예외 처리!');
    
    dbms_output.put_line('결과2 : ');
    dbms_output.put_line('결과3 : ');
end;
/

-- 5. 중첩 block
-- plsql에서 권장하는 변수명 : _ 사용
/* 
중첩된 블록 내부에 선언된 변수 : 로컬 변수명
로컬 변수는 선언된 begin 내에서만 사용 가능 
*/

declare
		v_global VARCHAR2(10) := 'global';
begin
		declare
				v_local VARCHAR2(10) := 'local';
    begin
        dbms_output.put_line('g -  : ' || v_global);
        dbms_output.put_line('l -  : ' || v_local);
    end;
end;
/

-- 에러
declare
		v_global VARCHAR2(10) := 'global';
begin
		declare
          v_local VARCHAR2(10) := 'local';
    begin
        dbms_output.put_line('g -  : ' || v_global);
        dbms_output.put_line('l -  : ' || v_local);
    end;
        dbms_output.put_line('g2 -  : ' || v_global);
        dbms_output.put_line('l2 -  : ' || v_local);
end;
/

-- 6. emp01 table의 컬럼을 사용해서 %type 표기법 학습
-- %type : 지정한 컬럼 타입 의미
-- table명과 컬럼명 필요
drop table emp01;
create table emp01 as select * from emp;

-- 사번으로 사원번호, 이름, 급여 검색해서 출력
-- select empno, ename, sal from emp01 where empno=7369
/* 
이미 존재하는 데이터 검색 : plsql의 변수에 대입 (할당)
주의사항 : 변수 타입은 반드시 DB에 존재하는 컬럼 타입과 동일
*/
declare
    v_empno  emp01.empno%type;
    v_ename  emp01.ename%type;
    v_sal    emp01.sal%type;
begin
		SELECT empno, ename, sal
        INTO v_empno, v_ename, v_sal
        FROM EMP01
        WHERE empno = 7369;
    
    dbms_output.put_line(v_empno || ' ' || v_ename || ' ' || v_sal);
end;
/

-- 7. 이미 존재하는 table의 record의 모든 컬럼 타입 활용 키워드 : %rowtype
/* 7369 사번으로 해당 사원의 모든 정보를 검색해서 사번, 이름만 착출해서 출력 */
declare
		v_rows emp01%rowtype;
begin
		SELECT *
        INTO v_rows
    FROM EMP01
    WHERE empno = 7369;
    
    dbms_output.put_line(v_rows.empno || ' ' ||v_rows.ename);
end;
/

-- 8. ???
-- emp01라는 table을 데이터 없이 emp table로 부터 생성하기

-- %rowtype을 사용해서 emp의 사번이 7369인 사원 정보 검색해서 
-- emp01 table에 insert
-- 힌트 : begin 영역에 다수의 sql 문장 사용 가능

declare
		v_rows emp%rowtype;
begin
		SELECT *
        INTO v_rows
    FROM EMP
    WHERE empno = 7369;
        
    INSERT INTO EMP02 VALUES v_rows;
    COMMIT;
end;
/

SELECT * 
FROM EMP02;


-- 9. 조건식
/*  1. 단일 조건식
		if(조건) then
			조건이 true인 경우 실행되는 블록
		end if;
	
	2. 다중 조건
		if(조건1) then
			조건1이 true인 경우 실행되는 블록 
		elsif(조건2) then
			조건2가 true인 경우 실행되는 블록
		end if;  */
	
-- emp01	
-- 사원의 연봉을 계산하는 procedure 개발[comm이 null인 직원들은 0으로 치환]
-- sal*12 + comm
-- 조건식 : comm이 null이면 0 값으로 할당
-- db에 영향? 연산만?
-- step 01 : 정적 데이터 대입
declare
		v_emp01 emp01%rowtype;
		total_sal NUMBER(8, 2);
begin
		
    SELECT sal, comm
    INTO v_emp01.sal, v_emp01.comm
    FROM emp01
    WHERE ename = 'SMITH';
    
    total_sal := (v_emp01.sal * 12) + NVL(v_emp01.comm, 0);
    dbms_output.put_line(total_sal);
end;
/

-- upgrade
declare
		v_emp01 emp01%rowtype;
		total_sal NUMBER(8, 2);
begin
		
    SELECT sal, comm
    INTO v_emp01.sal, v_emp01.comm
    FROM emp01
    WHERE ename = 'SMITH';
    
    if v_emp01.comm is null then
    	v_emp01.comm := 0;
    end if;
    
    total_sal := (v_emp01.sal * 12) + v_emp01.comm;
    dbms_output.put_line(total_sal);
end;
/

-- step 02 : 동적(가변) 데이터 적용 문법 ; rf. select * from emp01 where ename=&v;
declare
		v_emp01 emp01%rowtype;
		total_sal NUMBER(8, 2);
begin
		
    SELECT sal, comm
    INTO v_emp01.sal, v_emp01.comm
    FROM emp01
    WHERE ename = &name;
    
    if v_emp01.comm is null then
    	v_emp01.comm := 0;
    end if;
    
    total_sal := (v_emp01.sal * 12) + v_emp01.comm;
    dbms_output.put_line(total_sal);
end;
/

-- 10.??? 실행시 가변적인 데이터 적용해 보기
-- emp table의 deptno=10 : ACCOUNTING 출력, deptno=20 이라면 RESEARCH 출력
-- test data는 각 사원의 사번
declare
		v_empno NUMBER(4) := &empno;
    v_deptno emp.deptno%type;
    v_dname VARCHAR2(10);
begin
		SELECT deptno
        INTO v_deptno
    FROM EMP
    WEHRE empno = v_empno;
    
    if v_deptno = 10 then
    		v_dname := 'ACCOUNTING';
    elsif v_deptno = 20 then
    		v_dname := 'RESEARCH';
    else
    		v_dname := 'NONE';
    end if;
    
    dbms_output.put_line(v_empno || '의 부서명은 ' || v_dname);
end;
/

-- 11. 반복문
/* 
1. 기본
loop 
	ps/sql 문장들
	exit 조건;
end loop;

2. while 기본문법
 while 조건식 loop
 	plsql 문장;
 end loop;

3. for 기본 문법
for 변수 in [reverse] start ..end loop
	plsql문장
end loop;
*/
-- loop : 1 ~ 5 출력
declare
	num NUMBER(2) := 1;
begin
		loop 
    	dbms_output.put_line(num);
      num := num + 1;	
      exit when num > 5;
    end loop;
end;
/

-- while
declare
	num NUMBER(2) := 1;
begin
   while num <= 5 loop
    dbms_output.put_line(num);
    num := num + 1;
   end loop;
end;
/

-- for[사용 빈도 높음] : 초기값, 사용로직, 증감식, 비교식(조건식)
-- 오름차순 출력 
declare
begin
  for i in 1..5 loop
     dbms_output.put_line(i);
  end loop;
end;
/

-- 내림차순 출력
declare
begin
  for i in reverse 1..5 loop
     dbms_output.put_line(i);
  end loop;
end;
/

-- 12.? 사번을 입력받아서 해당하는 사원의 이름 음절 수 만큼 * (한line)표 찍기 
-- length() / 결합 연산자 : ||
-- 권장 실행 결과
/*
Enter value for no: 7369
SMITH님의 이름 길이 수는 *****
*/
declare
  v_empno emp.empno%type := &no;
  v_ename emp.ename%type;
  v_number NUMBER(20);
  v_stars VARCHAR(20);
begin
  SELECT ename, LENGTH(ename)
  	INTO v_ename, v_number
  FROM EMP
  WHERE empno = v_empno;
  
  for i in 1..v_number loop
     v_stars := v_stars || '*';
  end loop;
  
  dbms_output.put_line(v_ename || '님의 이름 길이 수는 ' || v_stars);
end;
/



