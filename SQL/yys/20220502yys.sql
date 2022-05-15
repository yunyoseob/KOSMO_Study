-- SQL 몸풀기 문제
-- EMP 테이블에 HIREDATE(입사일)
-- 입사일이 빠른 순서대로 5건을 구하시오

SELECT*FROM EMP ORDER BY HIREDATE ASC;
-- 80/12/17
-- 81/02/20
-- 81/02/22
-- 81/04/02
-- 81/05/01

-- 프롬절에서 인라인 뷰 서브쿼리로
-- 입사일 빠른 순으로  소트를 먼저한다.
SELECT 
                A.EMPNO     AS EMPNO
                ,A.ENAME     AS ENAME
                ,A.JOB             AS JOB
                ,A.MGR          AS MGR
                ,A.HIREDATE AS HIREDATE
                ,A.SAL              AS SAL
                ,A.COMM         AS COMM
                ,A.DEPTNO    AS DEPTNO
                -- 인라인 뷰 서브쿼리
FROM  (SELECT*FROM EMP ORDER BY HIREDATE ASC) A
WHERE ROWNUM<=5;



