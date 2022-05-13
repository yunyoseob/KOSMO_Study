SELECT EMPNO, ENAME, JOB, MGR FROM EMP;

-- 강소영 
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

SELECT A.ENAME || ' 사원의 상사(매니저)는 ' || B.ENAME  || ' 이다'
FROM   EMP A, EMP B
WHERE  A.MGR = B.EMPNO;

-- 상사(매니저)가 없는 사원을 구하시오 ? 
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


--서브쿼리 
--SELECT : 셀렉트 절 
--    SELECT * FROM DUAL; : 스칼라 서브쿼리 : 셀렉트 절에 SELECT 구문을 사용하는 것 
--      일부 OUTER JOIN 효과가 있다. 
--FROM : 프럼 절 
--    SELECT * FROM DUAL; : 인라인 뷰 서브쿼리 : 프럼 절에 SELECT 구문을 사용하는 것
--      인라인 뷰 서브쿼리를 사용하는 이유는 
--      테이블에 있는 전체 데이터를 사용하지 않고 
--      그 조건에 필요한 컬럼만 먼저 추출해서 사용하기 위해서 
--      파일의 크기를 줄이기 위해서 사용하는 것 
--      INLINE VIEW SUBQUERY 는 INNSER JOIN 효과가 있다. 
--WHERE : 웨어 절 
--    SELECT * FROM DUAL; : 서브쿼리 : 웨어 절에 SELECT 구문을 사용하는 것

--서브쿼리 유형
--단일 행(Single-Row) 서브쿼리
--다중 행(Multi-Row) 서브쿼리
--다중 열(컬럼)(Multi-Column) 서브쿼리 
--인라인 뷰(Inline view) 서브쿼리
--스칼라(Scala) 서브쿼리







