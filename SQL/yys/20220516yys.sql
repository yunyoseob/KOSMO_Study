-- 20220516 ��������
-- ���������� ������ �ϳ� �� �ִٴ� �ǹ��̴�.
-- �ܹ� : �ܼ� ���� (SELECT FROM WHERE GROUP BY HAVING ORDER BY) : �������� ���� ¥��� ��
-- ���� : ������ �ϳ��� �ƴ϶� ���� ���� ���̺��� �����͸� ��ȸ�ϴ� ���� �ǹ�

-- SELECT ����  SELECT �� => ��Į�� ��������
-- ���ӵ�� �����ؼ� �����.
-- �÷� �ϳ��� ��ȸ�ؾ� �Ѵ�.
-- NULL�� �ִ� �÷��� ��ȸ�ؾ� �� �� ����Ѵ�.
-- OUTER JOIN �� �ؾ� �� �� ��� ����ϱ⵵ �Ѵ�.

--SELECT ���� ���� �÷��� ��ȸ(NULL�� �ִ�) �� �� ����Ѵ�.
SELECT COUNT(DISTINCT(DEPTNO)) FROM EMP;
--  3
SELECT COUNT(DISTINCT(DEPTNO)) FROM DEPT;
-- 4 

-- FROM ������ SUBQUERY => INLINE VIEW SUB QUERY
-- �̳� ���� ȿ���� ���� �� �ְ�, �������� ũ�⸦ ���� ���·� ��ȸ�ϴ� ���� �����ϴ�.
SELECT COUNT(A.EMPNO) FROM EMP A, EMP B;
-- 196�� ��ȸ �ȴ� (14 * 14)

SELECT COUNT(A.EMPNO) FROM EMP A, EMP B WHERE A.EMPNO=B.EMPNO;
-- 14�� ��ȸ�ȴ�.

-- ����  : SCOTT ����� �μ� �̸��� ��ȸ �Ͻÿ�.

-- ������ �߷�
-- ����� �̸��� SCOTT�̴�.  SCOTT�� �μ���ȣ�� 20���̴�.
-- �μ���ȣ 20���� �μ��� �̸��� RESEARCH�̴�.
-- ����, SCOTT ����� �μ��̸��� RESEARCH�̴�.

-- ����� �̸��� SCOTT�� ����� ������ ��ȸ
SELECT*FROM EMP WHERE ENAME='SCOTT';
-- �μ���ȣ : DEPTNO : 20

-- �μ���ȣ�� DEPT ���̺��� �ִ�.
SELECT*FROM DEPT WHERE DEPTNO='20';
-- �μ���ȣ 20���� �μ��� �̸��� RESEARCH �̴�.

-- RESEARCH�� ���Դ�.
SELECT  B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND A.DEPTNO=20
AND A.ENAME='SCOTT';

-- �ٸ� ������� Ǯ���� ���� ��
-- �ζ��� �� ���������� ����Ͽ� Ǯ����� ����
SELECT B.DNAME
FROM (SELECT*FROM EMP WHERE DEPTNO='20' AND ENAME='SCOTT') A, DEPT B 
WHERE A.DEPTNO=B.DEPTNO;

-- ALLEN ����� �μ� �̸��� ��ȸ�Ͻÿ�.
--  1. ALLEN ����� ������ ���� ��ȸ�غ���.
SELECT*FROM EMP WHERE ENAME='ALLEN';
-- EMP���̺��� DEPTNO�� 30���̰� FK�̴�.
-- DEPT���̺��� DEPTNO�� PK�̴�.

SELECT DEPTNO FROM EMP WHERE ENAME='ALLEN';
-- ALLEN ����� �μ� ��ȣ�� 30���̴�.

-- 30�� �μ� ��ȣ�� �̸��� ������ ��
SELECT*FROM DEPT WHERE DEPTNO='30';
SELECT DNAME FROM DEPT WHERE DEPTNO='30';
-- 30�� DEPTNO�� �μ� �̸��� SALES�̴�.

-- ALLEN ����� �μ���ȣ�� 30���̰�, 30�� �μ� ��ȣ�� �̸��� SALES�̴�.
SELECT B.DNAME
FROM (SELECT*FROM EMP WHERE DEPTNO='30' AND ENAME='ALLEN') A, DEPT B
WHERE A.DEPTNO=B.DEPTNO;


-- INNER JOIN ���� �غ���
SELECT DNAME FROM DEPT WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='ALLEN');
 