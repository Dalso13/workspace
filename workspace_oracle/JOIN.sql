-- JOIN

-- 오라클 전용 JOIN 도 많지만 
-- 공통으로 사용되는 ANSI JOIN 위주로 필기함

-- 테이블에 별칭 주기
-- from 뒤 테이블 뒤에 원하는 별칭 쓰기
-- from table t inner join table2 t2


-- inner join
-- 여러개 테이블로 값 출력
-- inner join 이후 on절 사용
SELECT * FROM emp INNER join dept
on emp.deptno = dept.deptno
where ename = '김사랑';

-- outer join
-- 한쪽에는 데이터가 있고 다른쪽에는 데이터가 없을때 사용
-- 원래는 출력이 안되는데 출력이 되게 하기위해 사용
-- 테이블 뒤에 붙는 좌우 확인은 어떤걸 기준으로 할지 정하는것
-- SELECT * FROM table1 LEFT    -- left , right, full 사용
-- OUTER JOIN table2;

-- 임시 테이블 만들기
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

-- 위에 테이블 만든거 확정짓기
COMMIT;

SELECT *
FROM DEPT01 inner JOIN DEPT02
ON DEPT01.DEPTNO = DEPT02.DEPTNO;

-- (왼쪽 테이블을 기준)LEFT OUTER JOIN
SELECT *
FROM DEPT01 LEFT OUTER JOIN DEPT02
ON DEPT01.DEPTNO = DEPT02.DEPTNO;

-- INNER 는 같은것만 출력
-- OUTER 는 기준이 되는 테이블 기준으로 모두 출력

--1
SELECT emp.ename,emp.hiredate FROM EMP INNER JOIN DEPT
ON emp.deptno = dept.deptno
WHERE DEPT.DNAME = '경리부';

--2
SELECT e.ename,e.SAL FROM EMP E inner JOIN DEPT D      
ON e.deptno = d.deptno
WHERE d.loc = '인천'
ORDER BY SAL ASC;

    