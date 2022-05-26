-- ����Ŭ ������Ʈ
-- WITH�� 
-- ����Ŭ 9 ���� �������� ��� ����
-- �ӽ� ���̺��� ���� �� �������ȿ����� ����
-- ���� ���� ���� �ݺ������� SQL���� ����� ��� 
-- �� ���� �̸��� �ο��Ͽ� ����

WITH EXAMPLE AS (SELECT 'WITH��' AS STR1 FROM DUAL)
SELECT * FROM EXAMPLE;

-- ���� WITH ��
WITH EXAMPLE1 AS ( --ù��° WITH��
                    SELECT 'EX1' A FROM DUAL 
                    UNION ALL
                    SELECT 'EX2' FROM DUAL
                    ), 
EXAMPLE2 AS ( --�ι�° WITH��
                SELECT 'EX3' A FROM DUAL 
                UNION ALL
                SELECT A FROM EXAMPLE1 --ù��° WITH�� ����
             )
SELECT * FROM EXAMPLE2;


WITH EMP_W AS (SELECT DEPTNO, SUM(SAL) AS SAL FROM EMP GROUP BY DEPTNO)
SELECT A.DEPTNO, B.DNAME, A.SAL
FROM   EMP_W A, DEPT B
WHERE  A.DEPTNO = B.DEPTNO;

WITH EMP_W_1 AS (SELECT DEPTNO, AVG(SAL) AS SAL_AVG FROM EMP GROUP BY DEPTNO),
     EMP_W_2 AS (SELECT JOB, AVG(SAL) AS SAL_AVG FROM EMP GROUP BY JOB)
SELECT  A.ENAME, A.JOB, A.SAL,
        B.SAL_AVG AS DEPT_AVG,
        C.SAL_AVG AS JOB_AVG
FROM EMP A, EMP_W_1 B, EMP_W_2 C
WHERE A.EMPNO = 7788
AND   A.DEPTNO = B.DEPTNO
AND   A.JOB = C.JOB;

SELECT  A.ENAME, A.JOB, A.SAL, A.DEPTNO
FROM    EMP A
WHERE A.EMPNO = 7788;

WITH DEPT_TEMP AS (SELECT DEPTNO, DNAME FROM DEPT),
     EMP_TEMP AS (SELECT ENAME, DEPTNO, SAL FROM EMP),
     CNT_DEPT_TEMP AS (SELECT COUNT(DEPTNO) AS CNT FROM DEPT_TEMP)
SELECT  A.DNAME, B.ENAME, B.SAL, C.CNT
FROM    DEPT_TEMP A, EMP_TEMP B, CNT_DEPT_TEMP C
WHERE   A.DEPTNO = B.DEPTNO;


-- INDEX : ���� : ������� : ���� A, B, C ... , �ѱ� ���� : ���� ��, ��, �� ....
-- ����Ŭ �����ͺ��̽����� INDEX ���� ���(��ȸ �ӵ� ���)���� �糯�� �� 
SELECT  TABLE_NAME, INDEX_NAME, COLUMN_NAME
FROM    USER_IND_COLUMNS
WHERE   TABLE_NAME IN ('EMP', 'DEPT');

--���̺� ������ �����̸Ӹ� Ű(PK)�� �����ϸ�
--����Ŭ �������� �ڵ����� �ε����� �����Ѵ�. 
--�����ϴ� �̸��� SYS_  ���ξ� + C + 0000000 ��Ģ���� �����Ѵ�. 
--SYS_C0011065 : SYS  ���ξ� + C + 0000000
CREATE TABLE INDEX_TEST_1 (
    INDEX_1 NUMBER PRIMARY KEY 
);
SELECT  TABLE_NAME, INDEX_NAME, COLUMN_NAME
FROM    USER_IND_COLUMNS
WHERE   TABLE_NAME IN ('INDEX_TEST_1');

-- PK ������ �ڵ����� �ý��ۿ��� �ý����� �ε����� �����ϱ� ������
-- ����� ���Ƿ� �ε����� ������ �� ����. 
CREATE INDEX INDEX_TEST_1_111 ON INDEX_TEST_1(INDEX_1);

-- �ε��� �����ϱ� 
CREATE TABLE T2 (
    T2_1 NUMBER,
    T2_2 VARCHAR2(10)
);

--���� �ε���
CREATE INDEX INDEX_T2_T2_1 ON T2(T2_1);
--���� �ε���
CREATE INDEX INDEX_T2_T2_1_T2_2 ON T2(T2_1, T2_2);

/*
���� ���ǵ� ��
CONNECT ��
    -- Releas 9.0 ����
    ALTER SESSION
    CREATE CLUSTER
    CREATE DATABASE LINK
    CREATE SEQUENCE
    CREATE SESSION
    CREATE SYNONYM
    CREATE TABLE
    CREATE VIEW 
    -- Release 11.2 ����
    CREATE SESSION
RESOURCE ��
    CREATE CLUSTER
    CREATE PROCEDURE
    CREATE SEQUENCE
    CREATE TABLE
    CREATE TRIGGER

DAB �� 
*/


--����Ŭ�� �����Ϳ� ������ ���� ���� SYSTEM �Ǵ� SYS �������� �Ѵ�. 
SHOW USER;

-- ���������ϱ� 
-- �����̸� : test01
-- ������й�ȣ : 1234
--CREATE USER : ������ �����ϴ� Ű���� 
--IDENTIFIED BY : ��й�ȣ�� �����ϴ� Ű���� 
--CREATE USER ������ IDENTIFIED BY ��й�ȣ 
CREATE USER test01 IDENTIFIED BY 1234;

--C:\Users\KOSMO>sqlplus test01/1234
--ERROR:
--ORA-01045: user TEST01 lacks CREATE SESSION privilege; logon denied
--
--ORA-01045 : ����Ŭ �����ڵ� 
--����Ŭ �����ڵ带 ���ͳݿ��� �˻��ؼ� ������ ������Ѵ�. 

--��ó�� ������ �����ϸ� 
--�޶� ������ �����Ǳ� ������ 
--������� 
--���̺� ���� ������ �ο��ؾ� �Ѵ�. �ش��ϴ� ������ 

--������� �ֱ� 
--GRANT CREATE SESSION TO : �������� ���� ������ �ִ� ����
GRANT CREATE SESSION TO test01;

--C:\Users\KOSMO>sqlplus test01/1234
--������ ���ӵ�:
--Oracle Database 11g Enterprise Edition Release 11.2.0.1.0 - 64bit Production
--With the Partitioning, OLAP, Data Mining and Real Application Testing options
--
--SQL>

--���̺� ���� ������ �ο��ؾ� �Ѵ�. �ش��ϴ� ������ 
GRANT CREATE TABLE TO test01;

--Grant��(��) �����߽��ϴ�.

--���̺� �����̽� ���� 
ALTER USER test01 QUOTA UNLIMITED ON USERS;

--���� �����ؼ� ���̺� ����� 
--1. system/1234 �α���
--2. ��������� 
--CREATE USER test02 IDENTIFIED BY 1234;
--��й�ȣ �ٲٱ� 
--ALTER USER test02 IDENTIFIED BY 1234;
--3. ���� ���� �ο�
--GRANT CREATE SESSION TO test02;
--4. ���̺� ���� ���� �ο�
--GRANT CREATE TABLE TO test02;
--5. ���̺� �����̽� ������ ���� : 2M, 5M, 10M, UNLIMITED �� 
--ALTER USER test01 QUOTA UNLIMITED ON USERS;
--6. ������ �������� �α��� �ؼ� ���̺� �����ϱ� 
--CREATE TABLE T1_TABLE (
--    TESTCOLUMN1 VARCHAR2(20) 
--   ,TESTCOLUMN2 VARCHAR2(200)
--);

--test02/1234 ��������� 
--T2_TABLE ���̺� ����� 
--T2_COLUMN1 VARCHAR2(20)
--T2_COLUMN2 VARCHAR2(200)  
CREATE USER test02 IDENTIFIED BY 1234;
GRANT CREATE SESSION TO test02;
GRANT CREATE TABLE TO test02;
ALTER USER test02 QUOTA UNLIMITED ON USERS;

SELECT *
FROM   DBA_USERS
WHERE  USERNAME IN 'test02'


-- ���̺� �����̽��� ���ؼ� 
-- ����Ŭ����
SELECT * FROM V$VERSION;

-- ��ü ���̺� �����̽�
SELECT * FROM DBA_TABLESPACES;
SELECT * FROM DBA_DATA_FILES;

SELECT TABLESPACE_NAME, CONTENTS FROM DBA_TABLESPACES;

-- �ӽ� ���̺� �����̽�
SELECT * FROM DBA_TEMP_FILES;

-- ���� ������ DEFAULT TABLESPACE Ȯ�� 
SELECT * FROM USER_USERS;

--#############################################################
--���� ���� �� ���̺����̽� ���ϱ� 
CREATE USER test03 -- ��������� 
IDENTIFIED BY 1234 -- ��й�ȣ �����
DEFAULT TABLESPACE USERS -- DEFAULT TABLESPACE �� USER ��Ű���� ���� �⺻ ���̺����̽��� �����Ѵ�.
TEMPORARY TABLESPACE TEMP; --  TEMPORARY TABLESPACE�� USER �ӽ� ���̺����̽��� �����Ѵ�. 
-- ���������� �����Ǿ��ٸ� ���̺� �����̽� ������ �����Ѵ�. 

-- QUOTA ���� ����Ͽ� USER�� ����� ���̺����̽��� ������ �Ҵ��Ѵ�. 
-- UNLIMITED : ������ �������, 2M, 5M, 10M �� 
ALTER USER test03 DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

-- ���ҽ� ���Ѱ� ���� ������ ���̵� �ο��Ѵ�. 
GRANT resource, connect TO test03;

--CONNECT ��
--Releas 11.2 ����
--CREATE SESSION 
--Releas 9.0 ����
--ALTER SESSION, CREATE CLUSTER, CREATE DATABASE LINK, CREATE SEQUENCE, CREATE SESSION,
--CREATE SYNONYM, CREATE TABLE, CREATE VIEW

--RESOURCE �� 
--����ڰ� ��ü(���̺�, ��, �ε���)�� ������ �� �ֵ��� �ϱ� ���ؼ� ������ ������ ���� ���� 
--CREATE CLUSTER
--CREATE PROCEDURE
--CREATE SEQUENCE
--CREATE TABLE
--CREATE TRIGGER 

--CONN test03/124
--SELECT * FROM USER_ROLE_PRIVS;

--SELECT * FROM USER_SYS_PRIVS;

--####################################################


--hbe00/hbe1234 ��������� 
CREATE USER hbe00 IDENTIFIED BY hbe1234
DEFAULT TABLESPACE USERS -- DEFAULT TABLESPACE �� USER ��Ű���� ���� �⺻ ���̺����̽��� �����Ѵ�.
TEMPORARY TABLESPACE TEMP; --  TEMPORARY TABLESPACE�� USER �ӽ� ���̺����̽��� �����Ѵ�. 

GRANT CREATE SESSION TO hbe00;
GRANT CREATE TABLE TO hbe00;

ALTER USER hbe00 QUOTA 2M ON USERS;
-- ALTER USER hbe00 QUOTA UNLIMITED ON USERS;








