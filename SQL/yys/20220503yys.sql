SELECT*FROM EMP;
SELECT*FROM DEPT;

-- 입사일이 빠른 순서로 5건을 구하시오.
-- 데이터는 꼭 눈으로 확인해야 한다. 건수가 적으면 아이체킹 한다.
-- 건수가 많으면 대표적은 데이터 타입   구별해서 확인해야 한다.

-- 1. 입사일 전건 확인 하는 것 : 14건이니까
SELECT HIREDATE FROM EMP;

SELECT HIREDATE FROM EMP ORDER BY HIREDATE ASC;

SELECT HIREDATE FROM EMP WHERE ROWNUM<=5;

-- FROM 절에서 자식 쿼리 인라인 뷰 서브쿼리로
-- 입사일 빠른 순으로 소트를 먼저한다.
-- 이후 부모 쿼리에서 5건을 구한다.
SELECT A.HIREDATE
FROM
-- 인라인 뷰 서브쿼리  
(SELECT HIREDATE FROM EMP ORDER BY HIREDATE ASC) A
WHERE ROWNUM<=5;

/*
SELECT
        SELECT*FROM DUAL;
FROM
        SELECT*FROM DUAL;
WHERE
        SELECT*FROM DUAL;
*/

SELECT*FROM EMP;
SELECT*FROM DEPT;
DESC EMP;
DESC DEPT;

SELECT*FROM DEPT;

SELECT DISTINCT DEPTNO FROM EMP;
-- 10,20,30만 나온다.

SELECT DEPTNO FROM EMP GROUP BY DEPTNO;

SELECT UNIQUE(DEPTNO) FROM EMP;

--##############################
-- 조인 : 테이블을 합치는 것 : 여러 개의 테이블을 관계 키를 가지고 합치는 것
--              꼭 관계키가 없어도 합칠 수 있다.
-- PK, FK
-- EQUL JOIN 이퀴조인, EQUAL JOIN 이퀄조인 : INNER JOIN : 이너조인
-- NOT-EQUL JOIN 낫 이퀴 조인
-- SELF JOIN 셀프 조인
-- OUTER JOIN 아우터 조인
-- ##############################

-- INNER JOIN: 이너조인
-- 연산자 = 사용해서 각 테이블에서 동일한 컬럼을 매칭해서 조회하는 것

-- 이너 조인은 테이블에 있는 모든 데이터를 조회 할 수가 없다.
-- 컬럼에 데이터가 매칭이 되지 않으면 데이터를 조회할 수가 없다. <-- 이 조건을 충족하는 조인이 OUTER JOIN 아우터 조인이다.
-- ##############################
-- 테이블을 조인할 때는 꼭 테이블 엘리어스 사용하기
SELECT*FROM EMP A;
SELECT*FROM DEPT B;

SELECT*FROM EMP A, DEPT B WHERE A.DEPTNO=B.DEPTNO;
SELECT*FROM DEPT B, EMP A WHERE B.DEPTNO=A.DEPTNO;

SELECT A.*, B.*
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO;

SELECT*FROM EMP WHERE EMPNO='7369';

SELECT DNAME FROM DEPT WHERE DEPTNO='20';
-- RESEARCH

SELECT DNAME FROM DEPT WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE EMPNO='7369');
-- RESEARCH

-- INNER JOIN
SELECT B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND A.EMPNO='7369';
-- RESEARCH
SELECT A.DEPTNO EMP_T, B.DEPTNO DEPT_T
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
ORDER BY 1;

SELECT DEPTNO FROM DEPT;

-- OUTER JOIN
-- (+) 아우터 조인의 연산자 : 데이터 부족한 쪽 (없는) 테이블에 연산자를 붙인다.
-- 아우터 조인 순저
-- 1. 먼저 이퀄조인을 먼저 한다. : 연잔자=
-- 2. 데이터가 없는 테이블에 아우터 조인 연산자 (+)를 붙인다.
SELECT A.DEPTNO EMP_T, B.DEPTNO DEPT_T
FROM EMP A, DEPT B
WHERE A.DEPTNO(+)=B.DEPTNO
ORDER BY 1;







