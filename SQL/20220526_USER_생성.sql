-- 오라클 오브젝트
-- WITH절 
-- 오라클 9 이후 버전부터 사용 가능
-- 임시 테이블을 만들어서 그 쿼리문안에서만 실행
-- 동일 블럭에 대해 반복적으로 SQL문을 사용할 경우 
-- 그 블럭에 이름을 부여하여 재사용

WITH EXAMPLE AS (SELECT 'WITH절' AS STR1 FROM DUAL)
SELECT * FROM EXAMPLE;

-- 다중 WITH 문
WITH EXAMPLE1 AS ( --첫번째 WITH문
                    SELECT 'EX1' A FROM DUAL 
                    UNION ALL
                    SELECT 'EX2' FROM DUAL
                    ), 
EXAMPLE2 AS ( --두번째 WITH문
                SELECT 'EX3' A FROM DUAL 
                UNION ALL
                SELECT A FROM EXAMPLE1 --첫번째 WITH문 참조
             )
SELECT * FROM EXAMPLE2;


WITH EMP_W AS (SELECT DEPTNO, SUM(SAL) AS SAL FROM EMP GROUP BY DEPTNO)
SELECT A.DEPTNO, B.DNAME, A.SAL
FROM   EMP_W A, DEPT B
WHERE  A.DEPTNO = B.DEPTNO;

WITH EMP_W_1 AS (SELECT DEPTNO, AVG(SAL) AS SAL_AVG FROM EMP GROUP BY DEPTNO),
     EMP_W_2 AS (SELECT JOB, AVG(SAL) AS SAL_AVG FROM EMP GROUP BY JOB)
SELECT  A.ENAME, A.JOB, A.SAL,
        B.SAL_AVG AS DEPT_AVG,
        C.SAL_AVG AS JOB_AVG
FROM EMP A, EMP_W_1 B, EMP_W_2 C
WHERE A.EMPNO = 7788
AND   A.DEPTNO = B.DEPTNO
AND   A.JOB = C.JOB;

SELECT  A.ENAME, A.JOB, A.SAL, A.DEPTNO
FROM    EMP A
WHERE A.EMPNO = 7788;

WITH DEPT_TEMP AS (SELECT DEPTNO, DNAME FROM DEPT),
     EMP_TEMP AS (SELECT ENAME, DEPTNO, SAL FROM EMP),
     CNT_DEPT_TEMP AS (SELECT COUNT(DEPTNO) AS CNT FROM DEPT_TEMP)
SELECT  A.DNAME, B.ENAME, B.SAL, C.CNT
FROM    DEPT_TEMP A, EMP_TEMP B, CNT_DEPT_TEMP C
WHERE   A.DEPTNO = B.DEPTNO;


-- INDEX : 색인 : 영어사전 : 색인 A, B, C ... , 한글 사전 : 색인 ㄱ, ㄴ, ㄷ ....
-- 오라클 데이터베이스에서 INDEX 성능 향상(조회 속도 향상)에서 양날의 검 
SELECT  TABLE_NAME, INDEX_NAME, COLUMN_NAME
FROM    USER_IND_COLUMNS
WHERE   TABLE_NAME IN ('EMP', 'DEPT');

--테이블 생성시 프라이머리 키(PK)를 생성하면
--오라클 엔진에서 자동으로 인덱스를 생성한다. 
--생성하는 이름은 SYS_  접두어 + C + 0000000 규칙으로 생성한다. 
--SYS_C0011065 : SYS  접두어 + C + 0000000
CREATE TABLE INDEX_TEST_1 (
    INDEX_1 NUMBER PRIMARY KEY 
);
SELECT  TABLE_NAME, INDEX_NAME, COLUMN_NAME
FROM    USER_IND_COLUMNS
WHERE   TABLE_NAME IN ('INDEX_TEST_1');

-- PK 생성시 자동으로 시스템에서 시스템을 인덱스를 생성하기 때문에
-- 사용자 정의로 인덱스를 생성할 수 없다. 
CREATE INDEX INDEX_TEST_1_111 ON INDEX_TEST_1(INDEX_1);

-- 인덱스 생성하기 
CREATE TABLE T2 (
    T2_1 NUMBER,
    T2_2 VARCHAR2(10)
);

--단일 인덱스
CREATE INDEX INDEX_T2_T2_1 ON T2(T2_1);
--결합 인덱스
CREATE INDEX INDEX_T2_T2_1_T2_2 ON T2(T2_1, T2_2);

/*
사전 정의된 롤
CONNECT 롤
    -- Releas 9.0 버전
    ALTER SESSION
    CREATE CLUSTER
    CREATE DATABASE LINK
    CREATE SEQUENCE
    CREATE SESSION
    CREATE SYNONYM
    CREATE TABLE
    CREATE VIEW 
    -- Release 11.2 버전
    CREATE SESSION
RESOURCE 롤
    CREATE CLUSTER
    CREATE PROCEDURE
    CREATE SEQUENCE
    CREATE TABLE
    CREATE TRIGGER

DAB 롤 
*/


--오라클에 데이터에 계정을 만들 때는 SYSTEM 또는 SYS 계정으로 한다. 
SHOW USER;

-- 계정생성하기 
-- 계정이름 : test01
-- 계정비밀번호 : 1234
--CREATE USER : 계정을 생성하는 키워드 
--IDENTIFIED BY : 비밀번호를 생성하는 키워드 
--CREATE USER 계정명 IDENTIFIED BY 비밀번호 
CREATE USER test01 IDENTIFIED BY 1234;

--C:\Users\KOSMO>sqlplus test01/1234
--ERROR:
--ORA-01045: user TEST01 lacks CREATE SESSION privilege; logon denied
--
--ORA-01045 : 오라클 에러코드 
--오라클 에러코드를 인터넷에서 검색해서 에러를 디버깅한다. 

--맨처음 유저를 생성하면 
--달랑 유저만 생성되기 때문에 
--연결권한 
--테이블 생성 권한을 부여해야 한다. 해당하는 유저에 

--연결권한 주기 
--GRANT CREATE SESSION TO : 유저에게 연결 권한을 주는 구문
GRANT CREATE SESSION TO test01;

--C:\Users\KOSMO>sqlplus test01/1234
--다음에 접속됨:
--Oracle Database 11g Enterprise Edition Release 11.2.0.1.0 - 64bit Production
--With the Partitioning, OLAP, Data Mining and Real Application Testing options
--
--SQL>

--테이블 생성 권한을 부여해야 한다. 해당하는 유저에 
GRANT CREATE TABLE TO test01;

--Grant을(를) 성공했습니다.

--테이블 스페이스 생성 
ALTER USER test01 QUOTA UNLIMITED ON USERS;

--계정 생성해서 테이블 만들기 
--1. system/1234 로그인
--2. 계정만들기 
--CREATE USER test02 IDENTIFIED BY 1234;
--비밀번호 바꾸기 
--ALTER USER test02 IDENTIFIED BY 1234;
--3. 연결 권한 부여
--GRANT CREATE SESSION TO test02;
--4. 테이블 생성 권한 부여
--GRANT CREATE TABLE TO test02;
--5. 테이블 스페이스 사이즈 변경 : 2M, 5M, 10M, UNLIMITED 등 
--ALTER USER test01 QUOTA UNLIMITED ON USERS;
--6. 생성한 계정으로 로그인 해서 테이블 생성하기 
--CREATE TABLE T1_TABLE (
--    TESTCOLUMN1 VARCHAR2(20) 
--   ,TESTCOLUMN2 VARCHAR2(200)
--);

--test02/1234 계정만들기 
--T2_TABLE 테이블 만들기 
--T2_COLUMN1 VARCHAR2(20)
--T2_COLUMN2 VARCHAR2(200)  
CREATE USER test02 IDENTIFIED BY 1234;
GRANT CREATE SESSION TO test02;
GRANT CREATE TABLE TO test02;
ALTER USER test02 QUOTA UNLIMITED ON USERS;

SELECT *
FROM   DBA_USERS
WHERE  USERNAME IN 'test02'


-- 테이블 스페이스에 대해서 
-- 오라클버전
SELECT * FROM V$VERSION;

-- 전체 테이블 스페이스
SELECT * FROM DBA_TABLESPACES;
SELECT * FROM DBA_DATA_FILES;

SELECT TABLESPACE_NAME, CONTENTS FROM DBA_TABLESPACES;

-- 임시 테이블 스페이스
SELECT * FROM DBA_TEMP_FILES;

-- 현재 유저의 DEFAULT TABLESPACE 확인 
SELECT * FROM USER_USERS;

--#############################################################
--계정 생성 및 테이블스페이스 정하기 
CREATE USER test03 -- 유저만들기 
IDENTIFIED BY 1234 -- 비밀번호 만들기
DEFAULT TABLESPACE USERS -- DEFAULT TABLESPACE 는 USER 스키마를 위한 기본 테이블스페이스를 지정한다.
TEMPORARY TABLESPACE TEMP; --  TEMPORARY TABLESPACE는 USER 임시 테이블스페이스를 지정한다. 
-- 정상적으로 생성되었다면 테이블 스페이스 영역을 설정한다. 

-- QUOTA 절을 사용하여 USER가 사용할 테이블스페이스의 영역을 할당한다. 
-- UNLIMITED : 공간에 제약없음, 2M, 5M, 10M 등 
ALTER USER test03 DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

-- 리소스 권한과 연결 권한을 아이디에 부여한다. 
GRANT resource, connect TO test03;

--CONNECT 룰
--Releas 11.2 버전
--CREATE SESSION 
--Releas 9.0 버전
--ALTER SESSION, CREATE CLUSTER, CREATE DATABASE LINK, CREATE SEQUENCE, CREATE SESSION,
--CREATE SYNONYM, CREATE TABLE, CREATE VIEW

--RESOURCE 룰 
--사용자가 객체(테이블, 뷰, 인덱스)를 생성할 수 있도록 하기 위해서 스스템 권한을 묶어 놓음 
--CREATE CLUSTER
--CREATE PROCEDURE
--CREATE SEQUENCE
--CREATE TABLE
--CREATE TRIGGER 

--CONN test03/124
--SELECT * FROM USER_ROLE_PRIVS;

--SELECT * FROM USER_SYS_PRIVS;

--####################################################


--hbe00/hbe1234 계정만들기 
CREATE USER hbe00 IDENTIFIED BY hbe1234
DEFAULT TABLESPACE USERS -- DEFAULT TABLESPACE 는 USER 스키마를 위한 기본 테이블스페이스를 지정한다.
TEMPORARY TABLESPACE TEMP; --  TEMPORARY TABLESPACE는 USER 임시 테이블스페이스를 지정한다. 

GRANT CREATE SESSION TO hbe00;
GRANT CREATE TABLE TO hbe00;

ALTER USER hbe00 QUOTA 2M ON USERS;
-- ALTER USER hbe00 QUOTA UNLIMITED ON USERS;








