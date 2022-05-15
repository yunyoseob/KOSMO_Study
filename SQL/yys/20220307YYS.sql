SELECT*FROM EMP ORDER BY COMM DESC;

-- COUNT() �Լ�: ���̺��� �ο� ���� �����ش�.
 SELECT COUNT(*) FROM EMP;
 -- 14
 
 SELECT COUNT(EMPNO) FROM EMP;
 -- 14
 
 SELECT COUNT(COMM) FROM EMP;
 -- 4
 
 -- COUNT(*) ���� üũ�ϸ� Į������  �� ���鼭 ���� ���� �ľ��ϹǷ�,
 -- ���ҽ��� ���� ���.
 
 -- ����, Į�� �ϳ��� ��½��Ѿ� �Ѵ�.
 -- �׷���, Į������ ����ġ�� ������, ���ڵ� ���� ����� ����� ���� �ʴ´�.
 -- ����, SELECT COUNT(�⺻Ű) FROM ���̺�;
 -- �̷��� ��ȸ�ؾ� �Ѵ�. (���� :  �⺻Ű ������ NOT NIULL�̱� ����
 -- �⺻Ű(PRIMARY KEY : PK) : �ߺ����� ����� �Ѵ�.
 -- ����ũ : UNIQUE
 
 SELECT COUNT(EMPNO) FROM EMP;
-- 14

SELECT COUNT(DISTINCT(EMPNO)) FROM EMP;
-- 14
 
 -- �ܷ�Ű(FOREIGN KEY) : Ư�� ���̺� ���ԵǾ� �����鼭
 -- �ٸ� ���̺� �⺻Ű�� ������ Ű
 
 -- ��Ű�� : ���̺� + �ο� + �� + NULL + PK + FK ��ü�� ����
 -- ��Ű�� : ���̺� ���� ��Ҹ� �ǹ��Ѵ�.
 
 SELECT SYSDATE FROM DUAL;
 --  ��, ��, �Ͽ� ���� ����
 SELECT SYSTIMESTAMP FROM DUAL;
 -- ��,��,��,�ð������� ����
 
 
 -- CHAR :  ���� ���� 6ĭ�� A B CD�� ������ A B CD �״�� ����
 -- VARCHAR : ���� ���� 6ĭ�� A B CD �� ������ 6ĭ�� �״�� �������� �ʰ�, 4ĭ���� �ٿ��� ����
 
 
 -- ����
 
 SELECT 
                A.EMPNO             AS EMPNO 
              , A.ENAME             AS ENAME
              , A.JOB                     AS JOB
               ,A.MGR                   AS MCR
               ,A.HIREDATE       AS HIREDATE
               ,A.SAL                    AS SAL
               ,A.COMM              AS COMM
               ,A.DEPTNO          AS  DEPTNO
FROM
            SCOTT.EMP A;
 
 -- 2022/03/07
 
 SELECT*FROM EMP;
 
 SELECT ROWID, A.EMPNO,  A.ENAME, A.JOB  FROM EMP A;
 
 SELECT*FROM DEPT;
 
SELECT COUNT(EMPNO) FROM EMP;
 -- 14, ���� �� ���� Primary Key�� ������ ��ȸ�Ѵ�.
 -- ����: SELECT COUNT(*)�� ���� Ƚ���� �ʹ� ���� �����̴�.
 
 SELECT COUNT(ENAME) FROM EMP;
 
 SELECT COUNT(JOB) FROM EMP;
 
 SELECT COUNT(MGR) FROM EMP;
 
 -- DEPT  ���̺� ��ȸ�ϱ�
 SELECT*FROM DEPT;
 
 -- �����Ͱ� ���� ������ �̷��� �� ��!!
 
 -- �����Ͱ� ���� ���, Primary Key �� COUNT �Լ��� ���� ��ȸ�ؾ� ��.
 -- ���̺� ���� Ŭ�� ��, Model Ŭ���ؼ� ����. Ȥ�� SQL ���� Ŭ���ؼ� ����.
 -- DEPT ���̺��� Primary Key�� DEPTNO �̴�.
 
 SELECT COUNT(DEPTNO) FROM DEPT;
 -- 4
 
 -- SELECT*FROM DEPT
 -- SELECT COUN(*) FROM DEPT �� �ƴ϶�
 -- SELECT COUNT(DEPTNO) FROM DEPT, ���⼭ DEPTNO�� PRIMARY KEY
 --  �������� �����̴�. (PRIMARY KEY�� NOT NULL �����̱� ����)
 
 -- ���̺��� Į���� ���� ������ ���� �ʹٸ�??
 SELECT*FROM DEPT WHERE ROWNUM <=3;
 
 -- �̷� ������ ���� ������ �̾Ƽ� ��� ������� ���� ������ ����(3���� ����)
 -- SELECT*FROM DEPT �̷��� ��ü �� �� �ʿ����
 
 
 
 SELECT B.DEPTNO AS DEPTNO, B.DNAME AS DNAME, B.LOC AS LOC FROM SCOTT.DEPT B;
 
 
 -- DESC : DESCRIBE : ���̺� ���� Ȯ��
 -- ���̺� Į�� ��, NULL ����, ������ Ÿ��&������
 
 DESC DEPT;
 
 DESC EMP;
 
 DESC TAB;
 
 /*
 DESC ����
 
 �̸�        ��?       ����           
--------- -------- ------------ 
TNAME     NOT NULL VARCHAR2(30) 
TABTYPE            VARCHAR2(7)  
CLUSTERID          NUMBER       
 */
 
 -- DISTINCT
 SELECT COUNT(DEPTNO) FROM EMP;
 -- 14
SELECT COUNT(DEPTNO) FROM EMP WHERE DEPTNO=10;
 -- 3
 SELECT COUNT(DEPTNO) FROM EMP WHERE DEPTNO=20;
 -- 5
 SELECT COUNT(DEPTNO) FROM EMP WHERE DEPTNO=30;
 --  6
 SELECT COUNT(DEPTNO) FROM EMP WHERE DEPTNO=40;
 -- 0
 
 -- MIN, MAX �� Ȯ���غ���
 SELECT MAX(DEPTNO) FROM EMP;
 -- 30
 SELECT MAX(DEPTNO) FROM DEPT;
 -- 40
 SELECT MIN(DEPTNO) FROM EMP;
 -- 10
 SELECT MIN(DEPTNO) FROM DEPT;
-- 10

-- �ߺ��� ������ EMP ���̺��� DEPTNO ����
SELECT COUNT(DISTINCT DEPTNO) FROM EMP;
 -- 3
 
 -- �ߺ��� ������ DEPT ���̺��� DEPTNO ����
 SELECT COUNT(DISTINCT DEPTNO) FROM DEPT;
 -- 4
 
 --  �ߺ��� ������ EMP  ���̺�� DEPT ���̺��� DEPTNO  ����
 SELECT COUNT(DISTINCT A.DEPTNO), COUNT(DISTINCT B.DEPTNO) FROM EMP A, DEPT B;
 -- 3, 4
  
  -- EMP ���̺��� �μ���ȣ�� 10�� �μ��� �����ȣ�� (�����ȣ��) ���� ������ ��ȸ �Ͻÿ�.
  -- ()�ȿ� ������ ����������, ������ ���ؿ� ���� ��ð� �����Ƿ�, �ݵ�� ()���� ������ ���� ����Ѵ�.
  
  SELECT*FROM EMP A WHERE A.DEPTNO=10 ORDER BY DEPTNO DESC;
  
  --������ ��� ���� ���� ��� �����ұ�?
  
  -- LIKE ������ ����
  SELECT*FROM EMP WHERE JOB LIKE  '%SAL%';

-- �׳� �˻��غ���
  SELECT*FROM EMP WHERE JOB='SALESMAN';
  
-- �μ���ȣ�� 30�̰� �����ȣ�� 7499�� ����� ��å�� �����ΰ�?
SELECT JOB FROM EMP WHERE DEPTNO='30' AND EMPNO='7499';
-- SALESMAN
-- JAVA���� �����ʹ� ��κ� ���ڿ��� ó���ϹǷ�, 30, 7499�� �ƴ϶�
-- '30','7499'���� ã�ƾ� �Ѵ�.

-- ���̽� ����� �����ȣ, ��å, �Ի����� ��ȸ�Ͻÿ�.
SELECT EMPNO, JOB, HIREDATE FROM EMP WHERE ENAME='SMITH';
-- 7369, CLERK, 80/12/17

SELECT EMPNO, JOB, HIREDATE FROM EMP WHERE ENAME=UPPER('smith');
-- UPPER�� �ҹ��ڷ� ���͵� �빮�ڷ� ó���� �� �ִ�.

-- 80/12/17�� 1980-12-17���� �ٲپ ǥ���غ���
SELECT EMPNO, JOB, TO_CHAR(HIREDATE, 'YYYY-MM-DD')  FROM EMP WHERE ENAME=UPPER('smith');

-- �μ���ȣ 20�� ������� �Ի����� ��ȸ�Ͻÿ�. �Ի��� ������ YYYY.MM.DD
SELECT TO_CHAR(HIREDATE, 'YYYY.MM.DD') 
FROM EMP 
WHERE DEPTNO=20;

-- ����Ŭ������ �����ϴ� DUMMY TABLE : DUAL (�߿�) --

DESC DUAL;

SELECT*FROM DUAL;

SELECT 1 FROM DUAL;

SELECT 1+2 FROM DUAL;

-- TO_DATE : ��¥ �������� �ٲٴ� �Լ�
-- TO_CHAR : ��¥ ������ �ٲٴ� �Լ�
SELECT TO_CHAR(TO_DATE('80/12/17'), 'YYYY.MM.DD') FROM DUAL;

-- ���� ��¥ ���� �ٲٱ�
SELECT TO_CHAR(SYSDATE, 'YYYY.MM.DD') FROM DUAL;

-- DUAL Ȱ�� ��� smith, SMITH �ҹ��� Ȥ�� �빮�ڷ� ����
SELECT UPPER('smith') FROM DUAL;
SELECT LOWER('SMITH') FROM DUAL;


-- DUAL ���̺��� ���� ��Ģ���� �����غ���
SELECT 3*4 FROM DUAL;
-- 12

SELECT 3/4 FROM DUAL;
-- 0.75

SELECT 3-4 FROM DUAL;
-- -1

SELECT 3+4 FROM DUAL;
-- 7

SELECT NULL FROM DUAL;
-- (null)

SELECT ' ' FROM  DUAL;
-- null�� �ƴ� �� �������� ��µȴ�.

-- ========= �ϱ� ============
-- DUMP �����ϱ�
SELECT DUMP(NULL) FROM DUAL;

SELECT DUMP(' ') FROM DUAL;
--  Typ=96, Len=1:32

SELECT DUMP('  ') FROM DUAL;
-- Typ=96, Len=2:32,32
-- =========================

SELECT DUMP('   ��   ��       ��') FROM DUAL;
-- Typ=96 Len=19: 32,32,32,186,167,32,32,32,183,206,32,32,32,32,32,32,32,177,215

--  ������ ������ �Լ��̴�.

-- ��� ���̺��� 5�Ǹ� ��ȸ �Ͻÿ�.
SELECT*FROM EMP WHERE ROWNUM<=5;
-- �̷��� ������ ��ɹ��� ĥ ���� �ƴ϶� ������̺��� � �� � ������ �°�
-- ��ȸ�ؾ��ϴ��� ���� CHECK �ؾ� �Ѵ�.

-- NULL ������ ó���ϱ�
SELECT COMM FROM EMP;
-- 14���� �����Ͱ� �˻���.

SELECT COUNT(COMM) FROM EMP;
-- 4 (����ġ ���� 4�� ����)

SELECT COUNT(NULL) FROM DUAL;
-- 0
SELECT COUNT(0) FROM DUAL;
-- 1

SELECT COUNT(COMM) FROM EMP WHERE COMM=NULL;
--  �߸��� ǥ��

SELECT COMM FROM EMP WHERE COMM IS NULL;
-- NULL�� ��ȸ�� IS NULL���� �ؾ� ��.

SELECT COMM FROM EMP WHERE COMM IS NOT NULL;
-- NULL���� �ƴ� ���� ��ȸ�ÿ��� IS NOT NULL���� �ؾ��Ѵ�.

SELECT COUNT(COMM)  FROM EMP WHERE COMM IS NOT NULL;
-- 4���� NULL ���� �ƴ� ������ ǥ�� ��.

SELECT COUNT(COMM) FROM EMP WHERE COMM IS NULL;
-- 0: NULL���� ī���� ���� ����


SELECT NVL(COMM, 0) FROM EMP;
-- NULL ���� 0���� �����϶�

--EMP ���̺��� �Ǽ��� ��ü �Ǽ���? (��, COMM �÷��� ����ϼ���.)

-- 1�ܰ�
SELECT NVL(COMM, 0) AS COMM FROM EMP;
-- NULL���� 0���� �ٲ������ Ȯ��

-- 2�ܰ� �����ؼ� ����
SELECT COUNT(NVL(COMM, 0)) FROM EMP;
-- 14

--  LIKE ������ %(���ϵ� ī��) �˻�
-- ������̺��� ����̸��� S�� �����ϴ� ����� �˻��Ͻÿ�.
SELECT *FROM EMP WHERE  ENAME LIKE 'S%';

-- ��� ���̺��� ����̸��� S�� ������ ����� �˻��Ͻÿ�.
SELECT*FROM EMP WHERE ENAME LIKE '%S';

-- ��� ���̺��� ����̸��� S�� ���� ����� �˻��Ͻÿ�.
SELECT*FROM EMP WHERE ENAME LIKE '%S%';

-- ��� ���̺��� �����ȣ�� 7�� �����ϴ� ������� �˻��Ͻÿ�.
SELECT*FROM EMP WHERE EMPNO LIKE '7%';

-- ������̺��� �����ȣ�� 9�� ������ ������� �˻��Ͻÿ�.
SELECT*FROM EMP WHERE EMPNO LIKE '%9';

-- LIKE �����ڸ� �� ��, ������ ���, ��ҹ��� ���������� UPPER�� �Բ� ���ִ� ���� ����.
SELECT*FROM EMP WHERE ENAME LIKE 's%';
-- �ƹ� �͵� ��� ���� ����
SELECT*FROM EMP WHERE ENAME LIKE UPPER('s%');

-- _(���ϵ� ī��) �˻�, ��ȸ
SELECT*FROM EMP;

-- �� ��° ���ڿ� A�� ���� ��� ��ȸ
SELECT*FROM EMP WHERE ENAME LIKE '_A%';

-- �� ��° ���ڿ� A�� ���� ��� ��ȸ
SELECT*FROM EMP WHERE ENAME LIKE '__A%';

-- �߰��� A�� ������ ���� ���� ��� ��ȸ
SELECT*FROM EMP WHERE ENAME NOT LIKE '%A%';

-- �߰��� A�� ������ �Ǵ� ��� ��ȸ
SELECT*FROM EMP WHERE ENAME LIKE '%A%';

-- ��¥ ������ ��ȸ
-- 1981�� 1�� 1�� ������ �Ի��� ����� ����Ͻÿ�.
SELECT*FROM EMP ORDER BY HIREDATE ASC;
SELECT*FROM EMP WHERE HIREDATE<'81/01/01';
 -- SELECT*FROM EMP WHERE HIREDATE < '1981/01/01';
-- SELECT*FROM EMP WHERE HIREDATE < '1981.01.01';
-- SELECT*FROM EMP WHERE HIREDATE <'1981-01-01';
-- �� �ȴ�.

-- ===========================================
SELECT*FROM EMP 
WHERE 
                TO_CHAR(HIREDATE, 'YYYY-MM-DD') < TO_CHAR(TO_DATE('81/01/01'), 'YYYY-MM-DD');
-- ��¥�� �ݵ��, �����͸� TO_CHAR�� ���� ������ �������� ��, �˻��Ͽ��� �Ѵ�.
-- ===========================================

/*
SELECT TO_CHAR(ù ��° ���� ,�� ��° ����) FROM EMP;
ù ��° ������ �׻� DATE Ÿ���̾�� �Ѵ�.
�� ��° ������ ��¥ �����̾�� �Ѵ�.
  */
  
SELECT TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;
-- ��� ����

SELECT TO_CAHR('81/01/01', 'YYYY-MM-DD') FROM EMP;
-- ���� ��� ��

SELECT TO_CHAR(TO_DATE('81/01/01'), 'YYYY-MM-DD') FROM EMP;
-- ���� �ذ�


-- �������� ���� ����� �� HIREDATE�� ��¥���� ������ �� �� �����Ƿ� 
-- �ݵ�� TO_DATE�� �����ص�, �����ؾ� �Ѵ�.
SELECT TO_CHAR(TO_DATE(HIREDATE), 'YYYY-MM-DD') FROM EMP;

-- 2022-03-08
-- �����ϱ�
--==============================================

-- ���� : �̱������̼� : '���ڿ�'
SELECT 'A' FROM DUAL;

-- ����: ���� �Ǵ� '����'(���ڼ���)
SELECT 11 FROM DUAL;
-- 11
SELECT '11' FROM DUAL;
-- 11

-- null ó���ϴ� �Լ� : NVL(NULL, ġȯ�ϰ� ���� ������)
SELECT NVL(NULL, 0) FROM DUAL;
-- 0

-- ��¥ ó���ϴ� �Լ�
SELECT '90/12/01' FROM DUAL;
-- 90/12/01
SELECT TO_DATE('90/12/01') FROM DUAL;
-- 90/12/01

SELECT TO_CHAR(TO_DATE('90/12/01'),  'YYYY-MM-DD') FROM DUAL;
-- 1990-12-01

SELECT SYSDATE FROM DUAL;
-- 22/03/08

SELECT TO_CHAR(TO_DATE(SYSDATE), 'YYYY-MM-DD') FROM DUAL;
-- 2022-03-08
-- �׻� SYSDATE�� ��¥�� �� �˾Ƶ� TO_DATE() �Ұ�ȣ �ȿ� �ֱ� �̷��� ���߿� ���� �� ����.

-- ���ڿ� ��ҹ��ڸ� �����ϱ� ������ UPPER Ȥ�� LOWER ����ϱ�
SELECT UPPER('smith') FROM DUAL;
-- SMITH �� �빮�ڷ� ġȯ�Ǿ ��µ�

SELECT LOWER('SMITH') FROM DUAL;
-- smith�� �ҹ��ڷ� ġȯ�Ǿ ��µ�.

-- �˻� : LIKE '%', '_'
SELECT DISTINCT ENAME FROM EMP;

SELECT ENAME FROM EMP WHERE ENAME LIKE UPPER('%S');
-- JONES, ANAMS, JAMES
-- �˻��� UPPER�� �÷��� �˻��ϸ� �� ���ϴ�.


SELECT ENAME FROM EMP WHERE ENAME LIKE UPPER('S%');
-- SMITH, SCOTT

SELECT ENAME FROM EMP WHERE ENAME LIKE UPPER('%S%');
-- SMITH, JONES, SCOTT, ADAMS, JAMES

SELECT ENAME FROM EMP WHERE ENAME LIKE UPPER('__A%');
-- BLAKE, CLARK, ADAMS : �� ��° ���ڿ� A�� �ִ� ����鸸 ���

SELECT*FROM EMP WHERE COMM IS NULL;
-- COMM�� NULL�� �����͵��� ���� ����϶�

SELECT*FROM EMP WHERE COMM IS NOT NULL;
-- COMM�� NULL�� �ƴ� �����͵��� ���� ����϶�.

-- ������ ��������

DESC EMP;
/*
�̸�       ��?       ����           
-------- -------- ------------ 
EMPNO    NOT NULL NUMBER(4)    
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER(4)    
HIREDATE          DATE         
SAL               NUMBER(7,2)  
COMM              NUMBER(7,2)  
DEPTNO            NUMBER(2)    
*/

DESC DEPT;
/*
�̸�     ��?       ����           
------ -------- ------------ 
DEPTNO NOT NULL NUMBER(2)    
DNAME           VARCHAR2(14) 
LOC             VARCHAR2(13) 
*/

SELECT*FROM EMP WHERE ROWNUM<3;
-- ���� ���� �� �ٸ� ����ϴ� ���