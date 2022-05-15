-- 20220506
SELECT*FROM EMP;
-- 14개의 행(ROW)를 리턴한다.

-- 컬럼과 로우 결과를 리턴한다.
-- 1. 로우를 리턴한다.
-- 2. 컬럼을 리턴한다.
-- 3. 해당하는 테이블에 있는 모든 데이터를 리턴한다.
-- 4. 해당하는 테이블의 모든 데이터를 로우 단위로 리턴한다.
SELECT ROWID FROM EMP;
-- 기준이 ROW이다. 각 ROW의 ID를 리턴한다.

SELECT ROWID, EMPNO FROM EMP;

SELECT 1,2,3 FROM EMP;

-- 가비지 데이터
SELECT 1 FROM EMP;

SELECT COUNT(1) FROM EMP;
-- 14개의 행이 있으므로, 14가 나오는데,
-- 이 때, 주의해야 할 사항은 단일 행을 리턴하는 것이다.

SELECT 1 FROM DEPT;
-- 4개의 행에 데이터가 1이 입력되어 출력된다.
SELECT COUNT(1) FROM DEPT;
-- 그 행의 갯수(4개)를 단일행으로 리턴한다.
SELECT*FROM DEPT;


SELECT 24*60*60 FROM DUAL;
-- 86400 : 하루를 1초 단위로 환산한 것
SELECT 24*60*60 FROM DEPT;
-- 86400 : 하루를 1초 단위로 환산한 것

SELECT DEPTNO
                , DNAME, LOC
                , 24*60*60 AS DAYPERSECONDS 
FROM DEPT;

-- 함수에 따라 몇 개의 로우가 리턴되는지 체크해야한다.
-- 로우 => 컬럼 순으로 조회한다.
-- 단일행 리턴 :  조건에 만족하는 데이터가 한 건만 조회됨이 아니라 
-- 전체 데이터를 조회해서 결과를 구한 뒤, 하나의 행으로 리턴한다.
-- 다른 말로 집합 연산자라고 한다.
SELECT MIN(HIREDATE) FROM EMP;
SELECT MAX(HIREDATE) FROM EMP;
SELECT ROUND(AVG(SAL), 2) FROM EMP;
SELECT SUM(COMM) FROM EMP;

-- 다중행 리턴 : 조건에 만족하는 데이터를 여러 개의 행으로 리턴한다.
SELECT TO_CHAR(HIREDATE) FROM EMP;
SELECT TO_DATE(HIREDATE) FROM EMP;

-- 각 부서의 가장 월급을 많이 받는 사원들과 사원들의 부서 이름을  출력하시오.
SELECT MAX(ENAME), DEPTNO
FROM EMP
GROUP BY DEPTNO;

SELECT A.ENAME
                 ,B.DNAME
FROM (SELECT MAX(ENAME) AS ENAME
                                 , DEPTNO
                FROM EMP
                GROUP BY DEPTNO) A, DEPT B
WHERE A.DEPTNO=B.DEPTNO;                

-- GROUP BY 절의 기본 사용법
/*
-- GROUP BY절의 기본 사용법
-- SELECT       [조회할 열1 이름], [열2 이름], ..., [열N이름]

[]  : KEY & VALUE 로 이루어진 배열
조회할 열1 이름 : 칼럼명
, : SEPERATE

-- FROM         [조회할 테이블 이름]
-- WHERE        [조회할 행을 선별하는 조건식]
-- GROUP BY     [그룹화할 열을 지정(여러 개 지정 가능)]
-- HAVING [출력 그룹을 제한하는 조건식]
-- ORDER BY     [정렬하려는 열 지정]
*/

