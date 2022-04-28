package a.b.c.com.common;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBCP_Connectivity {

	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {	
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jndi_orclHBE00");
			conn = ds.getConnection();
			
			
		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e);
		}
				
		return conn;		
	}
}
