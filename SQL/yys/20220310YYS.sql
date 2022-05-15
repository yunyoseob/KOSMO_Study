-- 2022-03-10

SELECT 'M' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '0001' FROM DUAL;

SELECT 'M' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '0002' FROM DUAL;


SELECT DISTINCT DEPTNO FROM EMP;

SELECT DISTINCT MGR FROM EMP;

SELECT DISTINCT JOB FROM EMP;

SELECT DISTINCT COMM FROM EMP;

SELECT DISTINCT*  FROM EMP;
-- ���� �� ��� ��

SELECT DISTINCT DEPTNO, EMPNO FROM EMP;
-- Į���� �� ���̸�  �� ���� Į���� ���� �ߺ��϶��� �������ִµ�?

SELECT AA.* FROM (SELECT HIREDATE FROM EMP WHERE ROWNUM <= 1) AA;
-- ���������� HIREDATE�� ���� ���, DATE Ÿ�Կ���  ���ڿ��� �ٲ�� �ǹ���
-- ����, ��¥�� �ٷ� ���� ���� TO_DATE()�� ���־�߸� �Ѵ�.


SELECT HIREDATE, JOB FROM EMP WHERE ROWNUM<=1;
-- FROM ���� ���� ���� ��

SELECT   TO_CHAR(TO_DATE(AA.HIREDATE), 'YYYY-MM-DD') AS HIREDATE
                     ,AA.JOB                                                                                                AS JOB
FROM (SELECT HIREDATE, JOB FROM EMP WHERE ROWNUM <= 1) AA; 

-- ���� ������ ������ ���� �� FROM ���� HIREDATE�� TO_DATE, TO_CHAR 
-- 'YYYY-MM-DD'�� �ٲٰ�, JOB�̶� �Բ� ����϶�.


--======================================
SELECT*FROM EMP ORDER BY COMM NULLS FIRST;
-- null �� ���� ������ּ���.

SELECT*FROM EMP  ORDER BY COMM NULLS LAST;
-- null ���� �������� ������ּ���.

-- null �� ��ȸ�� �����ϰ� ����

--======================================

-- NULL �ִ� �÷��� ���� �ϸ�, ��Ʈ �ϸ�, ORDER BY �ϸ�
-- ����Ŭ�� ORDER BY �ϸ� DEFAULT �� ASCENDING 
SELECT * FROM EMP ORDER BY COMM;
SELECT * FROM EMP ORDER BY MGR;

--NULL ��ü

-- NVL

SELECT NVL(NULL, 0) FROM DUAL;

-- NVL2 (NULL���� �ƴ� �� Ȯ��)

SELECT NVL2(NULL, 'NOT NULL', 'NULL') FROM DUAL;
SELECT NVL2('AA', 'NOT NULL', 'NULL') FROM DUAL;

SELECT NVL2(COMM, 'NOT NULL','NULL') FROM EMP;
------------------------

-- NOT ������ ����



SELECT*FROM EMP WHERE EMPNO LIKE '%4%';


SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO '%'|| 7 || '%';

SELECT
                A.EMPNO     AS EMPNO
                ,A.ENAME     AS ENAME
               , A.JOB               AS JOB
               , A.MGR               AS MGR
                ,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD') AS HIREDATE
FROM  EMP A
WHERE 1=1
AND TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD')>=TO_CHAR(TO_DATE('80/01/01'), 'YYYYMMDD')
AND TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD')<=TO_CHAR(TO_DATE('81/01/01'), 'YYYYMMDD');


