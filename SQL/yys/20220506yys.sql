-- 20220506
SELECT*FROM EMP;
-- 14���� ��(ROW)�� �����Ѵ�.

-- �÷��� �ο� ����� �����Ѵ�.
-- 1. �ο츦 �����Ѵ�.
-- 2. �÷��� �����Ѵ�.
-- 3. �ش��ϴ� ���̺� �ִ� ��� �����͸� �����Ѵ�.
-- 4. �ش��ϴ� ���̺��� ��� �����͸� �ο� ������ �����Ѵ�.
SELECT ROWID FROM EMP;
-- ������ ROW�̴�. �� ROW�� ID�� �����Ѵ�.

SELECT ROWID, EMPNO FROM EMP;

SELECT 1,2,3 FROM EMP;

-- ������ ������
SELECT 1 FROM EMP;

SELECT COUNT(1) FROM EMP;
-- 14���� ���� �����Ƿ�, 14�� �����µ�,
-- �� ��, �����ؾ� �� ������ ���� ���� �����ϴ� ���̴�.

SELECT 1 FROM DEPT;
-- 4���� �࿡ �����Ͱ� 1�� �ԷµǾ� ��µȴ�.
SELECT COUNT(1) FROM DEPT;
-- �� ���� ����(4��)�� ���������� �����Ѵ�.
SELECT*FROM DEPT;


SELECT 24*60*60 FROM DUAL;
-- 86400 : �Ϸ縦 1�� ������ ȯ���� ��
SELECT 24*60*60 FROM DEPT;
-- 86400 : �Ϸ縦 1�� ������ ȯ���� ��

SELECT DEPTNO
                , DNAME, LOC
                , 24*60*60 AS DAYPERSECONDS 
FROM DEPT;

-- �Լ��� ���� �� ���� �ο찡 ���ϵǴ��� üũ�ؾ��Ѵ�.
-- �ο� => �÷� ������ ��ȸ�Ѵ�.
-- ������ ���� :  ���ǿ� �����ϴ� �����Ͱ� �� �Ǹ� ��ȸ���� �ƴ϶� 
-- ��ü �����͸� ��ȸ�ؼ� ����� ���� ��, �ϳ��� ������ �����Ѵ�.
-- �ٸ� ���� ���� �����ڶ�� �Ѵ�.
SELECT MIN(HIREDATE) FROM EMP;
SELECT MAX(HIREDATE) FROM EMP;
SELECT ROUND(AVG(SAL), 2) FROM EMP;
SELECT SUM(COMM) FROM EMP;

-- ������ ���� : ���ǿ� �����ϴ� �����͸� ���� ���� ������ �����Ѵ�.
SELECT TO_CHAR(HIREDATE) FROM EMP;
SELECT TO_DATE(HIREDATE) FROM EMP;

-- �� �μ��� ���� ������ ���� �޴� ������ ������� �μ� �̸���  ����Ͻÿ�.
SELECT MAX(ENAME), DEPTNO
FROM EMP
GROUP BY DEPTNO;

SELECT A.ENAME
                 ,B.DNAME
FROM (SELECT MAX(ENAME) AS ENAME
                                 , DEPTNO
                FROM EMP
                GROUP BY DEPTNO) A, DEPT B
WHERE A.DEPTNO=B.DEPTNO;                

-- GROUP BY ���� �⺻ ����
/*
-- GROUP BY���� �⺻ ����
-- SELECT       [��ȸ�� ��1 �̸�], [��2 �̸�], ..., [��N�̸�]

[]  : KEY & VALUE �� �̷���� �迭
��ȸ�� ��1 �̸� : Į����
, : SEPERATE

-- FROM         [��ȸ�� ���̺� �̸�]
-- WHERE        [��ȸ�� ���� �����ϴ� ���ǽ�]
-- GROUP BY     [�׷�ȭ�� ���� ����(���� �� ���� ����)]
-- HAVING [��� �׷��� �����ϴ� ���ǽ�]
-- ORDER BY     [�����Ϸ��� �� ����]
*/

