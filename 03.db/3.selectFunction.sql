-- 3.selectFunction.sql
-- 함수(Function)
-- 특정 결과값을 얻기 위해 데이터를 입력할 수 있는 특수 명령어
/*
-- 종류
1. 내장함수(built-in function)
	- 단일행 함수(single-row function) : 한 행 -> 한 행
	- 다중행 함수(multiple-row function) : 여러 행 -> 한 행

2. 사용자 정의 함수(user-defined function)

-- Oracle DB 지원 함수
	1. 숫자 함수
	2. 문자 함수
	3. 날짜 함수 
	4. ... 
*/

-- dumy table 검색


-- 숫자함수
-- 1.절대값 함수 : abs()

-- 2.반올림 함수 : round(데이터 [, 반올림자릿수])

-- 3.지정한 자리수 이하 버리는 함수 : trunc()

-- 4.나누고 난 나머지 값 연산 함수 : mod()

-- 5.? emp table에서 사번이 홀수인 사원의 이름, 사번 검색 

-- 6.제곱 함수 : power()

-- 문자함수
/* 
대문자 : upper
소문자 : lower
*/
-- 1.대소문자 변환 함수
-- upper() : 대문자[uppercase]
-- lower() : 소문자[lowercase]


-- 2.?소문자 manager로 일치되는 사원의 이름, 직업 검색 

-- 3.문자열 길이 체크함수 : length()

-- 4.byte수 체크함수 : lengthb()

-- 5.문자열 추출함수 : substr()
-- substr(데이터, 시작위치, 추출할 개수)
-- SQL에서는 INDEX 1부터 시작

-- 6.?년도 구분없이 2월에 입사한 사원이름, 입사일 검색

-- 7.문자열 앞뒤 여백 제거함수 : trim()

-- CONCAT()

-- 8.특정 문자 대체 함수 : replace()

-- 9. 특정 문자 채우기 함수 : lpad(), rpad()

-- ?개인정보
-- '230406-1234567'

-- ?PAD함수 외에 SUBSTR, RPLACE 사용해서 바꿔보기, PAD가 필요하면 PAD도 더해서 써보기
-- 230406-1******

-- 날짜 함수
-- 현재 시스템 날짜 정보 : sysdate
-- 1.어제, 오늘, 내일 날짜 검색 

-- 2.?emp table에서 근무일수 계산하기, 사번과 근무일수(반올림) 검색

-- 3.특정 개월수 더하는 함수 : add_months() 
-- 6개월 이후 검색

-- ?사원들의 10주년 기념일

-- 4.?입사일 이후 3개월 지난 일수 검색

-- 5.두 날짜 사이의 개월수 검색 : months_between()
-- 오늘을 기준으로 2017-02-09
-- 앞이 기준날짜

-- 6.요일을 기준으로 특정 날짜 검색 : next_day()

-- 7.주어진 날짜를 기준으로 해당 달의 가장 마지막 날짜 검색: last_day()

-- 8.?2017년 2월의 마지막 날짜

-- 형변환 함수
/*
암시적 형변환
명시적 형변환

                    -- >			    		-- >
숫자(Number) 		 문자(Chracter)  		 날짜(Date)
                    <-- 		    			<-- 
*/
-- 사용 빈도 높음
-- [1] to_char() : 날짜->문자, 숫자 -> 문자
-- [2] to_date() : 날짜로 변경
-- [3] to_number() : 문자열을 숫자로 변환


-- [1] to_char()
-- 1. 오늘 날짜 'yyyy-mm-dd' 변환

-- dy : 요일

-- hh:mi:ss

-- hh24:mi:ss

-- ? 2.날짜(sysdate)의 round(), trunc()
--  날짜 round()
--  날짜 trunc()

-- 3. 숫자를 문자형으로 변환 : to_char()
-- 1. 숫자를 원하는 형식으로 변환 검색
-- 9 : 실제 데이터의 유효한 자릿수 숫자 의미(자릿수 채우지 않음)
-- 0 :	 "		(자릿수 채움)
-- . : 소수점 표현
-- , : 원단위 표현
-- $ : 달러 
-- L or l : L(Locale)지역화폐 표현

-- [2] to_date() : 날짜로 변경 시키는 함수
-- 1. 올해 몇일이 지났는지 검색(포멧 yyyy/mm/dd)
-- 20190209
-- SELECT SYSDATE - 20190209 FROM DUAL;

-- 2. 문자열로 date타입 검색
--  1980년 12월 17일 입사한 직원이름 검색

-- [3] to_number() : 문자열을 숫자로 변환
-- 1.? '20,000'의 데이터에서 '10,000' 산수 연산하기 

-- 조건식 함수
-- decode()-if or switch
-- decode(조건컬럼, 
--           조건값1,  출력데이터1,
-- 			  조건값2,  출력데이터2,
-- 				...,
-- 			  default값) 
-- from table명;

-- 1.deptno에 따른 출력 데이터

-- 10 -> 'A' , 20 -> 'B', 나머지 부서는 'ETC'

-- 2.?emp table의 연봉(sal) 인상계산
-- job이 ANALYST 5%인상(sal*1.05), SALESMAN은 10% 인상, MANAGER는 15%, CLERK 20% 인상 
-- empno, job, sal, decode 출력

-- 3.?JOB : 'MANAGER' -> 'M', 'ANALYST' -> 'A', 나머지 -> 'ETC'

-- case문
-- case 조건컬럼
-- 		when 조건값1 then 출력데이터1
-- 		when 조건값2 then 출력데이터2
-- 		...
-- 		else default값
-- end

-- 4.?2번 case문으로 바꾸기
