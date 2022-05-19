-- 2022 05 17

-- 모수에서 조회하고자 하는 집합(표본)을 줄인 뒤에 조건을 걸고, 검색을 하는 
-- 인라인 뷰 서브쿼리 활용예제
SELECT A.*
FROM DEPT A, (SELECT DEPTNO FROM EMP WHERE ENAME='SMITH') B
WHERE A.DEPTNO=B.DEPTNO;

-- 스코트 사원과 동일한 부서에서 근무하는 사원의 이름, 부서번호를 조회하시오.

-- 1.  이름이 스코트인 사원은 어느 테이블에 있나요?
SELECT*FROM EMP WHERE ENAME='SCOTT';
-- 1-1. EMP테이블에 있다. 스코트사원의 DEPTNO(부서번호)는 20번이다.

-- 2.  동일한 부서번호에 근무하는 사람의 정보를 조회해봅시다.
SELECT*FROM EMP WHERE DEPTNO='20';
-- 2-1. 20번 부서에서 일하고 있는 사람의 수는?
SELECT COUNT(EMPNO) FROM EMP WHERE DEPTNO='20';
-- 5명이 나와야 한다는 것을 알 수 있다.

-- 3. 스코트 사원과 동일한 부서에서 근무하는 사원의 이름, 부서번호를 조회하시오.
SELECT ENAME, DEPTNO FROM EMP  WHERE DEPTNO='20';
-- 5명의 ENAME과  DEPTNO가 나왔다.

--**  SMITH의 부서번호가 20번인지 모르는 상황에서 조회하는 방법 **
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SMITH');

-- 다음 문제 : 스코트 사원과 동일한 부서에서 근무하는 사원의 이름, 부서명, 부서번호를 조회하시오.

-- 1. 사원 이름이 스코트인 사람은 어느 테이블에 있는가?
-- EMP  테이블에서 조회해보기
SELECT*FROM EMP WHERE ENAME='SCOTT';
-- 스코트사원의 부서 번호는 20번이다.

-- 2. 부서번호가 20번인 부서의 이름은 무엇인가?
--  DEPT 테이블에서 조회햅기
SELECT*FROM DEPT WHERE DEPTNO='20';
-- 부서번호가 20번인 부서의 이름은 RESEARCH 이다.

-- 부서번호가 20일 때, 사원의 이름, 부서명, 부서번호를 조회해라 (3가지 방법으로)

-- 1ST METHOD
-- INNER JOIN
SELECT A.ENAME,  B.DNAME, A.DEPTNO
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND A.DEPTNO=20;

-- 2ND METHOD
-- INLINE VIEW SUBQUERY AND INNER JOIN
SELECT A.ENAME, B.DNAME, A.DEPTNO
FROM (SELECT*FROM EMP WHERE DEPTNO=20) A, DEPT B
WHERE A.DEPTNO=20
AND A.DEPTNO=B.DEPTNO;


-- 3RD METHOD
-- 다중행 SUBQUERY  AND INNER JOIN
SELECT A.ENAME, B.DNAME, A.DEPTNO
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND A.DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SMITH');

-- 최대 급여를 받는 사원의 이름, 담당업무, 급여를 조회하시오
-- 1. EMP 테이블에서 최대 급여는 얼마일까?
SELECT MAX(SAL) FROM EMP;
-- 5000

-- 2. 사원의 이름, 담당업무, 급여 조회하기
SELECT ENAME, JOB, SAL FROM EMP;

-- 3. 둘이 합치기
-- 테이블 엘리어스는 서브쿼리안에서는 쓰지 않는다.
SELECT A.ENAME, A.JOB, A.SAL
FROM  EMP A
WHERE A.SAL=(SELECT MAX(SAL) FROM EMP);

-- 4. 다른 방법으로 풀어보기 (MAX 함수 안쓰고)
-- 급여 순서대로 출력시키기
SELECT*FROM EMP ORDER BY SAL DESC;

-- 급여 순서대로 가장 위에 있는 사람의 정보 보기
SELECT A.ENAME, A.JOB, A.SAL
FROM (SELECT*FROM EMP ORDER BY SAL DESC) A
WHERE ROWNUM=1;

-- 최저 급여를 받는 사원의 이름, 담당업무, 급여를 조회하시오
-- MIN 함수 쓰는 버전
SELECT A.ENAME, A.JOB, A.SAL
FROM  EMP A
WHERE A.SAL=(SELECT MIN(SAL) FROM EMP);

-- MIN 함수 안 쓰는 버전
SELECT A.ENAME, A.JOB, A.SAL
FROM  (SELECT*FROM EMP ORDER BY SAL ASC) A
WHERE ROWNUM=1;

-- EMP 테이블의 평균 급여
SELECT AVG(SAL) FROM EMP;
-- 2073.2142857134.......
SELECT ROUND(AVG(SAL), 2) FROM EMP;
-- 2073.32
SELECT CEIL(AVG(SAL)) FROM EMP;
-- 2074
SELECT FLOOR(AVG(SAL)) FROM EMP;
-- 2073


-- 30번 부서에서 최저 급여 받는 사람
SELECT MIN(SAL) FROM EMP WHERE DEPTNO='30';
-- 30번 부서의 최저 급여 : 950

SELECT*FROM EMP A 
WHERE SAL=(SELECT MIN(SAL) FROM EMP WHERE DEPTNO='30');

-- 다른 방법으로 풀어보기
SELECT MIN(A.SAL)
FROM  (SELECT*FROM EMP WHERE DEPTNO='30') A;

SELECT*
FROM EMP A
WHERE A.SAL=(SELECT MIN(SAL)
                                  FROM  (SELECT*FROM EMP WHERE DEPTNO='30'));

-- 부서별 최저 급여는?
SELECT MIN(SAL), DEPTNO FROM EMP 
GROUP BY DEPTNO;
-- 950, 30
-- 800, 20
-- 1300, 10

-- 검증해보기
SELECT*FROM EMP WHERE DEPTNO=10 ORDER BY SAL ASC;
-- 1300, 10
SELECT*FROM EMP WHERE DEPTNO=20 ORDER BY SAL ASC;
-- 800, 20
SELECT*FROM EMP WHERE DEPTNO=30 ORDER BY SAL ASC;
-- 950, 30

-- 30번 부서에서 최저 급여를 받는 사람?
SELECT MIN(A.SAL)
FROM (SELECT*FROM EMP WHERE DEPTNO=30) A;
-- 950

SELECT ENAME
FROM EMP A
WHERE A.SAL= (SELECT MIN(SAL)
                                    FROM (SELECT*FROM EMP WHERE DEPTNO=30));
-- 평균 이상
SELECT COUNT(EMPNO) FROM EMP A
WHERE A.SAL >= (SELECT AVG(SAL) FROM EMP);

-- 평균 이하
SELECT*FROM EMP A
WHERE A.SAL <= (SELECT AVG(SAL) FROM EMP);

-- 가장 급여가 많은 사원의 급여와 급여가 가장 적은 사람의 급여의 차이는?
SELECT MAX(SAL), MIN(SAL), MAX(SAL)-MIN(SAL)
FROM EMP;
-- 4200

-- 급여의 표준편차는
SELECT STDDEV(SAL) FROM EMP;
-- 1182

-- ================================================

-- 급여의 평균+3*(표준편차) 보다 급여를 더 많이 받는 사원이 있는가?
SELECT COUNT(EMPNO) FROM EMP A
WHERE SAL>(SELECT AVG(SAL)+(3*STDDEV(SAL)) FROM EMP);
-- 0 : 없다

-- 급여의 평균+2*(표준편차) 보다 급여를 더 많이 받는 사원이 있는가?
SELECT COUNT(EMPNO) FROM EMP A
WHERE SAL>(SELECT AVG(SAL)+(2*STDDEV(SAL)) FROM EMP);
-- 1: 1명이 존재한다.

SELECT*FROM EMP A
WHERE SAL>(SELECT AVG(SAL)+(2*STDDEV(SAL)) FROM EMP);
-- 그의 이름은 바로 KING

-- 급여의 평균+1*(표준편차) 보다 급여를 더 많이 받는 사원이 있는가?
SELECT*FROM EMP A
WHERE SAL>(SELECT AVG(SAL)+(STDDEV(SAL)) FROM EMP);
-- KING만 해당 된다.



