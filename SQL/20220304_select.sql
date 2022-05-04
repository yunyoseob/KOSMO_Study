scott ���� unlock
1. sys �Ǵ� system �������� �α��� �ϱ� 
?>sqlplus "/as sysdba" <- sys
?>sqlplus system/1234 <- system

sql>ALTER USER scott IDENTIFIED BY tiger ACCOUNT UNLOCK;


SELECT * FROM EMP;

SELECT ROWID, A.EMPNO, A.ENAME, A.JOB FROM EMP A;

-- COUNT()�Լ� : ���̺��� �ο� ���� �����ش�. ���̺��� ���ڵ� ���� �����ش�.
SELECT COUNT(*) FROM EMP;
SELECT COUNT(EMPNO) FROM EMP;
SELECT COUNT(COMM) FROM EMP;

SELECT ROWID, EMPNO FROM EMP;
--����ũ  UNIQUE NOT NULL

/*
��Ű�� 
���̺� �ο� �� NULL PK FK 
*/


SELECT SYSDATE FROM DUAL;
SELECT SYSTIMESTAMP FROM DUAL;

-- SELECT
/*
SELECT Ű���� : ���̺��� �����͸� �����ϴ�(��ȸ�ϴ�) Ű���� 
    SELECT �� : ���̺��� ��ȸ�ϰ� ���� �÷��̸��� ���������� ���´�, �����ڴ� ,(CSV)
FROM Ű���� : �����͸� ��ȸ�ϰ� ���� ���̺� �̸��� ���ϴ� Ű���� 
    FROM �� : ��ȸ�ϰ����ϴ� ���̺� �̸��� ���������� ���´�. ������ , 
WHERE Ű���� : �����͸� ��ȸ�ϴ� ������ ���� Ű���� 
    WHERE �� : ��ȸ ������ ���µ� AND(�׸��� ����) Ű���� �� OR(�Ǵ� ����) Ű���带 �̿��� �� �ִ�. 

SELECT
    SELECT ��
FROM 
    FROM �� 
WHERE 
    WHERE �� 
*/

-- EMP ���̺��� ���̺� ������ ��ü�� ��ȸ�Ͻÿ� 
-- * : ���ϵ� ī�� : ���̺� ��ü�� �ǹ��Ѵ�. : FULL SCAN : Ǯ ��ĵ 
-- ���ǹ��� �׻� ; �����ؾ� �Ѵ�.
SELECT * FROM EMP;
-- ���̺��� ������.���̺��̸�
SELECT * FROM SCOTT.EMP;

-- ���̺� �̸��� �׻� ���̺� �ٸ��(��Ī)�� ����Ѵ�. 
-- ���̺� �ٸ�� : �ڹٿ��� ��ü�� ���������� ���� ��Ȱ�� �Ѵ�. 
-- FROM ������ ���̺� ���̺� �ٸ��(��Ī)�� ����ϸ� 
-- �ش� ���̺��� �÷��� ��ȸ�� �� ���̺� �ٸ���� ����ؼ� �÷��� �����ؾ��Ѵ�. 
SELECT A.*, B.* FROM SCOTT.EMP A, SCOTT.EMP B;
SELECT B.* FROM SCOTT.EMP B;

-- AS �÷� �ٸ��(��Ī) �ĺ��� 
-- AS EMPNO �� A.EMPNO �� ��Ī�̴�.
-- �����ȣ : �ּ�
SELECT 
        A.EMPNO     AS EMPNO    -- �����ȣ
       ,A.ENAME     AS ENAME    -- ����̸�
       ,A.JOB       AS JOB      -- �����å
       ,A.MGR       AS MCR      -- ��������ȣ
       ,A.HIREDATE  AS HIREDATE -- �Ի���
       ,A.SAL       AS SAL      -- �޿�    
       ,A.COMM      AS COMM     -- ����
       ,A.DEPTNO    AS DEPTNO   -- �μ���ȣ 
FROM 
        SCOTT.EMP A;

-- AS Ű���� �� ����ϼ���         
SELECT 
        A.EMPNO     EMPNO    -- �����ȣ
       ,A.ENAME     ENAME    -- ����̸�
       ,A.JOB       JOB      -- �����å
       ,A.MGR       MCR      -- ��������ȣ
       ,A.HIREDATE  HIREDATE -- �Ի���
       ,A.SAL       SAL      -- �޿�    
       ,A.COMM      COMM     -- ����
       ,A.DEPTNO    DEPTNO   -- �μ���ȣ 
FROM 
        SCOTT.EMP A;
        
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE,
       SAL, COMM, DEPTNO 
FROM    EMP;

-- EMP ���̺��� �����ȣ, �μ�, �Ի����� ��ȸ �Ͻÿ�
SELECT
    A.EMPNO     AS EMPNO    -- �����ȣ
   ,A.JOB       AS JOB      -- �μ�
   ,A.HIREDATE  AS HIREDATE -- �Ի���
FROM 
    EMP A;

-- ��ȸ�� ������ �����ϱ� , SORT �ϱ� 
-- ORDER BY DESC, ASC    
-- Ascending ���� ����
-- Desending ���� ����
/*
SELECT *
FROM   T
WHERE  ���ǽ�
ORDER BY �÷���1 [ASC|DESC], �÷���2 [ASC|DESC], �÷���3 [ASC|DESC] ... 
*/

SELECT ROWID, A.* FROM EMP A;        
SELECT ROWID, A.* FROM EMP A ORDER BY A.EMPNO ASC;  -- DEFAULT 
SELECT ROWID, A.* FROM EMP A ORDER BY A.EMPNO DESC;
SELECT ROWID, A.* FROM EMP A ORDER BY 1 DESC;

-- SELECT ���� �ִ� �÷� EMPNO 1, ENAME 2, JOB 3, MGR 4
-- SELECT ������ ���������� ������ �÷����� ������ INDEX �̴�. 
SELECT EMPNO, ENAME, JOB, MGR FROM EMP A ORDER BY 1 ASC;  -- DEFAULT 


