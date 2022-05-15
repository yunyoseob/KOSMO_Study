-- 2022-03-08

SELECT 1 FROM EMP;
-- ���� ������ŭ 1�� ��µȴ�.

SELECT 2 FROM EMP;
-- ���� ������ŭ 2�� ��µȴ�.

-- DISTINCT
SELECT DISTINCT EMPNO FROM EMP;
-- 14�� �˻�

SELECT DISTINCT EMPNO, DEPTNO FROM EMP;
-- 14�� �˻�

SELECT DISTINCT DEPTNO FROM EMP;
-- 3�� �˻�

SELECT DISTINCT DEPTNO, EMPNO FROM EMP;
-- 14�� �˻�

-- WHERE �� ����
-- WHERE ���� �׻� TRUE �� ���� ����ȴ�.
/*
SELECT
    SELECT �� : SELECT*FROM DUAL;
FROM
    FROM �� : SELECT*FROM DUAL;
WHERE
    WHERE �� : SELECT*FROM DUAL;
    WHERE ���� �׻� TRUE �� ���� �����Ѵ�.
    1=1 : ������ ���� ����Ѵ�.
    1=1 : ��, ������� ���� ����̴�. 
            �(��) REAL SERVER������ ���� ��� �����̴�.
*/


SELECT*FROM EMP WHERE 1=1;
-- 14�� ���� �� ��µ�

SELECT*FROM EMP WHERE 1=2;
-- �ƹ��͵� ��µ��� ����
-- ���� ���� ���� : FROM - WHERE - GROUP BY-HAVING-SELECT-ORDER BY


-- Q. �μ���ȣ�� 10���̰� ��å�� MANAGER�� ����� ����Ͻÿ�.
-- �� ���
SELECT*FROM EMP WHERE DEPTNO=10 AND JOB LIKE UPPER('%ANAGE%');

/*
���� ������ ������ �� �濡 ���� ���� �ǹ��ϳ�, ������� �ҰŸ�
�ܹ� ����(������ �ϳ��� Ȯ���غ��� �۾�)�� ���ľ� �Ѵ�.
*/

-- ����� ��� : �μ���ȣ 10 ��å MANAGER
-- ���̺� ���Ǽ��� ���� ����, �ܹ������� �ۼ�
SELECT*FROM EMP WHERE DEPTNO=10;
-- 3���� ������ ��µ�.
SELECT * FROM EMP WHERE JOB = 'MANAGER';
-- 3���� ������ ��µ�.
SELECT * FROM EMP WHERE DEPTNO = 10 AND JOB = 'MANAGER';
-- 1���� ������ ��µ�.

SELECT*FROM EMP
WHERE 1=1
AND DEPTNO=10
AND JOB='MANAGER';
/*
EMPNO ENAME  JOB           MGR  HIREDATE  SAL   COMM    DEPTNO
7782	    CLARK	MANAGER	7839	 81/06/09	 2450	  (null) 	       10
*/

SELECT*FROM EMP
WHERE 1=2
AND DEPTNO=10
AND JOB='MANAGER';
/*
EMPNO ENAME  JOB   MGR  HIREDATE  SAL   COMM    DEPTNO
*/

-- Q. �μ���ȣ 10 �̰ų� ��å�� MANAGER�� ��� ������ ����Ͻÿ�.
SELECT*FROM EMP WHERE DEPTNO=10;
-- 3���� ������ ��µ�.
SELECT * FROM EMP WHERE JOB = 'MANAGER';
-- 3���� ������ ��µ�.
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER';
-- 5 ���� ������ ��µȴ�.

SELECT*FROM EMP
WHERE 1=1
OR DEPTNO=10
OR JOB='MANAGER';
-- 14��
-- �� �� ���� �� �ϳ��� 14�� �� �����ϱ� ������ ���� ��µ�.

SELECT*FROM EMP
WHERE 1=2
OR DEPTNO=10
OR JOB='MANAGER';
--5�� �� �� ������ �� �� ���� 5���� 5���� ��µ�.

-- Q. �μ���ȣ�� 10��, 20���� ����� ��ȸ�غ�����.
SELECT COUNT(*) FROM EMP WHERE DEPTNO=10;
-- 3���� ������ ��µȴ�.
SELECT COUNT(*) FROM EMP WHERE DEPTNO=20;
-- 5���� ������ ��µȴ�.

-- PULL SCAN �ڸ��� PK �� �־ ��ȸ�ϸ� �� �Ǵ���?!

SELECT COUNT(*) FROM EMP WHERE DEPTNO=10 OR DEPTNO=20;
-- 8�� ����

SELECT COUNT(EMPNO) FROM EMP WHERE DEPTNO=10 OR DEPTNO=20;
-- �⺻Ű�� ��ȸ�ص� COUNT�Լ��� ����߱� ������ 8�� ����.

-- IN() : OR ������ ��ü�ؼ� ���
-- ���� �÷��� ���� ���� ���� ��ȸ�� ��

SELECT*FROM EMP WHERE DEPTNO IN (10,20);

SELECT COUNT(*) FROM EMP WHERE DEPTNO IN (10,20);
-- 8 

-- Ŀ�̼��� 300, 500, 1400 ����� ��ȸ �Ͻÿ�. (OR �� IN �� �� �غ���)

-- OR �����ڷ� �غ���
SELECT COMM FROM EMP;
SELECT*FROM EMP WHERE COMM='300' OR COMM='500' OR COMM='1400';
SELECT COUNT(EMPNO) FROM EMP WHERE COMM='300' OR COMM='500' OR COMM='1400';
-- 3

-- IN �����ڷ� �غ���
SELECT*FROM EMP WHERE COMM IN ('300','500','1400');
SELECT COUNT(EMPNO) FROM EMP WHERE COMM IN ('300', '500', '1400');
-- 3

-- 10�� �μ��� �ִ� ����� ����Ͻÿ�.
SELECT*FROM EMP
WHERE DEPTNO IN ('10');

SELECT*FROM EMP
WHERE DEPTNO='10';

-- 10�� �μ��� �ƴ� ����� ����Ͻÿ�.
-- ======3���� ���======
SELECT*FROM EMP
WHERE DEPTNO NOT IN ('10');

SELECT*FROM EMP
WHERE DEPTNO <> '10';

SELECT*FROM EMP
WHERE DEPTNO!='10';

SELECT*FROM EMP
WHERE DEPTNO ^=10;

-- NOT �����ڵ��� ����� �����ϴ� ���� ����
-- NULL���� ī��Ʈ���� �ʱ� ����
-- ===================

SELECT*FROM EMP WHERE COMM NOT IN (300,500,1400);
-- NULL�� ī��Ʈ���� �ʱ� ������ 1�Ǹ� ���´�.

-- �޿� 1000���� 1500 ������ ����� ��ȸ �Ͻÿ�.
SELECT COUNT(*) FROM EMP WHERE SAL>=1000; 
-- 12
SELECT COUNT(*) FROM EMP WHERE SAL<=1500;
-- 7
SELECT COUNT(*) FROM EMP WHERE SAL>=1000 AND SAL<=1500;
-- 5

--===========================
-- FROM ~ TO ���� �˻��̶�� �Ѵ��ϴ���.
--===========================

SELECT*FROM EMP 
WHERE SAL>=1000 
AND SAL<=1500;

-- �Ʒ� �������� ����
SELECT A.* FROM EMP A
WHERE A.SAL<=1500
AND A.SAL>=1000;
-- 1500�̸��� ���� �˻���, 1000�̻��� �˻��ؾ�
-- �˻� ȿ���� ���ٰ� �����ϴ� ����� �ֱ� ������
-- �̷��� ����ϴ� ���� �����Ѵ�.


--Q. �޿��� 1000 �̸� �̰ų� 1500 �ʰ��� ����� ��ȸ
SELECT*FROM EMP WHERE SAL<1000;
-- 2���� ������ ���
SELECT*FROM EMP WHERE SAL>1500;
-- 7���� ������ ���

SELECT COUNT(*) FROM EMP WHERE SAL>1500;

SELECT A.*
FROM EMP A
WHERE A.SAL<'1000'
OR
A.SAL>'1500';

SELECT COUNT(*)
FROM EMP A
WHERE A.SAL<'1000'
OR
A.SAL>'1500';
-- 9

-- BETWEEN A AND B
SELECT*FROM EMP
WHERE 1=1
AND SAL BETWEEN 1000 AND 1500;
-- 5�� ����

SELECT*FROM EMP A
WHERE 1=1
AND (A.SAL<=1500 
AND A.SAL>=1000);
-- 5�� ����

-- Q. 1981�⿡ �Ի��� ����� ��ȸ�Ͻÿ�. �˻��Ͻÿ�. ����Ͻÿ�.
SELECT HIREDATE FROM EMP WHERE ROWNUM<=5;

-- ����� ��ȸ�غ��� ���1====================
-- �� ����� ���� ����=======================
SELECT*FROM SCOTT.EMP A
WHERE 1=1
AND TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD')
        <= TO_CHAR(TO_DATE('1981/12/31'), 'YYYYMMDD')
AND TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD')
        >=TO_CHAR(TO_DATE('1981/01/01'), 'YYYYMMDD');
/* 
    ���� 1: HIREDATE�� TO_DATE�� �ٲ۵� TO_CHAR��
             ���� �������� �ٲ�. ����ϰ� �� �������� �ٲ���
    ���� 2: ���� ������ ��Ȯ�ϰ� ������־���.
*/
--====================================

-- ����� ��ȸ�غ��� ���2=====================
SELECT A.* FROM SCOTT.EMP A
WHERE 1=1
AND TO_CHAR(TO_DATE(A.HIREDATE), 'YYYY')='1981';
-- �⵵�� ��ȸ�Ͽ� ���ϴ� ����̴�.
--=====================================

--����� ��ȸ �ϴ� ���3=======================
SELECT A.HIREDATE FROM SCOTT.EMP A
WHERE 1=1
AND SUBSTR(A.HIREDATE, 1,2) ='81';
--======================================

--�˻��ϴ� ���4========================
SELECT SUBSTR(A.HIREDATE, 1, 2) AS HIREDATE FROM SCOTT.EMP A
WHERE 1=1
AND SUBSTR(A.HIREDATE, 1,2)='81';
--==================================

--��ȸ�ϴ� ���5=========================
SELECT A.* FROM SCOTT.EMP A
WHERE 1=1
AND A.HIREDATE BETWEEN '1981/01/01' AND '1981/12/31';
--===================================

--��ȸ�ϴ� ���6==========================
SELECT A.* FROM SCOTT.EMP A
WHERE 1=1
AND A.HIREDATE <= '1981/12/31'
AND A.HIREDATE >= '1981/01/01';
--====================================


--STACK, QUEUE
-- STACK : LIFO
-- �Է�: push(), (���̽㿡���� append())
-- ���: pop()

-- QUEUE : FIFO

SELECT SUBSTR('SMITH', 1,2) FROM DUAL;
-- SM
SELECT SUBSTR('SMITH',-1,2) FROM DUAL;
-- H
-- -1�� H�ڿ� �� �� ���

SELECT SUBSTR('SMITH',-3,2) FROM DUAL;
-- IT
-- -3�� I�ڿ� �� �� ���

SELECT SUBSTR('SMITH',-3) FROM DUAL;
-- -3�� I �ڿ� ���� ���

SELECT NVL(NULL, 'AB') FROM DUAL;
SELECT NVL(NULL, 0) FROM DUAL;
SELECT NVL(NULL, 'A')FROM DUAL;

--========�߿�=============
SELECT NULL FROM DUAL;
-- (null)
SELECT NULL+1 FROM DUAL;
-- (null)
SELECT NVL(NULL, 0) +1 FROM DUAL;
-- 1
--========================


SELECT*FROM EMP WHERE COMM IS NOT NULL;


-- ���� ���� ��
SELECT COUNT(*) FROM EMP WHERE COMM IS NOT NULL AND COMM>0;
-- 3

-- ����� ��
SELECT COMM FROM EMP;
SELECT COMM FROM EMP WHERE COMM>0;
SELECT NVL(COMM, 0) AS COMM FROM EMP WHERE COMM>0;
SELECT COUNT(NVL(COMM, 0)) AS COMM FROM EMP WHERE COMM>0;
-- 3

-- ��� ������
-- ����� �޿��� ������ ����Ͻÿ�.
-- + - * /

SELECT SAL, (SAL*12) AS TSAL FROM EMP;

-- Q. ����� �޿��� ����, ������ ����Ͻÿ�.
-- SAL, SAL*12 AS TSAL, COMM
SELECT A.SAL, (A.SAL*12) AS TSAL, A.COMM 
FROM EMP A;

-- Q. ����� �޿��� ����, ����, ������ ������ ������ ����Ͻÿ�.
-- SAL, (SAL*12), COMM, (COMM+(SAL*12))
-- �� ��
SELECT 
         A.SAL AS SAL
         , (A.SAL*12) AS TSAL
         , A.COMM AS COMM
         , (A.COMM+(A.SAL*12)) AS TSALBONUS 
FROM EMP A;


-- ����� ��
SELECT
         A.SAL AS SAL
         ,(A.SAL*12) AS TSAL
         ,NVL(A.COMM, 0) AS COMM
         ,NVL(A.COMM, 0) + (A.SAL*12) AS CSAL
FROM EMP A;

-- Q. ����� �޿��� ����, ����, ������ ������ ������  ������ ���� ������ ����Ͻÿ�.
--  �޿�: SAL, ���� :SAL*12, ���� : COMM, ������������ ���� : COMM+(SAL*12)

-- Q. ��� ������� �޿��� ������ 300���� �λ����ش�.
-- ����̸�, �޿�, �λ����޿��� ����Ͻÿ�.
-- ����̸�: ENAME, �޿�:SAL+300, �λ����޿�: SAL

SELECT 
         NVL(A.ENAME, 0) AS ENAME
         ,NVL(A.SAL*12 +'300', 0) AS ASAL
         ,NVL(A.SAL, 0) AS BSAL
FROM EMP A;

-- Q. 10�� �μ��� ����鿡�� ������ 300���� �ϰ� �����Ͻÿ�.
-- ����̸�, ������ ����Ͻÿ�.
-- ����̸� : ENAME, ���� : COMM (�ϰ����޵Ǳ� ����)
-- 300���� �ϰ� ���޵� ����: COMM+300 AS COMM

SELECT
        A.ENAME                      AS ENAME
        ,NVL((A.COMM+'300'), 0) AS COMM
FROM EMP A
WHERE A.DEPTNO='10';

-- Q. 1981�� 9�� �Ի��ڵ鿡�� ������ 500���� �����Ѵ�.
-- �����ȣ, ����̸�, ��å, �Ի���, ������ ����Ͻÿ�.
-- �Ի��� ���� (YYYY-MM-DD)

SELECT A.EMPNO                                                      AS EMPNO
          ,A.ENAME                                                       AS ENAME
          ,A.JOB                                                            AS JOB
          ,TO_CHAR(TO_DATE(A.HIREDATE), 'YYYY-MM-DD') AS HIREDATE
          ,NVL(A.COMM, 0)+'500'                                    AS COMM
FROM 
        EMP A
WHERE 1=1
AND
      TO_CHAR(A.HIREDATE, 'YYYYMM') 
      ='198109';
      
      
-- Q. 1981�� 2�� 20�� ���� 1981�� 5�� 1�� ���̿� �Ի���
--     ����� �̸�, ��å, �Ի���(YYYY.MM.DD), �޿�, ����, �󿩱���
--     ����Ͻÿ�.
--     ��� ������ ������ ���� ������ ����Ͻÿ�.

-- ����� �̸�: ENAME, ��å:JOB, �Ի���:HIREDATE, �޿�:SAL,
-- ����:SAL*12 ����:COMM

-- 1ST ���
SELECT
         A.ENAME                                                         AS ENAME  -- ����� �̸�
         ,A.JOB                                                              AS JOB           -- ��å
         ,TO_CHAR(TO_DATE(A.HIREDATE), 'YYYY.MM.DD')   AS HIREDATE -- �Ի���(YYYY.MM.DD)
         ,A.SAL                                                              AS SAL --�޿�
         ,(A.SAL*12)                                                        AS TSAL --����
         ,NVL(A.COMM, 0)                                               AS COMM --�󿩱�
FROM 
        EMP A
WHERE
       1=1
       AND
        -- 1981�� 2�� 20�� ���� 1981�� 5�� 1�� ����
        TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') 
        <= TO_CHAR(TO_DATE('19810501'), 'YYYYMMDD')
        AND
        TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') 
        >= TO_CHAR(TO_DATE('19810220'), 'YYYYMMDD')
ORDER BY TSAL DESC;

-- 2ND ���
SELECT
        A.ENAME                                                          AS ENAME
        ,A.JOB                                                              AS JOB
        ,TO_CHAR(TO_DATE(A.HIREDATE), 'YYYY.MM.DD')   AS HIREDATE
        ,A.SAL                                                              AS SAL
        ,(A.SAL*12)                                                        AS TSAL
        ,NVL(A.COMM, 0)                                               AS COMM
FROM 
        EMP A
WHERE
        1=1
        AND
        TO_CHAR(A.HIREDATE, 'YYYY')='1981'
        AND
        TO_CHAR(A.HIREDATE, 'MMDD')<='0501'
        AND
        TO_CHAR(A.HIREDATE, 'MMDD')>='0220'
ORDER BY TSAL DESC;

