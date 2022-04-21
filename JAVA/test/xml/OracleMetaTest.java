package a.b.c.test.xml;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleMetaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;

		try{
			con = DBPropertyConn.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DEPT");

			ResultSetMetaData rsm = rs.getMetaData();
System.out.print("\n ResultSetMetaData rsm >>> : " + rsm + "\n");
System.out.println("===============================");

			int colCount = rsm.getColumnCount();
System.out.println("\n rsm.getColumnCount() >>> : " + colCount + "\n");

System.out.println("===============================");
			
			for (int i=1; i <= colCount ; i++){
				System.out.print(rsm.getColumnName(i) + "\t\t");
			}
			
			System.out.println("\n===============================");

			while (rs.next()){
				for (int i=1; i <= colCount ; i++){
					System.out.print(rs.getString(i) + "\t\t");				
				}
				System.out.println("");
			}	
		}catch (SQLException e){			
		}
	}
}
