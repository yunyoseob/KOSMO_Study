-- 2022 05 19 

-- do it �ǽ����� 9-6
SELECT*FROM EMP
WHERE DEPTNO IN (20, 30);
-- (11, 8) : 11�� 8���� �����Ͱ� ��µǾ���.


SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO;
-- (3, 1) : 3�� 1���� �����Ͱ� ��µǾ���.
-- 2850,3000,5000


--  do it �ǽ����� 9-7
SELECT*FROM EMP
WHERE SAL 
IN (SELECT MAX(SAL) 
       FROM EMP 
       GROUP BY DEPTNO);
-- EMP ���̺��� ������ (2850, 3000, 5000�� �ش��ϴ� ����� ������ ����Ͻÿ�.)

-- ANY ������
-- ���������� ���� ��� �� ��� �ϳ��� ���� ������ �Ǹ� ���� ��ȯ�Ѵ�.
-- SALESMAN ������ �޿����� ���� �޴� ����� ������ �޿� ������ ����Ͻÿ�
SELECT ENAME, SAL, JOB, DEPTNO
FROM  EMP
WHERE DEPTNO !=20
AND SAL > ANY (SELECT SAL FROM EMP WHERE JOB='SALESMAN')
ORDER BY 2;

-- DO IT 9-9
SELECT*FROM EMP
WHERE SAL = ANY(SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO);


-- SALES MAN�� ������� ���غ�����
SELECT*FROM EMP WHERE ROWNUM<=1;

-- CLERK
SELECT COUNT(A.EMPNO) AS NCNT 
FROM EMP A
WHERE A.JOB='SALESMAN';
-- 4


SELECT*FROM EMP A
WHERE A.JOB='SALESMAN';
-- ANY�� �Ἥ �غ�����

SELECT*
FROM EMP A
WHERE A.JOB=ANY(SELECT JOB FROM EMP WHERE  JOB='SALESMAN');


-- ������ SALESMAN�� ����� ����, �޿�, �μ���ȣ��
-- ������������ �����Ͽ�  ����Ͻÿ�.
SELECT JOB, SAL, DEPTNO 
FROM EMP
WHERE JOB='SALESMAN' ORDER BY 2;

SELECT SAL, DEPTNO FROM EMP WHERE SAL>=1250  ORDER BY 1;

-- ALL ������
-- ���������� ���� ��� �� �� ��� ���� �����ؾ� ���� ��ȯ�Ѵ�.
-- ���  SALESMAN ������ �޿����� ���� �޴� ����� ������ �޿� ������ ����Ͻÿ�.

SELECT ENAME, SAL, JOB, DEPTNO
FROM EMP
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE JOB='SALESMAN');
SELECT SAL FROM EMP WHERE JOB='SALESMAN' ORDER BY 1;
/*
1250
1250
1500
1600
*/

-- EXISTS ������
-- �������� �����Ͱ� �����ϴ°��� üũ�� ���� ����(TRUE, FALSE)�� ����� ��ȯ�Ѵ�.

-- do it
SELECT*
FROM EMP
WHERE EXISTS (SELECT DNAME
                                    FROM  DEPT
                                    WHERE DEPTNO=10);


SELECT DNAME
FROM  DEPT
WHERE DEPTNO=10;
-- ACCOUNTING
-- DEPT ���̺��� DEPTNO�� 10�� �μ��� �̸���
-- �����ϴ��� üũ + �����Ѵٸ� �ش� �μ��� �̸��� ��������
-- EMP ���̺��� �ش� ���ǿ� �´� ������ ��½�Ų��.

SELECT*
FROM EMP
WHERE EXISTS (SELECT DNAME
                                    FROM  DEPT
                                    WHERE DEPTNO=50);
-- EXISTS�� FALSE�̸� EMP���̺��� �ƹ��� ������ ��ȸ���� �ʴ´�.

-- ����� ���� ����
-- EMP ���̺��� ���� ������ ����, �μ���ȣ�� �μ��̸��� �ߺ����� 
--  �μ���ȣ ������ ����ϼ���.
SELECT DISTINCT A.DEPTNO, A.DNAME
FROM DEPT A, EMP B
WHERE A.DEPTNO=B.DEPTNO ORDER BY 1;
/*
DEPTNO DNAME
10	            ACCOUNTING
20	            RESEARCH
30	            SALES
*/

SELECT A.DEPTNO, A.DNAME
FROM DEPT A, EMP B
WHERE A.DEPTNO=B.DEPTNO
GROUP BY  A.DEPTNO
ORDER BY 1;

SELECT A.DEPTNO, A.DNAME
FROM DEPT A
WHERE EXISTS (SELECT 1 FROM EMP B WHERE B.DEPTNO=A.DEPTNO)
ORDER BY 1;

-- ���� ��(�÷�) (Multi-Column) ��������
-- ��� ���� �� �� �̻��� �÷��� ��ȯ�ϴ� ��������
SELECT EMPNO, SAL, DEPTNO
FROM EMP
WHERE (SAL, DEPTNO) IN (SELECT SAL, DEPTNO FROM EMP WHERE DEPTNO=30 AND COMM IS NOT NULL);

SELECT SAL, DEPTNO FROM EMP WHERE DEPTNO=30 AND COMM IS NOT NULL;
/*
SAL     DEPTNO
1600	    300.
1250	    30
1250	    30
1500	    30
*/

