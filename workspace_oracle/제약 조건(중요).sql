-- *** 12.�������� *** --

-- ���Ἲ ���� ����
-- �������� �ڷᰡ �ԷµǴ°� ����

--* NOT NULL     NULL X
--* UNIQUE       �ߺ��Ǵ°� X
--* PRIMARY KEY  NULL, �ߺ��Ǵ°� X
-- FOREIGN KEY  �����Ǵ� ���̺��� �÷��� ���� �����ϸ� ���
-- CHEAK        ���� ������ ������ ���� ������ ������ �����Ͽ� ������ ���� ���


SELECT * FROM DEPT;
INSERT INTO DEPT VALUES(10,'TEST','TEST');

DESC DEPT;

-- ���� ���� Ȯ��
DESC USER_CONSTRAINTS;
-- �߿��� �÷�
-- CONSTRAINT_TYPE
-- P  : PRIMARY KEY
-- R  : FOREIGN KEY
-- U  : UNIQUE
-- C  : CHECK, NOT NULL

SELECT * FROM USER_CONS_COLUMNS;

-- NOT NUL
INSERT INTO EMP03 VALUES(NULL,NULL,'������',30);
SELECT * FROM EMP03;

CREATE TABLE EMP04(
EMPNO NUMBER(4) NOT NULL,
ENAME VARCHAR2(10) NOT NULL,
JOB VARCHAR2(9),
DEPTNO NUMBER(2));

INSERT INTO EMP04
VALUES(NULL,NULL,'������',30);

-- UNIQUE

CREATE TABLE EMP05(
EMPNO NUMBER(4) UNIQUE,
ENAME VARCHAR2(10) NOT NULL,
JOB VARCHAR2(9),
DEPTNO NUMBER(2));

INSERT INTO EMP05
VALUES(3333,'�达','������',30);

INSERT INTO EMP05
VALUES(3333,'�ھ�','������',30);

--PRIMARY KEY
-- ���� �� ��� �����ִ� ��������
-- �⺻Ű�� �ѹ��� ����

-- * FOREIGN KEY    -- ������ �����
-- �ܷ�Ű
-- �θ�Ű
-- REFERENCES �������̺��(�������÷�);

-- CHECK
-- ���������� ���� ����
CREATE TABLE EMP08(
EMPNO NUMBER(4) PRIMARY KEY,
ENAME VARCHAR2(10) NOT NULL,
SAL NUMBER(7,2) CHECK(SAL BETWEEN 200 AND 1000), -- 200 ���� 1000���� ���� ����
GENDER VARCHAR2(1) CHECK (GENDER IN('M','F')),  -- M , F�� ��������
DEPTNO NUMBER(2) REFERENCES DEPT(DEPTNO));      -- DEPT(DEPTNO)�� ����

-- DEFAULT
-- �÷��� �ƹ��� ���� �ȵ��� NULL ��� �ְ���� ���� ���Ҷ� ���
ALTER TABLE DEPT02
MODIFY(LOC VARCHAR2(13) DEFAULT'����');   -- NULL �� ��� ����� ����

INSERT INTO DEPT02 (DEPTNO, DNAME)
VALUES(50,'������');

-- ���� ���� �����ϱ�
-- �÷� ���� ���� ����
-- �÷��� �ϳ� �����ϸ鼭 �ڿ� �������� ���̱�
-- �÷� ������ ����

-- ���̺� ���� ���� ����
-- �÷��� ��� �����ϰ� ���� ������ ������ ������ �÷��鿡 �������� ���̱�
-- NOT NULL �� ���̺� �������� ������ ������
-- ������ CONSTRAINT ���̺��_�÷���_PK(ª�� Ű����)_ Ű Ǯ����(�÷���) -- ���� �̷��� ���ص���


-- ���� ���� ��Ȱ��ȭ
-- ���� ���� Ȱ��ȭ 


-- CASCADE
-- �θ� ���̺�� �ڽ� ���̺� ���� ������ �Ǿ������� �θ� ���̺� ���� ������ ��Ȱ��ȭ�ϸ�
-- �ڽ� ���̺� ��Ȱ��ȭ �����ִ� �ɼ�
-- ���� ������ �����Ҷ��� ���� ������


