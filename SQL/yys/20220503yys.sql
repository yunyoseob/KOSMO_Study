SELECT*FROM EMP;
SELECT*FROM DEPT;

-- �Ի����� ���� ������ 5���� ���Ͻÿ�.
-- �����ʹ� �� ������ Ȯ���ؾ� �Ѵ�. �Ǽ��� ������ ����üŷ �Ѵ�.
-- �Ǽ��� ������ ��ǥ���� ������ Ÿ��   �����ؼ� Ȯ���ؾ� �Ѵ�.

-- 1. �Ի��� ���� Ȯ�� �ϴ� �� : 14���̴ϱ�
SELECT HIREDATE FROM EMP;

SELECT HIREDATE FROM EMP ORDER BY HIREDATE ASC;

SELECT HIREDATE FROM EMP WHERE ROWNUM<=5;

-- FROM ������ �ڽ� ���� �ζ��� �� ����������
-- �Ի��� ���� ������ ��Ʈ�� �����Ѵ�.
-- ���� �θ� �������� 5���� ���Ѵ�.
SELECT A.HIREDATE
FROM
-- �ζ��� �� ��������  
(SELECT HIREDATE FROM EMP ORDER BY HIREDATE ASC) A
WHERE ROWNUM<=5;

/*
SELECT
        SELECT*FROM DUAL;
FROM
        SELECT*FROM DUAL;
WHERE
        SELECT*FROM DUAL;
*/

SELECT*FROM EMP;
SELECT*FROM DEPT;
DESC EMP;
DESC DEPT;

SELECT*FROM DEPT;

SELECT DISTINCT DEPTNO FROM EMP;
-- 10,20,30�� ���´�.

SELECT DEPTNO FROM EMP GROUP BY DEPTNO;

SELECT UNIQUE(DEPTNO) FROM EMP;

--##############################
-- ���� : ���̺��� ��ġ�� �� : ���� ���� ���̺��� ���� Ű�� ������ ��ġ�� ��
--              �� ����Ű�� ��� ��ĥ �� �ִ�.
-- PK, FK
-- EQUL JOIN ��������, EQUAL JOIN �������� : INNER JOIN : �̳�����
-- NOT-EQUL JOIN �� ���� ����
-- SELF JOIN ���� ����
-- OUTER JOIN �ƿ��� ����
-- ##############################

-- INNER JOIN: �̳�����
-- ������ = ����ؼ� �� ���̺��� ������ �÷��� ��Ī�ؼ� ��ȸ�ϴ� ��

-- �̳� ������ ���̺� �ִ� ��� �����͸� ��ȸ �� ���� ����.
-- �÷��� �����Ͱ� ��Ī�� ���� ������ �����͸� ��ȸ�� ���� ����. <-- �� ������ �����ϴ� ������ OUTER JOIN �ƿ��� �����̴�.
-- ##############################
-- ���̺��� ������ ���� �� ���̺� ����� ����ϱ�
SELECT*FROM EMP A;
SELECT*FROM DEPT B;

SELECT*FROM EMP A, DEPT B WHERE A.DEPTNO=B.DEPTNO;
SELECT*FROM DEPT B, EMP A WHERE B.DEPTNO=A.DEPTNO;

SELECT A.*, B.*
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO;

SELECT*FROM EMP WHERE EMPNO='7369';

SELECT DNAME FROM DEPT WHERE DEPTNO='20';
-- RESEARCH

SELECT DNAME FROM DEPT WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE EMPNO='7369');
-- RESEARCH

-- INNER JOIN
SELECT B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND A.EMPNO='7369';
-- RESEARCH
SELECT A.DEPTNO EMP_T, B.DEPTNO DEPT_T
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
ORDER BY 1;

SELECT DEPTNO FROM DEPT;

-- OUTER JOIN
-- (+) �ƿ��� ������ ������ : ������ ������ �� (����) ���̺� �����ڸ� ���δ�.
-- �ƿ��� ���� ����
-- 1. ���� ���������� ���� �Ѵ�. : ������=
-- 2. �����Ͱ� ���� ���̺� �ƿ��� ���� ������ (+)�� ���δ�.
SELECT A.DEPTNO EMP_T, B.DEPTNO DEPT_T
FROM EMP A, DEPT B
WHERE A.DEPTNO(+)=B.DEPTNO
ORDER BY 1;







