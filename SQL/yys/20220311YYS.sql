-- 20220311 DAO����

-- ������ ��ü�˻�
SELECT*FROM EMP;

SELECT*FROM EMP WHERE ROWNUM<=3;
-- ���� ���� �ุ ����


-- ��ü �˻�
SELECT
                A.EMPNO                                                                        AS   EMPNO
               , A.ENAME                                                                       AS   ENAME
                ,A.JOB                                                                               AS   JOB
               , A.MGR                                                                            AS    MGR
               , TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')     AS   HIREDATE
               , A.SAL                                                                              AS  SAL
                ,A.COMM                                                                        AS COMM
                ,A.DEPTNO                                                                    AS DEPTNO
FROM EMP A
ORDER BY 1 DESC;

-- ��� �˻�
-- ���ް� ������ �ΰ��� �����̹Ƿ� ������� �ʴ´�.

SELECT
                A.EMPNO         AS EMPNO
               , A.ENAME        AS ENAME
                ,A.JOB                AS JOB
               , TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')     AS HIREDATE
                ,A.DEPTNO       AS DEPTNO
                
 FROM EMP A
 
 WHERE  A.EMPNO  LIKE '%7%';
            
-- ��� �̸�  �˻�

SELECT
                A.EMPNO         AS EMPNO
               , A.ENAME        AS ENAME
                ,A.JOB                AS JOB
               , TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')     AS HIREDATE
                ,A.DEPTNO       AS DEPTNO
                
 FROM EMP A
 
 -- �� ��� : WHERE  A.ENAME= 'ALLEN';
 -- ����� ���
 WHERE  A.ENAME     LIKE UPPER( '%S%');


-- ���, �̸� �˻�(EMPNO, ENAME)

SELECT
                A.EMPNO         AS EMPNO
               , A.ENAME        AS ENAME
                ,A.JOB                AS JOB
               , TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')     AS HIREDATE
                ,A.DEPTNO       AS DEPTNO
                
 FROM EMP A
 
 WHERE A.EMPNO = 7499 --?
 -- AND       A.ENAME=UPPER('ALLEN'); --?
 AND       A.ENAME LIKE UPPER( '%A%'); --?
            
SELECT*FROM EMP;

-- ��å�˻�(JOB)

SELECT
                A.EMPNO         AS EMPNO
               , A.ENAME        AS ENAME
                ,A.JOB                AS JOB
               , TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')     AS HIREDATE
                ,A.DEPTNO       AS DEPTNO
                
 FROM EMP A
 
 --  WHERE A.JOB='MANAGER'; --?
 WHERE A.JOB LIKE UPPER('%MANAGER%'); --?
            
-- ��¥ �˻�

SELECT
                A.EMPNO         AS EMPNO
               , A.ENAME        AS ENAME
                ,A.JOB                AS JOB
               , TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')     AS HIREDATE
                ,A.DEPTNO       AS DEPTNO
                
 FROM EMP A
 
 WHERE
                 TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') 
                 >= TO_CHAR(TO_DATE('81/01/01'), 'YYYYMMDD') --?
AND       TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') 
                <=TO_CHAR(TO_DATE('82/01/01'), 'YYYYMMDD'); --?
            
                   
            
SELECT*FROM EMP;
