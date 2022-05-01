package a.b.c.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.com.kosmo.board.dao.BoardDAOImpl;

public abstract class KosConnectivity {
	
	// Connection reference variable :: conn
	// conn = KosConnectivity.getConnection();
	
	// DataSource Information :: Database Connect Information
	public static final String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL="jdbc:oracle:thin:@localhost:1521:orclYYS00";
	public static final String JDBC_USER="scott";
	public static final String JDBC_PASSWORD="tiger";
	
	// Connection 
	public static Connection getConnection(){
		Logger logger = LogManager.getLogger(BoardDAOImpl.class);
		logger.info("getConnection() 함수 진입 >>> : ");
		Connection conn=null;
		
		try{
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			
		}catch(Exception e){
			System.out.println("KosConnectivity :: getConnection() :: Can't Connect DataBase >>> : "+e.getMessage());
		}
		return conn;
	}
	
	// method overloading
	// Checking Close Connection, PreparedStatement, ResultSet reference variable 
	// select
	public static void conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs){
		Logger logger = LogManager.getLogger(BoardDAOImpl.class);
		logger.info("conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs) 함수 진입 >>> : ");
		
		try {
			if (rsRs!=null) try {rsRs.close(); rsRs=null; } catch(Exception ex) {}
			if (pstmt!=null) try {pstmt.close(); pstmt=null; } catch(Exception ex){}
			if (conn!=null) try {conn.close(); conn=null; } catch(Exception ex) {}
		}catch(Exception e2){}
	}
	
	// Checking Close Connection, PreparedStatement reference variable 
	public static void conClose(Connection conn, PreparedStatement pstmt) {
		Logger logger = LogManager.getLogger(BoardDAOImpl.class);
		logger.info("conClose(Connection conn, PreparedStatement pstmt) 함수 진입 >>> : ");
		
		try{
			if(pstmt != null) try {pstmt.close(); pstmt=null;}catch(Exception ex){}
			if(conn!=null)try {conn.close(); conn=null; }catch(Exception ex) {} 
		}catch(Exception e2){}
	};
} // end of public abstract class KosConnectivity
