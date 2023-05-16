-- ������
-- ���̺� ���� ������ ���ڸ� �ڵ����� �����ϴ� �ڵ� ��ȣ �߻���
-- �⺻ Ű�� ����ϸ� ������� �δ��� ���� �� �ִ�.

-- CREATE SEQUENCE ������ ����
--      ���ǵ�~

-- ����

-- START WITH
-- ��� ���� �����Ұ���
-- START WITH ������ ����

-- INCREMENT BY
-- �ѹ� �����Ҷ� �� ��������
-- INCREMENT BY ������ ����

CREATE SEQUENCE DEPT_DEPTNO_SEQ
INCREMENT BY 10 START WITH 10;

-- ������ ���
SELECT * FROM USER_SEQUENCES;

-- CURRVAL  ������ ���簪 ��ȯ
-- NEXTVAL  ������ ������ ��ȯ

SELECT DEPT_DEPTNO_SEQ.NEXTVAL FROM DUAL;

SELECT DEPT_DEPTNO_SEQ.CURRVAL FROM DUAL;

CREATE SEQUENCE EMP_SEQ
INCREMENT BY 1 MAXVALUE 100000 START WITH 1;

CREATE TABLE EMP01(
EMPNO NUMBER(4) PRIMARY KEY,
ENAME VARCHAR2(10),
HIREDATE DATE
);

INSERT INTO EMP01
VALUES(EMP_SEQ.NEXTVAL,'�达',SYSDATE);

SELECT * FROM EMP01;

CREATE TABLE DEPT_EXAMPLE(
DEPTNO NUMBER(4) PRIMARY KEY,
DNAME VARCHAR2(15),
LOC VARCHAR2(15)
);

CREATE SEQUENCE DEPT_EXAMPLE_SEQ
INCREMENT BY 10 START WITH 10;

INSERT INTO dept_example
VALUES(DEPT_EXAMPLE_SEQ.NEXTVAL,'�����','����');

SELECT * FROM DEPT_EXAMPLE;

-- �ε���
-- SQL ��ɹ��� ó�� �ӵ��� ���ñ� ���� �÷��� �����ؼ� �����Ѵ�
-- �ʹ����̾��� ������ ���� ���ϰ� ��
-- ���� �˻��� ���� �ȴٰ� �����ϸ� ����

-- �ε����� ����ؾ� �ϴ� ���
-- ���̺� ���� ���� ������
-- JOIN�� ���� ���Ǵ� �÷��̳� NULL�� �����ϴ� �÷��� ���� ���


-- CREATE INDEX �ε��� ����
-- ON ���̺� ����(�÷� ����);

SELECT TABLE_NAME, INDEX_NAME, COLUMN_NAME
FROM USER_IND_COLUMNS
WHERE TABLE_NAME IN('EMP','EMP01');

CREATE INDEX IDX_EMP01_ENAME
ON EMP01(ENAME);

DROP INDEX IDX_EMP01_ENAME;


