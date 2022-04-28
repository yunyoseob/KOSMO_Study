package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Connection conn = DBCP_Connectivity.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMP");
			ResultSet rsRs = stmt.executeQuery();
			
			while (rsRs.next()){
				System.out.println(rsRs.getString(1) + " ");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
