-- 20220510 수업
SELECT*FROM EMP WHERE ROWNUM<=5;
SELECT DEPTNO, AVG(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING DEPTNO>10
ORDER BY DEPTNO;

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >=2000
ORDER BY DEPTNO, JOB;

-- AVG(SAL) : 단일행 리턴

-- EMP  테이블에서 가장 위의 5행 조회해보기
SELECT*FROM EMP WHERE ROWNUM<=5;

-- EMP 테이블에서 부서별로 조회해보기
SELECT DEPTNO FROM EMP GROUP BY DEPTNO;
-- 10, 20, 30

-- EMP 테이블에서 DEPTNO, JOB을 그룹화하여 조회하기
SELECT DEPTNO, JOB  
FROM EMP 
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO ASC;
-- 10 : CLERK, MANAGER, PRESIDENT
-- 20 : ANALYST, CLERK,  MANAGER
-- 30 : CLERK, MANAGER, SALESMAN

SELECT DEPTNO, COUNT(DISTINCT(JOB))
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;
-- 10 : 3
-- 20 : 3
-- 30 : 3

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO;
-- 9행 출력 된다.

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >=2000
ORDER BY DEPTNO, JOB;

-- HAVING 절을 사용하여 EMP 테이블의 부서별 직책의 평균 급여가 500
-- 이상인 사람들의
-- 부서번호, 직책, 부서별 직책의 평균 급여를 출력하시오.

SELECT*FROM EMP WHERE ROWNUM<1;
-- EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO
-- 출력해야 하는 절
-- DEPTNO : 부서번호
-- JOB : 직책
-- SAL : 급여

-- SELECT에 맞는 컬럼 조회하기
SELECT DEPTNO, JOB, SAL FROM EMP;

-- 부서와 직책 그룹화 하여 보기
SELECT DEPTNO, JOB, AVG(SAL) 
FROM EMP 
GROUP BY DEPTNO, JOB;

-- + 부서별 직책의 평균 급여가 500이상
SELECT DEPTNO, JOB, AVG(SAL) 
FROM EMP
GROUP BY DEPTNO, JOB
HAVING AVG(SAL)>=500;

-- 평균 급여가 500이상인 사람의 수를 조회해서 맞게 조회하였는지
-- 확인하기

SELECT*FROM EMP;

-- 부서별 직책의 평균급여 구하기
SELECT DEPTNO, JOB,  AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO ASC;

-- 1ST
SELECT DEPTNO, COUNT(EMPNO)
FROM EMP
GROUP BY DEPTNO
 HAVING AVG(SAL)>=500;
-- 30번 부서에 6명
-- 20번 부서에 5명
-- 10번 부서에 3명

-- 기존  GROUP BY절만 사용한 그룹화
SELECT DEPTNO, JOB,  COUNT(*) CNT, MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP 
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;
-- 부서별, 직책별로 조회했을 시, 9건 조회
--  COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL) : 단일 행 리턴 함수

SELECT SUM(CNT)
FROM (SELECT DEPTNO, JOB,  COUNT(*) CNT, MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP 
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB);
-- 14건 맞음


-- ################# ROLLUP ###############################

-- ROLLUP 함수를 적용한 그룹화
SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB);

-- ROLLUP함수 안 쓰고 구해보기
-- 부서별로 최대, 합계, 평균 구해보기
SELECT DEPTNO, MAX(MSAL), SUM(SSAL), AVG(ASAL)
FROM (
    SELECT DEPTNO
                     ,JOB
                     ,COUNT(*) CNT
                     ,MAX(SAL) MSAL
                     ,SUM(SAL) SSAL
                     ,AVG(SAL) ASAL
    FROM EMP 
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB
)
GROUP BY DEPTNO;

-- 총 최대, 합계, 평균 구해보기
SELECT COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP;

-- ################# ###### ###############################

-- ################# CUBE ###############################

-- CUBE 함수 써보기
SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY DEPTNO, JOB;


-- CUBE 함수 안쓰고 구하기


SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;






