--2022-03-18

SELECT*FROM TEST_T4 ORDER BY T1 ASC;

/*
ISUD �� �� ���� ����

================JAVA============================

 SELECT :  PreparedStatement  : excuteQuery() �޼��带 ����Ѵ�.
 
 INSERT : PreparedStatement : excuteUpdate() �޼��带 ����Ѵ�.
 
==========================================================
 INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ( ?, ?, ?, 'Y', SYSDATE)";
 -- �ݵ�� Y�� �Է��ϰ�, SYSDATE�� ���� ���ԵǾ����� ��� ���־�߸� �Ѵ�.
 ==========================================================
 
 UPDATE : PreparedStatement : excuteUpdate() �޼��带 ����Ѵ�.
 
 ==========================================================
 UPDATE TEST_T4 SET T2 = ?, T5 = SYSDATE WHERE T4 = 'Y' AND T1 = ? 
 ==========================================================
 
 -- UPDATE�� ��, ���� ��¥�� �ݵ�� �Է��Ѵ�.
 -- �ݵ��  WHERE ������ Y���� Ȯ���ϰ�,  PK�� �´��� Ȯ���Ѵ�.
 
 DELETE :  PreparedStatement : excuteUpdate() �޼��带 ����Ѵ�.
 -- �׷��� DELETE TABLE ���̺��̸� WHERE ����; �� ���� �ʴ´�.
 
 ==========================================================
 -- UPDATE TEST_T4 SET T4 = 'N', T5 = SYSDATE WHERE T4 = 'Y' AND T1 = ? 
 ==========================================================
 
 -- UPDATE�� ����,  WHERE ����  Ư�� �÷��� 'Y'�� PK ������ Ȯ���ϰ�
 -- Ư�� �÷��� 'N'���� �����ؼ� DELETE��� ó���Ѵ�.
 
 =================================================

*/

DESC TEST_T4;
SELECT*FROM TEST_T4;

SELECT NVL(MAX(SUBSTR(A.T1, -4)), 0)+1 AS COMM_NUM FROM TEST_T4 A;

CREATE TABLE TEST_T6(
    T1  VARCHAR2(20) PRIMARY KEY,
    T2 VARCHAR2(20) NOT NULL,
    T3  NUMBER(3),
    T4 VARCHAR2(1) NOT NULL,
    T5 DATE,
    T6 DATE
);

DESC TEST_T6;
