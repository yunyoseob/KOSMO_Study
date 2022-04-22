package a.b.c.test.xml;

import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class Property_Read_1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String resource = "a/b/c/test/xml/db_1.properties";		
		Properties prop = new Properties();
		
		try {
			
			Reader rd = Resources.getResourceAsReader(resource);
			prop.load(rd);

			
			System.out.println(prop.getProperty("driver"));
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("username"));
			System.out.println(prop.getProperty("password"));
			
		}catch(Exception e) {
			
		}				
	}
}
