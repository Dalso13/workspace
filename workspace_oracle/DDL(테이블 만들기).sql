-- DDL  
-- ���̺� �� ���� ������ ���� ���ǿ� ���Ǵ� ���
-- ���̺� ����, ���� , �ʱ�ȭ, ����


--ROWID ���� ��ġ�� �����ϴ� �ּҰ� * ���� ��
SELECT ROWID,EMPNO, ENAME FROM EMP;


-- CREATE TABLE
-- CREATE TABLE (
-- �÷� �̸� ������ Ÿ��)

CREATE TABLE EMP01 (
    EMPNO NUMBER(2),
    ENAME VARCHAR2(10),
    HEIGHT NUMBER(3),
    ADDRESS VARCHAR2(10),
    PHONE VARCHAR2(12)
);
    
INSERT INTO EMP01 VALUES(10,'�嵿��',170,'�����','01093413389');
INSERT INTO EMP01 VALUES(11,'�赿��',171,'�����','01093413388');

SELECT * FROM EMP01;
    
    
-- ���������� ���̺� �����ϱ�

-- ��� ����
CREATE TABLE EMP02
AS
SELECT  * FROM EMP;

-- �÷��� �����ؼ� ����
CREATE TABLE EMP03
AS
SELECT EMPNO, ENAME FROM EMP;

-- �ο�(��)�� �����ؼ� ����
CREATE TABLE EMP04
AS
SELECT * FROM EMP
WHERE deptno = 10;

-- ���� ������ ���̺� ������ ����
CREATE TABLE EMP05
AS
SELECT * FROM EMP
WHERE 1 = 0;       -- ���� �����̱� ������ ������ ��µǰ� ������ ����  

-- 1
CREATE TABLE EMP06
AS
SELECT EMPNO, ENAME, SAL FROM EMP;
SELECT * FROM emp06;


-- ���̺� ����

-- �÷� �߰�
--ALTER TABLE ���̺� ��
--ADD(�÷� �� ������ Ÿ��,)
ALTER TABLE EMP01
ADD(JOB VARCHAR2(9));

SELECT * FROM EMP01;
DESC EMP01;

-- �÷� ����
-- �߿��Ҷ� �ƴϸ� ������� ���� ������ ����
-- ������ ���踦 ���ϵ��� ����
--ALTER TABLE ���̺� ��
--MODIFY(�÷� �� ������ Ÿ��,)

ALTER TABLE EMP01
MODIFY(JOB VARCHAR2(30));

-- �÷� ����
--ALTER TABLE ���̺� ��
--DROP COLUMN �÷� ��

ALTER TABLE EMP01
DROP COLUMN JOB;

-- ���̺� ����
-- DROP TABLE ���̺� ��

DROP TABLE EMP01;

-- SET UNUSED   * �߿����� ����
-- �����ϴ� ���� �ƴ� ����� ���� �ϴ°�
--ALTER TABLE ���̺� ��
--SET UNUSED(�÷� ��)

-- Ŀ�� �ѹ�
-- Ŀ���� ������ �����Ѱ͵� ����
-- �ѹ��� ������ Ŀ���Ѱ����� �ǵ�����

-- TRUNCATE
-- ������ ����ϴ� ���̺��� ��� �ο츦 �����ϱ� ���� �۷ɾ�
-- ���̺��� �ʱ���·� �����
-- ��ü������ �����ϰ� * �ѹ��� �Ұ����ϴ�
-- TRUNCATE TABLE ���̺� ��;
TRUNCATE TABLE EMP06;

-- RENAME
-- ���� ���̺� �̸� ����
-- RENAME OLD_NAME TO NEW_NAME
RENAME EMP06 TO TEST;