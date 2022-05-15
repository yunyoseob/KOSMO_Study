--  20220509
SELECT ROWID FROM EMP;
SELECT ROUND(STDDEV(SAL),2) FROM EMP;

-- GROUP BY�� ����Ͽ� �μ��� ��� �޿� ����ϱ�
SELECT AVG(SAL), DEPTNO
FROM EMP 
GROUP BY DEPTNO;

SELECT AVG(A.SAL) AS SAL
                                , B.DNAME AS DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
GROUP BY B.DNAME;

-- �μ���ȣ�� �μ����� ����Ͻÿ�.
SELECT A.DEPTNO, B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
GROUP BY A.DEPTNO, B.DNAME;

-- ����� ��å�� ������ ���ϼ���.
SELECT DISTINCT(A.JOB) AS DISTINCTJOB
FROM EMP A;

-- GROUP BY�� �� ������.
SELECT A.JOB
FROM EMP A
GROUP BY A.JOB;

SELECT A.DEPTNO, B.DEPTNO, B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
GROUP BY A.DEPTNO, B.DNAME, B.DEPTNO;


-- EMP ���̺�� DEPT ���̺��� ��ȸ�Ͽ� �� �μ��� �޿� ������ ���� ū
-- �μ� �̸��� �Ҽ��� ù °�ڸ������� ��½�Ű�ÿ�.
SELECT B.DNAME
FROM(SELECT DEPTNO
                ,ROUND(STDDEV(SAL), 1) AS DSAL
                FROM EMP
                GROUP BY DEPTNO
                ORDER BY DSAL DESC) A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND ROWNUM<=1;




-- �μ��� �ִ� ��å�� ��� �޿��� �����ϱ�
SELECT*FROM EMP;

SELECT DEPTNO, JOB, SAL FROM EMP;

-- �μ����� ������ ���ô�.
SELECT DEPTNO
FROM EMP
GROUP BY DEPTNO;

-- �μ����� ��å ����
SELECT DEPTNO, JOB
FROM EMP
GROUP BY DEPTNO, JOB;

-- �μ����� ��� �޿� ����
SELECT DEPTNO, JOB, AVG(SAL) AS ASAL
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;

-- + �μ��̸�, �μ���ȣ, ��å, ���� ���� �ֱ�
-- �μ��� �ִ� ��å�� ��� �޿��� �����ϱ�
SELECT  A.DEPTNO, B.DEPTNO, B.DNAME, A.JOB, AVG(A.SAL)
FROM EMP A, DEPT B
WHERE A.DEPTNO(+)=B.DEPTNO
GROUP BY A.DEPTNO, B.DEPTNO, B.DNAME, A.JOB
ORDER BY A.DEPTNO, A.JOB;



