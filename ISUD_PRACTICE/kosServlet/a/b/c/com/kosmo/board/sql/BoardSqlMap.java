package a.b.c.com.kosmo.board.sql;

public abstract class BoardSqlMap {

	// 전체 조회
	public static String getBoardSelectAll(){ 
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT 										\n");
		sb.append(" 		 A.BNUM          BNUM 				\n");
		sb.append(" 		,A.BSUBJECT      BSUBJECT 			\n");
		sb.append(" 		,A.BWRITER       BWRITER 			\n");
		sb.append(" 		,A.BPW           BPW 				\n");
		sb.append(" 		,A.BMEMO         BEMMO 				\n");
		sb.append(" 		,A.DELETEYN      DELETEYN 			\n");
		sb.append(" 		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')    INSERTDATE \n");
		sb.append(" 		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')    UPDATEDATE \n");
		sb.append(" FROM 	MVC_BOARD A 						\n");
		sb.append(" WHERE 	A.DELETEYN = 'Y' 					\n");
		sb.append(" ORDER 	BY 1 DESC 							\n");
				
		return sb.toString();
	}
	
	// 조건 조회
	public static String getBoardSelect(){ 
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT 										\n");
		sb.append(" 		 A.BNUM          BNUM 				\n");
		sb.append(" 		,A.BSUBJECT      BSUBJECT 			\n");
		sb.append(" 		,A.BWRITER       BWRITER 			\n");
		sb.append(" 		,A.BPW           BPW 				\n");
		sb.append(" 		,A.BMEMO         BEMMO 				\n");
		sb.append(" 		,A.DELETEYN      DELETEYN 			\n");
		sb.append(" 		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')    INSERTDATE \n");
		sb.append(" 		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')    UPDATEDATE \n");
		sb.append(" FROM 	MVC_BOARD A 						\n");
		sb.append(" WHERE 	A.DELETEYN = 'Y' 					\n");
		sb.append(" AND 	A.BNUM = ? 							\n"); // placeholder 1
				
		return sb.toString();
	}
	
	// 입력하기 
	public static String getBoardInsert(){ 
	
		StringBuffer sb = new StringBuffer();
		/*
		INSERT INTO MVC_BOARD (BNUM, BSUBJECT, BWRITER, BPW, BMEMO, DELETEYN, INSERTDATE, UPDATEDATE)
        VALUES (?, ?, ?, ?, ?, 'Y', SYSDATE, SYSDATE);
		*/
		
		sb.append(" INSERT INTO 						\n");
		sb.append(" 	 MVC_BOARD 						\n");
		sb.append(" 				(   				\n");
		sb.append(" 				 	 BNUM  			\n"); // COLUMN 1
		sb.append(" 					,BSUBJECT  		\n"); // COLUMN 2
		sb.append(" 					,BWRITER  		\n"); // COLUMN 3
		sb.append(" 					,BPW  			\n"); // COLUMN 4
		sb.append(" 					,BMEMO  		\n"); // COLUMN 5
		sb.append(" 					,DELETEYN  		\n"); // COLUMN 6
		sb.append(" 					,INSERTDATE  	\n"); // COLUMN 7
		sb.append(" 					,UPDATEDATE  	\n"); // COLUMN 8
		sb.append(" 				)   				\n");
		sb.append(" 	  	VALUES   					\n");
		sb.append(" 				(   				\n"); 
		sb.append(" 				 	 ?  			\n"); // placeholder 2
		sb.append(" 					,?  			\n"); // placeholder 2
		sb.append(" 					,?  			\n"); // placeholder 3
		sb.append(" 					,?  			\n"); // placeholder 4
		sb.append(" 					,?  			\n"); // placeholder 5
		sb.append(" 					,'Y'  			\n"); // 'Y'	     6
		sb.append(" 					,SYSDATE  		\n"); // SYSDATE     7
		sb.append(" 					,SYSDATE  		\n"); // SYSDATE     8
		sb.append(" 				)   				\n");
		
		return sb.toString();
	}
	public static String getBoardUpdate(){ 
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("UPDATE    MVC_BOARD 					\n");
		sb.append("SET       BSUBJECT 	= ?  			\n"); // placeholder 1
		sb.append("			,BMEMO 		= ?      		\n"); // placeholder 2
		sb.append("         ,UPDATEDATE = SYSDATE 		\n");
		sb.append("WHERE     DELETEYN 	= 'Y' 			\n");
		sb.append("AND       BNUM 		= ? 			\n"); // placeholder 3

		return sb.toString();
	}
	
	public static String getBoardDelete(){ return null;}

}
