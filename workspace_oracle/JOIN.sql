-- JOIN

-- ����Ŭ ���� JOIN �� ������ 
-- �������� ���Ǵ� ANSI JOIN ���ַ� �ʱ���

-- ���̺� ��Ī �ֱ�
-- from �� ���̺� �ڿ� ���ϴ� ��Ī ����
-- from table t inner join table2 t2


-- inner join
-- ������ ���̺�� �� ���
-- inner join ���� on�� ���
SELECT * FROM emp INNER join dept
on emp.deptno = dept.deptno
where ename = '����';

-- outer join
-- ���ʿ��� �����Ͱ� �ְ� �ٸ��ʿ��� �����Ͱ� ������ ���
-- ������ ����� �ȵǴµ� ����� �ǰ� �ϱ����� ���
-- ���̺� �ڿ� �ٴ� �¿� Ȯ���� ��� �������� ���� ���ϴ°�
-- SELECT * FROM table1 LEFT    -- left , right, full ���
-- OUTER JOIN table2;

-- �ӽ� ���̺� �����
CREATE TABLE DEPT01(
 DEPTNO NUMBER(2),
 DNAME VARCHAR2(14));
 
INSERT INTO DEPT01 VALUES(10, 'ACCOUNTING');
INSERT INTO DEPT01 VALUES(20, 'RESEARCH');

CREATE TABLE DEPT02(
 DEPTNO NUMBER(2),
 DNAME VARCHAR2(14));
 
INSERT INTO DEPT02 VALUES(10, 'ACCOUNTING');
INSERT INTO DEPT02 VALUES(30, 'SALES');

-- ���� ���̺� ����� Ȯ������
COMMIT;

SELECT *
FROM DEPT01 inner JOIN DEPT02
ON DEPT01.DEPTNO = DEPT02.DEPTNO;

-- (���� ���̺��� ����)LEFT OUTER JOIN
SELECT *
FROM DEPT01 LEFT OUTER JOIN DEPT02
ON DEPT01.DEPTNO = DEPT02.DEPTNO;

-- INNER �� �����͸� ���
-- OUTER �� ������ �Ǵ� ���̺� �������� ��� ���

--1
SELECT emp.ename,emp.hiredate FROM EMP INNER JOIN DEPT
ON emp.deptno = dept.deptno
WHERE DEPT.DNAME = '�渮��';

--2
SELECT e.ename,e.SAL FROM EMP E inner JOIN DEPT D      
ON e.deptno = d.deptno
WHERE d.loc = '��õ'
ORDER BY SAL ASC;

    