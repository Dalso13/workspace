-- DESC : ���̺� ������ Ȯ���ϴ� ��ɾ�
DESC emp;

-- NUMBER : �����ϰ� �����ؼ� ���� ������ Ÿ��
-- DATE : ��¥ ������ Ÿ��
-- CHAR : ���� ���� Ÿ��(���̸� ������)  VARCHAR2 : CHAR�� ������ ���̰� ������ �������� 
-- NULL : ZERO ���� �ƴ϶� ��Ȯ��, �˼����� ��

-- ���
SELECT
    * FROM DEPT;
    
SELECT
    * FROM EMP;

-- ��� ���
SELECT
    SAL,JOB FROM EMP;

-- ��� ����   
SELECT
    ename, SAL,SAL*12 FROM EMP;

SELECT  ename, SAL, JOB, COMM, SAL*12 , SAL*12+comm
    FROM EMP;

-- NVL NULL �� ġȯ 
SELECT  ename, nvL(COMM, 0)
    FROM EMP;    

-- �� AS "" ���� ����    AS ���� ����, �ֵ���ǥ ���� ���� BUT �ֵ���ǥ ������ ������ �빮��
SELECT  ename AS "�̸�", SAL AS "����", JOB AS "����", nvL(COMM, 0) AS "������", SAL*12 AS "���� ", SAL*12+nvL(COMM, 0) AS "���� + ������"
    FROM EMP;  
    
-- ���� �����ҋ� || ������ ���
SELECT ENAME ||' is a ' || JOB FROM EMP;

-- �ߺ� ���� DISTINCT
SELECT DISTINCT JOB FROM EMP;

--
SELECT ENAME, SAL, HIREDATE FROM EMP;

SELECT DEPTNO AS "�μ���ȣ" ,DNAME AS "�μ���" FROM DEPT;
    
SELECT DISTINCT JOB FROM EMP;

-- ���ǹ� WHERE ���ڿ�, ��¥�� ''�� ���α�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE ENAME = '����';
SELECT * FROM EMP WHERE hiredate >= '03/09/01';

-- AND OR NOT �� ���� �״�� ����   NOT �� != ��������.
SELECT * FROM EMP WHERE DEPTNO = 10 AND JOB = '���';
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = '���';
SELECT * FROM EMP WHERE DEPTNO = 10 AND NOT JOB = '���';

-- ���� ���� ����ϱ����� BETWEEN (200<= SAL AND 300>= SAL) �� ����
SELECT * FROM EMP WHERE SAL BETWEEN 200 AND 300;

-- 200���� �۰� 300���� ū��
SELECT * FROM EMP WHERE SAL < 200 OR SAL > 300;
SELECT * FROM EMP WHERE SAL NOT BETWEEN 200 AND 300;

-- IN ������ : OR ������ ���� ���ϰ�
SELECT * FROM EMP WHERE SAL = 300 OR SAL = 500 OR SAL = 1000;
SELECT * FROM EMP WHERE SAL IN(300,500,1000);

-- *** �߿� ***   LIKE ������ : �÷��� LIKE % // LIKE _ 
SELECT * FROM EMP WHERE ename LIKE '��%';
SELECT * FROM EMP WHERE ename LIKE '_��_';

-- NULL �� ã�� ������ IS NULL �ݴ�� IS NOT NULL
SELECT * FROM EMP WHERE COMM IS NULL;
SELECT * FROM EMP WHERE COMM IS NOT NULL;

-- ���� ���� : �������� ASC , �������� DESC , ���� ORDER BY �߰� �� ���
SELECT * FROM EMP ORDER BY hiredate DESC;
SELECT * FROM EMP ORDER BY hiredate ASC;    -- ASC�� �Ƚᵵ �Ǵµ� ���°� ����
SELECT * FROM EMP ORDER BY SAL ASC;
SELECT * FROM EMP ORDER BY SAL DESC;

-- ���Ŀ� ���� : ���� ù��° ���Ŀ��� ��ġ�� �κ��� �ι�°���� ����
SELECT * FROM EMP ORDER BY SAL DESC , ename ASC;

--
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL <= 300;
SELECT EMPNO,ENAME,SAL FROM EMP WHERE ename = '����ȣ';
--3
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL = 250 OR SAL = 300 OR SAL = 500;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL IN(250,300,500);
--4
SELECT * FROM EMP WHERE SAL != 250 AND SAL != 300 AND SAL != 500;
SELECT * FROM EMP WHERE SAL NOT IN(250,300,500);
--5
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '��%' OR ENAME LIKE '%��%';
--6
SELECT * FROM EMP WHERE MGR IS NULL;
--7
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP ORDER BY hiredate ASC;

-- �׽�Ʈ �� ���̺�
SELECT * FROM DUAL;

-- �����Լ�
-- ABS  ���밪 ����  ũ�⸸ ��Ÿ�� (���� �Է½� ����� ���)
-- FLOOR    �Ҽ��� �Ʒ��� �߶�
-- ROUND    Ư�� �ڸ��� �ݿø�
SELECT 34.5678, ROUND(34.5678, -1) FROM DUAL; -- 1�� �ڸ� �ݿø� 10,100�� ����
-- TRUNC    Ư�� �ڸ��� ����
-- MOD      ������ ������ ��ȯ (�ڹٿ��� % ���°Ŷ� ����)

-- ���� ó�� �Լ�
-- SUBSTR ���ڿ� ������  == �ڹ� SUBSTRING
SELECT SUBSTR('ABCDEFG',3,4) FROM DUAL; -- (������ġ, ���� ����)
SELECT SUBSTR('ABCDEFG',-3,3) FROM DUAL; -- ���̳ʽ� ���� ���� �ڿ��� ""��°
-- TRIM ���� �Ǵ� Ư�� ���� �߶󳾼�����

-- ��¥ �Լ�
--SYSDATE �ý��� ��¥ ��ȯ

-- �� ��ȯ �Լ�
-- TO_CHAT ��¥�� OR �������� ���������� ��ȯ
-- TO_DATE �������� ��¥������ ��ȯ
-- TO_NUMBER �������� ���������� ��ȯ

select sysdate, to_char(sysdate, 'YYYY-MM-DD') FROM DUAL;
SELECT hiredate, TO_CHAR(hiredate,'YY/MON/DD DY') FROM EMP ORDER BY hiredate;

-- TO CHAR
SELECT SAL, TO_CHAR(SAL,'L999,999') FROM EMP;

--TO DATE
SELECT ENAME,HIREDATE FROM EMP WHERE hiredate = TO_DATE('20040108','YYYYMMDD');
SELECT TRUNC(SYSDATE - TO_DATE('2020/01/01','YYYY/MM/DD')) FROM DUAL;

-- TO NUMBER
SELECT TO_NUMBER('20,000', '99,999')- TO_NUMBER('10,000','99,999')FROM DUAL;

-- DECODE ���ǹ� : �ڹ� SWITC���̶� �������
SELECT ENAME, DEPTNO, DECODE(deptno, 10, 'ACCOUNTING',
                                    20, 'RESEARCH', 
                                    30, 'SALES',
                                    40, 'OPERATIONS')
                                    AS DNAME
    FROM EMP;
    
-- CASE ���ǹ� : �ڹ� IF ELSE �� ������ ���� WHEN,THEN
SELECT ENAME, DEPTNO, CASE
WHEN DEPTNO = 10 THEN 'ACCOUNTING'
WHEN DEPTNO = 20 THEN 'RESEARCH'
WHEN DEPTNO = 30 THEN 'SALES'
WHEN DEPTNO = 40 THEN 'OPERATIONS'
END -- ������ END
FROM EMP;

SELECT * FROM EMP;

-- 1
SELECT * FROM EMP WHERE SUBSTR(hiredate,4,2) = '10';
SELECT * FROM EMP WHERE hiredate LIKE '%%/10/%%';
-- 2
SELECT * FROM EMP WHERE SUBSTR(hiredate,1,2) = '03';
SELECT * FROM EMP WHERE hiredate LIKE '03/%%/%%';
-- 3
SELECT * FROM EMP WHERE SUBSTR(ENAME,3,1) = '��';
SELECT * FROM EMP WHERE ENAME LIKE '%%��';
-- 4
SELECT ENAME,JOB, SAL,DECODE(JOB, '����', SAL + SAL * (5/100),
                                   '����', SAL + SAL * (5/100), 
                                    '����', SAL + SAL * (1/10),
                                   '�븮', SAL + SAL * (15/100),
                                   '���', SAL + SAL * (2/10) )
                                    AS SAL1
    FROM EMP;
-- 5
SELECT ENAME,hiredate , TO_CHAR(hiredate,'YYYY/MON/DD')AS �⵵ FROM EMP ORDER BY hiredate;
 