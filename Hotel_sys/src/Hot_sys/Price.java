package Hot_sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Price {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?user=root?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
	   //  Database credentials
	static final String USER = "root";
	static final String PASS = "Q3dvJWqR";
	static Connection conn = null;
	static java.sql.Statement stmt = null;
	
	public static void price () throws SQLException, ClassNotFoundException
	{
		   JFrame frame3 = new JFrame("Prices");
	       frame3.setSize(600, 600);
	       frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		   JPanel panel = new JPanel();
		   frame3.add(panel);
		   frame3.setVisible(true);
		
		  Class.forName("com.mysql.cj.jdbc.Driver");


	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      
	      
	      System.out.println("Price"+"   Class");
	      
	      String sql = "select Prise, Class from hotel_sys.prise";
	      ResultSet rs1 = stmt.executeQuery(sql);

	      while(rs1.next()){
	         int price1 = rs1.getInt("Prise");
	         String class_r = rs1.getString("Class");
	         System.out.print(price1);
	         System.out.println("    "+class_r);
	      }
	      
	}

}
