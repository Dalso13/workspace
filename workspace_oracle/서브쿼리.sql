-- 서브 쿼리
-- 메인 SELECT 안에 포함되는 또 하나의 SELECT 문장

-- 단일 행 서브 쿼리
-- 서브 쿼리가 하나의 로우(행)만 나올때
-- 서브 쿼리에 DEPTNO 20 이라는 값이 나와서 그거랑 비교해서 출력
SELECT  ENAME, DEPTNO FROM EMP
WHERE deptno = (SELECT  DEPTNO 
                FROM EMP
                WHERE ENAME = '김사랑'); -- == WHERE DEPTNO = 20

--1
SELECT * FROM EMP
WHERE JOB = (SELECT JOB
             FROM EMP
             WHERE ENAME = '김사랑');  -- == WHERE JOB = '사원'

--2
SELECT ENAME,SAL FROM EMP
WHERE SAL >= (SELECT SAL
             FROM EMP
             WHERE ENAME = '김사랑')
AND ENAME != '김사랑'
ORDER BY SAL ASC;

--3
SELECT ENAME,SAL FROM EMP
WHERE DEPTNO = (SELECT DEPTNO
                FROM DEPT
                WHERE LOC = '용인');

-- INNER JOIN 으로 써보기
SELECT ENAME,SAL FROM EMP INNER JOIN DEPT
ON EMP.DEPTNO = DEPT.DEPTNO
WHERE DEPT.LOC = '용인';

SELECT * FROM EMP;

--3
SELECT ENAME, SAL FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP
             WHERE ENAME = '장동건');
             
-- 서브 쿼리에서 그룹 함수 사용
SELECT ENAME, SAL FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP);

-- 다중 행 서브 쿼리 

-- IN 연산자   OR 형태 다 나옴
SELECT ENAME, SAL, DEPTNO FROM EMP
WHERE DEPTNO IN (SELECT DISTINCT DEPTNO FROM EMP
                 WHERE SAL>= 400);

-- ALL 연산자  다중 행 에서 가장 큰값이랑 비교
SELECT ENAME, SAL
FROM EMP
WHERE SAL> ALL (SELECT SAL
                FROM EMP
                WHERE DEPTNO = 30);
                
-- ANY 연산자  가장 작은 값이랑 비교  *잘 안씀
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
                 WHERE JOB = '과장');

--3
SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > ALL (SELECT SAL FROM EMP
WHERE JOB = '과장');

SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > (SELECT MAX(SAL) FROM EMP
WHERE JOB = '과장');

--4
SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > ANY (SELECT SAL FROM EMP
WHERE JOB = '과장');

SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP
WHERE JOB = '과장');
                 