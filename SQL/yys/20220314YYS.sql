--2022-03-14
SELECT*FROM EMP;

/*
SQL Structured Query Language 

DQL : Data Query Language : ���̺��� �����͸� ��ȸ, �˻�
            SELECT

DML : Data Manipulation Language : ���̺��� �����͸� ����, ����, ����
            INSERT, UPDATE, DELETE
            
            -- DML ������ ���, Ʈ������� ó���ؾ� �Ѵ�.
            **�߿�!!**
            1. �޸𸮿� ����ȴ�.
            2. ROLLBACK : �޸𸮿� ����� ������ �����ȴ�.
            3. COMMIT :  �޸𸮿� ����� ������ ���Ͽ� �����Ѵ�.
            4. �ܺ� �������α׷������� ���̺� ���� �� ���Ͽ� ����� ���븸 ��ȸ�� �����ϴ�.
    
    
DDL : Data Definition Language : ���̺��� ������ ���� ��ü�� ����, ����, ����
            CREATE, ALTER, DROP
            
            -- DDL ������ Ʈ������� �ٷ� ����ȴ�.

TCL : Transaction Contorl Language : Ʈ����� �������� ���� ����, ��� ��
            COMMIT, ROLLBACK, SAVEPOINT

DCL : Data Control Language : ������ ��� ���� �ο� �� ���
            GRANT, REVOKE


-- DDL : Data Definition Language : ���̺��� ������ ���� ��ü�� ����, ����, ����
-- CREATE, ALTER, DROP

-- ���̺� �����
 CREATE TABLE ����.���̺��̸� (
     �÷��� 1 ������Ÿ��1(������)
     , �÷���2 ������Ÿ�� 2
     , �÷���3 ������Ÿ��3  (������)
     .....
     , �÷���N ������Ÿ��N (������));
    
--  (������)�� ���� ���� �ִ�.



-- ����Ʈ ������ ���̺� �̸��� TEST_T1 ���̺��� �����Ͻÿ�.
-- �÷��� 4���̴�.
-- ù ��° �÷��� �̸��� TC1�̰�, ������ Ÿ���� VARCHAR2 �̰�, ������� 10�̴�.
-- �� ��° �÷��� �̸��� TC2�̰�, ������ Ÿ���� VARCHAR2�̰�, ������� 20�̴�.
-- �� ��° �÷��� �̸��� TC3�̰�, ������ Ÿ���� NUMBER�̰�, ������� �⺻���̴�.
-- �� ��° �÷��� �̸��� TC4�̰�, ������ Ÿ���� DATE�̴�.
-- DATE Ÿ���� ����� ���� �ʴ´�.

**�߿�!!**
-- CREATE TABLE ��ɾ� : �����ͺ��̽� �������� ���̺� ������ ������ּ���.

CREATE TABLE SCOTT.TEST_T1 : �����ͺ��̽� �������� ����Ʈ �������ٰ� TEST_T1�̶��
���̺��� ������ּ��� ��� �ǹ�
*/

CREATE TABLE SCOTT.TEST_T1(
    TC1 VARCHAR2(10)
    ,TC2 VARCHAR2(20)
    ,TC3 NUMBER
    ,TC4 DATE
);

-- ���̺� �����ƴ��� Ȯ���ϴ� ���
SELECT*FROM TAB;
DESC TEST_T1;
-- DESCRIBE

CREATE TABLE SCOTT.TEST_2(
    TC2_1 NUMBER(7, 2)
    ,TC2_2 VARCHAR2(30)
    ,TC2_3 DATE
);

/*
����Ʈ ������ TEST_2 ���̺��� ������ּ���.

�÷��� �� 3������.

ù ��° �÷� �̸��� TC2_1�̰�, ������ Ÿ���� NUMBER�̸�, ������� 7�ڸ������̸鼭 
�Ҽ��� �� °�ڸ� ���� ǥ�����ּ���.

�� ��° �÷� �̸��� TC2_2�̰�, ������ Ÿ���� VARCHAR2�̸�, ������� 30���� �ҰԿ�.

�� ��° �÷� �̸��� TC2_3�̰�, ������ Ÿ���� DATE����. DATE�� ����� �����.

���, ����Ŭ �����ͺ��̽� �������� ��û�Ѵ�.
*/

SELECT*FROM TAB;

-- TEST_2 ���̺� �̸��� TEST_T2�� �ٲٱ�

RENAME TEST_2 TO TEST_T2;

SELECT*FROM TAB;

-- ���̺�(���͸�) : ���ΰ�ħ�ϱ�

CREATE TABLE TEST_T3
    -- ���� ������. (SCOTT)
    T_NUM               VARCHAR2(20) PRIMARY KEY
    -- PK�� NOT NULL �����̿��� �ϰ� UNIQUE �ؾ���
    ,T_ID                    VARCHAR2(20) NOT NULL
    ,T_PW                 VARCHAR2(20) NOT NULL
    ,T_NAME           VARCHAR2(50)
    ,T_TEL                VARCHAR2(16)
    ,T_HP                  VARCHAR2(16)
    ,T_ADDR            VARCHAR2(200)
    ,T_EMAIL           VARCHAR2(100) NOT NULL
    ,T_INSERTDATE DATE
    ,T_UPDATEDATE DATE
);

SELECT*FROM TAB;
DESC TEST_T3;

/*
-- CREAT TABLE ~ AS ���� : ���� ���̺��� �̿��ؼ� ���̺� ����� �� 
-- ���� ���̺��� �����ϰ� �÷� �� �Ǵ� �÷� && �����͸� �����ϴ� ���̴�.
-- WHERE 1=1, WHERE 1=2
-- �� ������Ʈ�� ���簡 ���� ���� 
-- ������Ʈ : PRIMARY KEY, INDEX ..... etc 
*/



CREATE TABLE EMP_T1 AS
SELECT*FROM EMP WHERE 1=2;
-- WHERE 1=2�̸�, �÷��� ������ �����ʹ� ������ ����
-- EMP���̺��� �÷����� ���ο� ���̺��� ����� ���� �� ���
-- ���� ���̺��� ������ ���ο� ���̺��� ���� �� ���

SELECT*FROM EMP_T1;
-- EMP ���̺��� �÷��� �����Ǿ���.

CREATE TABLE EMP_T2 AS
SELECT*FROM EMP WHERE 1=1;

SELECT*FROM EMP_T2;
-- ���̺��� ������ ��, ���
-- WHERE 1=1�̱� ������ �����͵� �ٰ��� ����ȴ�.
-- EMP ���̺��� �÷��� ���ڵ� ��� �Ȱ��� �����Ǿ���.

-- ���̺� �����
DROP TABLE TEST_T1;

SELECT*FROM TAB;
-- ������ TEST_T1 ���̺� �ڸ���
-- BIN$IUQk2JrcRK6BLrrQcK65KA==$0 �̶�� �̻��� �� �ߴµ�,
-- �� �˹پƴϴ�. DBA�� �˾Ƽ� �ϴ� ����

-- ���̺� ����
SELECT*FROM TAB;

SELECT*FROM TEST_T2;
DESC TEST_T2;

-- ���̺� �÷� �߰�
-- TEST_T2 ���̺� ����� 100�̰�, ������Ÿ����
-- VARCHAR2�� TT��� Į���� �߰��ҰԿ�.
-- ����Ŭ���� ���̺� �÷��� �߰��ϸ� ���� �÷��� �� �ڿ� 
-- �÷��� �����ȴ�. (�߿�!!!)

ALTER TABLE TEST_T2
ADD TT VARCHAR2(100);

SELECT*FROM TEST_T2;
DESC TEST_T2;

-- ���̺� �÷� �̸� ����
ALTER TABLE TEST_T2
RENAME COLUMN TT TO TT_RENAME;

SELECT*FROM TEST_T2;
DESC TEST_T2;

-- ���̺� �÷� ������ ����
ALTER TABLE TEST_T2
MODIFY TT_RENAME VARCHAR2(50);
-- TT_RENAME    VARCHAR2(100) ���� VARCHAR2(50)���� �ٲٰڴٴ� �ǹ�

SELECT*FROM TEST_T2;
DESC TEST_T2;
-- TT_RENAME    VARCHAR2(50)

-- ���̺� �÷� ����
ALTER TABLE TEST_T2
DROP COLUMN TT_RENAME;

SELECT*FROM TEST_T2;
DESC TEST_T2;
-- ���̺��� TT_RENAME�̶�� �÷��� ������.


-- DML

SELECT*FROM TAB;
DESC TEST_T2;

-- ���̺� TEST_T2 ���� ISUD, CRUD �ϱ�
-- INSERT INTO ���̺� VALUES ();
-- UPDATE ���̺� SET �÷�;
-- DELETE ���̺�;

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.3, '���� 2 ���ڿ�', SYSDATE);

COMMIT;
-- Ŀ�� �Ϸ�. 


-- Ŀ���� �Ϸ�Ǿ�߸�, �ܺο��� DML�� �۾��� �������
-- Ȱ���ϴ� ���� �����ϴ�.

-- SQL Structure Language�߿��� DML�� COMMIT�� ���ϰ� ��ȸ�ϸ�
-- ���� ���� �޸𸮿� �ִ� �͸� ��ȸ�Ѵ�. (�ٸ� SQL Structure Language�� �ش� X)
-- �̷� ���, �ܺο��� Ȱ���� �Ұ��ϴ�.
-- ����, �ܺο��� ���Ÿ� �ݵ�� COMMIT �� ����Ѵ�.
-- COMMIT�� ��߸�, ���Ϸ� ��������� �ܺο��� ����� �����ϴ�.

-- Ŀ���� �� ���ؼ� �������� �ǵ����� ���� ���? ROLLBACK

SELECT*FROM TEST_T2;

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.31, '���� 2 ���ڿ�1', SYSDATE);

SELECT*FROM TEST_T2;

ROLLBACK;

SELECT*FROM TEST_T2;
-- ���� COMMIT ���·� ���ư���.

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.31, '���� 2 ���ڿ�1', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.32, '���� 2 ���ڿ�2', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.33, '���� 2 ���ڿ�3', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.34, '���� 2 ���ڿ�4', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.35, '���� 2 ���ڿ�5', SYSDATE);


SELECT*FROM TEST_T2;
SELECT COUNT(*) FROM TEST_T2;
-- 6

ROLLBACK;

SELECT*FROM TEST_T2;
SELECT COUNT(*) FROM TEST_T2;
-- 1

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.31, '���� 2 ���ڿ�1', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.32, '���� 2 ���ڿ�2', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.33, '���� 2 ���ڿ�1', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.34, '���� 2 ���ڿ�4', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.35, '���� 2 ���ڿ�5', SYSDATE);

COMMIT;
-- Ŀ�� �Ϸ�.

SELECT*FROM TEST_T2;
SELECT COUNT(*) FROM TEST_T2;
-- 6

ROLLBACK;

SELECT COUNT(*) FROM TEST_T2;
-- 6

-- Ŀ���� �ϰ� �� �ڿ�, ROLLBACK�� �ϸ� 
-- ���� COMMIT ���·� ���ư��� ������ COUNT(*)RK
-- 6�� ���´�.

SELECT*FROM TEST_T2;

DELETE FROM TEST_T2
WHERE TC2_1 >= 1.32;

SELECT*FROM TEST_T2;
COMMIT;
--=========================================



