-- 20220510 ����
SELECT*FROM EMP WHERE ROWNUM<=5;
SELECT DEPTNO, AVG(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING DEPTNO>10
ORDER BY DEPTNO;

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >=2000
ORDER BY DEPTNO, JOB;

-- AVG(SAL) : ������ ����

-- EMP  ���̺��� ���� ���� 5�� ��ȸ�غ���
SELECT*FROM EMP WHERE ROWNUM<=5;

-- EMP ���̺��� �μ����� ��ȸ�غ���
SELECT DEPTNO FROM EMP GROUP BY DEPTNO;
-- 10, 20, 30

-- EMP ���̺��� DEPTNO, JOB�� �׷�ȭ�Ͽ� ��ȸ�ϱ�
SELECT DEPTNO, JOB  
FROM EMP 
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO ASC;
-- 10 : CLERK, MANAGER, PRESIDENT
-- 20 : ANALYST, CLERK,  MANAGER
-- 30 : CLERK, MANAGER, SALESMAN

SELECT DEPTNO, COUNT(DISTINCT(JOB))
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;
-- 10 : 3
-- 20 : 3
-- 30 : 3

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO;
-- 9�� ��� �ȴ�.

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >=2000
ORDER BY DEPTNO, JOB;

-- HAVING ���� ����Ͽ� EMP ���̺��� �μ��� ��å�� ��� �޿��� 500
-- �̻��� �������
-- �μ���ȣ, ��å, �μ��� ��å�� ��� �޿��� ����Ͻÿ�.

SELECT*FROM EMP WHERE ROWNUM<1;
-- EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO
-- ����ؾ� �ϴ� ��
-- DEPTNO : �μ���ȣ
-- JOB : ��å
-- SAL : �޿�

-- SELECT�� �´� �÷� ��ȸ�ϱ�
SELECT DEPTNO, JOB, SAL FROM EMP;

-- �μ��� ��å �׷�ȭ �Ͽ� ����
SELECT DEPTNO, JOB, AVG(SAL) 
FROM EMP 
GROUP BY DEPTNO, JOB;

-- + �μ��� ��å�� ��� �޿��� 500�̻�
SELECT DEPTNO, JOB, AVG(SAL) 
FROM EMP
GROUP BY DEPTNO, JOB
HAVING AVG(SAL)>=500;

-- ��� �޿��� 500�̻��� ����� ���� ��ȸ�ؼ� �°� ��ȸ�Ͽ�����
-- Ȯ���ϱ�

SELECT*FROM EMP;

-- �μ��� ��å�� ��ձ޿� ���ϱ�
SELECT DEPTNO, JOB,  AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO ASC;

-- 1ST
SELECT DEPTNO, COUNT(EMPNO)
FROM EMP
GROUP BY DEPTNO
 HAVING AVG(SAL)>=500;
-- 30�� �μ��� 6��
-- 20�� �μ��� 5��
-- 10�� �μ��� 3��

-- ����  GROUP BY���� ����� �׷�ȭ
SELECT DEPTNO, JOB,  COUNT(*) CNT, MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP 
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;
-- �μ���, ��å���� ��ȸ���� ��, 9�� ��ȸ
--  COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL) : ���� �� ���� �Լ�

SELECT SUM(CNT)
FROM (SELECT DEPTNO, JOB,  COUNT(*) CNT, MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP 
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB);
-- 14�� ����


-- ################# ROLLUP ###############################

-- ROLLUP �Լ��� ������ �׷�ȭ
SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB);

-- ROLLUP�Լ� �� ���� ���غ���
-- �μ����� �ִ�, �հ�, ��� ���غ���
SELECT DEPTNO, MAX(MSAL), SUM(SSAL), AVG(ASAL)
FROM (
    SELECT DEPTNO
                     ,JOB
                     ,COUNT(*) CNT
                     ,MAX(SAL) MSAL
                     ,SUM(SAL) SSAL
                     ,AVG(SAL) ASAL
    FROM EMP 
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB
)
GROUP BY DEPTNO;

-- �� �ִ�, �հ�, ��� ���غ���
SELECT COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP;

-- ################# ###### ###############################

-- ################# CUBE ###############################

-- CUBE �Լ� �Ẹ��
SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY DEPTNO, JOB;


-- CUBE �Լ� �Ⱦ��� ���ϱ�


SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;






