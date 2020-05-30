package Hot_sys;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Data {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?user=root?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
	   //  Database credentials
	static final String USER = "root";
	static final String PASS = "Q3dvJWqR";
	static Connection conn = null;
	static java.sql.Statement stmt = null;

	public static void Connection() {
		   try{

		      Class.forName("com.mysql.cj.jdbc.Driver");


		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      
		      
		      System.out.println("idRoom"+" NumRoom"+ " Seats"+" Class"+" Busy"+" Time"+" Price");
		      
		      String sql = "select * from hotel_sys.full";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){

		         int id_room  = rs.getInt("idRoom");
		         int num_room  = rs.getInt("NumRoom");
		         int seats = rs.getInt("Seats");
		         String class_r = rs.getString("Class");
		         boolean busy = rs.getBoolean("Busy");
		         int time_r = rs.getInt("time_pr");
		         int price = rs.getInt("Prise");


		         System.out.print(id_room);
		         System.out.print("        "+num_room);
		         System.out.print("    "+seats);
		         System.out.print("    "+class_r);
		         System.out.print("    "+busy);
		         System.out.print("     "+time_r);
		         System.out.println("     "+price);
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
		   System.out.println("Goodbye!");
	}
}
