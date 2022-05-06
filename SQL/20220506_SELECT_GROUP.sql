SELECT * FROM EMP;
-- �÷��� �ο� ����� �����Ѵ�. 
-- 1. �ο츦 �����Ѵ�. 
-- 2. �÷��� �����Ѵ�. 
-- 3. �ش��ϴ� ���̺� �ִ� ��� �����͸� �����Ѵ�.
-- 4. �ش��ϴ� ���̺��� ��� �����͸� �ο� ������ �����Ѵ�. 

SELECT ROWID FROM EMP;

SELECT ROWID, EMPNO FROM EMP;

SELECT ROWID, EMPNO FROM EMP WHERE ROWNUM <= 5;

SELECT 1, 2 FROM EMP WHERE ROWNUM <= 2;

SELECT COUNT(1) FROM EMP;
SELECT 24*60*60 FROM DEPT WHERE ROWNUM <= 1;
SELECT 24*60*60 FROM DUAL;

-- EMP ���̺��� �ο� ������ �÷� ��ü�� ��ȸ �ߴ�. 
SELECT * FROM EMP;

-- SELECT Ű���带 ���̺��� �Լ��� ����ؼ� ��ȸ �Ҷ��� 
-- 1. ������ ����  
SELECT TO_CHAR(HIREDATE) FROM EMP;
SELECT TO_DATE(HIREDATE) FROM EMP;

-- 2. �Ѱ��� �� ����
SELECT COUNT(*) FROM EMP;
SELECT SUM(SAL) FROM EMP;
SELECT AVG(SAL) FROM EMP;
SELECT MIN(SAL) FROM EMP;
SELECT MAX(SAL) FROM EMP;

-- ������̺� �ִ� ������� �μ���ȣ�� ��ȸ �Ͻÿ�
SELECT DEPTNO FROM EMP;

SELECT DISTINCT DEPTNO FROM EMP;

SELECT DEPTNO FROM EMP GROUP BY DEPTNO;


-- GROUP BY���� �⺻ ���� 
-- SELECT   [��ȸ�� ��1 �̸�], [��2 �̸�], .... [��N �̸�]
-- FROM     [��ȸ�� ���̺� �̸�]
-- WHERE    [��ȸ�� ���� �����ϴ� ���ǽ�]
-- GROUP BY [�׷�ȭ�� ���� ����(���� �� ���� ����)]
-- HAVING   [��� �׷��� �����ϴ� ���ǽ�]
-- ORDER BY [�����Ϸ��� �� ����]

SELECT DEPTNO
FROM   EMP
GROUP BY DEPTNO;

SELECT DEPTNO
FROM   EMP
GROUP BY DEPTNO
ORDER BY 1;

SELECT DEPTNO
FROM   EMP
GROUP BY DEPTNO
ORDER BY 1 DESC;

SELECT DEPTNO 
FROM   EMP
GROUP BY DEPTNO;











