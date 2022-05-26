-- 20220525 YYS

-- INDEX : ���� 
-- ���̺� ���� ä������ ���������
CREATE TABLE INDEX_TEST_1(
    INDEX_1 NUMBER PRIMARY KEY
);

SELECT*FROM INDEX_TEST_1;

SELECT MAX(INDEX_1) FROM INDEX_TEST_1;

SELECT /*+ INDEX_DESC(A SYS_C0013191)   */ NVL(MAX(INDEX_1), 0)+1 AS INUM  FROM INDEX_TEST_1;


-- �ǹ������� �׻� �ε����� ���� ��ȸ�ؾ� �Ѵ�.
SELECT TABLE_NAME, INDEX_NAME, COLUMN_NAME
FROM USER_IND_COLUMNS
WHERE TABLE_NAME IN ('INDEX_TEST_1');
--TABLE_NAME :  INDEX_TEST_1
-- INDEX_NAME : SYS_C0013191
--COLUMN_NAME : INDEX_1

-- PK ������ �ڵ����� �ý��ۿ��� �ý����� �ε����� �����ϱ� ������
-- ����� ���Ƿ� �ε����� ������ �� �ִ�.

-- �ε��� �����ϱ�
CREATE TABLE T2(
    T2_1 NUMBER,
    T2_2 VARCHAR2(10)
);

SELECT*FROM T2;

-- ���� �ε���
CREATE  INDEX_T2_T2_1 ON T2(T2_1);
-- ORA-00901: CREATE ��ɾ �������մϴ�
-- 00901. 00000 -  "invalid CREATE command"

-- ���� �ε���
CREATE INDEX INDEX_T2_T2_1_T2_2 ON T2(T2_1, T2_2);

SELECT TABLE_NAME, INDEX_NAME, COLUMN_NAME
FROM USER_IND_COLUMNS
WHERE TABLE_NAME IN ('T2');
-- �ε����� ���� ���� �� �� �ִ�.

/*
���� ���ǵ� ��
CONNECT ��(ROLE)
    -- Release 9.0����
    ALTER SESSION
    CREATE CLUSTER
    CREATE SEQUENCE
    CREATE SESSION
    CREATE SYNONYM
    CREATE TABLE
    CREATE VIEW
    -- Release 11.2 ����
    CREATE SESSION
RESOURCE ��(ROLE)
    CREATE CLUSTER
    CREATE PROCEDURE
    CREATE SEQUENCE
    CREATE TABLE
    CREATE TRIGGER
*/
    
    


