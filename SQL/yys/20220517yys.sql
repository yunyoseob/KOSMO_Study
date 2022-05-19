-- 2022 05 17

-- ������� ��ȸ�ϰ��� �ϴ� ����(ǥ��)�� ���� �ڿ� ������ �ɰ�, �˻��� �ϴ� 
-- �ζ��� �� �������� Ȱ�뿹��
SELECT A.*
FROM DEPT A, (SELECT DEPTNO FROM EMP WHERE ENAME='SMITH') B
WHERE A.DEPTNO=B.DEPTNO;

-- ����Ʈ ����� ������ �μ����� �ٹ��ϴ� ����� �̸�, �μ���ȣ�� ��ȸ�Ͻÿ�.

-- 1.  �̸��� ����Ʈ�� ����� ��� ���̺� �ֳ���?
SELECT*FROM EMP WHERE ENAME='SCOTT';
-- 1-1. EMP���̺� �ִ�. ����Ʈ����� DEPTNO(�μ���ȣ)�� 20���̴�.

-- 2.  ������ �μ���ȣ�� �ٹ��ϴ� ����� ������ ��ȸ�غ��ô�.
SELECT*FROM EMP WHERE DEPTNO='20';
-- 2-1. 20�� �μ����� ���ϰ� �ִ� ����� ����?
SELECT COUNT(EMPNO) FROM EMP WHERE DEPTNO='20';
-- 5���� ���;� �Ѵٴ� ���� �� �� �ִ�.

-- 3. ����Ʈ ����� ������ �μ����� �ٹ��ϴ� ����� �̸�, �μ���ȣ�� ��ȸ�Ͻÿ�.
SELECT ENAME, DEPTNO FROM EMP  WHERE DEPTNO='20';
-- 5���� ENAME��  DEPTNO�� ���Դ�.

--**  SMITH�� �μ���ȣ�� 20������ �𸣴� ��Ȳ���� ��ȸ�ϴ� ��� **
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SMITH');

-- ���� ���� : ����Ʈ ����� ������ �μ����� �ٹ��ϴ� ����� �̸�, �μ���, �μ���ȣ�� ��ȸ�Ͻÿ�.

-- 1. ��� �̸��� ����Ʈ�� ����� ��� ���̺� �ִ°�?
-- EMP  ���̺��� ��ȸ�غ���
SELECT*FROM EMP WHERE ENAME='SCOTT';
-- ����Ʈ����� �μ� ��ȣ�� 20���̴�.

-- 2. �μ���ȣ�� 20���� �μ��� �̸��� �����ΰ�?
--  DEPT ���̺��� ��ȸ�ݱ�
SELECT*FROM DEPT WHERE DEPTNO='20';
-- �μ���ȣ�� 20���� �μ��� �̸��� RESEARCH �̴�.

-- �μ���ȣ�� 20�� ��, ����� �̸�, �μ���, �μ���ȣ�� ��ȸ�ض� (3���� �������)

-- 1ST METHOD
-- INNER JOIN
SELECT A.ENAME,  B.DNAME, A.DEPTNO
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND A.DEPTNO=20;

-- 2ND METHOD
-- INLINE VIEW SUBQUERY AND INNER JOIN
SELECT A.ENAME, B.DNAME, A.DEPTNO
FROM (SELECT*FROM EMP WHERE DEPTNO=20) A, DEPT B
WHERE A.DEPTNO=20
AND A.DEPTNO=B.DEPTNO;


-- 3RD METHOD
-- ������ SUBQUERY  AND INNER JOIN
SELECT A.ENAME, B.DNAME, A.DEPTNO
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND A.DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SMITH');

-- �ִ� �޿��� �޴� ����� �̸�, ������, �޿��� ��ȸ�Ͻÿ�
-- 1. EMP ���̺��� �ִ� �޿��� ���ϱ�?
SELECT MAX(SAL) FROM EMP;
-- 5000

-- 2. ����� �̸�, ������, �޿� ��ȸ�ϱ�
SELECT ENAME, JOB, SAL FROM EMP;

-- 3. ���� ��ġ��
-- ���̺� ������� ���������ȿ����� ���� �ʴ´�.
SELECT A.ENAME, A.JOB, A.SAL
FROM  EMP A
WHERE A.SAL=(SELECT MAX(SAL) FROM EMP);

-- 4. �ٸ� ������� Ǯ��� (MAX �Լ� �Ⱦ���)
-- �޿� ������� ��½�Ű��
SELECT*FROM EMP ORDER BY SAL DESC;

-- �޿� ������� ���� ���� �ִ� ����� ���� ����
SELECT A.ENAME, A.JOB, A.SAL
FROM (SELECT*FROM EMP ORDER BY SAL DESC) A
WHERE ROWNUM=1;

-- ���� �޿��� �޴� ����� �̸�, ������, �޿��� ��ȸ�Ͻÿ�
-- MIN �Լ� ���� ����
SELECT A.ENAME, A.JOB, A.SAL
FROM  EMP A
WHERE A.SAL=(SELECT MIN(SAL) FROM EMP);

-- MIN �Լ� �� ���� ����
SELECT A.ENAME, A.JOB, A.SAL
FROM  (SELECT*FROM EMP ORDER BY SAL ASC) A
WHERE ROWNUM=1;

-- EMP ���̺��� ��� �޿�
SELECT AVG(SAL) FROM EMP;
-- 2073.2142857134.......
SELECT ROUND(AVG(SAL), 2) FROM EMP;
-- 2073.32
SELECT CEIL(AVG(SAL)) FROM EMP;
-- 2074
SELECT FLOOR(AVG(SAL)) FROM EMP;
-- 2073


-- 30�� �μ����� ���� �޿� �޴� ���
SELECT MIN(SAL) FROM EMP WHERE DEPTNO='30';
-- 30�� �μ��� ���� �޿� : 950

SELECT*FROM EMP A 
WHERE SAL=(SELECT MIN(SAL) FROM EMP WHERE DEPTNO='30');

-- �ٸ� ������� Ǯ���
SELECT MIN(A.SAL)
FROM  (SELECT*FROM EMP WHERE DEPTNO='30') A;

SELECT*
FROM EMP A
WHERE A.SAL=(SELECT MIN(SAL)
                                  FROM  (SELECT*FROM EMP WHERE DEPTNO='30'));

-- �μ��� ���� �޿���?
SELECT MIN(SAL), DEPTNO FROM EMP 
GROUP BY DEPTNO;
-- 950, 30
-- 800, 20
-- 1300, 10

-- �����غ���
SELECT*FROM EMP WHERE DEPTNO=10 ORDER BY SAL ASC;
-- 1300, 10
SELECT*FROM EMP WHERE DEPTNO=20 ORDER BY SAL ASC;
-- 800, 20
SELECT*FROM EMP WHERE DEPTNO=30 ORDER BY SAL ASC;
-- 950, 30

-- 30�� �μ����� ���� �޿��� �޴� ���?
SELECT MIN(A.SAL)
FROM (SELECT*FROM EMP WHERE DEPTNO=30) A;
-- 950

SELECT ENAME
FROM EMP A
WHERE A.SAL= (SELECT MIN(SAL)
                                    FROM (SELECT*FROM EMP WHERE DEPTNO=30));
-- ��� �̻�
SELECT COUNT(EMPNO) FROM EMP A
WHERE A.SAL >= (SELECT AVG(SAL) FROM EMP);

-- ��� ����
SELECT*FROM EMP A
WHERE A.SAL <= (SELECT AVG(SAL) FROM EMP);

-- ���� �޿��� ���� ����� �޿��� �޿��� ���� ���� ����� �޿��� ���̴�?
SELECT MAX(SAL), MIN(SAL), MAX(SAL)-MIN(SAL)
FROM EMP;
-- 4200

-- �޿��� ǥ��������
SELECT STDDEV(SAL) FROM EMP;
-- 1182

-- ================================================

-- �޿��� ���+3*(ǥ������) ���� �޿��� �� ���� �޴� ����� �ִ°�?
SELECT COUNT(EMPNO) FROM EMP A
WHERE SAL>(SELECT AVG(SAL)+(3*STDDEV(SAL)) FROM EMP);
-- 0 : ����

-- �޿��� ���+2*(ǥ������) ���� �޿��� �� ���� �޴� ����� �ִ°�?
SELECT COUNT(EMPNO) FROM EMP A
WHERE SAL>(SELECT AVG(SAL)+(2*STDDEV(SAL)) FROM EMP);
-- 1: 1���� �����Ѵ�.

SELECT*FROM EMP A
WHERE SAL>(SELECT AVG(SAL)+(2*STDDEV(SAL)) FROM EMP);
-- ���� �̸��� �ٷ� KING

-- �޿��� ���+1*(ǥ������) ���� �޿��� �� ���� �޴� ����� �ִ°�?
SELECT*FROM EMP A
WHERE SAL>(SELECT AVG(SAL)+(STDDEV(SAL)) FROM EMP);
-- KING�� �ش� �ȴ�.



