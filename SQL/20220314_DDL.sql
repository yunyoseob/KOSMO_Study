/*
SQL Structured Query Language ����ť��, ���� 

DQL Data Query Language ���̺��� �����͸� ��ȸ, �˻�
    SELECT

DML Data Manipulation Language ���̺��� �����͸� ����, ����, ����
    INSERT, UPDATE, DELETE
    DML ������ Ʈ������� ó���ؾ� �Ѵ�. 
	1. �޸𸮿� ����ȴ�.
	2. ROLLBACK : �޸𸮿� ����� ������ �����Ѵ�.
	3. COMMIT : �޸𸮿� ����� ���븦 ���Ͽ� �����Ѵ�. 
	4. �ܺ� �������α׷������� ���̺� ������ ���Ͽ� ����� ���븸 ��ȸ�� �����Ѵ�.
    
DDL Data Definition Language ���̺��� ������ ���� ��ü�� ����, ����, ����
    CREATE, ALTER, DROP
    DDL ������ Ʈ������� �ٷ� ����ȴ�. 
    
TCL Transaction Control Language Ʈ����� �������� ���� ����, ��� ��
    COMMIT, ROLLBACK, SAVEPOINT

DCL Data Control Language ������ ��� ���� �ο� �� ���
    GRANT, REVOKE
*/

-- DDL Data Definition Language ���̺��� ������ ���� ��ü�� ����, ����, ����
-- CREATE, ALTER, DROP

-- ���̺� ����� 
/*
CREATE TABLE [����].���̺��̸� (
    �÷���1 ������Ÿ��1(������)
   ,�÷���2 ������Ÿ��2
   ,�÷���3 ������Ÿ��3(������)
   ....
   ,�÷���N ������Ÿ��N(������)
);
*/
/*
����Ʈ ������ ���̺� �̸��� TEST_1 ���̺��� �����Ͻÿ� 
�÷� 4�� �̴�.
ù ��° �÷��� �̸��� TC1 �̰� ������ Ÿ���� ����2 �̰� ������� 10 �̴�.
�� ��° �÷��� �̸��� TC2 �̰� ������ Ÿ���� ����2 �̰� ������� 20 �̴�.
�� ��° �÷��� �̸��� TC3 �̰� ������ Ÿ���� �ѹ� �̰� ������� �⺻�� �̴�.
�� ��° �÷��� �̸��� TC4 �̰� ������ Ÿ���� DATE �̴�. DATE Ÿ���� ����� ���� �ʴ���.
*/

-- CREATE TABLE ��ɾ� : �����ͺ��̽� �������� ���̺� ������ ������ּ��� 
-- CREATE TABLE SCOTT.TEST_T1 : �����ͺ��̽� �������� ���ڵ� �������ٰ� TEST_T1 �̶�� ���̺��� ����� �ּ��� 
                       
CREATE TABLE SCOTT.TEST_T1 (
    TC1 VARCHAR2(10)
   ,TC2 VARCHAR2(20) 
   ,TC3 NUMBER
   ,TC4 DATE
);
-- CREATE TABLE SCOTT.TEST_T1

SELECT * FROM TAB;
DESC TEST_T1;

-- �ּ�
CREATE TABLE SCOTT.TEST_2 (
    TC2_1 NUMBER(7, 2)
   ,TC2_2 VARCHAR2(30)
   ,TC2_3 DATE
);
-- Table SCOTT.TEST_2��(��) �����Ǿ����ϴ�.

SELECT * FROM TAB;

-- ���̺� �̸� ������ ���� 
RENAME TEST_2 TO TEST_T2;
SELECT * FROM TAB;

CREATE TABLE TEST_T3 (
    T_NUM VARCHAR2(20) PRIMARY KEY 
   ,T_ID VARCHAR2(20) NOT NULL
   ,T_PW VARCHAR2(20) NOT NULL
   ,T_NAME VARCHAR2(50)    
   ,T_TEL VARCHAR2(16)       
   ,T_HP VARCHAR2(16)          
   ,T_ADDR VARCHAR2(200)             
   ,T_EMAIL VARCHAR2(100) NOT NULL            
   ,T_INSERTDATE DATE
   ,T_UPDATEDATE DATE
);

SELECT * FROM TAB;
DESC TEST_T3;


-- CREAT TABLE ~ AS ���� : ���� ���̺��� �̿��ؼ� ���̺� ����� �� 
-- ���� ���̺��� �����ϰ� �÷� �� �Ǵ� �÷� && �����͸� �����ϴ� ���̴�.
-- WHERE 1=1, WHERE 1=2
-- �� ������Ʈ�� ���簡 ���� ���� 
-- ������Ʈ : PRIMARY KEY, INDEX ..... etc 
CREATE TABLE EMP_T1 AS 
SELECT * FROM EMP WHERE 1=2;

SELECT * FROM EMP_T1;

CREATE TABLE EMP_T2 AS 
SELECT * FROM EMP WHERE 1=1;

SELECT * FROM EMP_T2;

SELECT * FROM TAB;

-- ���̺� ���� 
DROP TABLE TEST_T1;
-- Table TEST_T1��(��) �����Ǿ����ϴ�.

SELECT * FROM TAB;

-- ���̺� ����
SELECT * FROM TAB;
SELECT * FROM TEST_T2;
DESC TEST_T2;

-- ���̺� �÷� �߰� 
-- ����Ŭ���� ���̺� �÷��� �߰��ϸ� ���� �÷���  �� �ڿ� �÷��� �����ȴ�.  
ALTER TABLE TEST_T2 
ADD TT VARCHAR2(100);
SELECT * FROM TEST_T2;
DESC TEST_T2;

-- ���̺� �÷� �̸� ����
ALTER TABLE TEST_T2
RENAME COLUMN TT TO TT_RENAME;
SELECT * FROM TEST_T2;
DESC TEST_T2;

-- ���̺� �÷� ������ ����  
ALTER TABLE TEST_T2
MODIFY TT_RENAME VARCHAR2(50);
SELECT * FROM TEST_T2;
DESC TEST_T2;

-- ���̺� �÷� ���� 
ALTER TABLE TEST_T2
DROP COLUMN TT_RENAME;
SELECT * FROM TEST_T2;
DESC TEST_T2;


-- DML Data Manipulation Language ���̺��� �����͸� ����, ����, ����
--    INSERT, UPDATE, DELETE
--    DML ������ Ʈ������� ó���ؾ� �Ѵ�.
SELECT * FROM TAB;
DESC TEST_T2;
DESC TEST_T3;
DESC EMP_T1;
DESC EMP_T2;


-- ����Ŭ �����ͺ��̽����� INSERT ���� �����ϸ� �� ���� ������ �ؾ��Ѵ�.
-- INSERT INTO ~ VALUES �������� �μ�Ʈ�� ��û�ϸ� 
-- 1. ���� �޸𸮿� ������ �����Ѵ�.
-- �� ���¿��� SELECT �� �� �� �ִ�. 

-- COMMIT ����� �����ϸ�
-- 2. ���Ͽ� ���������� ������ �����Ѵ�. 
-- �ܺ� ���α׷�(�ڹ�)������ ���Ͽ� �ִ� ���븸 ��ȸ�� �����ϴ�. 

-- ���̺� TEST_T2 ���� ISUD CRUD �ϱ� 
-- INSERT INTO ���̺� VALUES ();
INSERT INTO TEST_T2 (TC2_1, TC2_2,         TC2_3)
             VALUES (1.3,   '����2 ���ڿ�',  SYSDATE); 
-- 1 �� ��(��) ���ԵǾ����ϴ�.
SELECT * FROM TEST_T2; <-- COMMIT ������ �޸𸮿� �ִ� ���� ��ȸ �� ���̴�. 
COMMIT;
-- Ŀ�� �Ϸ�.
SELECT * FROM TEST_T2;

-- ROLLBACK
INSERT INTO TEST_T2 (TC2_1, TC2_2,         TC2_3)
             VALUES (1.31,   '����2 ���ڿ�1',  SYSDATE); 
-- 1 �� ��(��) ���ԵǾ����ϴ�.             
SELECT * FROM TEST_T2;
ROLLBACK;
-- �ѹ� �Ϸ�.
SELECT * FROM TEST_T2;
-- 1.3	����2 ���ڿ�	22/03/14 
-- ROLLBACK �� �ϸ� �ٷ� ���� �Է��ߴ� ������ �����ǰ� 
-- COMMIT �� ���븸 ��ȸ�� �ȴ�.



-- UPDATE ���̺� SET �÷�;
-- DELETE ���̺�; 
