package a.b.c.t6.sql;

//A : Actual Practice
public class T6QueryMap_A {
	// ��ü ��ȸ
	public static String getT6SelectAll(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT                           		              \n");
		sb.append("       A.T1 		AS T1                                 \n");
		sb.append("      ,A.T2		AS T2                                 \n");
		sb.append("      ,A.T3		AS T3                                 \n");
		sb.append("      ,A.T4		AS T4                                 \n");
		sb.append("      ,TO_CHAR(A.T5, 'YYYY-MM-DD') AS T5               \n");
		sb.append("      ,TO_CHAR(A.T6, 'YYYY-MM-DD') AS T6               \n");
		sb.append("FROM TEST_T6 A    		                              \n");
		sb.append("WHERE A.T4='Y'                                         \n");
		sb.append("ORDER BY T1 DESC 								   	  \n"); 
		
		return sb.toString();
	}
	
	// �̸� �˻�
	public static String getT6SelectName(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT    			                                  \n");
		sb.append("       A.T1 		AS T1                                 \n");
		sb.append("      ,A.T2		AS T2                                 \n");
		sb.append("      ,A.T3		AS T3                                 \n");
		sb.append("      ,A.T4		AS T4                                 \n");
		sb.append("      ,TO_CHAR(A.T5, 'YYYY-MM-DD') AS T5               \n");
		sb.append("      ,TO_CHAR(A.T6, 'YYYY-MM-DD') AS T6               \n");
		sb.append("FROM TEST_T6 A    		                              \n");
		sb.append("WHERE A.T4='Y'                                         \n");
		sb.append("AND A.T2 LIKE UPPER('%'||?||'%')                                         \n");
		sb.append("ORDER BY T1 DESC 								   	  \n"); 
		
		return sb.toString();
	}
	
	// ��¥ �˻�
	public static String getT6SelectDate(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT    			                                  \n");
		sb.append("       A.T1 		AS T1                                 \n");
		sb.append("      ,A.T2		AS T2                                 \n");
		sb.append("      ,A.T3		AS T3                                 \n");
		sb.append("      ,A.T4		AS T4                                 \n");
		sb.append("      ,TO_CHAR(A.T5, 'YYYY-MM-DD') AS T5               \n");
		sb.append("      ,TO_CHAR(A.T6, 'YYYY-MM-DD') AS T6               \n");
		sb.append("FROM TEST_T6 A    		                              \n");
		sb.append("WHERE A.T4='Y'                                         \n");
		sb.append("AND TO_CHAR(TO_DATE(A.T5), 'YYYYMMDD')>=TO_CHAR(TO_DATE(?), 'YYYYMMDD')   \n");
		sb.append("AND TO_CHAR(TO_DATE(A.T5), 'YYYYMMDD')<=TO_CHAR(TO_DATE(?), 'YYYYMMDD' \n");
		sb.append("ORDER BY T1 DESC 								   	  \n");	
	}
	
	// �Է�
	public static String getT6Insert(){}

	// ����
	public static String getT6Update(){}
	
	// ����
	public static String getT6Delete(){}
}
