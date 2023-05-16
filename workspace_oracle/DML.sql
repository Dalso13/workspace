-- DML
-- ���̺� ������ �˻� ���� ���� ����
-- �ѹ� ����
-- SELECT   �˻�  R
-- INSERT   �߰�  C
-- UPDATE   ����  U
-- DELETE   ����  D

-- INSERT
--INSERT INTO ���̺��
--(�÷� �̸�,...)
--VALUES(�÷� ������,....)
SELECT * FROM DEPT01;

INSERT INTO DEPT01
(deptno,dname,LOC)
VALUES(10,'������','�λ�');
-- �÷� ��ο� ������ �Է��ҰŸ� �÷����� �����ص� ��

--2
CREATE TABLE SAM01(
    EMPNO   NUMBER(4),
    ENAME   VARCHAR2(10),
    JOB     VARCHAR2(9),
    sal     NUMBER(7,2));

DESC SAM01;

INSERT INTO SAM01
(EMPNO,ENAME,JOB,SAL)   -- ���� ����
VALUES(1000,'���','����',1000);

INSERT INTO SAM01
(EMPNO,ENAME,JOB,SAL)
VALUES(1010,'�ٳ���','��ȣ��',1500);

INSERT INTO SAM01
(EMPNO,ENAME,JOB,SAL)
VALUES(1020,'������','�ǻ�',2000);

SELECT * FROM SAM01;

-- null �� ����

-- �Ͻ��� ���
-- �÷��� ����Ʈ�� null�� �ְ���� �÷��� ���� , �ٸ� �÷��� ���� �Է�
INSERT INTO DEPT01
(deptno,dname)
VALUES(10,'������');   -- LOC�� ����

-- ����� ���
-- VALUES ���� NULL �Է�
INSERT INTO DEPT01
(deptno,dname,LOC)
VALUES(10,'������',NULL); -- �Ǵ� �� ���ڿ� '' �ֱ�


--3
SELECT * FROM SAM01;

INSERT INTO SAM01
(empno,ENAME,JOB,SAL)
VALUES(1030,'����',NULL,2500);

INSERT INTO SAM01
(EMPNO,ENAME,JOB,SAL)
VALUES(1040,'����',NULL,25000);

-- ���� ������ ������ ����
-- ���̺��̶� ���������� ������ ���ƾ���
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
-- ������ ����
-- ����Ҷ� �����ϰ� ����ؾ���
-- ( UPDATE ���̺��
--  SET �÷�1 = ��1, �÷�2 = ��2,.....
--  WHERE ����; )  -- WHERE ������ �� ���������Ѵ� �����ϸ� ��� ���� �ٲ�

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

-- ���� �÷� �� ����
UPDATE EMP01
SET DEPTNO = 10, JOB = '����' -- ������ ������ ���� , �ٿ��� �־��ֱ�
WHERE ENAME = '�ѿ���';    -- ���������� ���ǵ� ������ ���� ������ AND,OR,NOT

SELECT * FROM DEPT02;

-- ���� ���� �̿��ؼ� ������Ʈ
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
                WHERE LOC = '��õ');

SELECT * FROM SAM02;


-- DELETE
--DELETE FROM ���̺��
--WHERE ����      -- WHERE �����ϸ� ������ ��� ����

-- DELETE �����ʹ� ���������� �뷮�� �״�� ���ϴ� �����͸� ������ְ� �ѹ鰡��
-- TRUNCATE ������ �� �ε����� ��� �����ϰ� �뷮�� �ٰ� �ѹ� �Ұ��� -- ���̺��� ���� ����
-- DROP ���̺� ��ü�� ���� �ѹ� �Ұ���

DELETE FROM SAM01
WHERE JOB IS NULL;

SELECT * FROM SAM01;

-- 1
DELETE FROM SAM02
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT
                WHERE  DNAME = '������');
SELECT * FROM SAM02;




