SELECT * FROM EMP;
-- 컬럼과 로우 결과를 리턴한다. 
-- 1. 로우를 리턴한다. 
-- 2. 컬럼을 리턴한다. 
-- 3. 해당하는 테이블에 있는 모든 데이터를 리턴한다.
-- 4. 해당하는 테이블의 모든 데이터를 로우 단위로 리턴한다. 

SELECT ROWID FROM EMP;

SELECT ROWID, EMPNO FROM EMP;

SELECT ROWID, EMPNO FROM EMP WHERE ROWNUM <= 5;

SELECT 1, 2 FROM EMP WHERE ROWNUM <= 2;

SELECT COUNT(1) FROM EMP;
SELECT 24*60*60 FROM DEPT WHERE ROWNUM <= 1;
SELECT 24*60*60 FROM DUAL;

-- EMP 테이블을 로우 단위로 컬럼 전체를 조회 했다. 
SELECT * FROM EMP;

-- SELECT 키워드를 테이블을 함수로 사용해서 조회 할때는 
-- 1. 단일행 리턴  
SELECT TO_CHAR(HIREDATE) FROM EMP;
SELECT TO_DATE(HIREDATE) FROM EMP;

-- 2. 한개의 행 리턴
SELECT COUNT(*) FROM EMP;
SELECT SUM(SAL) FROM EMP;
SELECT AVG(SAL) FROM EMP;
SELECT MIN(SAL) FROM EMP;
SELECT MAX(SAL) FROM EMP;

-- 사원테이블에 있는 사원들의 부서번호를 조회 하시오
SELECT DEPTNO FROM EMP;

SELECT DISTINCT DEPTNO FROM EMP;

SELECT DEPTNO FROM EMP GROUP BY DEPTNO;


-- GROUP BY절의 기본 사용법 
-- SELECT   [조회할 열1 이름], [열2 이름], .... [열N 이름]
-- FROM     [조회할 테이블 이름]
-- WHERE    [조회할 행을 선별하는 조건식]
-- GROUP BY [그룹화할 열의 지정(여러 개 지정 가능)]
-- HAVING   [출력 그룹을 제한하는 조건식]
-- ORDER BY [정렬하려는 열 지정]

SELECT DEPTNO
FROM   EMP
GROUP BY DEPTNO;

SELECT DEPTNO
FROM   EMP
GROUP BY DEPTNO
ORDER BY 1;

SELECT DEPTNO
FROM   EMP
GROUP BY DEPTNO
ORDER BY 1 DESC;

SELECT DEPTNO 
FROM   EMP
GROUP BY DEPTNO;











