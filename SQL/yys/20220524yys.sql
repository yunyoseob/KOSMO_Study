-- 20220524

-- NATURAL JOIN
-- 14���� ��ȸ�ȴ�. 
SELECT  E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL,  E.COMM
                  ,DEPTNO, D.DNAME, D.LOC
FROM EMP E NATURAL JOIN DEPT D
ORDER BY DEPTNO, E.EMPNO;

-- JOIN~USING
-- �Ȱ��� 14���� ��ȸ�ȴ�. DEPTNO��� ���� �����Ͽ���.(���ؿ�)
SELECT  E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL,  E.COMM
                  ,DEPTNO, D.DNAME, D.LOC
FROM EMP E JOIN DEPT D USING (DEPTNO)
ORDER BY DEPTNO, E.EMPNO;


-- FROM�� USING��  ������� ����ϸ� ORA-01748 : ���� �� ��ü�� ����� �� �ִٰ� ǥ�õȴ�.
SELECT  E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL,  E.COMM
                  ,DEPTNO, D.DNAME, D.LOC
FROM EMP E JOIN DEPT D USING (E.DEPTNO)
ORDER BY DEPTNO, E.EMPNO;

-- ORA-25155 : NATURAL ���ο� ���� ���� �ĺ��ڸ� ���� �� ����.
SELECT A.*, B.*
FROM EMP  A NATURAL JOIN DEPT B;


SELECT A.*, B.*
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO;

-- JOIN ~ ON
-- 13���� ��ȸ�Ǿ���.
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM
                ,E.DEPTNO, D.DNAME, D.LOC
FROM EMP E JOIN DEPT D ON (E.DEPTNO=D.DEPTNO)
WHERE SAL <= 3000
ORDER BY E.DEPTNO, EMPNO;


-- VIEW ����

-- ���� ���̺��� �����մϴ�.
CREATE TABLE EMP02
AS
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP;

SELECT*FROM EMP02;

CREATE VIEW VIEW_EMP02
AS
SELECT *
FROM EMP02
WHERE DEPTNO=10;
-- ORA-01031 : ������ ������մϴ�. ���� ����.

-- cmd����  sqlplus system/1234
-- �Է� ��, show user �Է����� ��, USER�� "SYSTEM"�Դϴ�
-- ��� ���� �� ����
-- grant create view to scott; ��ɾ �Է��ϸ�
-- ������ �ο��ȴ�.
-- �� ������ ���� ��ɾ �ٽ� �Է��ϸ� View VIEW_EMP02�� �����ȴ�.

SELECT*FROM EMP02;

-- �� ����
SELECT A.EMPNO, A.ENAME, A.SAL, B.DEPTNO, B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND A.DEPTNO=10;
-- 3���� �����Ͱ� ��ȸ�ȴ�.


CREATE VIEW VIEW_EMP_DEPT
AS
SELECT A.EMPNO, A.ENAME, A.SAL, B.DEPTNO, B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND A.DEPTNO=10;

INSERT INTO VIEW_EMP_DEPT
VALUES(8001, 'AAAA', 4000, 10, 'ACCNT');
-- SQL ���� : ORA-17776 : ���� �信 ���Ͽ� �ϳ� �̻��� �⺻ ���̺��� ������ �� �����ϴ�.

-- �� ������ �÷����� ������ �� �ִ�.
CREATE OR REPLACE VIEW VIEW_EMP02_CCL(�����ȣ, �����, �޿�, �μ���ȣ)
AS
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP02;

SELECT*FROM VIEW_EMP02_CCL;


-- �並 ���� ���� ��
CREATE OR REPLACE VIEW VIEW_EMP02_CCL_1
AS
SELECT EMPNO AS E_1, ENAME AS E_2, SAL AS E_3, DEPTNO AS E_4
FROM EMP02;

SELECT*FROM VIEW_EMP02_CCL_1;
SELECT E_1 FROM VIEW_EMP02_CCL_1;


SELECT A.*, B.*
FROM EMP  A, DEPT B
WHERE A.DEPTNO=B.DEPTNO;

-- �⺻ ���̺��� ������ ���� �ɼ� �ֱ�
-- �⺻���̺��� ������ VIEW�� ���� �� ���� ? FALSE

-- ���� : NOFORCE(DEFALUT)�� ��쿡�� �´� ��, �⺻ ���̺��� ������, ���� ���� ����
-- �׷���, FORCE ��ɾ ����, �⺻ ���̺��� ��� �並 ������ �� �ֱ� ������ FALSE��� �� �� �ִ�.

-- ORA-00942 : ���̺� �Ǵ� �䰡 �������� �ʽ��ϴ�.
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP02_NOTABLE
WHERE ROWNUM<=3;

-- �̷� ��Ȳ���� VIEW�� �����ϰ��� �Ѵٸ�?
-- ���������� ORA-00942 : ���̺� �Ǵ� �䰡 �������� �ʽ��ϴ�.
CREATE OR REPLACE VIEW VIEW_EMP02_1
AS
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP02_NOTABLE
WHERE ROWNUM<=3;

SELECT*FROM 

-- FORCE : �⺻ ���̺��� ��� USER_VIEW ������ ������ �並 �����Ѵ�.
CREATE OR REPLACE FORCE VIEW VIEW_EMP02_2
AS
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP02_NOTABLE
WHERE ROWNUM<=3;
-- ACTION : ��� : ������ ������ �Բ� �䰡 �����Ǿ����ϴ�.

-- ��ȸ�� ���� �ʴ´�.
SELECT*FROM VIEW_EMP02_2;
-- ORA-04063: view "SCOTT.VIEW_EMP02_2"�� ������ �ֽ��ϴ�
-- 04063. 00000 -  "%s has errors"
-- *Action:   Fix the errors and/or create referenced objects as necessary.

-- WITH CHECK OPTION
CREATE OR REPLACE VIEW VIEW_EMP03
AS
SELECT EMPNO, ENAME, DEPTNO, JOB
FROM EMP
WHERE JOB LIKE 'MANAGER' WITH CHECK OPTION;

SELECT*FROM VIEW_EMP03;

INSERT INTO VIEW_EMP03
VALUES(9000, 'ABC',30, 'SALESMAN');
--  ORA-01402: ���� WITH CHECK OPTION�� ���ǿ� ���� �˴ϴ�


-- WITH READ ONLY : �б⸸ ����
-- ��κ��� ��� ����¸��� ������ ��
CREATE OR REPLACE VIEW VIEW_EMP04
AS
SELECT EMPNO, ENAME, DEPTNO, JOB
FROM EMP
WHERE JOB LIKE 'MANAGER' WITH READ ONLY;

SELECT*FROM VIEW_EMP04;

INSERT INTO VIEW_EMP04
VALUES(9000, 'ABC', 30, 'MANAGER');
-- SQL ����: ORA-42399: �б� ���� �信���� DML �۾��� ������ �� �����ϴ�.
-- 42399.0000 - "cannot perform a DML operation on a read-only view"


