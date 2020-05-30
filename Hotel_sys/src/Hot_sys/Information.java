package Hot_sys;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Information {
	private Component paint;

	static void Infa() {
		
		 JFrame frame = new JFrame("Information about Hotel");
		    frame.setLayout(new FlowLayout());
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(350, 250);
		    String text = "Gradient Hotel was founded in 2014. Since then, we have significantly improved. "
		        + "In addition to a huge number of comfortable rooms, we can boast: "
		        + "huge swimming pool, spacious bath, wonderful bar with an extensive alcohol list "
		        + "Our delicious restaurant will also not leave you indifferent. "
		        + "In addition, our hotel is located right between the mountain and the ocean. "
		        + "You can choose any of the incredible views."
		        + "In addition, we work with many tour companies, so you can order something from the hotel or "
		        + "tickets to some place of entertainment.";
		    
		    JTextArea textAreal = new JTextArea(text, 20, 50);
		    textAreal.setPreferredSize(new Dimension(10, 10));
		    textAreal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		    
		    textAreal.setLineWrap(true);
		    frame.add(textAreal);
		    frame.pack();
		    frame.setVisible(true);
	}

}
