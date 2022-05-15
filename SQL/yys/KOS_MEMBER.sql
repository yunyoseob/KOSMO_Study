-- KOS_MEMBER ���� (ù ��° ���� ���� ��, KOS_MEMBER => KOS_MEMBER1 �� �����Ͽ���.
-- 2022 03 31
CREATE TABLE SCOTT.KOS_MEMBER(
            MNUM VARCHAR2(20) PRIMARY KEY,
            MNAME VARCHAR2(50),
            MID VARCHAR2(50) NOT NULL,
            MPW VARCHAR2(300) NOT NULL,
            MHP VARCHAR2(16) NOT NULL,
            MEMAIL VARCHAR2(200) NOT NULL,
            MGENDER VARCHAR2(10),
            MHOBBY VARCHAR2(100),
            MLOCAL VARCHAR2(200),
            MMSG VARCHAR2(2000),
            DELETEYN VARCHAR2(1) NOT NULL,
            INSERTDATE DATE,
            UPDATEDATE DATE
);


-- =================================
COMMIT;
-- �������� insert �غ���

INSERT INTO KOS_MEMBER(MNUM,MNAME,MID,MPW,MHP,MEMAIL,MGENDER,MHOBBY,MLOCAL,MMSG,DELETEYN,INSERTDATE,UPDATEDATE)
VALUES (123,'PGW','RIVEF','123','01023351912','RIVENF@NAVER.COM','M','BIKE','SEOUL','MSG','Y',SYSDATE,SYSDATE);
COMMIT;

SELECT*FROM KOS_MEMBER;
SELECT COUNT(MNUM) FROM KOS_MEMBER;
/*
           MNUM VARCHAR2(20) PRIMARY KEY,
            MNAME VARCHAR2(50),
            MID VARCHAR2(50) NOT NULL,
            MPW VARCHAR2(300) NOT NULL,
            MHP VARCHAR2(16) NOT NULL,
            MEMAIL VARCHAR2(200) NOT NULL,
            MGENDER VARCHAR2(10),
            MHOBBY VARCHAR2(100),
            MLOCAL VARCHAR2(200),
            MMSG VARCHAR2(2000),
            DELETEYN VARCHAR2(1) NOT NULL,
            INSERTDATE DATE,
            UPDATEDATE DATE
*/

/*    **DQL :: Data Query Language :: SELECT**    */
--��ü ��ȸ
SELECT               A.MNUM                                                                                                           AS      MNUM --ȸ����ȣ  	:: COLUMN_ID :: 1
                              ,A.MNAME                                                                                                         AS      MNAME --ȸ���̸�	:: COLUMN_ID :: 2
                              ,A.MID                                                                                                                  AS      MID --���̵�		:: COLUMN_ID :: 3
                              ,A.MPW                                                                                                               AS      MPW --�н�����	:: COLUMN_ID :: 4 
                              ,A.MHP                                                                                                                AS      MHP --�ڵ�����ȣ	:: COLUMN_ID :: 5
                              ,A.MEMAIL                                                                                                         AS     MEMAIL --�̸���		:: COLUMN_ID :: 6
                              ,A.MGENDER                                                                                                     AS    MGENDER --����		:: COLUMN_ID :: 7
                              ,A.MHOBBY                                                                                                       AS       MHOBBY --���		:: COLUMN_ID :: 8
                              ,A.MLOCAL                                                                                                       AS      MLOCAL --����		:: COLUMN_ID :: 9
                              ,A.MMSG                                                                                                            AS      MMSG --����		:: COLUMN_ID :: 10
                              , A.DELETEYN                                                                                                  AS      DELETEYN --ȸ������	:: COLUMN_ID :: 11
                              ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD')          AS      INSERTDATE --�����		:: COLUMN_ID :: 12
                              ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD')        AS      UPDATEDATE --������		:: COLUMN_ID :: 13
FROM                 SCOTT.KOS_MEMBER A -- SCOTT ������ KOS_MEMBER ���̺� :: ALIAS(��Ī)�� A
WHERE              A.DELETEYN='Y' -- ȸ�����ΰ� 'Y'�� ��츸 ��ȸ (����ȸ���� ��ȸ���� �ʴ´�.)
ORDER BY        MNUM  ASC;  -- PRIMARY KEY�� MNUM Į���� ������������ ����
/*
ORDER BY ���� �÷� �̸��� A.MNUM�� �ƴ� MNUM�� ����
FROM - WHERE - SELECT - ORDER BY �� ������ ���� �ǹǷ�,
SELECT�� ALIAS����  ORDER BY ���� Į������ �Է��ؾ� �Ѵ�.
ASC : ������������ �����ϼ���.
*/

-- ȸ�� ��ȣ ��ȸ
SELECT               A.MNUM                                                                                                           AS      MNUM --ȸ����ȣ  	:: COLUMN_ID :: 1
                              ,A.MNAME                                                                                                         AS      MNAME --ȸ���̸�	:: COLUMN_ID :: 2
                              ,A.MID                                                                                                                  AS      MID --���̵�		:: COLUMN_ID :: 3
                              ,A.MPW                                                                                                               AS      MPW --�н�����	:: COLUMN_ID :: 4 
                              ,A.MHP                                                                                                                AS      MHP --�ڵ�����ȣ	:: COLUMN_ID :: 5
                              ,A.MEMAIL                                                                                                         AS     MEMAIL --�̸���		:: COLUMN_ID :: 6
                              ,A.MGENDER                                                                                                     AS    MGENDER --����		:: COLUMN_ID :: 7
                              ,A.MHOBBY                                                                                                       AS       MHOBBY --���		:: COLUMN_ID :: 8
                              ,A.MLOCAL                                                                                                       AS      MLOCAL --����		:: COLUMN_ID :: 9
                              ,A.MMSG                                                                                                            AS      MMSG --����		:: COLUMN_ID :: 10
                              , A.DELETEYN                                                                                                  AS      DELETEYN --ȸ������	:: COLUMN_ID :: 11
                              ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD')          AS      INSERTDATE --�����		:: COLUMN_ID :: 12
                              ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD')        AS      UPDATEDATE --������		:: COLUMN_ID :: 13
FROM                 SCOTT.KOS_MEMBER A -- SCOTT ������ KOS_MEMBER ���̺� :: ALIAS(��Ī)�� A
WHERE              A.DELETEYN='Y'  -- ȸ�����ΰ� 'Y'�� ��츸 ��ȸ (����ȸ���� ��ȸ���� �ʴ´�.)
AND                    A.MNUM LIKE  '%||123||%'
-- ȸ����ȣ :: MNUM :: place holder 1
ORDER BY        MNUM  ASC; -- PRIMARY KEY�� MNUM Į���� ������������ ����

-- ȸ�� �̸� ��ȸ
SELECT               A.MNUM                                                                                                           AS      MNUM --ȸ����ȣ  	:: COLUMN_ID :: 1
                              ,A.MNAME                                                                                                         AS      MNAME --ȸ���̸�	:: COLUMN_ID :: 2
                              ,A.MID                                                                                                                  AS      MID --���̵�		:: COLUMN_ID :: 3
                              ,A.MPW                                                                                                               AS      MPW --�н�����	:: COLUMN_ID :: 4 
                              ,A.MHP                                                                                                                AS      MHP --�ڵ�����ȣ	:: COLUMN_ID :: 5
                              ,A.MEMAIL                                                                                                         AS     MEMAIL --�̸���		:: COLUMN_ID :: 6
                              ,A.MGENDER                                                                                                     AS    MGENDER --����		:: COLUMN_ID :: 7
                              ,A.MHOBBY                                                                                                       AS       MHOBBY --���		:: COLUMN_ID :: 8
                              ,A.MLOCAL                                                                                                       AS      MLOCAL --����		:: COLUMN_ID :: 9
                              ,A.MMSG                                                                                                            AS      MMSG --����		:: COLUMN_ID :: 10
                              , A.DELETEYN                                                                                                  AS      DELETEYN --ȸ������	:: COLUMN_ID :: 11
                              ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD')          AS      INSERTDATE --�����		:: COLUMN_ID :: 12
                              ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD')        AS      UPDATEDATE --������		:: COLUMN_ID :: 13
FROM                 SCOTT.KOS_MEMBER A -- SCOTT ������ KOS_MEMBER ���̺� :: ALIAS(��Ī)�� A
WHERE              A.DELETEYN='Y'  -- ȸ�����ΰ� 'Y'�� ��츸 ��ȸ (����ȸ���� ��ȸ���� �ʴ´�.)
AND                    A.MNAME LIKE UPPER('%PGW%')
-- ȸ���̸� :: MNAME :: place holder 1
ORDER BY        MNUM  ASC; -- PRIMARY KEY�� MNUM Į���� ������������ ����


-- ��¥ ��ȸ (����� ��ȸ)
-- ������ ��ȸ�� java ISUD ���� �� ��, ������ ��ȸ ���� ���� ������ ���� ��,
-- ������ ��ȸ ����� ���� �����Ƿ�, ����ϸ� �϶�� �ϼ̴�.

SELECT               A.MNUM                                                                                                           AS      MNUM --ȸ����ȣ  	:: COLUMN_ID :: 1
                              ,A.MNAME                                                                                                         AS      MNAME --ȸ���̸�	:: COLUMN_ID :: 2
                              ,A.MID                                                                                                                  AS      MID --���̵�		:: COLUMN_ID :: 3
                              ,A.MPW                                                                                                               AS      MPW --�н�����	:: COLUMN_ID :: 4 
                              ,A.MHP                                                                                                                AS      MHP --�ڵ�����ȣ	:: COLUMN_ID :: 5
                              ,A.MEMAIL                                                                                                         AS     MEMAIL --�̸���		:: COLUMN_ID :: 6
                              ,A.MGENDER                                                                                                     AS    MGENDER --����		:: COLUMN_ID :: 7
                              ,A.MHOBBY                                                                                                       AS       MHOBBY --���		:: COLUMN_ID :: 8
                              ,A.MLOCAL                                                                                                       AS      MLOCAL --����		:: COLUMN_ID :: 9
                              ,A.MMSG                                                                                                            AS      MMSG --����		:: COLUMN_ID :: 10
                              , A.DELETEYN                                                                                                  AS      DELETEYN --ȸ������	:: COLUMN_ID :: 11
                              ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD')          AS      INSERTDATE --�����		:: COLUMN_ID :: 12
                              ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD')        AS      UPDATEDATE --������		:: COLUMN_ID :: 13
FROM                 SCOTT.KOS_MEMBER A -- SCOTT ������ KOS_MEMBER ���̺� :: ALIAS(��Ī)�� A
WHERE              A.DELETEYN='Y'  -- ȸ�����ΰ� 'Y'�� ��츸 ��ȸ (����ȸ���� ��ȸ���� �ʴ´�.)
AND                    TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYYMMDD') >= TO_CHAR(TO_DATE('2022-03-01'), 'YYYYMMDD')
-- ����� fromdate :: place holder 1 
AND                     TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYYMMDD') <= TO_CHAR(TO_DATE('2022-04-01'), 'YYYYMMDD')
-- ����� todate :: place holder 	 2 
ORDER BY        MNUM  ASC; -- PRIMARY KEY�� MNUM Į���� ������������ ����

-- ȸ�� ���� �Է�
SELECT*FROM KOS_MEMBER;

SELECT NVL(MAX(SUBSTR(A.MNUM, -4)), 0) + 1 AS COMM_NUM FROM KOS_MEMBER A;

INSERT INTO SCOTT.KOS_MEMBER(
MNUM
,MNAME
,MID
,MPW
,MHP
,MEMAIL
,MGENDER
,MHOBBY
,MLOCAL
,MMSG
,DELETEYN
,INSERTDATE
,UPDATEDATE)
VALUES (
456--?
YYS--,?
imyoseob--,?
1234--,?
01091389471--,?
imyoseob@naver.com--,?
M--,?
game--,?
--,?
--,?
,'Y'--,'Y'
,SYSDATE
,SYSDATE
);

commit;

SELECT NVL(MAX(SUBSTR(A.MNUM, -4)), 0) + 1 AS COMM_NUM FROM KOS_MEMBER A;
SELECT*FROM KOS_MEMBER;

RENAME KOS_MEMBER TO KOS_MEMBER1;

COMMIT;