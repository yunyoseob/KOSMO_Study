
CREATE TABLE KOSMO_PRODUCT(
    KPNUM VARCHAR2(20) PRIMARY KEY 
   ,KPID VARCHAR2(200)
   ,KPNAME VARCHAR2(200)
   ,KPCOMPANY VARCHAR2(200)
   ,KPFILE VARCHAR2(200)
   ,KPCNT NUMBER
   ,KPPRICE NUMBER
   ,KPDESC VARCHAR2(2002)
   ,DELETEYN VARCHAR2(1)
   ,INSERTDATE DATE
   ,UPDATEDATE DATE
);

SELECT * FROM KOSMO_PRODUCT;

-- SYS_C0011100
SELECT  A.TABLE_NAME, A.COLUMN_NAME, A.INDEX_NAME
FROM    ALL_IND_COLUMNS A
WHERE   A.TABLE_NAME IN ('KOSMO_PRODUCT');

SELECT  NVL(MAX(SUBSTR(A.KPNUM, -4)), 0) + 1  KPNUM 
FROM    KOSMO_PRODUCT A;

INSERT INTO KOSMO_PRODUCT (KPNUM, KPID, KPNAME, KPCOMPANY, KPFILE, KPCNT, KPPRICE, KPDESC, 'Y', SYSDATE, SYSDATE)
            VALUES ('11', '11', '11', '11', '11', '11', '11', '11', 'Y', SYSDATE, SYSDATE);







