-- DESC : 테이블 구조를 확인하는 명령어
DESC emp;

-- NUMBER : 간단하게 생각해서 숫자 데이터 타입
-- DATE : 날짜 데이터 타입
-- CHAR : 정적 문자 타입(길이를 정해줌)  VARCHAR2 : CHAR와 같지만 길이가 유동적 쓰기편함 
-- NULL : ZERO 값이 아니라 미확정, 알수없음 값

-- 출력
SELECT
    * FROM DEPT;
    
SELECT
    * FROM EMP;

-- 골라서 출력
SELECT
    SAL,JOB FROM EMP;

-- 산수 가능   
SELECT
    ename, SAL,SAL*12 FROM EMP;

SELECT  ename, SAL, JOB, COMM, SAL*12 , SAL*12+comm
    FROM EMP;

-- NVL NULL 값 치환 
SELECT  ename, nvL(COMM, 0)
    FROM EMP;    

-- 열 AS "" 별명 짓기    AS 생략 가능, 쌍따옴표 생략 가능 BUT 쌍따옴표 생략시 무조건 대문자
SELECT  ename AS "이름", SAL AS "연봉", JOB AS "직급", nvL(COMM, 0) AS "성과금", SAL*12 AS "연봉 ", SAL*12+nvL(COMM, 0) AS "연봉 + 성과금"
    FROM EMP;  
    
-- 행을 연결할떄 || 수직바 사용
SELECT ENAME ||' is a ' || JOB FROM EMP;

-- 중복 제거 DISTINCT
SELECT DISTINCT JOB FROM EMP;

--
SELECT ENAME, SAL, HIREDATE FROM EMP;

SELECT DEPTNO AS "부서번호" ,DNAME AS "부서명" FROM DEPT;
    
SELECT DISTINCT JOB FROM EMP;

-- 조건문 WHERE 문자열, 날짜는 ''로 감싸기
SELECT EMPNO, ENAME, SAL FROM EMP WHERE ENAME = '김사랑';
SELECT * FROM EMP WHERE hiredate >= '03/09/01';

-- AND OR NOT 은 영어 그대로 쓰자   NOT 은 != 쓸수있음.
SELECT * FROM EMP WHERE DEPTNO = 10 AND JOB = '사원';
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = '사원';
SELECT * FROM EMP WHERE DEPTNO = 10 AND NOT JOB = '사원';

-- 사이 값을 출력하기위한 BETWEEN (200<= SAL AND 300>= SAL) 와 같음
SELECT * FROM EMP WHERE SAL BETWEEN 200 AND 300;

-- 200보다 작고 300보다 큰것
SELECT * FROM EMP WHERE SAL < 200 OR SAL > 300;
SELECT * FROM EMP WHERE SAL NOT BETWEEN 200 AND 300;

-- IN 연산자 : OR 연산자 쓰기 편하게
SELECT * FROM EMP WHERE SAL = 300 OR SAL = 500 OR SAL = 1000;
SELECT * FROM EMP WHERE SAL IN(300,500,1000);

-- *** 중요 ***   LIKE 연산자 : 컬럼명 LIKE % // LIKE _ 
SELECT * FROM EMP WHERE ename LIKE '김%';
SELECT * FROM EMP WHERE ename LIKE '_사_';

-- NULL 을 찾고 싶을때 IS NULL 반대는 IS NOT NULL
SELECT * FROM EMP WHERE COMM IS NULL;
SELECT * FROM EMP WHERE COMM IS NOT NULL;

-- 순서 정렬 : 오름차순 ASC , 내림차순 DESC , 쓸때 ORDER BY 추가 후 사용
SELECT * FROM EMP ORDER BY hiredate DESC;
SELECT * FROM EMP ORDER BY hiredate ASC;    -- ASC는 안써도 되는데 쓰는게 좋음
SELECT * FROM EMP ORDER BY SAL ASC;
SELECT * FROM EMP ORDER BY SAL DESC;

-- 정렬에 조건 : 대입 첫번째 정렬에서 겹치는 부분을 두번째에서 정렬
SELECT * FROM EMP ORDER BY SAL DESC , ename ASC;

--
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL <= 300;
SELECT EMPNO,ENAME,SAL FROM EMP WHERE ename = '오지호';
--3
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL = 250 OR SAL = 300 OR SAL = 500;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL IN(250,300,500);
--4
SELECT * FROM EMP WHERE SAL != 250 AND SAL != 300 AND SAL != 500;
SELECT * FROM EMP WHERE SAL NOT IN(250,300,500);
--5
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '김%' OR ENAME LIKE '%기%';
--6
SELECT * FROM EMP WHERE MGR IS NULL;
--7
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP ORDER BY hiredate ASC;

-- 테스트 용 테이블
SELECT * FROM DUAL;

-- 숫자함수
-- ABS  절대값 구함  크기만 나타냄 (음수 입력시 양수로 출력)
-- FLOOR    소수점 아래를 잘라냄
-- ROUND    특정 자릿수 반올림
SELECT 34.5678, ROUND(34.5678, -1) FROM DUAL; -- 1의 자리 반올림 10,100도 가능
-- TRUNC    특정 자릿수 버림
-- MOD      나눈후 나머지 반환 (자바에서 % 쓰는거랑 같음)

-- 문자 처리 함수
-- SUBSTR 문자열 꺼내기  == 자바 SUBSTRING
SELECT SUBSTR('ABCDEFG',3,4) FROM DUAL; -- (시작위치, 꺼낼 개수)
SELECT SUBSTR('ABCDEFG',-3,3) FROM DUAL; -- 마이너스 부터 시작 뒤에서 ""번째
-- TRIM 공백 또는 특정 문자 잘라낼수있음

-- 날짜 함수
--SYSDATE 시스템 날짜 반환

-- 형 변환 함수
-- TO_CHAT 날짜형 OR 숫자형을 문자형으로 변환
-- TO_DATE 문자형을 날짜형으로 변환
-- TO_NUMBER 문자형을 숫자형으로 변환

select sysdate, to_char(sysdate, 'YYYY-MM-DD') FROM DUAL;
SELECT hiredate, TO_CHAR(hiredate,'YY/MON/DD DY') FROM EMP ORDER BY hiredate;

-- TO CHAR
SELECT SAL, TO_CHAR(SAL,'L999,999') FROM EMP;

--TO DATE
SELECT ENAME,HIREDATE FROM EMP WHERE hiredate = TO_DATE('20040108','YYYYMMDD');
SELECT TRUNC(SYSDATE - TO_DATE('2020/01/01','YYYY/MM/DD')) FROM DUAL;

-- TO NUMBER
SELECT TO_NUMBER('20,000', '99,999')- TO_NUMBER('10,000','99,999')FROM DUAL;

-- DECODE 조건문 : 자바 SWITC문이랑 같은기능
SELECT ENAME, DEPTNO, DECODE(deptno, 10, 'ACCOUNTING',
                                    20, 'RESEARCH', 
                                    30, 'SALES',
                                    40, 'OPERATIONS')
                                    AS DNAME
    FROM EMP;
    
-- CASE 조건문 : 자바 IF ELSE 와 유사한 구조 WHEN,THEN
SELECT ENAME, DEPTNO, CASE
WHEN DEPTNO = 10 THEN 'ACCOUNTING'
WHEN DEPTNO = 20 THEN 'RESEARCH'
WHEN DEPTNO = 30 THEN 'SALES'
WHEN DEPTNO = 40 THEN 'OPERATIONS'
END -- 끝날때 END
FROM EMP;

SELECT * FROM EMP;

-- 1
SELECT * FROM EMP WHERE SUBSTR(hiredate,4,2) = '10';
SELECT * FROM EMP WHERE hiredate LIKE '%%/10/%%';
-- 2
SELECT * FROM EMP WHERE SUBSTR(hiredate,1,2) = '03';
SELECT * FROM EMP WHERE hiredate LIKE '03/%%/%%';
-- 3
SELECT * FROM EMP WHERE SUBSTR(ENAME,3,1) = '기';
SELECT * FROM EMP WHERE ENAME LIKE '%%기';
-- 4
SELECT ENAME,JOB, SAL,DECODE(JOB, '부장', SAL + SAL * (5/100),
                                   '부장', SAL + SAL * (5/100), 
                                    '과장', SAL + SAL * (1/10),
                                   '대리', SAL + SAL * (15/100),
                                   '사원', SAL + SAL * (2/10) )
                                    AS SAL1
    FROM EMP;
-- 5
SELECT ENAME,hiredate , TO_CHAR(hiredate,'YYYY/MON/DD')AS 년도 FROM EMP ORDER BY hiredate;
 