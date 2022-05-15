-- 2022-05-12 PAGING
-- BOARD_PAGING ���̺� ����
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

-- BOARD_PAGING ���̺� �� �����Ǿ����� Ȯ���ϱ�
SELECT*FROM BOARD_PAGING;
DESC BOARD_PAGING;

-- �ζ��� �信 �� ���� ���� �����غ���
-- �˾ƾ� �ϴ� ����
-- RANK : �ߺ� ���� ���� ���� �ǳʶ�. (1,2,3,4)
-- DENSE_RANK : �ߺ� ���� ���� ���� ����. (1,2,3,4)
-- ROW_NUMBER : �ߺ� ���� ���� ���ϰ�. (1,2,3,4)

-- OVER�� SUBQUERY, GROUP BY�� ��� ���ִ� �м��Լ��̴�.
-- GROUP BY, ORDERY BY�� �����Լ���� �Ѵ�.

/*
OVER() �Լ�
GROUP BY�� ���������� ������� �ʰ�
SUM, AVG, MAX, MIN, COUNT(�м� �Լ�)��
GROUP BY, ORDER BY(���� �Լ�) ���� ���� ���̸� ����

�м�_�Լ�() OVER(PARTITION BY Į�� / ORDER BY �÷� / �κ� ���� ����)
���⼭ �м� �Լ��� OVER()�� �ʼ�����
OVER ���� ������� �ʿ��� ��쿡�� �ۼ����ָ� �ȴ� (ORDER BY�� �ʼ��� �ƴϴ�)
RANK, DENSE_RANK�� ORDER BY �ʼ�
*/
SELECT CEIL(3.141592) FROM DUAL;
-- 4




SELECT
    A.bnum -- �۹�ȣ
    ,A.btitle -- ����
    ,A.bname -- �ۼ���
    ,A.barea -- �۳���
    ,A.bpass -- ��й�ȣ
    ,TO_CHAR(A.bwriteday, 'YYYY-MM-DD') bwriteday -- �ۼ���
    ,A.bhits -- ��ȸ��
    ,CEIL(ROW_NUMBER() OVER(ORDER BY A.bnum)/10) pageSize -- ������ ������
    -- bnum Į���� �ο� ���� �����͸� 10���� ���� �� �������� �����Ѵ�.
    -- ROW_NUMBER : �ߺ� ���� ���� ���ϰ�. (1,2,3,4)
    ,COUNT(A.bnum) OVER() AS totalCount
FROM
        BOARD_PAGING A;
 

-- DROP SEQUENCE B_SEQ;
-- TRUNCATE TABLE BOARD_PAGING;
-- DROP TABLE BOARD_PAGING;
ROLLBACK;













