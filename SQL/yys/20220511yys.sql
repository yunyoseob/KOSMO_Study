SELECT*FROM EMP;

SELECT DEPTNO, EMPNO, ENAME, SAL FROM EMP;

-- �޿��� ������ �Ű� ������.
-- ��������? ��������?

-- ���� ������ ���� ���� ���;� �ϴ� ������
SELECT MAX(SAL) FROM EMP;
-- 5000

-- ���� ������ ���� ���� ���;� �ϴ� ������
SELECT MIN(SAL) FROM EMP;
-- 800

-- COLUMN INDEX�� �������� �����غ���
SELECT DEPTNO,  EMPNO, ENAME, SAL
FROM EMP
ORDER BY 4 DESC;

-- COLUMN LABEL�� �������� �����غ���
SELECT DEPTNO, EMPNO, ENAME, SAL
FROM EMP
ORDER BY SAL DESC;

-- RANK : �ߺ� ���� ���� ���� �ǳʶ�. (1,2,3,4)
-- DENSE_RANK : �ߺ� ���� ���� ���� ����. (1,2,3,4)
-- ROW_NUMBER : �ߺ� ���� ���� ���ϰ�. (1,2,3,4)

-- OVER�� SUBQUERY, GROUP BY�� ��� ���ִ� �м��Լ��̴�.
-- GROUP BY, ORDERY BY�� �����Լ���� �Ѵ�.
SELECT DEPTNO, EMPNO, ENAME,  SAL
                ,RANK() OVER (ORDER BY SAL DESC) AS RK
                ,DENSE_RANK() OVER(ORDER BY SAL DESC) AS DR
                ,ROW_NUMBER() OVER(ORDER BY SAL DESC) AS RN
FROM EMP;                

/*
OVER() �Լ�
GROUP BY�� ���������� ������� �ʰ�
SUM, AVG, MAX, MIN, COUNT(�м� �Լ�)��
GROUP BY, ORDER BY(���� �Լ�) ���� ���� ���̸� ����

�м�_�Լ�() OVER(PARTITION BY Į�� / ORDER BY �÷� / �κ� ���� ����)
���⼭ �м� �Լ��� OVER()�� �ʼ�����
OVER ���� ������� �ʿ��� ��쿡�� �ۼ����ָ� �ȴ� (ORDER BY�� �ʼ��� �ƴϴ�)
RANK, DENSE_RANK�� ORDER BY �ʼ�
*/

-- �׷캰�� ���� �ο�
SELECT EMPNO, ENAME, SAL,
                 RANK() OVER(PARTITION BY DEPTNO ORDER BY SAL DESC) AS RK
                 , DEPTNO
FROM EMP;    

-- ROW_NUMBER() OVER()
SELECT ROWID, ROWNUM, EMPNO, ENAME, SAL
                ,ROW_NUMBER() OVER(ORDER BY SAL DESC) AS RK
FROM EMP;

SELECT*FROM EMP;




