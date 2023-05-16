-- ���� ����
-- ���� SELECT �ȿ� ���ԵǴ� �� �ϳ��� SELECT ����

-- ���� �� ���� ����
-- ���� ������ �ϳ��� �ο�(��)�� ���ö�
-- ���� ������ DEPTNO 20 �̶�� ���� ���ͼ� �װŶ� ���ؼ� ���
SELECT  ENAME, DEPTNO FROM EMP
WHERE deptno = (SELECT  DEPTNO 
                FROM EMP
                WHERE ENAME = '����'); -- == WHERE DEPTNO = 20

--1
SELECT * FROM EMP
WHERE JOB = (SELECT JOB
             FROM EMP
             WHERE ENAME = '����');  -- == WHERE JOB = '���'

--2
SELECT ENAME,SAL FROM EMP
WHERE SAL >= (SELECT SAL
             FROM EMP
             WHERE ENAME = '����')
AND ENAME != '����'
ORDER BY SAL ASC;

--3
SELECT ENAME,SAL FROM EMP
WHERE DEPTNO = (SELECT DEPTNO
                FROM DEPT
                WHERE LOC = '����');

-- INNER JOIN ���� �Ẹ��
SELECT ENAME,SAL FROM EMP INNER JOIN DEPT
ON EMP.DEPTNO = DEPT.DEPTNO
WHERE DEPT.LOC = '����';

SELECT * FROM EMP;

--3
SELECT ENAME, SAL FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP
             WHERE ENAME = '�嵿��');
             
-- ���� �������� �׷� �Լ� ���
SELECT ENAME, SAL FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP);

-- ���� �� ���� ���� 

-- IN ������   OR ���� �� ����
SELECT ENAME, SAL, DEPTNO FROM EMP
WHERE DEPTNO IN (SELECT DISTINCT DEPTNO FROM EMP
                 WHERE SAL>= 400);

-- ALL ������  ���� �� ���� ���� ū���̶� ��
SELECT ENAME, SAL
FROM EMP
WHERE SAL> ALL (SELECT SAL
                FROM EMP
                WHERE DEPTNO = 30);
                
-- ANY ������  ���� ���� ���̶� ��  *�� �Ⱦ�
SELECT ENAME,SAL
FROM EMP
WHERE SAL> ANY (SELECT SAL
                FROM EMP
                WHERE DEPTNO=30);
                
--1
SELECT * FROM EMP
WHERE SAL IN (SELECT MAX(SAL) FROM EMP
              GROUP BY DEPTNO);
              
--2
SELECT * FROM DEPT
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP
                 WHERE JOB = '����');

--3
SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > ALL (SELECT SAL FROM EMP
WHERE JOB = '����');

SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > (SELECT MAX(SAL) FROM EMP
WHERE JOB = '����');

--4
SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > ANY (SELECT SAL FROM EMP
WHERE JOB = '����');

SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP
WHERE JOB = '����');
                 