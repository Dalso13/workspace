-- *** Ʈ�����
-- ������ ó���� �� ����
-- ������ �۾� ���� �������� �ϰ����� �����ϸ鼭 ���������� �����͸� ���� ��Ű������ ���
-- ALL-OR-NOTHING

--COMMIT , ROLLBACK
-- DML���� ��� 
-- COMMIT ���ݱ��� �۾��Ѱ� ���� ����
-- ROLLBACK ���������� Ŀ���� �������� ���ư���

-- OUTO COMMIT
DELETE FROM DEPT02
WHERE DEPTNO = 40;
COMMIT;

SELECT * FROM DEPT02;

CREATE TABLE DEPT03
AS
SELECT * FROM DEPT; -- ���̺��� ���鶧 �ڵ����� ���� Ŀ���� �ȴ�
ROLLBACK;

-- SAVE POINT
-- SAVEPOINT LABEL_NAME;
-- ROLLBACK TO LABEL_NAME;
SELECT * FROM DEPT02;

DELETE FROM DEPT02
WHERE DEPTNO = 30;

SAVEPOINT S1;

DELETE FROM DEPT02
WHERE DEPTNO = 20;

SAVEPOINT S2;

DELETE FROM DEPT02
WHERE DEPTNO = 10;

SAVEPOINT S3;

ROLLBACK TO S1;
ROLLBACK TO S2;

