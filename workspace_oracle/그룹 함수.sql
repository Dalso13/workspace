-- 그룹 함수
--SUM   그룹의 누적 합계 반환
--AVG       평균 반환
--COUNT     컬럼 개수 반환
--MAX       최대값 반환
--MIN       최소값 반환

SELECT SUM(SAL)  FROM EMP;
SELECT SUM(COMM)  FROM EMP; -- NULL 은 연산에 안들어감

SELECT AVG(SAL)  FROM EMP;

SELECT MAX(SAL)  FROM EMP;
SELECT MIN(SAL)  FROM EMP;    

SELECT ENAME, MAX(SAL)  FROM EMP;   -- 그룹 함수 일반 컬럼은 같이 못씀

-- COUNT 컬럼 개수 반환
SELECT COUNT(*),COUNT(COMM) FROM EMP;  
SELECT COUNT(DISTINCT JOB) FROM EMP; -- DISTINCT 중복제거

-- GROUP BY 그룹 함수에 기준을 정해줌(어떤 컬럼값을 기준으로 할지) 
-- 일반 컬럼과 같이 쓰기 가능
SELECT DEPTNO FROM EMP 
GROUP BY deptno;

SELECT DEPTNO, AVG(sal) 
FROM EMP 
GROUP BY deptno; -- DEPTNO 로 묶은뒤 급여 평균 구하고 DEPTNO 랑 같이 출력

SELECT DEPTNO, MAX(SAL),MIN(SAL)
FROM EMP 
GROUP BY deptno;    -- 최대 최소

SELECT DEPTNO, COUNT(*),COUNT(COMM)
FROM EMP 
GROUP BY deptno;    -- DEPTNO 컬럼 개수랑 COMM 갖고 있는 컬럼 개수 나타내기

SELECT job, SUM(sal) ,COUNT(*) AS 인원수
FROM EMP 
GROUP BY JOB
ORDER BY MAX(SAL) DESC;

-- HAVING : 그룹의 결과를 제한할때 쓰는 WHERE 라고 생각하면 됨 WHERE 랑 쓰임새가 다름
SELECT DEPTNO, AVG(SAL) FROM EMP
GROUP BY DEPTNO HAVING AVG(SAL) >= 500;   -- 부서별로 그룹 평균 급여 출력 근데 평균이 500이상인


SELECT DEPTNO, MAX(SAL),MIN(SAL) FROM EMP
GROUP BY DEPTNO
HAVING MAX(SAL) <= 500; -- 부서당 최대 급여 최소 급여 출력 근데 최대가 500이하인



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
    
    decode(deptno, '10', '경리부', '20', '인사부',
           '30', '영업부', '40', '전산부') AS 팀,
           
    decode(deptno, '10', '서울', '20', '인천',
           '30', '용인', '40', '수원')   AS 지역
           
FROM emp
GROUP BY deptno;
