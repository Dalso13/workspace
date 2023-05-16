-- 뷰
-- 가상 테이블
-- 기본 테이블에서 파생된 객체, 기본 테이블에 대한 하나의 쿼리
-- 사용자에게 주어진 뷰를 통해서 기본 테이블을 제한적으로 사용
-- 원래 쓰려던 테이블을 복사해서 카피본으로 만든후 기본테이블로 사용하면 좋음
-- 제약조건은 복사가 안됌

-- create or replace view

-- create view 로도 사용해도 되지만 구조를 바꿀때 까다로움
-- force 기본 테이블의 존재 여부 상관없이 뷰를 생성

-- WITH CHECK OPTION
-- 뷰를 통해서 볼수 있는 범위 내에서 UPDATE 또는 INSERT 가능

-- WHITH READ ONLY
-- SELECT 만 가능 
-- 이걸 생략하면 뷰를 사용하여 DML 기능 다 사용가능 (UPDATE,INSERT,DELETE)

-- 뷰 사용이유
-- 테이블이 복잡해서 자주 사용하지만 긴 기능들을 뷰로 만들어서 사용가능

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

-- 뷰는 테이블 그자체를 저장하는게 아니라
-- 위 문장 같이 SELECT 쿼리를 저장하는것

-- 유저가 만든 뷰 출력
SELECT VIEW_NAME, TEXT
FROM USER_VIEWS;

-- VIEW 에 INSERT 하기
-- 그러면 기본 테이블에도 적용이 됌
INSERT INTO EMP_VIEW30
VALUES(1111,'AAAA',30);

SELECT * FROM EMP_COPY;


-- 뷰의 종류
-- 단순뷰  한개의 테이블
-- 복합뷰  여러개 테이블

INSERT INTO EMP_VIEW30
VALUES(8000,'김천사',30);
SELECT * FROM EMP_VIEW30;

SELECT * FROM EMP_COPY;

-- 컬럼명 한글화 해서 뷰 만들기
CREATE OR REPLACE
VIEW EMP_VIEW(사원번호,사원명,급여,부서번호)
AS
SELECT EMPNO,ENAME,SAL,DEPTNO
FROM EMP_COPY;

SELECT * FROM emp_view
WHERE 부서번호=30;

-- 그룹 함수 사용
CREATE VIEW VIEW_SAL
AS
SELECT DEPTNO,SUM(SAL) AS "SALSUM", AVG(SAL) AS "SALAVG"
FROM EMP_COPY
GROUP BY DEPTNO;

SELECT * FROM VIEW_SAL;

-- 복합 뷰, INNER JOIN 사용
CREATE VIEW EMP_VIEW_DEPT
AS
SELECT E.EMPNO,E.ENAME,E.SAL, E.DEPTNO, D.DNAME, D.LOC
FROM EMP E INNER JOIN DEPT D
ON e.deptno = d.deptno
ORDER BY EMPNO DESC;

SELECT * FROM emp_view_dept;

--

CREATE VIEW SAL_VIEW(이름,최대급여,최소급여)
AS
SELECT D.DNAME, MAX(E.SAL),MIN(E.SAL) FROM EMP E INNER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
GROUP BY D.DNAME;

SELECT * FROM SAL_VIEW;

-- 뷰 삭제
-- 기본 테이블에는 영향을 안줌
DROP VIEW VIEW_SAL;

-- OR REPLACE
-- 존재하지 않은 뷰 이면 새로운 뷰를 생성하고 기존에 존재하는 뷰이면 내용변경
-- 덮어쓰기 개념?
CREATE OR REPLACE VIEW EMP_VIEW30
AS
SELECT EMPNO, ENAME, SAL, COMM, DEPTNO
FROM EMP_COPY
WHERE DEPTNO = 30;

SELECT * FROM EMP_VIEW30;

-- FORCE
-- 기본 테이블이 존재하지 않는 경우에도 뷰를 생성해야할때
-- 뷰를 생성할때 기본적으로 NOFORCE 옵션이 지정됨

CREATE OR REPLACE FORCE VIEW EMPLOYEES_VIEW -- FORCE 가 없으면 에러남
AS
SELECT EMPNO, ENAME, DEPTNO
FROM EMPLOYEES
WHERE DEPTNO = 30;  -- 에러가 났지만 뷰는 생성함


-- READ ONLY
-- 뷰를 통해 기본 테이블 내용 변경을 못하게 하는것
-- 뷰를 만들때 맨 마지막에 WITH READ ONLY 써주면 됌

-- 인라인 뷰
-- ROWNUM 은 INSERT 한 순서대로 숫자가 매겨짐
SELECT ROWNUM, EMPNO, ename, C
FROM EMP
ORDER BY hiredate;

-- 정렬한 쿼리를 뷰로 만들어지면 ROWNUM이 재설정됌
CREATE OR REPLACE VIEW VIEW_HIRE
AS
SELECT EMPNO, ename, hiredate
FROM EMP
ORDER BY hiredate;

SELECT ROWNUM,ENAME,hiredate FROM VIEW_HIRE
WHERE ROWNUM <=5;

-- 서브 쿼리로 해보기
SELECT ROWNUM, EMPNO, ename, HIREDATE   -- 여기서 출력할때는 ROWNUM 재설정 됨
FROM ( SELECT EMPNO, ENAME, HIREDATE    -- 안에서의 ROWNUM은 뒤죽박죽이지만
        FROM EMP
        ORDER BY hiredate)
WHERE ROWNUM <= 5;                  

-- 서브 쿼리로
SELECT ROWNUM AS "RANKING" , EMPNO, ENAME, SAL
FROM ( SELECT EMPNO, ENAME, SAL
        FROM EMP
        ORDER BY SAL DESC)
WHERE ROWNUM <= 3;

-- 뷰로
CREATE OR REPLACE VIEW RANKING_SAL
AS
SELECT EMPNO, ENAME, SAL
FROM EMP
ORDER BY SAL DESC;

SELECT ROWNUM AS "RANKING" , EMPNO, ENAME, SAL
FROM RANKING_SAL
WHERE ROWNUM <= 3;