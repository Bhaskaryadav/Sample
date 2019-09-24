package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class SampleData {

	public static void main(String[] args) {
		System.out.println("Inside Method");
		
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null; 
		
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			 connection=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","bhaskar");  
			  
			String sqlSelectQuery = "select * from customer";
			String str = "select * from employee";
			System.out.println(str);
			String str1 = "select * from employee";
			System.out.println(str1);
			//step3 create the statement object  
			preparedStatement = connection.prepareStatement(sqlSelectQuery );  
			  
			//step4 execute query  
			rs = preparedStatement.executeQuery();
			int count=0;
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getString(4));
				count=rs.getRow();
			System.out.println("Number of rows retrieved from Table: "+count);			  
			  
			//step5 close the connection object  
			connection.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
			  
	}

}
