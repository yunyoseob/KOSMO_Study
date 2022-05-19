-- 2022 05 19 

-- do it 실습예제 9-6
SELECT*FROM EMP
WHERE DEPTNO IN (20, 30);
-- (11, 8) : 11행 8열로 데이터가 출력되었다.


SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO;
-- (3, 1) : 3행 1열로 데이터가 출력되었다.
-- 2850,3000,5000


--  do it 실습예제 9-7
SELECT*FROM EMP
WHERE SAL 
IN (SELECT MAX(SAL) 
       FROM EMP 
       GROUP BY DEPTNO);
-- EMP 테이블에서 연봉이 (2850, 3000, 5000에 해당하는 사람의 정보를 출력하시오.)

-- ANY 연산자
-- 서브쿼리의 여러 결과 중 어느 하나의 값만 만족이 되면 행을 반환한다.
-- SALESMAN 직업의 급여보다 많이 받는 사원의 사원명과 급여 정보를 출력하시오
SELECT ENAME, SAL, JOB, DEPTNO
FROM  EMP
WHERE DEPTNO !=20
AND SAL > ANY (SELECT SAL FROM EMP WHERE JOB='SALESMAN')
ORDER BY 2;

-- DO IT 9-9
SELECT*FROM EMP
WHERE SAL = ANY(SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO);


-- SALES MAN이 몇명인지 구해보세요
SELECT*FROM EMP WHERE ROWNUM<=1;

-- CLERK
SELECT COUNT(A.EMPNO) AS NCNT 
FROM EMP A
WHERE A.JOB='SALESMAN';
-- 4


SELECT*FROM EMP A
WHERE A.JOB='SALESMAN';
-- ANY를 써서 해보세요

SELECT*
FROM EMP A
WHERE A.JOB=ANY(SELECT JOB FROM EMP WHERE  JOB='SALESMAN');


-- 직업이 SALESMAN인 사람의 직업, 급여, 부서번호를
-- 오름차순으로 정렬하여  출력하시오.
SELECT JOB, SAL, DEPTNO 
FROM EMP
WHERE JOB='SALESMAN' ORDER BY 2;

SELECT SAL, DEPTNO FROM EMP WHERE SAL>=1250  ORDER BY 1;

-- ALL 연산자
-- 서브쿼리의 여러 결과 값 중 모든 값의 만족해야 행을 반환한다.
-- 모든  SALESMAN 직업의 급여보다 많이 받는 사원의 사원명과 급여 정보를 출력하시오.

SELECT ENAME, SAL, JOB, DEPTNO
FROM EMP
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE JOB='SALESMAN');
SELECT SAL FROM EMP WHERE JOB='SALESMAN' ORDER BY 1;
/*
1250
1250
1500
1600
*/

-- EXISTS 연산자
-- 서브쿼리 데이터가 존재하는가를 체크해 존재 여부(TRUE, FALSE)를 결과로 반환한다.

-- do it
SELECT*
FROM EMP
WHERE EXISTS (SELECT DNAME
                                    FROM  DEPT
                                    WHERE DEPTNO=10);


SELECT DNAME
FROM  DEPT
WHERE DEPTNO=10;
-- ACCOUNTING
-- DEPT 테이블에서 DEPTNO가 10인 부서의 이름이
-- 존재하는지 체크 + 존재한다면 해당 부서의 이름을 조건으로
-- EMP 테이블에서 해당 조건에 맞는 정보를 출력시킨다.

SELECT*
FROM EMP
WHERE EXISTS (SELECT DNAME
                                    FROM  DEPT
                                    WHERE DEPTNO=50);
-- EXISTS가 FALSE이면 EMP테이블에서 아무런 정보도 조회되지 않는다.

-- 강사님 쿼리 예제
-- EMP 테이블에서 셀프 조인한 다음, 부서번호와 부서이름을 중복없이 
--  부서번호 순으로 출력하세요.
SELECT DISTINCT A.DEPTNO, A.DNAME
FROM DEPT A, EMP B
WHERE A.DEPTNO=B.DEPTNO ORDER BY 1;
/*
DEPTNO DNAME
10	            ACCOUNTING
20	            RESEARCH
30	            SALES
*/

SELECT A.DEPTNO, A.DNAME
FROM DEPT A, EMP B
WHERE A.DEPTNO=B.DEPTNO
GROUP BY  A.DEPTNO
ORDER BY 1;

SELECT A.DEPTNO, A.DNAME
FROM DEPT A
WHERE EXISTS (SELECT 1 FROM EMP B WHERE B.DEPTNO=A.DEPTNO)
ORDER BY 1;

-- 다중 열(컬럼) (Multi-Column) 서브쿼리
-- 결과 값이 두 개 이상의 컬럼을 반환하는 서브쿼리
SELECT EMPNO, SAL, DEPTNO
FROM EMP
WHERE (SAL, DEPTNO) IN (SELECT SAL, DEPTNO FROM EMP WHERE DEPTNO=30 AND COMM IS NOT NULL);

SELECT SAL, DEPTNO FROM EMP WHERE DEPTNO=30 AND COMM IS NOT NULL;
/*
SAL     DEPTNO
1600	    300.
1250	    30
1250	    30
1500	    30
*/

