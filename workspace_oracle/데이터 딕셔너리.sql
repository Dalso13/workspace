-- ������ ��ųʸ�
-- DBA_XXXX   ������ ���̽� �����ڸ� ���� ������ ��ü ���� ��ȸ
-- ALL_XXXX   �ڽ� ���� ���� �Ǵ� ������ �ο� ���� ��ü � ���� ���� ��ȸ
-- USER_XXXX   �ڽ��� ������ ������ ��ü 

-- USER ������ ��ųʸ�
-- ������ ��ųʸ� �� USER_TABLES ���� Ȯ��
DESC USER_TABLES;

-- ���� ����� ��ȸ
SHOW USER;

-- ���̺� ���ӵ� ���
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