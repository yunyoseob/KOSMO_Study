SELECT HIREDATE FROM EMP;

-- 입사일이 빠른 순서로 5건을 구하시오 
-- 데이터는 꼭 눈으로 확인 해야 한다. 건수 가 적으면 아이체킹 한다.
-- 건수가 많으면 대표적은 데이터 타입 구별해서 확인 해야 한다. 

-- 1. 입사일 전건 확인 하는 것 : 14건 이니까
SELECT HIREDATE FROM EMP;

SELECT HIREDATE FROM EMP ORDER BY HIREDATE ASC;

SELECT HIREDATE FROM EMP WHERE ROWNUM <= 5;

-- 프럼절에서 자식 쿼리 인라인 뷰 서브쿼리로 
-- 입사일 빠른 순으로 소트를 먼저한다.
-- 이후 부모 쿼리에서 5건을 구한다.
SELECT A.HIREDATE 
FROM
    -- 인라인 뷰 서브쿼리 
    (SELECT HIREDATE FROM EMP ORDER BY HIREDATE ASC) A
WHERE ROWNUM <= 5;

/*
SELECT 
    SELECT * FROM DUAL;
FROM 
    SELECT * FROM DUAL;
WHERE 
    SELECT * FROM DUAL;
*/
