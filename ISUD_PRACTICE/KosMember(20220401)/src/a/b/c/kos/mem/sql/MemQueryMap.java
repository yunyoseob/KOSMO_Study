package a.b.c.kos.mem.sql;

import a.b.c.kos.mem.vo.MemVO;

public abstract class MemQueryMap {

	// 회원 전체 조회
	public static String getMmemSelectAllQuery(MemVO mvo){
		
		String searchFilter = mvo.getSearchFilter();
		String keyword = mvo.getKeyword();
		String fromdate = mvo.getFromdate();
		String todate = mvo.getTodate();	
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 									\n");
		sb.append("      A.MNUM 			MNUM 			\n");
		sb.append("		,A.MNAME  			MNAME 			\n");
		sb.append("		,A.MID  			MID 			\n");
	    sb.append("		,A.MPW  			MPW   			\n");
	    sb.append("		,A.MHP  			MHP 			\n");
	    sb.append("		,A.MEMAIL  			MEMAIL 			\n");
	    sb.append("		,A.MGENDER  		MGENDER 		\n");
	    sb.append("		,A.MHOBBY  			MHOBBY   		\n");	   
		sb.append("		,A.MZONE  			MZONE 			\n");		
	    sb.append("		,A.MROAD  			MROAD   		\n");
	    sb.append("		,A.MJIBUN  			MJIBUN 			\n");
	    sb.append("		,A.MMSG  			MMSG 			\n");
	    sb.append("		,A.DELETEYN 		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	    
	    sb.append("	FROM 								\n");
	    sb.append("		 KOS_MEMBER A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    
	    if(fromdate !=null && fromdate.length() > 0 && todate !=null && todate.length() > 0){
	    	 sb.append("AND	A.INSERTDATE >= TO_DATE(" + "'" + fromdate + "'"  + ") \n"); // '2022-04-01'
	    	 sb.append("AND	A.INSERTDATE <= TO_DATE(" + "'" + todate 	+ "'" + ") \n");
	    }
	    
	    if ("01".equals(searchFilter)) {	    	 
	    }
	    
	    if ("02".equals(searchFilter)) {
	    	sb.append("AND	A.MNUM 	= " + "'" + keyword + "'" + "\n");
	    }
	    
	    if ("03".equals(searchFilter)) {
	    	sb.append("AND	A.MNAME = " + "'" + keyword + "'" + "\n");
	    }
	    
		if ("04".equals(searchFilter)) {
			sb.append("AND	A.MID 	= " + "'" + keyword + "'"  + "\n");
		}
	    sb.append("	ORDER BY 1 DESC					\n");
	    
	    return sb.toString();
	}
	
	// 회원 조건 조회
	public static String getMemSelectQuery(){
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 									\n");
		sb.append("      A.MNUM 			MNUM 			\n");
		sb.append("		,A.MNAME  			MNAME 			\n");
		sb.append("		,A.MID  			MID 			\n");
	    sb.append("		,A.MPW  			MPW   			\n");
	    sb.append("		,A.MHP  			MHP 			\n");
	    sb.append("		,A.MEMAIL  			MEMAIL 			\n");
	    sb.append("		,A.MGENDER  		MGENDER 		\n");
	    sb.append("		,A.MHOBBY  			MHOBBY   		\n");	   
		sb.append("		,A.MZONE  			MZONE 			\n");		
	    sb.append("		,A.MROAD  			MROAD   		\n");
	    sb.append("		,A.MJIBUN  			MJIBUN 			\n");
	    sb.append("		,A.MMSG  			MMSG 			\n");
	    sb.append("		,A.DELETEYN 		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	    
	    sb.append("	FROM 								\n");
	    sb.append("		 KOS_MEMBER A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    sb.append("	AND   A.MNUM   = ?					\n");// placeholder 1

	    
	    return sb.toString();
	}
	
	public static String getMemInsertQuery(){
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	INSERT INTO 						\n");	
		sb.append("		KOS_MEMBER 				    	\n");
		sb.append("		          (			    		\n");
		sb.append("      			 MNUM 				\n"); // COLUMN 1
		sb.append("					,MNAME 				\n"); // COLUMN 2
		sb.append("					,MID 				\n"); // COLUMN 3
	    sb.append("					,MPW   				\n"); // COLUMN 4
	    sb.append("					,MHP 				\n"); // COLUMN 5
	    sb.append("					,MEMAIL 			\n"); // COLUMN 6
	    sb.append("					,MGENDER 			\n"); // COLUMN 7
	    sb.append("					,MHOBBY 			\n"); // COLUMN 8
	    sb.append("					,MZONE   			\n"); // COLUMN 9
	    sb.append("					,MROAD 				\n"); // COLUMN 10
	    sb.append("					,MJIBUN 			\n"); // COLUMN 11	    
	    sb.append("					,MMSG 				\n"); // COLUMN 12
	    sb.append("					,DELETEYN			\n"); // COLUMN 13
	    sb.append("					,INSERTDATE			\n"); // COLUMN 14
	    sb.append("					,UPDATEDATE			\n"); // COLUMN 15	 	  
		sb.append("			      )						\n");
		sb.append("	       VALUES   					\n");
		sb.append("	       		 (  					\n");
		sb.append("     				 ? 				\n"); // placeholder 1
		sb.append("						,? 				\n"); // placeholder 2
	    sb.append("						,?   			\n"); // placeholder 3
	    sb.append("						,?   			\n"); // placeholder 4
	    sb.append("						,? 				\n"); // placeholder 5
	    sb.append("						,? 				\n"); // placeholder 6
	    sb.append("						,?				\n"); // placeholder 7
	    sb.append("						,?				\n"); // placeholder 8
	    sb.append("						,?				\n"); // placeholder 9
	    sb.append("						,?   			\n"); // placeholder 10
	    sb.append("						,? 				\n"); // placeholder 11
	    sb.append("						,? 				\n"); // placeholder 12
	    sb.append("						,'Y'			\n"); // placeholder 13
	    sb.append("						,SYSDATE 		\n"); // placeholder 14
	    sb.append("						,SYSDATE 		\n"); // placeholder 15	
		sb.append("	              )						\n");		
		
		return sb.toString();	
	}
	
	// 회원 수정 
	public static String getMemUpdateQuery(){
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   	 KOS_MEMBER 			    \n");	
		sb.append("	SET  								\n");		
		sb.append("			 MEMAIL 			= ?			\n"); // placeholder 1
		sb.append("			,MHOBBY 		= ? 		\n"); // placeholder 2	
		sb.append("			,MZONE   		= ?			\n"); // placeholder 3	
		sb.append("			,MROAD 			= ?			\n"); // placeholder 4	
		sb.append("			,MJIBUN			= ?			\n"); // placeholder 5			   	        	
	    sb.append("		  	,UPDATEDATE 	= SYSDATE	\n");
		sb.append("	WHERE  	 MNUM 			= ?			\n"); // placeholder 6	    
		sb.append("	AND    	 DELETEYN 		= 'Y'  		\n");		
					
		return sb.toString();
	}
	public static String getMemDeleteQuery(){
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   KOS_MEMBER 			    	\n");	
		sb.append("	SET  								\n");
	    sb.append("		   DELETEYN 	= 'N'			\n");	    	   
	    sb.append("		  ,UPDATEDATE 	= SYSDATE		\n");
		sb.append("	WHERE  MNUM 		= ?				\n"); // placeholder 1    
		sb.append("	AND    DELETEYN 	= 'Y'  			\n");		
					
		return sb.toString();
	}
}
