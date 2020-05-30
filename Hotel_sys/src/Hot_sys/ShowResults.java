package Hot_sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowResults {

	Registration rigi = new Registration();
	String query = rigi.fullnameText.getText();
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?user=root?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
	   //  Database credentials
	static final String USER = "root";
	static final String PASS = "Q3dvJWqR";
	static Connection conn = null;
	static java.sql.Statement stmt = null;
	
	public void show() {
		 try{

		      Class.forName("com.mysql.cj.jdbc.Driver");


		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      
		      
		      System.out.println("Totaly Price");
		      
		      String sql = "select TotalyPrice from hotel_sys.results ";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){

		         int totaly_price  = rs.getInt("TotalyPrice");
		         


		         System.out.print(totaly_price);
		         System.out.print(" ");
		        
		      }
		      rs.close();
		   }catch(SQLException se){

		      se.printStackTrace();
		   }catch(Exception e){

		      e.printStackTrace();
		   }finally{

		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}

}
