/*
-- 데이타 1000000 건을 넣기위해 수정
CREATE TABLE BOARD_PAGING(
	bnum		NUMBER(20)		PRIMARY KEY,
	btitle		VARCHAR2(50)		NOT NULL,
	bname		VARCHAR2(20)		NOT NULL,
	barea		VARCHAR2(2000)		NOT NULL,
	bpass		VARCHAR2(20)		NULL,
	bwriteday	DATE				DEFAULT SYSDATE,
	bhits		NUMBER(8)			NULL
);


SELECT COUNT(BNUM)FROM BOARD_PAGING;
SELECT * FROM USER_SEQUENCES;

SELECT B_SEQ.CURRVAL FROM DUAL;
SELECT B_SEQ.NEXTVAL FROM DUAL;

컴파일
C:\00.KOSMO108\10.JExam\paging>javac -d . -encoding utf-8 B*.java C*.java
실행
C:\00.KOSMO108\10.JExam\paging>java a.b.c.test.paging.BoardTestData


SELECT  *                                           
FROM (                                           
        SELECT                                      
            A.bnum,				-- 글번호                          	
            A.btitle,			-- 제목                             	
            A.bname,			-- 작성자                          				
            A.barea,			-- 글내용                          	
            A.bpass,			-- 비밀번호                       	
            TO_CHAR(A.bwriteday, 'YYYY-MM-DD') bwriteday,  -- 작성일   				
            A.bhits,			-- 조회수                          	
            CEIL(ROW_NUMBER() OVER(ORDER BY A.bnum) / 10) pageSize, 	
            COUNT(bnum) OVER() AS totalCount        
        FROM                                        
             BOARD_PAGING A                             
    )                                           
WHERE                                            
    pageSize = 2 ; 

*/

package a.b.c.test.paging;

import java.sql.Connection;
import java.sql.Statement;

public class BoardTestData {
	
	public void insertData() throws Exception {
		
		Connection	conn = ConnProperty.getConnection();			
		Statement	stmt = conn.createStatement();
		String sqls = null;
			
		for (long i = 0; i < 200 ; i++){
			sqls = "INSERT INTO BOARD_PAGING VALUES ( "
														+ "B_SEQ.NEXTVAL, " 
														+ "'" + i + "', " 
														+ "'" + i + "', " 
														+ "'" + i + "', " 
														+ "'" + i + "', " 										 
														+ "DEFAULT, "
														+ "1"
												  + ")";
			
			int nCount = stmt.executeUpdate(sqls);		
			if (nCount % 100 == 0) conn.commit();
		}
		
		conn.commit();		
		stmt.close();stmt = null;
		conn.close();conn = null;
	}
	
	public static void main(String args[]) throws Exception{
				
		new BoardTestData().insertData();		
	}
}