package Hot_sys;

import java.awt.*;  
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;  

public class All implements ActionListener  {
	JButton jb1 = new JButton("Registration");
    JButton jb2 = new JButton("Information");
    JButton jb3 = new JButton("Prices");
	
	public static void main (String[] args) {
		
		 SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new All().createGui();
	            }
	        });

	}
	
	public void createGui() {
	   JFrame frame = new JFrame("Gradient");
       JLabel label = new JLabel("Welcome to the Hotel 'Gradient'. Please, choose information.", JLabel.CENTER);
       JPanel panel = new JPanel();
       
       BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
       panel.setLayout(boxlayout);
       panel.setBorder(new EmptyBorder(new Insets(50, 200, 70, 200)));

       panel.add(jb1); 
       panel.add(Box.createRigidArea(new Dimension(0, 30)));
       jb1.addActionListener((ActionListener) this);
       
       panel.add(jb2); 
       panel.add(Box.createRigidArea(new Dimension(0, 30)));
       jb2.addActionListener((ActionListener) this);
       
       panel.add(jb3); 
       panel.add(Box.createRigidArea(new Dimension(0, 30)));
       jb3.addActionListener((ActionListener) this);

       frame.setLayout(new GridLayout(2, 1));
       frame.add(label);
       frame.add(panel);

       frame.pack();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
   }

   public void actionPerformed(ActionEvent e) { 
	   if (e.getSource() == jb1) {
		   

	   Registration reg = new Registration();
	   reg.Userdialog();
	   }
	   
	   else if (e.getSource() == jb3)
	   {   
		   Price pr = new Price();
		   try {
			pr.price();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	   }
	   
	   else {
           Information inf = new Information();
		   inf.Infa();
	   }
	   //ShowResults show = new ShowResults();
	   //show.show();
       
   	}
}
