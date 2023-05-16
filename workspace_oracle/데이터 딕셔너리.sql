-- 데이터 딕셔너리
-- DBA_XXXX   데이터 베이스 관리자만 접근 가능한 객체 정보 조회
-- ALL_XXXX   자신 계정 소유 또는 권한을 부여 받은 객체 등에 관한 정보 조회
-- USER_XXXX   자신의 계정이 소유한 객체 

-- USER 데이터 딕셔너리
-- 데이터 딕셔너리 뷰 USER_TABLES 구조 확인
DESC USER_TABLES;

-- 현재 사용자 조회
SHOW USER;

-- 테이블 네임들 출력
SELECT TABLE_NAME FROM USER_TABLES
ORDER BY  TABLE_NAME DESC;

--1
CREATE TABLE DEPT_MISSION(
    DNO    NUMBER(2),
    DNAME  VARCHAR2(14),
    LOC    VARCHAR2(13)
);

CREATE TABLE EMP_MISSION(
    ENO    NUMBER(4),
    ENAME  VARCHAR2(10),
    DNO    VARCHAR2(2)
);

DESC dept_mission;
DESC emp_mission;

--2
ALTER TABLE EMP_MISSION
MODIFY(ENAME VARCHAR2(25));

DROP TABLE EMP_MISSION;

--3
ALTER TABLE DEPT_MISSION
DROP COLUMN DNAME;