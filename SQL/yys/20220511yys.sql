SELECT*FROM EMP;

SELECT DEPTNO, EMPNO, ENAME, SAL FROM EMP;

-- 급여의 순위를 매겨 보세요.
-- 내림차순? 오름차순?

-- 내림 차순시 가장 먼저 나와야 하는 데이터
SELECT MAX(SAL) FROM EMP;
-- 5000

-- 오름 차순시 가장 먼저 나와야 하는 데이터
SELECT MIN(SAL) FROM EMP;
-- 800

-- COLUMN INDEX로 내림차순 정렬해보기
SELECT DEPTNO,  EMPNO, ENAME, SAL
FROM EMP
ORDER BY 4 DESC;

-- COLUMN LABEL로 내림차순 정렬해보기
SELECT DEPTNO, EMPNO, ENAME, SAL
FROM EMP
ORDER BY SAL DESC;

-- RANK : 중복 순위 다음 순서 건너뜀. (1,2,3,4)
-- DENSE_RANK : 중복 순위 다음 순위 연속. (1,2,3,4)
-- ROW_NUMBER : 중복 순위 값이 유일값. (1,2,3,4)

-- OVER는 SUBQUERY, GROUP BY를 대신 해주는 분석함수이다.
-- GROUP BY, ORDERY BY를 집계함수라고 한다.
SELECT DEPTNO, EMPNO, ENAME,  SAL
                ,RANK() OVER (ORDER BY SAL DESC) AS RK
                ,DENSE_RANK() OVER(ORDER BY SAL DESC) AS DR
                ,ROW_NUMBER() OVER(ORDER BY SAL DESC) AS RN
FROM EMP;                

/*
OVER() 함수
GROUP BY나 서브쿼리를 사용하지 않고
SUM, AVG, MAX, MIN, COUNT(분석 함수)와
GROUP BY, ORDER BY(집계 함수) 사용시 쿼리 길이를 줄임

분석_함수() OVER(PARTITION BY 칼럼 / ORDER BY 컬럼 / 부분 분할 기준)
여기서 분석 함수와 OVER()는 필수지만
OVER 안의 내용들은 필요한 경우에만 작성해주면 된다 (ORDER BY가 필수가 아니다)
RANK, DENSE_RANK는 ORDER BY 필수
*/

-- 그룹별로 순위 부여
SELECT EMPNO, ENAME, SAL,
                 RANK() OVER(PARTITION BY DEPTNO ORDER BY SAL DESC) AS RK
                 , DEPTNO
FROM EMP;    

-- ROW_NUMBER() OVER()
SELECT ROWID, ROWNUM, EMPNO, ENAME, SAL
                ,ROW_NUMBER() OVER(ORDER BY SAL DESC) AS RK
FROM EMP;

SELECT*FROM EMP;




