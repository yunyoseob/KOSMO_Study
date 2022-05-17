-- 20220516 서브쿼리
-- 서브쿼리는 쿼리가 하나 더 있다는 의미이다.
-- 단문 : 단순 쿼리 (SELECT FROM WHERE GROUP BY HAVING ORDER BY) : 서브쿼리 없이 짜라는 뜻
-- 복문 : 쿼리가 하나가 아니라 여러 개의 테이블에서 데이터를 조회하는 것을 의미

-- SELECT 절에  SELECT 절 => 스칼라 서브쿼리
-- 선임들과 상의해서 써야함.
-- 컬럼 하나씩 조회해야 한다.
-- NULL이 있는 컬럼을 조회해야 할 때 사용한다.
-- OUTER JOIN 을 해야 할 때 대신 사용하기도 한다.

--SELECT 절에 단일 컬럼을 조회(NULL이 있는) 할 때 사용한다.
SELECT COUNT(DISTINCT(DEPTNO)) FROM EMP;
--  3
SELECT COUNT(DISTINCT(DEPTNO)) FROM DEPT;
-- 4 

-- FROM 절에서 SUBQUERY => INLINE VIEW SUB QUERY
-- 이너 조인 효과를 얻을 수 있고, 데이터의 크기를 줄인 상태로 조회하는 것이 가능하다.
SELECT COUNT(A.EMPNO) FROM EMP A, EMP B;
-- 196건 조회 된다 (14 * 14)

SELECT COUNT(A.EMPNO) FROM EMP A, EMP B WHERE A.EMPNO=B.EMPNO;
-- 14건 조회된다.

-- 문제  : SCOTT 사원의 부서 이름을 조회 하시오.

-- 연역적 추론
-- 사원의 이름이 SCOTT이다.  SCOTT의 부서번호는 20번이다.
-- 부서번호 20번의 부서의 이름은 RESEARCH이다.
-- 따라서, SCOTT 사원의 부서이름은 RESEARCH이다.

-- 사원의 이름이 SCOTT인 사람의 정보를 조회
SELECT*FROM EMP WHERE ENAME='SCOTT';
-- 부서번호 : DEPTNO : 20

-- 부서번호는 DEPT 테이블에도 있다.
SELECT*FROM DEPT WHERE DEPTNO='20';
-- 부서번호 20번인 부서의 이름은 RESEARCH 이다.

-- RESEARCH가 나왔다.
SELECT  B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND A.DEPTNO=20
AND A.ENAME='SCOTT';

-- 다른 방법으로 풀수는 없을 까
-- 인라인 뷰 서브쿼리를 사용하여 풀어보도록 하자
SELECT B.DNAME
FROM (SELECT*FROM EMP WHERE DEPTNO='20' AND ENAME='SCOTT') A, DEPT B 
WHERE A.DEPTNO=B.DEPTNO;

-- ALLEN 사원의 부서 이름을 조회하시오.
--  1. ALLEN 사원의 정보를 먼저 조회해본다.
SELECT*FROM EMP WHERE ENAME='ALLEN';
-- EMP테이블의 DEPTNO는 30번이고 FK이다.
-- DEPT테이블의 DEPTNO은 PK이다.

SELECT DEPTNO FROM EMP WHERE ENAME='ALLEN';
-- ALLEN 사원의 부서 번호는 30번이다.

-- 30번 부서 번호의 이름은 무엇일 까
SELECT*FROM DEPT WHERE DEPTNO='30';
SELECT DNAME FROM DEPT WHERE DEPTNO='30';
-- 30번 DEPTNO의 부서 이름은 SALES이다.

-- ALLEN 사원의 부서번호는 30번이고, 30번 부서 번호의 이름은 SALES이다.
SELECT B.DNAME
FROM (SELECT*FROM EMP WHERE DEPTNO='30' AND ENAME='ALLEN') A, DEPT B
WHERE A.DEPTNO=B.DEPTNO;


-- INNER JOIN 없이 해보기
SELECT DNAME FROM DEPT WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='ALLEN');
 