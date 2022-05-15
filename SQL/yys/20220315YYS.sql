--20220315 YYS

SELECT*FROM TEST_T2;

-- Q. TEST_T2 ���̺�
-- TC2_1 : ���� ����
-- TC2_2 : ���� �̸�
-- TC2_3: ���糯¥
-- �� �Է��ϰ�, ��ȸ�ϰ�, ROLLBACK, ��ȸ�ϱ�

DESC TEST_T2;
/*
�̸�    ��? ����           
----- -- ------------ 
TC2_1    NUMBER(7,2)  
TC2_2    VARCHAR2(30) 
TC2_3    DATE     
*/

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (27, 'YUNYOSEOB', SYSDATE);
-- TC2_1���� ���ڸ� �Է�
-- TC2_2���� ���ڿ��� �Է�
-- TC2_3���� ���� ��¥�� �Է�

SELECT*FROM TEST_T2;

/*
1.3	����2 ���ڿ�	22/03/15
27	YUNYOSEOB	22/03/15
*/

ROLLBACK;

SELECT*FROM TEST_T2;
/*
1.3	����2 ���ڿ�	22/03/15
*/

-- Ʈ����� : �ɰ� �� ���� ���� ó���� �ּҴ����̸�, �ŷ������̶�� �Ѵ�.
-- SQL ���� ���� �۾��Ѵ�. (DDL, DML, DCL, TCL)

-- Ʈ���� : ��Ƽ��� ��, DB���� �۾�, Ʈ����ǰ��� �ٸ� �����̴�.
-- PL/SQL ���� ����Ѵ�.

-- ���̺�1�� ������ ���̺��� ����� ��� ���̺�1(���̺�1 �����丮)�� �ִ�.
-- ���̺�1���� ��� ���̺�1(���̺�1 �����丮)�� ����� ��
-- Ʈ���Ű� �߻��Ѵ�.

-- SQL ���� ���� �۾��� �ϸ� �������̺��� ���̺� �����丮�� �Ѿ��
-- �������� Ʈ���Ű� �߻��ϴ� ���̴�.

-- ������ �����ϴ� ���� DUMP ��ٰ� �Ѵ�.

-- Q. TEST_T2 ���̺�
-- TC2_1 : ���� ����
-- TC2_2 : ���� �̸�
-- TC2_3: ���糯¥
-- �� �Է��ϰ�, ��ȸ�ϰ�, COMMIT, ��ȸ�ϱ�

DESC TEST_T2;
/*
�̸�    ��? ����           
----- -- ------------ 
TC2_1    NUMBER(7,2)  
TC2_2    VARCHAR2(30) 
TC2_3    DATE   
*/

INSERT INTO TEST_T2 -- (TC2_1, TC2_2, TC2_3) : ��ü �÷��̸� ��������
-- �׷���, ������ �����Ѵ�.
-- ���̺� �÷��� ��Ȯ�� �����ϰ� �־, �Ǽ��� �� �ֱ� ����
VALUES (27, 'YUNYOSEOB', SYSDATE);

SELECT*FROM TEST_T2;

COMMIT;
ROLLBACK;

SELECT*FROM TEST_T2;
/*
1.3	����2 ���ڿ�	22/03/15
27	YUNYOSEOB	22/03/15
*/

-- DML�� �ƴ� SQL ���� ���� AUTO COMMIT�̴�.
-- ROLLBACK ��ɾ�� �ǵ��� �� ����.


-- ###################################################
-- ### ����Ŭ���� INSERT VALUES ���� ���ϰ� ���� ���� ���� ######

-- ### INSERT Į��, ���� ���� ##############################

-- ����Ŭ���� ���� �ڵ带 �����Ѵ�.

INSERT INTO TEST_T2
VALUES (27, 'YUN');
/*
SQL ����: ORA-00947: ���� ���� ������� �ʽ��ϴ�
00947. 00000 -  "not enough values"
*/

-- ���� ���ϰ� ���� ������. �̷��� �ݵ��
-- INSERT INTO ���̺� �̸� (Į���̸�1...Į���̸�N)
-- �� ���־�� ��. 

INSERT INTO TEST_T2(TC2_1, TC2_2)
VALUES (27, 'YUN');
-- ���������� �Է��� ��.

-- �����ؾ� �� ��Ȳ
DESC TEST_T3;
/*
�̸�           ��?       ����            
------------ -------- ------------- 
T_NUM        NOT NULL VARCHAR2(20)  
T_ID         NOT NULL VARCHAR2(20)  
T_PW         NOT NULL VARCHAR2(20)  
T_NAME                VARCHAR2(50)  
T_TEL                 VARCHAR2(16)  
T_HP                  VARCHAR2(16)  
T_ADDR                VARCHAR2(200) 
T_EMAIL      NOT NULL VARCHAR2(100) 
T_INSERTDATE          DATE          
T_UPDATEDATE          DATE    
*/

INSERT INTO TEST_T3 (T_ADDR)
VALUES ('SEOUL');

/*
���� ���� -
ORA-01400: NULL�� ("SCOTT"."TEST_T3"."T_NUM") �ȿ� ������ �� �����ϴ�

�׻� NOT NULL ������ �ִ� Į���� �ִ��� ���� Ȯ���ؾ� �Ѵ�.
PK�� NOT NULL ������ �ִ� Į������ NULL ���� �� �� ����.
*/

-- JAVA���� SQLMAP ���� ����ϱ�
-- INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
-- VALUES( ? , ? , SYSDATE);

DESC TEST_T2;
/*
�̸�    ��? ����           
----- -- ------------ 
TC2_1    NUMBER(7,2)  
TC2_2    VARCHAR2(30) 
TC2_3    DATE       
*/

-- VARCHAR2 ������ Ÿ�Կ� �̱������̼�(' ') �� �� ���� ����
INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES ('2.22', �ѱ�, '20220315');

/*
SQL ����: ORA-00984: ���� ����� �� �����ϴ�
00984. 00000 -  "column not allowed here"

���� : '2.22' ������ ������ ���� ���� �ƴϴ�. (���ڼ��� �Է°���)
*/

-- DATE ������ Ÿ�Կ� ���� �ʴ� �������� �Է��� �� ����� ���� 1
INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES(2.22, '�ѱ�', 2022�� 3�� 15��);

/*
SQL ����: ORA-00917: ������ �޸�
00917. 00000 -  "missing comma"
*/

-- DATE ������ Ÿ�Կ� ���� �ʴ� �������� �Է��� �� ����� ���� 2
INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (2.22, '�ѱ�', '2022�� 3�� 15��');

/*
ORA-01861: ���ͷ��� ���� ���ڿ��� ��ġ���� ����

Ư�̻��� : SQL���� : ~~ ��� ���� ���� ����
*/

-- DATE ������ Ÿ�Կ� ���� �ʴ� �������� �Է��� �� ����� ���� 3
INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (2.22, '�ѱ�', 2022315);
/*
SQL ����: ORA-00932: �ϰ��� ���� ������ ����: DATE��(��) �ʿ������� NUMBER��
00932. 00000 -  "inconsistent datatypes: expected %s got %s"

NUMBER �� ���� �߻�
*/

-- DATE ������ Ÿ�Կ� ���� �ʴ� �������� �Է��� �� ����� ���� 4

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (2.22,  '�ѱ�', 20220315);
/*
SQL ����: ORA-00932: �ϰ��� ���� ������ ����: DATE��(��) �ʿ������� NUMBER��
00932. 00000 -  "inconsistent datatypes: expected %s got %s"
*/

-- DATE ������ Ÿ�Կ� ���� �ʴ� �������� �Է��� �� ����� ���� 5

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (2.22, '�ѱ�', '2022315');

/*
���� ���� -
ORA-01861: ���ͷ��� ���� ���ڿ��� ��ġ���� ����

-- Ư�̻��� : SQL���� : ~~ ��� ���� ���� ����
yyyyMMdd ������ �ƴ϶� ���� �߻�
*/


INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (2.22, '�ѱ�','20220315');
-- 1���� �� ������ �ȴ�.

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES('2.25', '�ѱ�1', '20220315');

ROLLBACK;

-- #####################################################

-- ### INSERT ������ ���� ##################################

DESC TEST_T2;
/*
�̸�    ��? ����           
----- -- ------------ 
TC2_1    NUMBER(7,2)  
TC2_2    VARCHAR2(30) 
TC2_3    DATE    
*/

-- NUMBER(7,2)�� �Ҽ��� ��°�ڸ����� �Է½� �߻��ϴ� ����

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (2.2233, '�ѱ�', '20220315');
-- 1�� ������ �ȴ�. 

SELECT*FROM TEST_T2 WHERE TC2_1 = '2.2233';
-- �׷��� �ƹ��͵� ��� ���� �ʴ´�. 

SELECT*FROM TEST_T2;
-- TC2_1�� ������ Ÿ���� NUMBER(7,2)�̴�.
-- ����, �Ҽ��� �� ° �ڸ� ���ϴ� ���� ��������.
-- ORA ������ ǥ�õ��� ������, �� ��������.

-- NUMBER(7,2)�� 8�ڸ� �̻��� ���ڸ� �Է��� �� ����� ����

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (123456789.2233, '�ѱ�', '20220315');
/*
���� ���� -
ORA-01438: �� ���� ���� ������ ��ü �ڸ������� ū ���� ���˴ϴ�.

-- Ư�̻��� : SQL���� : ~~ ��� ���� ���� ����
*/

SELECT LENGTH('�ѱ��̸��ڳ��������ñ��մϴ�.') FROM DUAL;
-- 17

-- TC2_2    VARCHAR2(30) �̹Ƿ�, �� �͸� ����.

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (2.22, '�ѱ��̸��ڳ��������ñ��մϴ�.', '20220315');
/*
���� ���� -
ORA-12899: "SCOTT"."TEST_T2"."TC2_2" 
���� ���� ���� �ʹ� ŭ(����: 33, �ִ밪: 30)

-- Ư�̻��� : SQL���� : ~~ ��� ���� ���� ����

�׷���, �ѱ��� ��� 1���ڿ� ũ�Ⱑ 1�� �ƴ϶� ������ ����
*/

SELECT LENGTH('AAAAAAAAAAAAAAAAA') FROM DUAL;
-- 17

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (2.22, 'AAAAAAAAAAAAAAAAA', '20220315');
-- LENGTH�Լ��� ���� ��½� ���� 17������, ���� ���� 1���� �� ���Եȴ�.

-- ######################################################
-- ���� ��� ����

DESC TEST_T2;
/*
�̸�    ��? ����           
----- -- ------------ 
TC2_1    NUMBER(7,2)  
TC2_2    VARCHAR2(30) 
TC2_3    DATE    
*/


INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (NULL, NULL, NULL);
-- NULL���� ���� �Էµȴ�.

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES ('NULL','NULL','NULL');
/*
���� ���� -
ORA-01722: ��ġ�� �������մϴ�

NUMBER(7,2)���� ���� Ȥ�� ���� ���ڸ� �� �� �ִ�.
'NULL'�� ���� ���ڰ� �ƴϿ��� ������ ��µȴ�.
*/

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (NULL, 'NULL','NULL');
/*
���� ����-
ORA-01841: ���� ���� �ƴ� -4713 �� +4713 ������ ������ �����ؾ� �մϴ�.

��¥ �����Ϳ� 'NULL'�� ���� �� ���� ������ ��Ÿ���� �����̴�.

-- DATE�� NULL�� ���� �� ������, 'NULL'�� ���� ���� ����.
*/

-- ############## INSERT INTO ���̺��̸� SELCT*FROM###########
SELECT*FROM TEST_T2;

INSERT INTO TEST_T2
    SELECT*FROM TEST_T2 WHERE ROWNUM<2;
-- ���� ���� 1���� ���� ���� ��

SELECT*FROM TEST_T2;

INSERT INTO TEST_T2(TC2_1, TC2_2)
    SELECT TC2_1, TC2_1 FROM TEST_T2 WHERE ROWNUM<3;
-- Į���� TC2_1, TC2_2�� ���� ���� �� ���� �� �����Ͱ� ���Ե�
COMMIT;

-- ##############################################

DESC TEST_T3;
/*
�̸�           ��?       ����            
------------ -------- ------------- 
T_NUM        NOT NULL VARCHAR2(20)  
T_ID         NOT NULL VARCHAR2(20)  
T_PW         NOT NULL VARCHAR2(20)  
T_NAME                VARCHAR2(50)  
T_TEL                 VARCHAR2(16)  
T_HP                  VARCHAR2(16)  
T_ADDR                VARCHAR2(200) 
T_EMAIL      NOT NULL VARCHAR2(100) 
T_INSERTDATE          DATE          
T_UPDATEDATE          DATE     
*/

SELECT*FROM ALL_IND_COLUMNS;

SELECT  A.TABLE_NAME,  A.COLUMN_NAME, A.INDEX_NAME 
FROM    ALL_IND_COLUMNS A
WHERE   A.TABLE_NAME IN ('TEST_T3');
-- INDEX �ѱ����� ���� (����������� a,b,c,d....���� ��)
-- ��� : TEST_T3	T_NUM	SYS_C0011056

-- PRIMARY KEY

/*
���̺� ���� �� �÷��� PRIMARY KEY�� �����ϸ�
�ý��ۿ��� �ش� �÷��� �ε����� �ο��Ѵ�.
�ε��� �̸��� SYS_C0011056 �̴�.

�÷��� PRIMARY KEY�� �����ϸ�
�ش� �÷��� NOT NULL + UNIQUE �̴�.
�� ���̺� �ش� �÷����� �� �����Ͱ� �־�� �ϰ� <-- NOT NULL
�� �����Ϳ� ���� ���� ������ �� �ȴ�. <--UNIQUE
*/

CREATE TABLE TEST_T4(
    T1 VARCHAR2(20) PRIMARY KEY -- NOT NULL �̰� UNIQUE
    ,T2 VARCHAR2(20) NOT NULL -- NOT NULL�̾�� �Ѵ�.
    ,T3 NUMBER(4,3) -- NULL ���
    ,T4 VARCHAR2(1) -- NULL ���
    ,T5 DATE -- NULL ���
);

DESC TEST_T4;
/*
�̸� ��?       ����           
-- -------- ------------ 
T1 NOT NULL VARCHAR2(20) 
T2 NOT NULL VARCHAR2(20) 
T3          NUMBER(4,3)  
-- NUMBER(4,3) : 4�� ��ü�ڸ���, 3�� �Ҽ����ڸ�
-- ����, �����ڸ����� �ϳ��ۿ� ����.
T4          VARCHAR2(1)  
T5          DATE  
*/

SELECT*FROM TEST_T4;
SELECT A.TABLE_NAME, A.COLUMN_NAME, A.INDEX_NAME
FROM ALL_IND_COLUMNS A
WHERE A.TABLE_NAME IN('TEST_T4');
-- ALL_IND_COLUMNS ���̺���
-- alias�� A�� �����ϰ�,
-- A.TABLE_NAME�� TEST_T4 �� ������
-- A.TABLE_NAME�� A.COLUMN_NAME�� A.INDEX_NAME Į����
-- ����ϼ���.

-- ��� : TEST_T4	T1	SYS_C0011058

INSERT INTO TEST_T4(T1,     T2,   T3,   T4,     T5)
VALUES                   ('1',  '���伷',27,   'Y',    SYSDATE);
/*
���� ���� -
ORA-01438: �� ���� ���� ������ ��ü �ڸ������� ū ���� ���˴ϴ�.

��� �� �������� ã�ƺ���
T1�� PK�̹Ƿ�, NULL �� �ְ�, �ߺ����� ���� �� ����.
*/

INSERT INTO TEST_T4(T1, T2,     T3, T4, T5)
VALUES                    ('2',NULL,NULL,NULL,NULL);

/*
���� ���� -
ORA-01400: NULL�� ("SCOTT"."TEST_T4"."T2") �ȿ� ������ �� �����ϴ�.

-- T2 NOT NULL VARCHAR2(20) �ε�
-- NULL �Է��ؼ� ����
*/

INSERT INTO TEST_T4(T1, T2,     T3,T4,  T5)
VALUES                   ('2','���伷',NULL, NULL, NULL);
-- 1���� ���� ��

INSERT INTO TEST_T4(T1,T2,T3,T4,T5)
VALUES ('2','���伷',27, NULL, NULL);
/*
���� ���� -
ORA-01438: �� ���� ���� ������ ��ü �ڸ������� ū ���� ���˴ϴ�.

T3          NUMBER(4,3)  
�� �ڸ��� �� �ڸ��� �Է��Ͽ� ��Ÿ���� ����
*/

INSERT INTO TEST_T4(T1,T2,T3,T4,T5)
VALUES ('2','���伷',1.333, NULL, NULL);
-- T1�� 2�� �̹� �ִµ�, �� �����ϸ� ���Ἲ ���� ������ �����Ѵ�.
-- PK�� NULL�� ���� �� �ǰ�, ���� UNIQUE �ؾ� �Ѵ�.

/*
���� ���� -
ORA-00001: ���Ἲ ���� ����(SCOTT.SYS_C0011058)�� ����˴ϴ�

TABLE_NAME     COLUMN_NAME        INDEX_NAME
TEST_T4	                    T1	                   SYS_C0011058

-- INDEX_NAME �ȿ� VALUE�� �ߺ��� �Ǿ�� �� �ȴ�.
*/

INSERT INTO TEST_T4(T1,T2,T3,T4,T5)
VALUES ('1','���伷',1.333, NULL, NULL);


INSERT INTO TEST_T4(T1,T2,T3,T4,T5)
VALUES (NULL,'���伷',1.345, NULL, NULL);

/*
���� ���� -
ORA-01400: NULL�� ("SCOTT"."TEST_T4"."T1") �ȿ� ������ �� �����ϴ�

PK�� �ڸ����� NULL�� �� �� ����.
*/

SELECT*FROM TEST_T4;

UPDATE TEST_T4
SET T4='Y'
WHERE T1=2;

UPDATE TEST_T4
SET T4='F'
WHERE T1=1;

SELECT*FROM TEST_T4 WHERE T4='Y';
-- T4 : ���ڵ��� �������θ� ǥ���Ѵ�.
-- DELETE ��ɾ�� ���� ������
-- HISTORY ���̺� ����� �����ֱ� ������
-- (Ʈ���ű��� ����ϰ� �������� ����.)
-- ����� ������ ���� �ʴ´�.
-- ���� �̷� ������ Y (YES) OR N(NO)��
-- ����ִ� ���������� �׾��ִ� ���������� ǥ�ø� ���ִ� 
-- ������ �Ѵ�.

INSERT INTO TEST_T4(T1, T2, T3, T4, T5)
VALUES('3','������',2,'Y',SYSDATE);

SELECT*FROM TEST_T4;

UPDATE TEST_T4
SET T2='�ڰǿ�'
WHERE T1=1;

UPDATE TEST_T4
SET T3=1.123
WHERE T1=1;

UPDATE TEST_T4
SET T4=NULL
WHERE T1=1;

UPDATE TEST_T4
SET T5=NULL
WHERE T1=1;

UPDATE TEST_T4
SET T2='������'
WHERE T1=2;

UPDATE TEST_T4
SET T3=7
WHERE T1=2;

UPDATE TEST_T4
SET T5=SYSDATE
WHERE T1=2;

SELECT*FROM TEST_T4;
COMMIT;


-- ���̺� �÷� ������  TEST_T4
ALTER TABLE TEST_T4
MODIFY T3 NUMBER(6,3);
-- T3          NUMBER(4,3)  
-- Į�� ������ ������ ���� ���� Į���� �����Ͱ� ���� ��,
-- ����� ���̸� �ٲ��� �ʴ´�.
-- ���� :  �����Ͱ� �߷������� �ϱ� ������
-- �׷��� ������ ����� �÷��߸� Į�� ������ �����ϴ�.
-- ����, MODIFY T3 NUMBER(2,3) �̷��Դ� �ٲ� �� ����.

DESC TEST_T4;

SELECT*FROM TEST_T4;

-- UPDATE
-- 1. ������ Į�� �� ��ȸ�غ���

/*
UPDATE ���̺��̸�
SET �÷��� = ��,  �÷���=��
WHERE �÷��� =��
*/
UPDATE TEST_T4
SET T3=30
WHERE T2='�ڰǿ�' AND T1='1';


SELECT*FROM TEST_T4 ORDER BY T1 ASC;

-- ������ 27
UPDATE TEST_T4
SET T3=27
WHERE T2='������' AND T1=2;

-- ������ 27
UPDATE TEST_T4
SET T3=27
WHERE  T2='������' AND T1=3;

SELECT*FROM TEST_T4 ORDER BY T1 ASC;


-- �ڰǿ� T4 : Y, T5 : SYSDATE
UPDATE TEST_T4
SET T4='Y', T5=SYSDATE
-- SET �� AND�� OR �� �ƴ϶� �����ڰ� �޸�(,) �̴�.
WHERE T1=1 AND T2='�ڰǿ�';

SELECT*FROM TEST_T4 ORDER BY T1 ASC;

COMMIT;

SELECT*FROM TEST_T4 ORDER BY 1;

-- MAX �� ä�� ����
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '������', 26, 'Y', SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '������', 26, 'Y', SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '�躰', 23, 'Y', SYSDATE);
/*
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '���伷',27,'Y',SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '�ΰ�ȣ',27,'Y',SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '������', 27, 'Y', SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '�ڼ���', 27, 'Y', SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '���ѽ�',29,'Y',SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), 'Ȳ�ž�',23,'Y',SYSDATE);
*/

/*
����� 595 �࿡�� �����ϴ� �� ���� �߻� -

INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) 
VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), 'Ȳ�ž�',23,'Y',SYSDATE)
���� ���� -
ORA-00001: ���Ἲ ���� ����(SCOTT.SYS_C0011058)�� ����˴ϴ�
*/

SELECT*FROM TEST_T4 ORDER BY T1 ASC;
-- 11, 'Ȳ�ž�', 23, 'Y', SYSDATE �� �Էµ��� ����
/*
1	�ڰǿ�	30	Y	22/03/15
10	�ڼ���	27	Y	22/03/15
2	������	27	Y	22/03/15
3	������	27	Y	22/03/15
4	������	26	Y	22/03/15
5	������	26	Y	22/03/15
6	�躰	23	Y	22/03/15
7	���伷	27	Y	22/03/15
8	�ΰ�ȣ	27	Y	22/03/15
9	������	27	Y	22/03/15
*/

SELECT*FROM TEST_T4;

SELECT AVG(T3) FROM TEST_T4;
-- 26.7

SELECT HIREDATE FROM EMP ORDER BY HIREDATE;
SELECT MAX(HIREDATE) FROM EMP;
-- 87/05/23
SELECT MIN(HIREDATE) FROM EMP;
-- 80/12/17

SELECT*FROM EMP WHERE ROWNUM <2;

SELECT AVG(SAL) FROM EMP;
-- 2073.214285714285714285714285714285714286

SELECT AVG(COMM) FROM EMP;
-- 550

SELECT SUM(COMM) FROM EMP;
-- 2200

SELECT SUM(SAL) FROM EMP;
-- 29025

SELECT AVG(SAL)+AVG(COMM) FROM EMP;
-- 2623.214285714285714285714285714285714286

SELECT MAX(SAL) + MAX(COMM) FROM EMP;
-- 6400

-- ROLLBACK

SELECT*FROM TEST_T4;

-- ���� SELECT�� UPDATE �� Į���� �ο� ��ȸ
SELECT T4, T5 FROM TEST_T4 WHERE T1='3';

UPDATE TEST_T4
SET T4='N', T5=SYSDATE
WHERE T1=3;

SELECT T4, T5 FROM TEST_T4 WHERE T1='2';

-- ������, ������, ������ Ż�� ó��
SELECT*FROM TEST_T4;
SELECT T4, T5 FROM TEST_T4 WHERE T1='5' OR T1='4';

UPDATE TEST_T4
SET T4='N', T5=SYSDATE
WHERE T1 IN ('5','4');

SELECT*FROM TEST_T4;

SELECT*FROM TEST_T4 
WHERE T4='Y'
ORDER BY T1 ASC;

SELECT*FROM TEST_T4 
WHERE T4='N'
ORDER BY T1 ASC;

SELECT*FROM TEST_T4 
WHERE T4 LIKE UPPER('%Y%')
ORDER BY T1 ASC;

SELECT*FROM TEST_T4 
WHERE T4 LIKE UPPER('%N%')
ORDER BY T1 ASC;

-- DELETE vs TRUNCATE vs DROP

SELECT*FROM TEST_T2;
/*
1.3	����2 ���ڿ�	22/03/15
27	YUNYOSEOB	22/03/15
		
1.3	����2 ���ڿ�	22/03/15
1.3	1.3	
27	27	
*/

SELECT*FROM TEST_T2 WHERE TC2_1=1.3;
DELETE FROM TEST_T2 WHERE TC2_1=1.3;
-- 1 �� ��(��) �����Ǿ����ϴ�.
SELECT*FROM TEST_T2;
ROLLBACK;

-- DELETE vs TRUNCATE
SELECT*FROM TEST_T2;
DELETE FROM TEST_T2;
SELECT*FROM TEST_T2;
-- �����Ͱ� ���� �����
ROLLBACK;
SELECT*FROM TEST_T2;
-- ROLLBACK Ű����� �����Ͱ� �ٽ� ������ �ȴ�.

-- TRUNCATE TABLE TEST_T2;
-- Table TEST_T2��(��) �߷Ƚ��ϴ�.
-- SELECT*FROM TEST_T2;
-- �����Ͱ� ���� �������.
-- ROLLBACK;
-- �ѹ� �Ϸ�.
-- SELECT*FROM TEST_T2;
-- ROLLBACK ��ɾ�� �����Ͱ� ������ ���� �ʴ´�.
-- TRUNCATE ��ɾ�� ROLLBACK�� ���� �����Ƿ�,
-- ����� �����Ѵ�. (������� ���)

-- DROP TABLE TEST_T2
-- ���̺� ��ü�� ������ ������.

-- DELETE : ������ ���� : ROLLBACK ����
-- TRUNCATE : ������ ���� : ROLLBACK �Ұ���
-- DROP : ���̺� ���� : ROLLBACK �Ұ���

SELECT*FROM TEST_T4;
SELECT*FROM TEST_T4 ORDER BY T1 ASC;