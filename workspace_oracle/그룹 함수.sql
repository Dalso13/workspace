-- �׷� �Լ�
--SUM   �׷��� ���� �հ� ��ȯ
--AVG       ��� ��ȯ
--COUNT     �÷� ���� ��ȯ
--MAX       �ִ밪 ��ȯ
--MIN       �ּҰ� ��ȯ

SELECT SUM(SAL)  FROM EMP;
SELECT SUM(COMM)  FROM EMP; -- NULL �� ���꿡 �ȵ�

SELECT AVG(SAL)  FROM EMP;

SELECT MAX(SAL)  FROM EMP;
SELECT MIN(SAL)  FROM EMP;    

SELECT ENAME, MAX(SAL)  FROM EMP;   -- �׷� �Լ� �Ϲ� �÷��� ���� ����

-- COUNT �÷� ���� ��ȯ
SELECT COUNT(*),COUNT(COMM) FROM EMP;  
SELECT COUNT(DISTINCT JOB) FROM EMP; -- DISTINCT �ߺ�����

-- GROUP BY �׷� �Լ��� ������ ������(� �÷����� �������� ����) 
-- �Ϲ� �÷��� ���� ���� ����
SELECT DEPTNO FROM EMP 
GROUP BY deptno;

SELECT DEPTNO, AVG(sal) 
FROM EMP 
GROUP BY deptno; -- DEPTNO �� ������ �޿� ��� ���ϰ� DEPTNO �� ���� ���

SELECT DEPTNO, MAX(SAL),MIN(SAL)
FROM EMP 
GROUP BY deptno;    -- �ִ� �ּ�

SELECT DEPTNO, COUNT(*),COUNT(COMM)
FROM EMP 
GROUP BY deptno;    -- DEPTNO �÷� ������ COMM ���� �ִ� �÷� ���� ��Ÿ����

SELECT job, SUM(sal) ,COUNT(*) AS �ο���
FROM EMP 
GROUP BY JOB
ORDER BY MAX(SAL) DESC;

-- HAVING : �׷��� ����� �����Ҷ� ���� WHERE ��� �����ϸ� �� WHERE �� ���ӻ��� �ٸ�
SELECT DEPTNO, AVG(SAL) FROM EMP
GROUP BY DEPTNO HAVING AVG(SAL) >= 500;   -- �μ����� �׷� ��� �޿� ��� �ٵ� ����� 500�̻���


SELECT DEPTNO, MAX(SAL),MIN(SAL) FROM EMP
GROUP BY DEPTNO
HAVING MAX(SAL) <= 500; -- �μ��� �ִ� �޿� �ּ� �޿� ��� �ٵ� �ִ밡 500������



--1
SELECT  MAX(SAL),MIN(SAL),SUM(SAL),ROUND(AVG(SAL),0) FROM EMP;

--2
SELECT JOB,MAX(SAL),MIN(SAL),SUM(SAL),ROUND(AVG(SAL),0)  FROM EMP
GROUP BY JOB;

--3
SELECT JOB,COUNT(JOB) FROM EMP
GROUP BY JOB;

--4
SELECT mgr, COUNT(EMPNO) FROM EMP
GROUP BY MGR
HAVING MGR IS NOT NULL
ORDER BY MGR;

--5
SELECT MAX(SAL) - MIN(SAL) FROM EMP;

--6
SELECT JOB,MIN(SAL) FROM EMP
GROUP BY JOB
HAVING MIN(SAL) < 500;

--7
SELECT DEPTNO,COUNT(ENAME),ROUND(AVG(SAL),2) FROM EMP
GROUP BY DEPTNO
ORDER BY deptno ASC;

--8
SELECT
    deptno, COUNT(ename), round(AVG(sal), 2),
    
    decode(deptno, '10', '�渮��', '20', '�λ��',
           '30', '������', '40', '�����') AS ��,
           
    decode(deptno, '10', '����', '20', '��õ',
           '30', '����', '40', '����')   AS ����
           
FROM emp
GROUP BY deptno;
