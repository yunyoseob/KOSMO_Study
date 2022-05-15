-- SQL ��Ǯ�� ����
-- EMP ���̺� HIREDATE(�Ի���)
-- �Ի����� ���� ������� 5���� ���Ͻÿ�

SELECT*FROM EMP ORDER BY HIREDATE ASC;
-- 80/12/17
-- 81/02/20
-- 81/02/22
-- 81/04/02
-- 81/05/01

-- ���������� �ζ��� �� ����������
-- �Ի��� ���� ������  ��Ʈ�� �����Ѵ�.
SELECT 
                A.EMPNO     AS EMPNO
                ,A.ENAME     AS ENAME
                ,A.JOB             AS JOB
                ,A.MGR          AS MGR
                ,A.HIREDATE AS HIREDATE
                ,A.SAL              AS SAL
                ,A.COMM         AS COMM
                ,A.DEPTNO    AS DEPTNO
                -- �ζ��� �� ��������
FROM  (SELECT*FROM EMP ORDER BY HIREDATE ASC) A
WHERE ROWNUM<=5;



