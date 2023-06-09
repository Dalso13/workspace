-- *** 12.제약조건 *** --

-- 무결성 제약 조건
-- 부적절한 자료가 입력되는걸 방지

--* NOT NULL     NULL X
--* UNIQUE       중복되는값 X
--* PRIMARY KEY  NULL, 중복되는값 X
-- FOREIGN KEY  참조되는 테이블의 컬럼의 값이 존재하면 허용
-- CHEAK        저장 가능한 데이터 값의 범위나 조건을 지정하여 설정한 값만 허용


SELECT * FROM DEPT;
INSERT INTO DEPT VALUES(10,'TEST','TEST');

DESC DEPT;

-- 제약 조건 확인
DESC USER_CONSTRAINTS;
-- 중요한 컬럼
-- CONSTRAINT_TYPE
-- P  : PRIMARY KEY
-- R  : FOREIGN KEY
-- U  : UNIQUE
-- C  : CHECK, NOT NULL

SELECT * FROM USER_CONS_COLUMNS;

-- NOT NUL
INSERT INTO EMP03 VALUES(NULL,NULL,'영업부',30);
SELECT * FROM EMP03;

CREATE TABLE EMP04(
EMPNO NUMBER(4) NOT NULL,
ENAME VARCHAR2(10) NOT NULL,
JOB VARCHAR2(9),
DEPTNO NUMBER(2));

INSERT INTO EMP04
VALUES(NULL,NULL,'영업부',30);

-- UNIQUE

CREATE TABLE EMP05(
EMPNO NUMBER(4) UNIQUE,
ENAME VARCHAR2(10) NOT NULL,
JOB VARCHAR2(9),
DEPTNO NUMBER(2));

INSERT INTO EMP05
VALUES(3333,'김씨','영업부',30);

INSERT INTO EMP05
VALUES(3333,'박씨','영업부',30);

--PRIMARY KEY
-- 위에 둘 모두 갖고있는 제약조건
-- 기본키라서 한번만 가능

-- * FOREIGN KEY    -- 개념이 어려움
-- 외래키
-- 부모키
-- REFERENCES 참조테이블명(참조할컬럼);

-- CHECK
-- 정해진값만 들어가게 설정
CREATE TABLE EMP08(
EMPNO NUMBER(4) PRIMARY KEY,
ENAME VARCHAR2(10) NOT NULL,
SAL NUMBER(7,2) CHECK(SAL BETWEEN 200 AND 1000), -- 200 에서 1000사이 값만 가능
GENDER VARCHAR2(1) CHECK (GENDER IN('M','F')),  -- M , F만 쓸수있음
DEPTNO NUMBER(2) REFERENCES DEPT(DEPTNO));      -- DEPT(DEPTNO)를 참조

-- DEFAULT
-- 컬럼에 아무런 값이 안들어갈때 NULL 대신 넣고싶은 값을 정할때 사용
ALTER TABLE DEPT02
MODIFY(LOC VARCHAR2(13) DEFAULT'서울');   -- NULL 값 대신 서울로 설정

INSERT INTO DEPT02 (DEPTNO, DNAME)
VALUES(50,'영업부');

-- 제약 조건 지정하기
-- 컬럼 레벨 제약 조건
-- 컬럼을 하나 정의하면서 뒤에 제약조건 붙이기
-- 컬럼 레벨이 편함

-- 테이블 레벨 제약 조건
-- 컬럼을 모두 정의하고 나서 마무리 짓기전 생성된 컬럼들에 제약조건 붙이기
-- NOT NULL 은 테이블 레벨에서 조건을 못붙임
-- 정석은 CONSTRAINT 테이블명_컬럼명_PK(짧은 키네임)_ 키 풀네임(컬럼명) -- 굳이 이렇게 안해도됨


-- 제약 조건 비활성화
-- 제약 조건 활성화 


-- CASCADE
-- 부모 테이블과 자식 테이블간 참조 설정이 되어있을때 부모 테이블 제약 조건을 비활성화하면
-- 자식 테이블도 비활성화 시켜주는 옵션
-- 제약 조건을 삭제할때도 같이 삭제됨


