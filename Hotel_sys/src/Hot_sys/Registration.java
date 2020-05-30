package Hot_sys;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registration {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?user=root?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
	   //  Database credentials
	static final String USER = "root";
	static final String PASS = "Q3dvJWqR";
	static Connection conn = null;
	static java.sql.Statement stmt = null;

	  //JTextField name;
	  JLabel fullnamelabel = new JLabel("Full name");
	  JLabel seatsLabel = new JLabel("Seats");
	  JLabel classLabel = new JLabel("Class");
	  JLabel periodLabel = new JLabel("Period");
	  
	  JTextField fullnameText = new JTextField(20);
	  JTextField seatsText = new JTextField(20);
	  JTextField classText = new JTextField(20);
	  JTextField periodText = new JTextField(20);
	  
	  
	  JButton    proceed;

	  public void Userdialog()
	  {
	    JFrame useradd = new JFrame("Add user to database");
	    useradd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    useradd.setLayout(new GridLayout(0, 1));
	    JPanel pane = new JPanel(new GridLayout(0, 1));
	    useradd.add(pane);

		fullnamelabel.setBounds(10, 10, 80, 25);
		pane.add(fullnamelabel);


		fullnameText.setBounds(100, 10, 160, 25);
		pane.add(fullnameText);


		seatsLabel.setBounds(10, 40, 80, 25);
		pane.add(seatsLabel);


		seatsText.setBounds(100, 40, 160, 25);
		pane.add(seatsText);
		

		classLabel.setBounds(10, 70, 80, 25);
		pane.add(classLabel);


		classText.setBounds(100, 70, 160, 25);
		pane.add(classText);
		

		periodLabel.setBounds(10, 100, 80, 25);
		pane.add(periodLabel);


		periodText.setBounds(100, 100, 160, 25);
		pane.add(periodText);
	    proceed = new JButton("Register");
	    pane.add(proceed);
	    proceed.addActionListener(new ActionListener()
	    {
	      @Override
	      public void actionPerformed(ActionEvent e)
	      {
	        //HOW TO MAKE IT TO THE SQL TABLE???
	        try
	        {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          conn= DriverManager.getConnection(DB_URL, USER, PASS);
	          stmt = (Statement) conn.createStatement();
	          String query = " insert into hotel_sys.client values (?, ?, ?, ?)";

	        	      // create the mysql insert preparedstatement
	          PreparedStatement preparedStmt = conn.prepareStatement(query);
	          preparedStmt.setString (1, fullnameText.getText());
	          preparedStmt.setString (2, seatsText.getText());
	          preparedStmt.setString (3, classText.getText());
	    	  preparedStmt.setString (4, periodText.getText());

	        	      // execute the preparedstatement
	        	      preparedStmt.execute();
	        	      
	        	      conn.close();
	        }
	        catch(Exception ex)
	        {
	          ex.printStackTrace();
	        }
	      }});
	    useradd.pack();
	    useradd.setSize(300,200);
	    useradd.setVisible(true);
	  }
}