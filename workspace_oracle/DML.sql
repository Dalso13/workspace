-- DML
-- 테이블에 데이터 검색 삽입 수정 삭제
-- 롤백 가능
-- SELECT   검색  R
-- INSERT   추가  C
-- UPDATE   수정  U
-- DELETE   삭제  D

-- INSERT
--INSERT INTO 테이블명
--(컬럼 이름,...)
--VALUES(컬럼 데이터,....)
SELECT * FROM DEPT01;

INSERT INTO DEPT01
(deptno,dname,LOC)
VALUES(10,'영업부','부산');
-- 컬럼 모두에 내용을 입력할거면 컬럼명을 생략해도 됨

--2
CREATE TABLE SAM01(
    EMPNO   NUMBER(4),
    ENAME   VARCHAR2(10),
    JOB     VARCHAR2(9),
    sal     NUMBER(7,2));

DESC SAM01;

INSERT INTO SAM01
(EMPNO,ENAME,JOB,SAL)   -- 생략 가능
VALUES(1000,'사과','경찰',1000);

INSERT INTO SAM01
(EMPNO,ENAME,JOB,SAL)
VALUES(1010,'바나나','간호사',1500);

INSERT INTO SAM01
(EMPNO,ENAME,JOB,SAL)
VALUES(1020,'오렌지','의사',2000);

SELECT * FROM SAM01;

-- null 값 삽입

-- 암시적 방법
-- 컬럼명 리스트에 null을 넣고싶은 컬럼을 생략 , 다른 컬럼은 값을 입력
INSERT INTO DEPT01
(deptno,dname)
VALUES(10,'영업부');   -- LOC값 생략

-- 명시적 방법
-- VALUES 에서 NULL 입력
INSERT INTO DEPT01
(deptno,dname,LOC)
VALUES(10,'영업부',NULL); -- 또는 빈 문자열 '' 넣기


--3
SELECT * FROM SAM01;

INSERT INTO SAM01
(empno,ENAME,JOB,SAL)
VALUES(1030,'베리',NULL,2500);

INSERT INTO SAM01
(EMPNO,ENAME,JOB,SAL)
VALUES(1040,'망고',NULL,25000);

-- 서브 쿼리로 데이터 삽입
-- 테이블이랑 서브쿼리랑 구조가 같아야함
INSERT INTO DEPT02
SELECT * FROM DEPT;

SELECT * FROM DEPT02;

--4
INSERT INTO SAM01
SELECT EMPNO,ENAME,JOB,SAL FROM EMP
WHERE DEPTNO = 10;

SELECT * FROM SAM01
ORDER BY EMPNO;


-- UPDATE
-- 데이터 수정
-- 사용할때 신중하게 사용해야함
-- ( UPDATE 테이블명
--  SET 컬럼1 = 값1, 컬럼2 = 값2,.....
--  WHERE 조건; )  -- WHERE 조건을 꼭 사용해줘야한다 사용안하면 모든 행이 바뀜

SELECT * FROM EMP01;

UPDATE EMP01
SET DEPTNO = 30;

UPDATE EMP01
SET SAL = SAL + (SAL / 10);

UPDATE EMP01
SET HIREDATE = SYSDATE;

SELECT * FROM EMP01;
SELECT * FROM SAM01;

-- 1 
UPDATE EMP01
SET DEPTNO = 30
WHERE DEPTNO = 10;

-- 2
UPDATE EMP01
SET SAL = SAL + (SAL/10)
WHERE SAL >= 400;

-- 3
UPDATE SAM01
SET SAL = SAL - 5000
WHERE SAL >= 10000;

-- 다중 컬럼 값 변경
UPDATE EMP01
SET DEPTNO = 10, JOB = '과장' -- 변경을 여러개 가능 , 붙여서 넣어주기
WHERE ENAME = '한예슬';    -- 마찬가지로 조건도 여러개 가능 조건은 AND,OR,NOT

SELECT * FROM DEPT02;

-- 서브 쿼리 이용해서 업데이트
UPDATE DEPT02
SET LOC = (SELECT LOC FROM DEPT02
           WHERE DEPTNO = 40)
WHERE DEPTNO = 20;

--4
CREATE TABLE SAM02(
    ENAME VARCHAR2(10),
    SAL   NUMBER(7,2),
    HIREDATE DATE,
    DEPTNO  NUMBER(2));
DESC SAM02;

INSERT INTO SAM02
SELECT ENAME,SAL,HIREDATE,DEPTNO FROM EMP;
--5
UPDATE SAM02
SET SAL = SAL + 100
WHERE DEPTNO = (SELECT DEPTNO FROM dept
                WHERE LOC = '인천');

SELECT * FROM SAM02;


-- DELETE
--DELETE FROM 테이블명
--WHERE 조건      -- WHERE 사용안하면 데이터 모두 삭제

-- DELETE 데이터는 지워지지만 용량은 그대로 원하는 데이터만 지울수있고 롤백가능
-- TRUNCATE 데이터 및 인덱스들 모두 삭제하고 용량도 줄고 롤백 불가능 -- 테이블은 삭제 안함
-- DROP 테이블 전체를 삭제 롤백 불가능

DELETE FROM SAM01
WHERE JOB IS NULL;

SELECT * FROM SAM01;

-- 1
DELETE FROM SAM02
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT
                WHERE  DNAME = '영업부');
SELECT * FROM SAM02;




