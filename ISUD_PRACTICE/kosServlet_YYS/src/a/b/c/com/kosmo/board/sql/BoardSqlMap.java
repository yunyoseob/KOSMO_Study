package a.b.c.com.kosmo.board.sql;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.com.kosmo.board.dao.BoardDAOImpl;

public abstract class BoardSqlMap {
	static Logger logger = LogManager.getLogger(BoardSqlMap.class);
	public static String getBoardSelectAll(){ 
		logger.info("getBoardSelectAll() 함수 진입 >>> : ");
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT															\n");
		sb.append("A.BNUM          	                             AS BNUM		    \n");
		sb.append(",A.BSUBJECT 		                             AS BSUBJECT	    \n");
		sb.append(",A.BWRITER 		                             AS BWRITER		    \n");
		sb.append(",A.BPW 			                             AS BPW			    \n");
		sb.append(",A.BMEMO 		                             AS BMEMO		    \n");
		sb.append(",A.DELETEYN 		                             AS DELETEYN        \n");
		sb.append(",TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD') AS INSERTDATE      \n");
		sb.append(",TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD') AS UPDATEDATE      \n");
		sb.append("FROM MVC_BOARD A												    \n");
		sb.append("WHERE A.DELETEYN='Y'											    \n");
		sb.append("ORDER BY BNUM DESC											    ");
		
		/*
		 SELECT
                 A.BNUM          AS BNUM
                ,A.BSUBJECT AS BSUBJECT
                ,A.BWRITER AS BWRITER
                ,A.BPW AS BPW
                ,A.BMEMO AS BMEMO
                ,A.DELETEYN AS DELETEYN
                ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD') AS INSERTDATE
                ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD') AS UPDATEDATE
                FROM MVC_BOARD A
                WHERE A.DELETEYN='Y'
                ORDER BY BNUM DESC;
		  */
		return sb.toString();
	}
	public static String getBoardSelect(){ 
		logger.info("getBoardSelect() 함수 진입 >>> : ");
		
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT																	\n");
		sb.append("      A.BNUM          	                             AS BNUM		    \n");
		sb.append("      ,A.BSUBJECT 		                             AS BSUBJECT	    \n");
		sb.append("      ,A.BWRITER 		                             AS BWRITER		    \n");
		sb.append("      ,A.BPW 			                             AS BPW			    \n");
		sb.append("      ,A.BMEMO 		                            	 AS BMEMO		    \n");
		sb.append("      ,A.DELETEYN 		                             AS DELETEYN        \n");
		sb.append("      ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD') 	 AS INSERTDATE      \n");
		sb.append("      ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD')   AS UPDATEDATE      \n");
		sb.append("FROM MVC_BOARD A												  		    \n");
		sb.append("WHERE A.DELETEYN='Y'											    		\n");
		sb.append("AND A.BNUM=?											    		  		  "); // placeholder 1 :: BNUM
		
		return sb.toString();
	}
	public static String getBoardInsert(){
		logger.info("getBoardInsert 함수 진입 >>> : ");
		/*
		 * INSERT INTO MVC_BOARD(
	 BNUM
		,BSUBJECT
		,BWRITER
		,BPW
		,BMEMO
		,DELETEYN
		,INSERTDATE
		,UPDATEDATE
	)
	VALUES (
	?
		,?
		,?
		,?
		,?
		,'Y'
		,SYSDATE
		,SYSDATE
	);
		 * */
		StringBuffer sb=new StringBuffer();
		
		sb.append("INSERT INTO    MVC_BOARD(	                   \n");
		sb.append("			      BNUM			                   \n");
		sb.append("               ,BSUBJECT	                       \n");
		sb.append("               ,BWRITER		                   \n");
		sb.append("               ,BPW			                   \n");
		sb.append("               ,BMEMO		                   \n");
		sb.append("               ,DELETEYN	                       \n");
		sb.append("               ,INSERTDATE	                   \n");
		sb.append("               ,UPDATEDATE	                   \n");
		sb.append(")			                  				   \n");
		sb.append("VALUES (		                  				   \n");
		sb.append("          ?			                           \n"); // BNUM     :: placeholder :: 1
		sb.append("         ,?			                           \n"); // BSUBJECT :: placeholder :: 2
		sb.append("         ,?			                           \n"); // BWRITER  ::placeholder :: 3
		sb.append("         ,?			                           \n"); // BPW      :: placeholder :: 4
		sb.append("         ,?			                           \n"); // BMEMO    :: placeholder :: 5
		sb.append("         ,'Y'			                       \n");
		sb.append("         ,SYSDATE		                       \n");
		sb.append("         ,SYSDATE		                       \n");
		sb.append(")												 ");
		
		
		return sb.toString();
	}
	public static String getBoardUpdate(){
		/*
		 UPDATE MVC_BOARD
				SET BSUBJECT=?
        		,BMEMO=?
        		,UPDATEDATE=SYSDATE
		 WHERE DELETEYN='Y'
		 AND BNUM=?;  
		 */
		logger.info("getBoardUpdate() 함수 진입 >>> : ");
		StringBuffer sb=new StringBuffer();
		
		sb.append("UPDATE MVC_BOARD	                     \n");
		sb.append("SET BSUBJECT=?		           		 \n"); // place holder 1 :: BSUBJECT :: 글 제목
		sb.append("	  ,BMEMO=?               		 	 \n"); // place holder 2 :: BMEMO    :: 글 내용
		sb.append("   ,UPDATEDATE=SYSDATE            	 \n");
		sb.append("WHERE DELETEYN='Y'                 	 \n");
		sb.append("AND BNUM=?                   	       "); // place holder 3 :: BNUM :: 글 번호 
		
		return sb.toString();
	}
	public static String getBoardDelete(){ 
		logger.info("getBoardDelete 함수 진입 >>> : ");
		StringBuffer sb=new StringBuffer();
		
		/*
		  UPDATE MVC_BOARD
          SET DELETEYN='N'
          WHERE DELETEYN='Y'
          AND BNUM=? ;
		*/
		
		sb.append("UPDATE MVC_BOARD	                     \n");
		sb.append("SET DELETEYN='N'		           		 \n"); 
		sb.append("WHERE DELETEYN='Y'                    \n"); 
		sb.append("AND BNUM=?            	 			 \n"); // place holder 1 :: BNUM :: 글 번호
				
		return sb.toString();
	}

} // end of BoardSqlMap
