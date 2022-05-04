-- ���� : �̱������̼� : '���ڿ�'
SELECT '���ڿ�' FROM DUAL;

-- ���� : ���� �Ǵ� '����'(���ڼ���)
SELECT 11, '11' FROM DUAL;

-- null ó���ϴ� �Լ� : NVL(NULL, ġȯ�ϰ���� ������)
SELECT NVL(NULL, 0) FROM DUAL;

-- ��¥ ó���ϴ� �Լ� : 
-- TO_DATE() : ��¥ ����� �� ���ڿ��� ��¥ ������ �������� ��ȯ�Ѵ�. 
SELECT '90/12/01' FROM DUAL;
SELECT TO_DATE('90/12/01') FROM DUAL;

-- TO_CHAR(ù��° �Ű�����, �ι�° �Ű�����) : SimpleDateFormat
-- ù��° �Ű����� : DATE Ÿ���̾�� �Ѵ�.
-- �ι�° �Ű����� : ��¥ ���� :  YYYY-MM-DD, YYYY/MM/DD, YYYY.MM.DD
SELECT TO_CHAR(TO_DATE('90/12/01'), 'YYYY-MM-DD') FROM DUAL;

-- ��¥ ó���ϴ� ������Ÿ�� : 
-- ���� ��¥ : SYSDATE, SYSTIMESTAMP
SELECT TO_CHAR(TO_DATE(SYSDATE), 'YYYY-MM-DD') FROM DUAL;

-- ���ڿ� ��ҹ��ڸ� ���� �ߴ�.
-- �빮�ڷ� ��ȯ�ϴ� �Լ� : UPPER()
SELECT UPPER('smith') FROM DUAL;

-- �ҹ��ڷ� ��ȯ�ϴ� �Լ� : LOWER()
SELECT LOWER('SMITH') FROM DUAL;

-- �˻� : LIKE '%', '_'
SELECT ENAME FROM EMP WHERE ENAME LIKE '%S';
SELECT ENAME FROM EMP WHERE ENAME LIKE '_A%';

SELECT ENAME FROM EMP WHERE ENAME LIKE 'S%';
SELECT ENAME FROM EMP WHERE ENAME LIKE '%S%';

-- ������ ����üŷ
-- NULL CHECK
SELECT COMM FROM EMP WHERE COMM IS NULL;
SELECT COMM FROM EMP WHERE COMM IS NOT NULL;
-- ������Ÿ�� DATE �÷��� ��¥ ���� 
-- ����
-- ����

-- DESC : ���̺� ���� : �÷���, ������ Ÿ��,  ������, NULL ����
DESC EMP;

-- DISTINCT
SELECT DISTINCT EMPNO, DEPTNO FROM EMP;
SELECT DISTINCT DEPTNO, EMPNO FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

-- ROWNUM()
SELECT * FROM EMP WHERE ROWNUM <= 10;

SELECT * FROM DUAL;
SELECT COUNT(*) FROM TAB;
SELECT 1, 2, A.* FROM  TAB A;
SELECT 1 FROM  TAB;

SELECT COUNT(*) FROM EMP;
SELECT 1, 2, 3, A.* FROM EMP A;
SELECT 1 FROM EMP A;


-- WHERE �� 
/*
SELECT
    SELECT �� : SELECT * FROM DUAL;    
FROM 
    FROM �� :  SELECT * FROM DUAL;
WHERE 
    WHERE �� : SELECT * FROM DUAL;
    WHERE ���� �׻� TRUE �� ���� �����Ѵ�.
    1=1 : ������ ���� ����Ѵ�.
    1=1 : ������� ���� ����̴�. �(��) REAL SERVER ������ �������̴�.
    
������ �� ���������� ����� �� �ִ�.
AND, OR, IN, FROM ~ TO ����, <, >, <=, >= ..... 
*/

SELECT * FROM EMP WHERE 1=1;
SELECT * FROM EMP WHERE 1=2;

/*
������ �������� ������ ���� ���� 
�׻� ���� �ϳ��� ������ ���� ������ Ȯ���Ѵ�.
Ȯ���� �Ǹ� 
�������� �����Ѵ�.

<-- �ܹ� ������ Ȯ����
<-- ���� ������ �ٷ� �������� �ܹ� ������ Ȯ���ϰ� �� 
*/

-- �μ���ȣ 10 ��å MANAGER 
SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT * FROM EMP WHERE JOB = 'MANAGER';

SELECT * FROM EMP 
WHERE 1=2
AND   DEPTNO = 10 
AND   JOB = 'MANAGER';

SELECT * FROM EMP 
WHERE 1=1
AND   DEPTNO = 10 
AND   JOB = 'MANAGER';

SELECT * FROM EMP 
WHERE 1=2
AND   DEPTNO = 10 
AND   JOB = 'MANAGER';

-- �μ���ȣ 10 ��å MANAGER 
SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT * FROM EMP WHERE JOB = 'MANAGER';

SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER';

SELECT * FROM EMP 
WHERE 1=1
OR    DEPTNO = 10 
OR    JOB = 'MANAGER';

SELECT * FROM EMP 
WHERE 1=2
OR   DEPTNO = 10 
OR   JOB = 'MANAGER';

-- �μ���ȣ 10 20 ���
SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT COUNT(*) FROM EMP WHERE DEPTNO = 10;
SELECT * FROM EMP WHERE DEPTNO = 20;
SELECT COUNT(*) FROM EMP WHERE DEPTNO = 20;

SELECT * FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20;
SELECT COUNT(*) FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20;

-- IN() : ���� �÷��� �������� ���� ��ȸ �� �� 
SELECT COUNT(*) FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20;

-- Ŀ�̼��� 300, 500, 1400 ���
SELECT * FROM EMP WHERE COMM IN (300, 500, 1400);
SELECT * FROM EMP WHERE COMM = 300 OR COMM = 500 OR COMM = 1400;

SELECT * FROM EMP WHERE COMM NOT IN (300, 500, 1400);

-- 10�� �μ��� ����� ��� 
SELECT * FROM EMP WHERE DEPTNO = 10;

-- 10�� �μ��� �ƴ� ����� ��� 
SELECT * FROM EMP WHERE NOT DEPTNO = 10;
SELECT * FROM EMP WHERE DEPTNO <> 10;
SELECT * FROM EMP WHERE DEPTNO != 10;
SELECT * FROM EMP WHERE DEPTNO ^= 10;

-- �޿� 1000���� 1500 ������ ����� ��ȸ �Ͻÿ� 
SELECT * FROM EMP WHERE SAL >= 1000;
SELECT * FROM EMP WHERE SAL <= 1500;

-- FROM ~ TO ���� �˻� 
SELECT * FROM EMP 
WHERE SAL >= 1000
AND   SAL <= 1500;

SELECT  A.* 
FROM    EMP A
WHERE   1=1
AND     A.SAL <= 1500
AND     A.SAL >= 1000;

-- �޿��� 1000 �̸� �̰ų� 1500 �ʰ��� ����� ��ȸ 

SELECT * FROM EMP A
WHERE 1=1
AND (SAL < 1000
OR SAL > 1500);

-- FROM ~ TO : ���� �˻� 
-- BETWEEN A AND B
-- Ư�� �÷��� ������ ���� ���Ѱ�(A) �� ���Ѱ�(B) ���̿� ���Ե� �ο츦 ��ȯ�Ѵ�.
SELECT * FROM EMP
WHERE  1=1
AND    SAL BETWEEN 1000 AND 1500;

SELECT * FROM EMP
WHERE 1=1
AND SAL >= 1000
AND SAL <= 1500;

-- 1981�⿡ �Ի��� ����� ��ȸ�Ͻÿ�, �˻��Ͻÿ�, ����Ͻÿ� 
-- 19810101 ~ 19811231
-- �����˻�, BETWEEN A AND B
-- 81/02/20 �ڹ�ó�� ���ڿ� �ɰ��� �ֳ� ??  
-- ���̺� �ٸ��
SELECT HIREDATE FROM EMP WHERE ROWNUM <= 5;

SELECT A.* FROM SCOTT.EMP A
WHERE  1=1
AND    A.HIREDATE BETWEEN '1981/01/01' AND '1981/12/31';

SELECT A.* FROM SCOTT.EMP A
WHERE  1=1
AND    A.HIREDATE <= '1981/12/31'
AND    A.HIREDATE >= '1981/01/01'; 

SELECT A.* FROM SCOTT.EMP A
WHERE  1=1
AND    A.HIREDATE <= TO_CHAR(TO_DATE('1981/12/31'), 'YYYYMMDD')
AND    A.HIREDATE >= TO_CHAR(TO_DATE('1981/01/01'), 'YYYYMMDD'); 

--##################################################################
SELECT A.* FROM SCOTT.EMP A
WHERE  1=1
AND    TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') <= TO_CHAR(TO_DATE('1981/12/31'), 'YYYYMMDD')
AND    TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') >= TO_CHAR(TO_DATE('1981/01/01'), 'YYYYMMDD'); 
--##################################################################

--##################################################################
SELECT A.* FROM SCOTT.EMP A
WHERE  1=1       
AND    TO_CHAR(TO_DATE(A.HIREDATE), 'YYYY') = '1981';

SELECT SUBSTR('81/02/20', 1, 2) FROM DUAL;

SELECT A.HIREDATE FROM SCOTT.EMP A
WHERE  1=1       
AND   SUBSTR(A.HIREDATE, 1, 2) = '81';

SELECT SUBSTR(A.HIREDATE, 1, 2) AS HIREDATE FROM SCOTT.EMP A
WHERE  1=1       
AND   SUBSTR(A.HIREDATE, 1, 2) = '81';
--##################################################################

-- ���� STACK, ť QUEUE

-- SUBSTR(���ڿ�, ������ġ, ����)
SELECT SUBSTR('SMITH', 1, 2) FROM DUAL;
SELECT SUBSTR('SMITH', 1) FROM DUAL;
SELECT SUBSTR('SMITH', -1, 2) FROM DUAL;
SELECT SUBSTR('SMITH', -1) FROM DUAL;
SELECT SUBSTR('SMITH', -3, 2) FROM DUAL;
SELECT SUBSTR('SMITH', -3) FROM DUAL;

SELECT NVL(NULL, 0) FROM DUAL;
SELECT NVL(NULL, 'A') FROM DUAL;
SELECT NVL(NULL, 'AB') FROM DUAL;

--############################################
SELECT NULL FROM DUAL;
SELECT NULL + 1 FROM DUAL;
SELECT NVL(NULL, 0) + 1 FROM DUAL;
--############################################

SELECT SAL, COMM FROM EMP;

--########################
-- �ڰǿ� 
SELECT SAL 
FROM EMP;

SELECT COMM
FROM EMP; 

SELECT COMM, SAL
FROM EMP;
--########################

SELECT COMM FROM EMP;
SELECT COMM FROM EMP WHERE COMM > 0;
SELECT NVL(COMM, 0) AS COMM FROM EMP WHERE COMM > 0;

-- ��� ������ + - * /
-- ����� �޿��� ������ ����Ͻÿ� 
SELECT 1 + 2 FROM DUAL;
SELECT 1 * 2 FROM DUAL;
SELECT 1 * 12 FROM EMP;

SELECT SAL, SAL * 12 AS TSAL FROM EMP;

SELECT DEPTNO * 100, DNAME, LOC  FROM DEPT;

-- ����� �޿��� ����, ������ ����Ͻÿ� 
SELECT SAL, (SAL * 12) AS TSAL, COMM FROM EMP;

SELECT 'M' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '0001' FROM DUAL;

-- ����� �޿��� ����, ����, ������ ������ ���� �� ����Ͻÿ� 
SELECT SAL, (SAL * 12) AS TSAL, COMM, (SAL*12)+COMM AS CSAL FROM EMP;
-- �÷��� ��ȸ �� ���� NULL ���θ� �� üũ�ؾ� �ϰ�
-- ���� ���� �����ʹ� NULL �̸� ����Ʈ ������ ġȯ�� ���ƾ� �Ѵ�. 
-- ���ڿ� ���� �����ʹ� NULL �̸� ������ ������ ġȯ�� ���ƾ� �Ѵ�. 
SELECT 
        A.SAL                       AS SAL   -- �޿�
       ,A.SAL * 12                  AS TSAL  -- ����
       ,NVL(A.COMM, 0)              AS COMM  -- ���� 
       ,A. SAL * 12 + NVL(COMM, 0)  AS CSAL  -- ������������ ����
FROM 
        EMP A
ORDER BY TSAL DESC;     

SELECT 
        A.SAL                       
       ,A.SAL * 12                  
       ,NVL(A.COMM, 0)              
       ,A. SAL * 12 + NVL(COMM, 0)  
FROM 
        EMP A
ORDER BY 3 DESC; 


-- ��������� �޿��� 300���� �λ����ش�.
-- ����̸� , �޿�, �λ�� �޿�(����)�� ����Ͻÿ� 
SELECT 
        A.ENAME             AS ENAME
       ,A.SAL               AS SAL
       ,A.SAL * 12 + 300    AS GSAL
FROM    EMP A;

-- 10�� �μ��� ����鿡�� ������ 300���� �ϰ� �����Ͻÿ� 
-- ����̸�, ������ ����Ͻÿ� 

SELECT   A.ENAME                    AS ENAME
        ,NVL(A.COMM,0) +300         AS COMM
FROM
         EMP A
WHERE
         A.DEPTNO = 10;
        
-- 1981�� 9�� �Ի���, ���� 500 ���� 
-- �����ȣ, ����̸�, ��å, �Ի���(YYYY-MM-DD), ������ ����Ͻÿ� 
SELECT 
        A.EMPNO                             AS EMPNO
       ,A.ENAME                             AS ENAME
       ,A.JOB                               AS JOB
       ,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')   AS HIREDATE
       ,NVL(A.COMM, 0) + 500                AS COMM
FROM    EMP A
WHERE   1=1
AND     TO_CHAR(A.HIREDATE, 'YYYYMM') = '198109';

SELECT 
        A.EMPNO                             AS EMPNO
       ,A.ENAME                             AS ENAME
       ,A.JOB                               AS JOB
       ,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')   AS HIREDATE
       ,NVL(A.COMM, 0) + 500                AS COMM
FROM    EMP A
WHERE   1=1
AND     TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') <= TO_CHAR(TO_DATE('1981/09/31'), 'YYYYMMDD')
AND     TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') >= TO_CHAR(TO_DATE('1981/09/01'), 'YYYYMMDD'); 

-- 1981�� 2�� 20�� ���� 1981�� 5�� 1�� ���̿� �Ի��� ����� 
-- �̸�, ��å, �Ի���(YYYY.MM.DD), �޿�, ����, �󿩱��� ����Ͻÿ� 
-- ��� ������ ������ ���� ������ ��� �Ͻÿ� 

--#########################################################
-- ������ ����� 
SELECT 
        --A.*  
         A.ENAME
        ,A.JOB
        ,TO_CHAR(TO_DATE(A.HIREDATE,'YYYY.MM.DD'))
        ,NVL(A.SAL,0)
        ,NVL(A.SAL,0) * 12
        ,NVL(A.COMM,0)
FROM 
        EMP A
WHERE   1 = 1
AND     TO_CHAR(TO_DATE(A.HIREDATE),'YYYY-MM-DD') >= TO_CHAR(TO_DATE('1981-02-20'),'YYYY-MM-DD')
AND     TO_CHAR(TO_DATE(A.HIREDATE),'YYYY-MM-DD') <= TO_CHAR(TO_DATE('1981-05-01'),'YYYY-MM-DD')
ORDER BY 5 DESC;
--#########################################################

SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO = 7369 AND ENAME = UPPER('smith');

SELECT 'M' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '0001' FROM DUAL;
SELECT 'M' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '0002' FROM DUAL;

SELECT * FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT COMM FROM EMP;
SELECT DISTINCT MGR FROM EMP;
SELECT DISTINCT DEPTNO, EMPNO FROM EMP;

SELECT * FROM EMP WHERE ROWNUM <= 10;

SELECT AA.* FROM (SELECT HIREDATE FROM EMP WHERE ROWNUM <= 1) AA;

SELECT   TO_CHAR(TO_DATE(AA.HIREDATE), 'YYYY-MM-DD') AS HIREDATE
        ,AA.JOB                                      AS JOB
FROM (SELECT HIREDATE, JOB FROM EMP WHERE ROWNUM <= 1) AA;

-- NULL �ִ� �÷��� ���� �ϸ�, ��Ʈ �ϸ�, ORDER BY �ϸ�
-- ����Ŭ�� ORDER BY �ϸ� DEFAULT �� ASCENDING 
SELECT * FROM EMP ORDER BY COMM;
SELECT * FROM EMP ORDER BY MGR;

SELECT * FROM EMP ORDER BY COMM DESC;
SELECT * FROM EMP ORDER BY MGR DESC;

SELECT * FROM EMP ORDER BY COMM NULLS FIRST;
SELECT * FROM EMP ORDER BY COMM NULLS LAST;

SELECT NULL + 1 FROM DUAL;

SELECT NVL(NULL, 0) FROM DUAL;
SELECT NVL(NULL, 'AA') FROM DUAL;

SELECT NVL2(NULL, 'NOT NULL', 'NULL') FROM DUAL;
SELECT NVL2('AA', 'NOT NULL', 'NULL') FROM DUAL;
