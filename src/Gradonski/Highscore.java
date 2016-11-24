package Gradonski;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * Die Klasse Highscore
 * liest nur von dem File "highscore.txt" die Scores aus
 * und zeigt sie dann an.
 * @author Gradonski Janusz
 *
 */
public class Highscore extends JFrame implements ActionListener{
	private JFrame frame;
	private BufferedReader br;
	private String line;
	private JLabel label;
	private JLabel label2;
	private String everything;
	private JButton clean;
	private PrintWriter writer;
	private JOptionPane window;
	private ArrayList items;
	private String commaSeparated;
	/**
	 * Konstruktor von der Klasse
	 * der Zust‰ndig ist um das Fenster zu zeichnen und
	 * die Daten aus dem file Rauszulesen
	 */
	public Highscore()
	{	
		window = new JOptionPane("Bereinigt");
		frame = new JFrame("Highscore");
		label = new JLabel("Zeiten in Millisekunden:");
		label2 = new JLabel("");
		clean = new JButton("File Bereinigen");
		 frame.setPreferredSize(new Dimension(700, 200));
	     frame.setLayout(new BorderLayout());
	     frame.add(label,BorderLayout.NORTH);
	     frame.add(label2,BorderLayout.CENTER);
		 frame.add(clean,BorderLayout.SOUTH);
		 
		 
		
		 
		 
		 clean.addActionListener(this);
		try {
			br = new BufferedReader(new FileReader("./src/highscore.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    try {
		        StringBuilder sb = new StringBuilder();
		      
				try {
					line = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        while (line != null) {
		            sb.append(line);
		            sb.append(System.getProperty("line.separator"));
		            try {
						line = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        everything = sb.toString();
		    } finally {
		        try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    
		    String[] columnNames = {"Auto",
	                 "Bestzeit",
			 };
		    
		    commaSeparated = everything;
			ArrayList<String> items = new  ArrayList<String>(Arrays.asList(commaSeparated.split(",")));

			 Object[][] data = {
					 	{items.get(1), "A"},
					 	{items.get(2), "Doe"},
					 	{items.get(3), "Black"},
					 	{items.get(4), "White"},
					 	{items.get(5), "Brown"}
			 };
		 
			  
		   label2.setText(everything);
		   final JTable table = new JTable(data, columnNames);
	        table.setPreferredScrollableViewportSize(new Dimension(400, 150));
	        table.setEnabled(false);
	       frame.add(table);
	       
		 
		      frame.pack();
		      frame.setResizable(false);
		      frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			writer = new PrintWriter("./src/highscore.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.close();
		window.showMessageDialog(null, "Das File wurde bereinigt.\nDas Score Fenster schlieﬂt sich Automatisch.");
		 frame.setVisible(false);
         frame.dispose();
	}
		
	}
