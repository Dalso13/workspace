-- DDL  
-- 테이블 과 같은 데이터 구조 정의에 사용되는 언어
-- 테이블 생성, 수정 , 초기화, 삭제


--ROWID 행의 위치를 지정하는 주소값 * 몰라도 됨
SELECT ROWID,EMPNO, ENAME FROM EMP;


-- CREATE TABLE
-- CREATE TABLE (
-- 컬럼 이름 데이터 타입)

CREATE TABLE EMP01 (
    EMPNO NUMBER(2),
    ENAME VARCHAR2(10),
    HEIGHT NUMBER(3),
    ADDRESS VARCHAR2(10),
    PHONE VARCHAR2(12)
);
    
INSERT INTO EMP01 VALUES(10,'장동완',170,'시흥시','01093413389');
INSERT INTO EMP01 VALUES(11,'김동완',171,'시흥시','01093413388');

SELECT * FROM EMP01;
    
    
-- 서브쿼리로 테이블 복사하기

-- 모두 복사
CREATE TABLE EMP02
AS
SELECT  * FROM EMP;

-- 컬럼만 선택해서 복사
CREATE TABLE EMP03
AS
SELECT EMPNO, ENAME FROM EMP;

-- 로우(행)만 선택해서 복사
CREATE TABLE EMP04
AS
SELECT * FROM EMP
WHERE deptno = 10;

-- 서브 쿼리로 테이블 구조만 복사
CREATE TABLE EMP05
AS
SELECT * FROM EMP
WHERE 1 = 0;       -- 값이 거짓이기 때문에 구조만 출력되고 구조만 복사  

-- 1
CREATE TABLE EMP06
AS
SELECT EMPNO, ENAME, SAL FROM EMP;
SELECT * FROM emp06;


-- 테이블 수정

-- 컬럼 추가
--ALTER TABLE 테이블 명
--ADD(컬럼 명 데이터 타입,)
ALTER TABLE EMP01
ADD(JOB VARCHAR2(9));

SELECT * FROM EMP01;
DESC EMP01;

-- 컬럼 수정
-- 중요할때 아니면 사용하지 말자 위험한 행위
-- 사전에 설계를 잘하도록 하자
--ALTER TABLE 테이블 명
--MODIFY(컬럼 명 데이터 타입,)

ALTER TABLE EMP01
MODIFY(JOB VARCHAR2(30));

-- 컬럼 삭제
--ALTER TABLE 테이블 명
--DROP COLUMN 컬럼 명

ALTER TABLE EMP01
DROP COLUMN JOB;

-- 테이블 삭제
-- DROP TABLE 테이블 명

DROP TABLE EMP01;

-- SET UNUSED   * 중요하진 않음
-- 삭제하는 것이 아닌 사용을 제한 하는것
--ALTER TABLE 테이블 명
--SET UNUSED(컬럼 명)

-- 커밋 롤백
-- 커밋은 데이터 변경한것들 저장
-- 롤백은 마지막 커밋한곳으로 되돌리기

-- TRUNCATE
-- 기존에 사용하던 테이블의 모든 로우를 제거하기 위한 멍령어
-- 테이블은 초기상태로 만든다
-- 전체삭제만 가능하고 * 롤백이 불가능하다
-- TRUNCATE TABLE 테이블 명;
TRUNCATE TABLE EMP06;

-- RENAME
-- 기존 테이블 이름 변경
-- RENAME OLD_NAME TO NEW_NAME
RENAME EMP06 TO TEST;