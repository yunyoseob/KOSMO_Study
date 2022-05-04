SELECT HIREDATE FROM EMP;

-- �Ի����� ���� ������ 5���� ���Ͻÿ� 
-- �����ʹ� �� ������ Ȯ�� �ؾ� �Ѵ�. �Ǽ� �� ������ ����üŷ �Ѵ�.
-- �Ǽ��� ������ ��ǥ���� ������ Ÿ�� �����ؼ� Ȯ�� �ؾ� �Ѵ�. 

-- 1. �Ի��� ���� Ȯ�� �ϴ� �� : 14�� �̴ϱ�
SELECT HIREDATE FROM EMP;

SELECT HIREDATE FROM EMP ORDER BY HIREDATE ASC;

SELECT HIREDATE FROM EMP WHERE ROWNUM <= 5;

-- ���������� �ڽ� ���� �ζ��� �� ���������� 
-- �Ի��� ���� ������ ��Ʈ�� �����Ѵ�.
-- ���� �θ� �������� 5���� ���Ѵ�.
SELECT A.HIREDATE 
FROM
    -- �ζ��� �� �������� 
    (SELECT HIREDATE FROM EMP ORDER BY HIREDATE ASC) A
WHERE ROWNUM <= 5;

/*
SELECT 
    SELECT * FROM DUAL;
FROM 
    SELECT * FROM DUAL;
WHERE 
    SELECT * FROM DUAL;
*/

SELECT * FROM EMP;
SELECT * FROM DEPT;

DESC EMP;
DESC DEPT;

SELECT * FROM DEPT;
SELECT DISTINCT DEPTNO FROM EMP;
SELECT DEPTNO FROM EMP GROUP BY DEPTNO;


--####################################################
-- ���� : ���̺��� ��ġ�� �� : �������� ���̺��� ���� Ű�� ������ ��ġ�� �� 
--      �� ����Ű�� ��� ��ĥ �� �ִ�. 
-- PK, FK 
-- EQUI JOIN ��������, EQUAL JOIN �������� : INNSER JOIN �̳�����
-- NOT-EQUI JOIN �� ��Ű����
-- SELF JOIN ���� ����
-- OUTER JOIN �ƿ��� ���� 




-- EQUI JOIN : ��Ű ����, EQUAL JOIN : �������� 
-- �� ���� ���̺��� �� ���� ������ ���̺� ó�� ���, 
-- �� ���� ���̺��� ����� ���� ���̺��� ���� �����Ѵ�, 
-- ���� �÷� �������� ����

--###############################################
-- INNSER JOIN : �̳����� 
-- ������ = ����ؼ� �� ���̺��� ������ �÷��� ��Ī�ؼ� ��ȸ�ϴ� ��  

-- �̳� ������ ���̺� �ִ� ��� �����͸� ��ȸ �� ���� ����.
-- �÷��� �����Ͱ� ��Ī�̵��� ������ �����͸� ��ȸ�� ���� ����. <-- �� ������ �����ϴ� ������ OUTER JOIN �ƿ��� ���� �̴�. 
--###############################################
-- ���̺��� ������ ���� �� ���̺� �ٸ�� ����ϱ� 
SELECT * FROM EMP A;
SELECT * FROM DEPT B;

SELECT * FROM EMP A, DEPT B WHERE A.DEPTNO = B.DEPTNO;
SELECT * FROM DEPT B, EMP A WHERE B.DEPTNO = A.DEPTNO;

SELECT A.*, B.*
FROM   EMP A, DEPT B
WHERE  A.DEPTNO = B.DEPTNO;

SELECT * FROM EMP WHERE EMPNO = '7369';
SELECT DNAME FROM DEPT WHERE DEPTNO = '20';

SELECT DNAME FROM DEPT WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE EMPNO = '7369');

-- INNER JOIN
SELECT B.DNAME
FROM   EMP A, DEPT B
WHERE  A.DEPTNO = B.DEPTNO
AND    A.EMPNO = '7369';

SELECT A.DEPTNO EMP_T, B.DEPTNO DEPT_T
FROM   EMP A, DEPT B
WHERE  A.DEPTNO = B.DEPTNO
ORDER BY 1;

SELECT DEPTNO FROM DEPT;

-- OUTER JOIN
-- (+) �ƿ��� ������ ������ : ������ ������ ��(����) ���̺� �����ڸ� ���δ�.
-- �ƿ��� ���� ����
-- 1. ���� ���������� ���� �Ѵ�. : ������ =
-- 2. �����Ͱ� ���� ���̺� �ƿ������� ������ (+)�� ���δ�. 
SELECT A.DEPTNO EMP_T, B.DEPTNO DEPT_T
FROM   EMP A, DEPT B
WHERE  A.DEPTNO(+) = B.DEPTNO
ORDER BY 1;










