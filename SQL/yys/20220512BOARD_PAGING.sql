-- 2022-05-12 PAGING
-- BOARD_PAGING 테이블 생성
CREATE TABLE BOARD_PAGING(
	bnum		NUMBER(20)		PRIMARY KEY,
	btitle		VARCHAR2(50)		NOT NULL,
	bname		VARCHAR2(20)		NOT NULL,
	barea		VARCHAR2(2000)		NOT NULL,
	bpass		VARCHAR2(20)		NULL,
	bwriteday	DATE				DEFAULT SYSDATE,
	bhits		NUMBER(8)			NULL
);
CREATE SEQUENCE B_SEQ INCREMENT BY 1 START WITH 1;

-- BOARD_PAGING 테이블 잘 생성되었는지 확인하기
SELECT*FROM BOARD_PAGING;
DESC BOARD_PAGING;

-- 인라인 뷰에 들어갈 문장 먼저 실행해보기
-- 알아야 하는 개념
-- RANK : 중복 순위 다음 순서 건너뜀. (1,2,3,4)
-- DENSE_RANK : 중복 순위 다음 순위 연속. (1,2,3,4)
-- ROW_NUMBER : 중복 순위 값이 유일값. (1,2,3,4)

-- OVER는 SUBQUERY, GROUP BY를 대신 해주는 분석함수이다.
-- GROUP BY, ORDERY BY를 집계함수라고 한다.

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
SELECT CEIL(3.141592) FROM DUAL;
-- 4




SELECT
    A.bnum -- 글번호
    ,A.btitle -- 제목
    ,A.bname -- 작성자
    ,A.barea -- 글내용
    ,A.bpass -- 비밀번호
    ,TO_CHAR(A.bwriteday, 'YYYY-MM-DD') bwriteday -- 작성일
    ,A.bhits -- 조회수
    ,CEIL(ROW_NUMBER() OVER(ORDER BY A.bnum)/10) pageSize -- 페이지 사이즈
    -- bnum 칼럼의 로우 단위 데이터를 10으로 나눈 뒤 오름차순 정렬한다.
    -- ROW_NUMBER : 중복 순위 값이 유일값. (1,2,3,4)
    ,COUNT(A.bnum) OVER() AS totalCount
FROM
        BOARD_PAGING A;
 

-- DROP SEQUENCE B_SEQ;
-- TRUNCATE TABLE BOARD_PAGING;
-- DROP TABLE BOARD_PAGING;
ROLLBACK;













