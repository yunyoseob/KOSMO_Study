SELECT EMPNO, ENAME, JOB, MGR FROM EMP;

-- ���ҿ� 
SELECT A.EMPNO, A.ENAME, A.MGR, B.ENAME AS MANAGER
FROM EMP A
JOIN EMP B ON A.MGR = B.EMPNO;

SELECT * 
FROM   EMP A, EMP B
WHERE  A.MGR = B.EMPNO;

SELECT A.*, B.* 
FROM   EMP A, EMP B
WHERE  A.MGR = B.EMPNO;

SELECT A.ENAME, B.ENAME 
FROM   EMP A, EMP B
WHERE  A.MGR = B.EMPNO;

SELECT * FROM EMP WHERE MGR = 
(SELECT MGR FROM EMP WHERE ENAME = 'FORD');

SELECT * FROM EMP WHERE EMPNO = 
(SELECT MGR FROM EMP WHERE ENAME = 'FORD');

SELECT A.ENAME || ' ����� ���(�Ŵ���)�� ' || B.ENAME  || ' �̴�'
FROM   EMP A, EMP B
WHERE  A.MGR = B.EMPNO;

-- ���(�Ŵ���)�� ���� ����� ���Ͻÿ� ? 
SELECT MGR FROM EMP;
SELECT EMPNO, ENAME, JOB, MGR FROM EMP;

SELECT * FROM EMP WHERE MGR = NULL;
SELECT * FROM EMP WHERE MGR IS NULL;
SELECT * FROM EMP WHERE MGR IS NOT NULL;

SELECT * FROM SALGRADE;
SELECT SAL FROM EMP;

SELECT A.EMPNO, A.ENAME, A.SAL * 50 , B.GRADE
FROM   EMP A, SALGRADE B
WHERE  A.SAL >= B.LOSAL
AND    A.SAL <= B.HISAL;


--�������� 
--SELECT : ����Ʈ �� 
--    SELECT * FROM DUAL; : ��Į�� �������� : ����Ʈ ���� SELECT ������ ����ϴ� �� 
--      �Ϻ� OUTER JOIN ȿ���� �ִ�. 
--FROM : ���� �� 
--    SELECT * FROM DUAL; : �ζ��� �� �������� : ���� ���� SELECT ������ ����ϴ� ��
--      �ζ��� �� ���������� ����ϴ� ������ 
--      ���̺� �ִ� ��ü �����͸� ������� �ʰ� 
--      �� ���ǿ� �ʿ��� �÷��� ���� �����ؼ� ����ϱ� ���ؼ� 
--      ������ ũ�⸦ ���̱� ���ؼ� ����ϴ� �� 
--      INLINE VIEW SUBQUERY �� INNSER JOIN ȿ���� �ִ�. 
--WHERE : ���� �� 
--    SELECT * FROM DUAL; : �������� : ���� ���� SELECT ������ ����ϴ� ��

--�������� ����
--���� ��(Single-Row) ��������
--���� ��(Multi-Row) ��������
--���� ��(�÷�)(Multi-Column) �������� 
--�ζ��� ��(Inline view) ��������
--��Į��(Scala) ��������







