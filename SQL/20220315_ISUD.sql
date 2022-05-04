SELECT * FROM TAB;
SELECT COUNT(*) FROM TAB;
SELECT * FROM TEST_T1; -- ���̺��� ������

SELECT * FROM TEST_T2;

-- TEST_T2 ���̺� 
-- TC2_1 : ���� ���� 
-- TC2_2 : ���� �̸� 
-- TC2_3 : ���糯¥ 
-- �Է��ϰ�, ��ȸ�ϰ�,  ROLLBACK, ��ȸ�ϱ� 
-- �Է��ϰ�, ��ȸ�ϰ�,  COMMIT, ��ȸ�ϱ� 

-- �����ͺ��̽����� ���� �߼���

INSERT INTO TEST_T2 (  
                        TC2_1 -- place holder 1
                       ,TC2_2 -- place holder 2
                       ,TC2_3 -- SYSDATE
                    )
             VALUES (   
                        30      -- place holder 1
                       ,'�ڰǿ�' -- place holder 2
                       ,SYSDATE
                    );
SELECT * FROM TEST_T2;
ROLLBACK;
COMMIT;

INSERT INTO TEST_T2 -- (TC2_1,   TC2_2,    TC2_3)
             VALUES (   27,  '������',  SYSDATE);
COMMIT;             

/*
�÷� ������ ���ƾ� �Ѵ�.
INSERT INTO TEST_T2 -- (TC2_1,   TC2_2,    TC2_3)
             VALUES (   27,  '������');
SQL ����: ORA-00947: ���� ���� ������� �ʽ��ϴ�
00947. 00000 -  "not enough values"
 */            
/*
����Ŭ���� ���� �ڵ带 �����Ѵ�.
ORA-00947
ORA : ���ξ� 
00947 : ���� �ڵ� �̸鼭 ���������� ��ȣ
*/
/*
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (   27,  '������');
SQL ����: ORA-00947: ���� ���� ������� �ʽ��ϴ�
00947. 00000 -  "not enough values"
*/

INSERT INTO TEST_T2 (TC2_1,   TC2_2)
             VALUES (   27,  '������');
SELECT * FROM TEST_T2;

INSERT INTO TEST_T2 (TC2_1,   TC2_3)
             VALUES (   27,  SYSDATE);
SELECT * FROM TEST_T2;
COMMIT;

-- �ڹ� SQLMAP  ���� ����ϱ� 
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (   ?,        ?,  SYSDATE);

DESC TEST_T2;

/*          
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES ('2.22',  �ѱ� ,  '20220315');             
���� �߻� �����: 60 ��: 31
���� ���� -
SQL ����: ORA-00984: ���� ����� �� �����ϴ�
00984. 00000 -  "column not allowed here"
*/


/*
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  �ѱ� ,  '20220315');             
���� �߻� �����: 69 ��: 29
���� ���� -
SQL ����: ORA-00984: ���� ����� �� �����ϴ�
00984. 00000 -  "column not allowed here"
*/

/*
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '�ѱ�' ,  2022��3��15��); 
����� 78 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '�ѱ�' ,  2022��3��15��)
���� �߻� �����: 79 ��: 43
���� ���� -
SQL ����: ORA-00917: ������ �޸�
00917. 00000 -  "missing comma"
*/

/*
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '�ѱ�' ,  '2022��3��15��'); 
����� 88 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '�ѱ�' ,  '2022��3��15��')
���� ���� -
ORA-01861: ���ͷ��� ���� ���ڿ��� ��ġ���� ����
*/

/*
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '�ѱ�' ,  2022315); 
����� 96 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '�ѱ�' ,  2022315)
���� �߻� �����: 97 ��: 39
���� ���� -
SQL ����: ORA-00932: �ϰ��� ���� ������ ����: DATE��(��) �ʿ������� NUMBER��
00932. 00000 -  "inconsistent datatypes: expected %s got %s"
*/

/*
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '�ѱ�' ,  '2022315'); 
����� 106 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '�ѱ�' ,  '2022315')
���� ���� -
ORA-01861: ���ͷ��� ���� ���ڿ��� ��ġ���� ����             
*/


INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '�ѱ�' ,  '20220315');             
-- 1 �� ��(��) ���ԵǾ����ϴ�.
SELECT * FROM TEST_T2;             
ROLLBACK;             
             
DESC TEST_T2;
--�̸�    ��? ����           
----- -- ------------ 
--TC2_1    NUMBER(7,2)  
--TC2_2    VARCHAR2(30) 
--TC2_3    DATE 

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.2233,  '�ѱ�' ,  '20220315');             
SELECT * FROM TEST_T2;

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (12345678.2233,  '�ѱ�' ,  '20220315');       
--����� 149 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (12345678.2233,  '�ѱ�' ,  '20220315');
--���� ���� -
--ORA-01438: �� ���� ���� ������ ��ü �ڸ������� ū ���� ���˴ϴ�.

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '�ѱ��̸��ڳ��������ñ��մϴ�.' ,  '20220315');
SELECT LENGTH('�ѱ��̸��ڳ��������ñ��մϴ�.') FROM DUAL;   

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  'ABCDEFGHIJKLMNOPQRSTUVWXYZabcde' ,  '20220315');
--����� 162 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  'ABCDEFGHIJKLMNOPQRSTUVWXYZabcde' ,  '20220315');
--���� ���� -
--ORA-12899: "SCOTT"."TEST_T2"."TC2_2" ���� ���� ���� �ʹ� ŭ(����: 31, �ִ밪: 30)

SELECT LENGTH('ABCDEFGHIJKLMNOPQRSTUVWXYZabcde') FROM DUAL;

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (NULL,  NULL ,  NULL);
SELECT * FROM TEST_T2;

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES ('NULL',  'NULL' ,  'NULL');
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (NULL,  'NULL' ,  'NULL');
--���� ���� -
--ORA-01722: ��ġ�� �������մϴ�
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES ('NULL',  'NULL' ,  'NULL');
--���� ���� -
--ORA-01722: ��ġ�� �������մϴ�

SELECT * FROM TEST_T2;

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (30,  '�ڰǿ�' ,  SYSDATE);
COMMIT;             

INSERT INTO TEST_T2
    SELECT * FROM TEST_T2 WHERE ROWNUM < 2;

SELECT * FROM TEST_T2;

INSERT INTO TEST_T2 (TC2_1, TC2_2)
    SELECT TC2_1, TC2_2 FROM TEST_T2 WHERE ROWNUM < 3;
    
SELECT * FROM TAB;    
DESC TEST_T3;

SELECT * FROM ALL_IND_COLUMNS;

CREATE TABLE TEST_T3 (
    T_NUM           VARCHAR2(20) PRIMARY KEY 
   ,T_ID            VARCHAR2(20) NOT NULL
   ,T_PW            VARCHAR2(20) NOT NULL
   ,T_NAME          VARCHAR2(50)    
   ,T_TEL           VARCHAR2(16)       
   ,T_HP            VARCHAR2(16)          
   ,T_ADDR          VARCHAR2(200)             
   ,T_EMAIL         VARCHAR2(100) NOT NULL            
   ,T_INSERTDATE    DATE
   ,T_UPDATEDATE    DATE
);

/*
���̺� ���� �� �÷��� PRIMARY KEY �� �����ϸ�
�ý��ۿ��� �ش� �÷��� �ε����� �ο��Ѵ�. 
�ε��� �̸��� SYS_C00110565 �̴�. 

�÷��� PRIMARY KEY �� �����ϸ�
�ش� �÷��� NOT NULL + UNIQUE �̴�.
�� ���̺� �ش� �÷����� �� �����Ͱ� �־�� �ϰ� <-- NOT NULL
�� �����Ϳ� ���� ���� ������ �ʵȴ� <-- UNIQUE
*/

-- TEST_T3	T_NUM	SYS_C0011056
SELECT  A.TABLE_NAME,  A.COLUMN_NAME, A.INDEX_NAME 
FROM    ALL_IND_COLUMNS A
WHERE   A.TABLE_NAME IN ('TEST_T3');


CREATE TABLE TEST_T4 (
    T1 VARCHAR2(20) PRIMARY KEY -- NOT NULL + UNIQUE
   ,T2 VARCHAR2(20) NOT NULL 
   ,T3 NUMBER(4,3) -- NULL ���
   ,T4 VARCHAR2(1) -- NULL ���
   ,T5 DATE -- NULL ���
);

DESC TEST_T4;

SELECT * FROM TEST_T4;
DESC TEST_T4;
SELECT  A.TABLE_NAME,  A.COLUMN_NAME, A.INDEX_NAME 
FROM    ALL_IND_COLUMNS A
WHERE   A.TABLE_NAME IN ('TEST_T4');

INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  ('1', '�ڰǿ�',   30,  'Y',  SYSDATE);

INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  ('1',    NULL,   NULL,  NULL,  NULL);            

INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  ('1',  '�ڰǿ�',   NULL,  NULL,  NULL); 
ROLLBACK;

INSERT INTO TEST_T4 (T1,       T2,    T3,   T4,       T5)
            VALUES  ('1',  '�ڰǿ�',   30,  NULL,  NULL); 

INSERT INTO TEST_T4 (T1,       T2,      T3,   T4,       T5)
            VALUES  ('1',  '�ڰǿ�',     1.333,  NULL,  NULL); 
SELECT * FROM TEST_T4;

INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  ('2', '������',   7,  'Y',  SYSDATE);            
INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  ('2', '������',   2,  'Y',  SYSDATE);            
--���� ���� -
--ORA-00001: ���Ἲ ���� ����(SCOTT.SYS_C0011058)�� ����˴ϴ�
--TEST_T4	T1	SYS_C0011058

INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  (NULL, '������',   2,  'Y',  SYSDATE); 
--���� ���� -
--ORA-01400: NULL�� ("SCOTT"."TEST_T4"."T1") �ȿ� ������ �� �����ϴ� 

-- INDEX 
-- PRIMARY KEY = NOT NULL + UNIQUE

INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  ('3', '������',   2,  'Y',  SYSDATE); 
COMMIT;



-- ���̺� �÷� ������ TEST_T4  
ALTER TABLE TEST_T4
MODIFY T3 NUMBER(6,3);
DESC TEST_T4;
/*
UPDATE ���̺��̸� 
SET �÷��� = ��, �÷��� = ��
WHERE �÷��� = ��
*/

-- 1. ������ �÷� �� ��ȸ �غ���
SELECT T3 FROM TEST_T4 WHERE T2 = '�ڰǿ�' AND T1 = '1';
-- 2. ���� Ȯ�� ������ UPDATE �������� �����ϱ� 
UPDATE TEST_T4 
SET T3 = 30 
WHERE T2 = '�ڰǿ�' AND T1 = '1';
-- 3. ���� Ȯ���ϰ� ROLLBACK , COMMIT
COMMIT;
-- ������ 27
UPDATE TEST_T4 
SET T3 = 27 
WHERE T2 = '������' AND T1 = '2';
-- ������ 27
UPDATE TEST_T4 
SET T3 = 27 
WHERE T2 = '������' AND T1 = '3';
COMMIT;
-- �ڰǿ� Y, SYSDATE ����
UPDATE TEST_T4 
SET T4 = 'Y', T5 = SYSDATE 
WHERE T2 = '�ڰǿ�' AND T1 = '1';

SELECT * FROM TEST_T4 ORDER BY 1;
ROLLBACK;

-- MAX �� ä������ 
INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '������', 26,  'Y',  SYSDATE); 
INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '������', 26,  'Y',  SYSDATE); 
INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '�躰', 23,  'Y',  SYSDATE); 
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '���伷', 27,  'Y',  SYSDATE); 
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '�ΰ�ȣ', 27,  'Y',  SYSDATE); 
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '������', 27,  'Y',  SYSDATE); 
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '�ڼ���', 27,  'Y',  SYSDATE); 
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '���ѽ�', 29,  'Y',  SYSDATE); 
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), 'Ȳ�ž�', 23,  'Y',  SYSDATE);
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '�迵��', 22,  'Y',  SYSDATE);
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '��ι�', 32,  'Y',  SYSDATE);

SELECT NVL(MAX(NULL), 0) + 1 FROM DUAL;
CREATE TABLE TEST_T5 ( T1 VARCHAR2(20) PRIMARY KEY);
SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T5;

SELECT * FROM TEST_T5;
INSERT INTO TEST_T5 VALUES (1);
INSERT INTO TEST_T5 VALUES (10);

SELECT HIREDATE FROM EMP ORDER BY HIREDATE;
SELECT MAX(HIREDATE) FROM EMP ORDER BY HIREDATE;
SELECT MIN(HIREDATE) FROM EMP ORDER BY HIREDATE;

SELECT * FROM TEST_T4 ORDER BY 1;

SELECT T4, T5 FROM TEST_T4 WHERE T1 = '3';

UPDATE TEST_T4
SET T4 = 'N', T5 = SYSDATE
WHERE T1 = '3';

COMMIT;

UPDATE TEST_T4
SET T4 = 'N', T5 = SYSDATE
WHERE T1 IN ('4', '5');

SELECT * FROM TEST_T4 WHERE T4 = 'Y' ORDER BY 1;
SELECT * FROM TEST_T4 WHERE T4 = 'N' ORDER BY 1;

SELECT * FROM TEST_T2;
/*
DELETE  FROM ���̺�
WHERE �÷��� = ��;
*/

SELECT * FROM TEST_T2 WHERE TC2_1 = '2.22';
DELETE FROM TEST_T2 WHERE TC2_1 = '2.22';
ROLLBACK;

SELECT * FROM TEST_T2 WHERE TC2_1 = '1.3';
DELETE FROM TEST_T2 WHERE TC2_1 = '1.3';

DELETE FROM TEST_T2;
-- 10�� �� ��(��) �����Ǿ����ϴ�.
TRUNCATE TABLE TEST_T2;
-- Table TEST_T2��(��) �߷Ƚ��ϴ�.

SELECT*FROM TEST_T4 ORDER BY T1 ASC;

UPDATE TEST_T4
SET  T3='27';

UPDATE TEST_T4
SET T3='30'
WHERE T1=1;

COMMIT;


/*
DML Data Manipulation Language ���̺��� �����͸� ����, ����, ����
    INSERT, UPDATE, DELETE
    DML ������ Ʈ������� ó���ؾ� �Ѵ�. COMMIT ROLLBACK
	1. �޸𸮿� ����ȴ�.
	2. ROLLBACK : �޸𸮿� ����� ������ �����Ѵ�.
	3. COMMIT : �޸𸮿� ����� ���븦 ���Ͽ� �����Ѵ�. 
	4. �ܺ� �������α׷������� ���̺� ������ ���Ͽ� ����� ���븸 ��ȸ�� �����Ѵ�.

INSERT 
    1. �÷� ����, ���� �� �� ���� ���� ��ġ��Ű�� 
    2. ������ Ÿ�� Ȯ���ϱ�
    3. ������ ������ Ȯ���ϱ� 
    4. NULL ������ Ȯ���ϱ� 
UPDATE 
    1. ������ �÷� �� ������ Ȯ���ϱ�
    2. ������ �� Ȯ���ϱ�
    3. ���� �ϰ��� ���� �׸� Ȯ���ϰ� Ŀ�� �ϱ� 
DELETE    
    1. ������ �÷� �� ������ Ȯ���ϱ�
    2. ������ �� Ȯ���ϱ�
    3. �����ϰ��� ���� �׸� Ȯ���ϰ� Ŀ�� �ϱ� 
    4. TRUNCATE ��ɾ �����ϸ� ROLLBACK �� �� �� ����.
*/