-- ��
-- ���� ���̺�
-- �⺻ ���̺��� �Ļ��� ��ü, �⺻ ���̺� ���� �ϳ��� ����
-- ����ڿ��� �־��� �並 ���ؼ� �⺻ ���̺��� ���������� ���
-- ���� ������ ���̺��� �����ؼ� ī�Ǻ����� ������ �⺻���̺�� ����ϸ� ����
-- ���������� ���簡 �ȉ�

-- create or replace view

-- create view �ε� ����ص� ������ ������ �ٲܶ� ��ٷο�
-- force �⺻ ���̺��� ���� ���� ������� �並 ����

-- WITH CHECK OPTION
-- �並 ���ؼ� ���� �ִ� ���� ������ UPDATE �Ǵ� INSERT ����

-- WHITH READ ONLY
-- SELECT �� ���� 
-- �̰� �����ϸ� �並 ����Ͽ� DML ��� �� ��밡�� (UPDATE,INSERT,DELETE)

-- �� �������
-- ���̺��� �����ؼ� ���� ��������� �� ��ɵ��� ��� ���� ��밡��

CREATE VIEW EMP_VIEW30
AS
SELECT EMPNO, ENAME, DEPTNO
FROM EMP_COPY
WHERE DEPTNO= 30;

SELECT * FROM emp_view30;

CREATE VIEW EMP_VIEW20
AS
SELECT EMPNO,ENAME,DEPTNO,MGR FROM EMP_COPY
WHERE DEPTNO = 20;

SELECT * FROM EMP_VIEW20;

-- ��� ���̺� ����ü�� �����ϴ°� �ƴ϶�
-- �� ���� ���� SELECT ������ �����ϴ°�

-- ������ ���� �� ���
SELECT VIEW_NAME, TEXT
FROM USER_VIEWS;

-- VIEW �� INSERT �ϱ�
-- �׷��� �⺻ ���̺��� ������ ��
INSERT INTO EMP_VIEW30
VALUES(1111,'AAAA',30);

SELECT * FROM EMP_COPY;


-- ���� ����
-- �ܼ���  �Ѱ��� ���̺�
-- ���պ�  ������ ���̺�

INSERT INTO EMP_VIEW30
VALUES(8000,'��õ��',30);
SELECT * FROM EMP_VIEW30;

SELECT * FROM EMP_COPY;

-- �÷��� �ѱ�ȭ �ؼ� �� �����
CREATE OR REPLACE
VIEW EMP_VIEW(�����ȣ,�����,�޿�,�μ���ȣ)
AS
SELECT EMPNO,ENAME,SAL,DEPTNO
FROM EMP_COPY;

SELECT * FROM emp_view
WHERE �μ���ȣ=30;

-- �׷� �Լ� ���
CREATE VIEW VIEW_SAL
AS
SELECT DEPTNO,SUM(SAL) AS "SALSUM", AVG(SAL) AS "SALAVG"
FROM EMP_COPY
GROUP BY DEPTNO;

SELECT * FROM VIEW_SAL;

-- ���� ��, INNER JOIN ���
CREATE VIEW EMP_VIEW_DEPT
AS
SELECT E.EMPNO,E.ENAME,E.SAL, E.DEPTNO, D.DNAME, D.LOC
FROM EMP E INNER JOIN DEPT D
ON e.deptno = d.deptno
ORDER BY EMPNO DESC;

SELECT * FROM emp_view_dept;

--

CREATE VIEW SAL_VIEW(�̸�,�ִ�޿�,�ּұ޿�)
AS
SELECT D.DNAME, MAX(E.SAL),MIN(E.SAL) FROM EMP E INNER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
GROUP BY D.DNAME;

SELECT * FROM SAL_VIEW;

-- �� ����
-- �⺻ ���̺��� ������ ����
DROP VIEW VIEW_SAL;

-- OR REPLACE
-- �������� ���� �� �̸� ���ο� �並 �����ϰ� ������ �����ϴ� ���̸� ���뺯��
-- ����� ����?
CREATE OR REPLACE VIEW EMP_VIEW30
AS
SELECT EMPNO, ENAME, SAL, COMM, DEPTNO
FROM EMP_COPY
WHERE DEPTNO = 30;

SELECT * FROM EMP_VIEW30;

-- FORCE
-- �⺻ ���̺��� �������� �ʴ� ��쿡�� �並 �����ؾ��Ҷ�
-- �並 �����Ҷ� �⺻������ NOFORCE �ɼ��� ������

CREATE OR REPLACE FORCE VIEW EMPLOYEES_VIEW -- FORCE �� ������ ������
AS
SELECT EMPNO, ENAME, DEPTNO
FROM EMPLOYEES
WHERE DEPTNO = 30;  -- ������ ������ ��� ������


-- READ ONLY
-- �並 ���� �⺻ ���̺� ���� ������ ���ϰ� �ϴ°�
-- �並 ���鶧 �� �������� WITH READ ONLY ���ָ� ��

-- �ζ��� ��
-- ROWNUM �� INSERT �� ������� ���ڰ� �Ű���
SELECT ROWNUM, EMPNO, ename, C
FROM EMP
ORDER BY hiredate;

-- ������ ������ ��� ��������� ROWNUM�� �缳����
CREATE OR REPLACE VIEW VIEW_HIRE
AS
SELECT EMPNO, ename, hiredate
FROM EMP
ORDER BY hiredate;

SELECT ROWNUM,ENAME,hiredate FROM VIEW_HIRE
WHERE ROWNUM <=5;

-- ���� ������ �غ���
SELECT ROWNUM, EMPNO, ename, HIREDATE   -- ���⼭ ����Ҷ��� ROWNUM �缳�� ��
FROM ( SELECT EMPNO, ENAME, HIREDATE    -- �ȿ����� ROWNUM�� ���׹���������
        FROM EMP
        ORDER BY hiredate)
WHERE ROWNUM <= 5;                  

-- ���� ������
SELECT ROWNUM AS "RANKING" , EMPNO, ENAME, SAL
FROM ( SELECT EMPNO, ENAME, SAL
        FROM EMP
        ORDER BY SAL DESC)
WHERE ROWNUM <= 3;

-- ���
CREATE OR REPLACE VIEW RANKING_SAL
AS
SELECT EMPNO, ENAME, SAL
FROM EMP
ORDER BY SAL DESC;

SELECT ROWNUM AS "RANKING" , EMPNO, ENAME, SAL
FROM RANKING_SAL
WHERE ROWNUM <= 3;