-- 20220524

-- NATURAL JOIN
-- 14건이 조회된다. 
SELECT  E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL,  E.COMM
                  ,DEPTNO, D.DNAME, D.LOC
FROM EMP E NATURAL JOIN DEPT D
ORDER BY DEPTNO, E.EMPNO;

-- JOIN~USING
-- 똑같이 14건이 조회된다. DEPTNO라는 열을 지정하였다.(기준열)
SELECT  E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL,  E.COMM
                  ,DEPTNO, D.DNAME, D.LOC
FROM EMP E JOIN DEPT D USING (DEPTNO)
ORDER BY DEPTNO, E.EMPNO;


-- FROM절 USING에  엘리어스를 사용하면 ORA-01748 : 열명 그 자체만 사용할 수 있다고 표시된다.
SELECT  E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL,  E.COMM
                  ,DEPTNO, D.DNAME, D.LOC
FROM EMP E JOIN DEPT D USING (E.DEPTNO)
ORDER BY DEPTNO, E.EMPNO;

-- ORA-25155 : NATURAL 조인에 사용된 열은 식별자를 가질 수 없다.
SELECT A.*, B.*
FROM EMP  A NATURAL JOIN DEPT B;


SELECT A.*, B.*
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO;

-- JOIN ~ ON
-- 13건이 조회되었다.
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM
                ,E.DEPTNO, D.DNAME, D.LOC
FROM EMP E JOIN DEPT D ON (E.DEPTNO=D.DEPTNO)
WHERE SAL <= 3000
ORDER BY E.DEPTNO, EMPNO;


-- VIEW 배우기

-- 먼저 테이블을 생성합니다.
CREATE TABLE EMP02
AS
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP;

SELECT*FROM EMP02;

CREATE VIEW VIEW_EMP02
AS
SELECT *
FROM EMP02
WHERE DEPTNO=10;
-- ORA-01031 : 권한이 불충분합니다. 오류 난다.

-- cmd에서  sqlplus system/1234
-- 입력 후, show user 입력했을 때, USER는 "SYSTEM"입니다
-- 라는 것을 본 다음
-- grant create view to scott; 명령어를 입력하면
-- 권한이 부여된다.
-- 그 다음에 앞의 명령어를 다시 입력하면 View VIEW_EMP02가 생성된다.

SELECT*FROM EMP02;

-- 뷰 연습
SELECT A.EMPNO, A.ENAME, A.SAL, B.DEPTNO, B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND A.DEPTNO=10;
-- 3건의 데이터가 조회된다.


CREATE VIEW VIEW_EMP_DEPT
AS
SELECT A.EMPNO, A.ENAME, A.SAL, B.DEPTNO, B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND A.DEPTNO=10;

INSERT INTO VIEW_EMP_DEPT
VALUES(8001, 'AAAA', 4000, 10, 'ACCNT');
-- SQL 오류 : ORA-17776 : 조인 뷰에 의하여 하나 이상의 기본 테이블을 수정할 수 없습니다.

-- 뷰 생성시 컬럼명을 조정할 수 있다.
CREATE OR REPLACE VIEW VIEW_EMP02_CCL(사원번호, 사원명, 급여, 부서번호)
AS
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP02;

SELECT*FROM VIEW_EMP02_CCL;


-- 뷰를 새로 만든 것
CREATE OR REPLACE VIEW VIEW_EMP02_CCL_1
AS
SELECT EMPNO AS E_1, ENAME AS E_2, SAL AS E_3, DEPTNO AS E_4
FROM EMP02;

SELECT*FROM VIEW_EMP02_CCL_1;
SELECT E_1 FROM VIEW_EMP02_CCL_1;


SELECT A.*, B.*
FROM EMP  A, DEPT B
WHERE A.DEPTNO=B.DEPTNO;

-- 기본 테이블의 유무에 따라 옵션 넣기
-- 기본테이블이 없으면 VIEW를 만들 수 없다 ? FALSE

-- 이유 : NOFORCE(DEFALUT)인 경우에는 맞는 말, 기본 테이블이 없으면, 만들 수가 없음
-- 그러나, FORCE 명령어를 쓰면, 기본 테이블이 없어도 뷰를 생성할 수 있기 때문에 FALSE라고 할 수 있다.

-- ORA-00942 : 테이블 또는 뷰가 존재하지 않습니다.
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP02_NOTABLE
WHERE ROWNUM<=3;

-- 이런 상황에서 VIEW를 생성하고자 한다면?
-- 마찬가지로 ORA-00942 : 테이블 또는 뷰가 존재하지 않습니다.
CREATE OR REPLACE VIEW VIEW_EMP02_1
AS
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP02_NOTABLE
WHERE ROWNUM<=3;

SELECT*FROM 

-- FORCE : 기본 테이블이 없어도 USER_VIEW 데이터 사전에 뷰를 생성한다.
CREATE OR REPLACE FORCE VIEW VIEW_EMP02_2
AS
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP02_NOTABLE
WHERE ROWNUM<=3;
-- ACTION : 경고 : 컴파일 오류와 함께 뷰가 생성되었습니다.

-- 조회는 되지 않는다.
SELECT*FROM VIEW_EMP02_2;
-- ORA-04063: view "SCOTT.VIEW_EMP02_2"에 오류가 있습니다
-- 04063. 00000 -  "%s has errors"
-- *Action:   Fix the errors and/or create referenced objects as necessary.

-- WITH CHECK OPTION
CREATE OR REPLACE VIEW VIEW_EMP03
AS
SELECT EMPNO, ENAME, DEPTNO, JOB
FROM EMP
WHERE JOB LIKE 'MANAGER' WITH CHECK OPTION;

SELECT*FROM VIEW_EMP03;

INSERT INTO VIEW_EMP03
VALUES(9000, 'ABC',30, 'SALESMAN');
--  ORA-01402: 뷰의 WITH CHECK OPTION의 조건에 위배 됩니다


-- WITH READ ONLY : 읽기만 가능
-- 대부분의 뷰는 리드온리로 생성할 것
CREATE OR REPLACE VIEW VIEW_EMP04
AS
SELECT EMPNO, ENAME, DEPTNO, JOB
FROM EMP
WHERE JOB LIKE 'MANAGER' WITH READ ONLY;

SELECT*FROM VIEW_EMP04;

INSERT INTO VIEW_EMP04
VALUES(9000, 'ABC', 30, 'MANAGER');
-- SQL 오류: ORA-42399: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.
-- 42399.0000 - "cannot perform a DML operation on a read-only view"


