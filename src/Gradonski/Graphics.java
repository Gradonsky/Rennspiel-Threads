package Gradonski;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferStrategy;






import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Die Klasse Graphics ist dafür da um das Spielfeld zu Zeichnen.
 * Die Größe von dem Spielfeld wurde auf 1000 px WIDTH und 250 PX HEIGHT eingestellt
 * um eine Strecke von 1 Km in einer kleineren form darzustellen.
 * Die jeweiligen Components wie JButton die für Score und das Starten von dem Spiel werden hier 
 * bestimmt.
 * @author Gradonski Janusz
 *
 */
public class Graphics extends JFrame implements ActionListener {
	private int dx;
	private int dy;
	private double x = 0;
	private int y;
	private final int WIDTH = 1000;
	private final int HEIGHT = 250;
	private JFrame frame;
	Canvas canvas;
	boolean running = true;
	public static BufferStrategy bufferStrategy;
	public static BufferStrategy buff;
	private JButton jb;
	private JButton hs;
	   private Timer stopwatch;
	    private final int SEC = 10;
	private JLabel line;
	private JLabel cpline2;
	private JLabel cpline3;
	private JLabel cpline4;
	private JLabel cpline5;
	private JLabel cpline6;
	private JLabel cpline7;
	private JLabel cpline8;
	private JLabel cpline9;
	private JLabel cpline;
	private JLabel meter1;
	private JLabel meter2;
	private JLabel meter3;
	private JLabel meter4;
	private JLabel meter5;
	private JLabel meter6;
	private JLabel meter7;
	private JLabel meter8;
	private JLabel meter9;
	/**
	 * Der Konstruktor von der Klasse bleibt leer 
	 * damit wenn die Klasse Autorennen die Klasse aufruft
	 * um die größe von dem Fenseter zu wissen damit 
	 *das jeweilige Objekt gelöscht werden kann kein neues Fenter mit 
	 * neuem "Spielfeld" gezeichent wird.
	 */
	public Graphics(){
		
	}
	
/**
 * Die Metohde Fenster
 * sie Zeichnet canvas und die Ganzen Components und 
 * fügt sie in das JPanel ein.
 * Hier wird auch der Timer für den JButton bestimmt
 * (10 Sekunden) wird der JButton start geblockt damit es
 * nicht misbraucht wird.
 */
	public void Fenster() {
		frame = new JFrame("Threads Race");
		JPanel panel = (JPanel) frame.getContentPane();
		hs = new JButton ("Score");
		  line = new JLabel("____________________________________________________________________________");
		  line.setText(line.getText()+ "_________________________________________________________________");
		  
		  meter1 = new JLabel("100");
		  meter2 = new JLabel("200");
		  meter3 = new JLabel("300");
		  meter4 = new JLabel("400");
		  meter5 = new JLabel("500");
		  meter6 = new JLabel("600");
		  meter7 = new JLabel("700");
		  meter8 = new JLabel("800");
		  meter9 = new JLabel("900");
		  
		  cpline = new JLabel("|");
		  cpline2 = new JLabel("|");
		  cpline3 = new JLabel("|");
		  cpline4 = new JLabel("|");
		  cpline5 = new JLabel("|");
		  cpline6 = new JLabel("|");
		  cpline7 = new JLabel("|");
		  cpline8 = new JLabel("|");
		  cpline9 = new JLabel("|");
		  
	      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	      panel.setLayout(new BorderLayout());
	      canvas = new Canvas();
	      canvas.setBounds(0, 0, 100, 200);
	      canvas.setIgnoreRepaint(true);
	      jb = new JButton("Start");
	      jb.addActionListener(this);
	      hs.addActionListener(this);
	      
	      line.setBounds(0,95,1000,15);
	      
	      cpline.setBounds(100,160,10,10);
	      cpline2.setBounds(200,160,10,10);
	      cpline3.setBounds(300,160,10,10);
	      cpline4.setBounds(400,160,10,10);
	      cpline5.setBounds(500,160,10,10);
	      cpline6.setBounds(600,160,10,10);
	      cpline7.setBounds(700,160,10,10);
	      cpline8.setBounds(800,160,10,10);
	      cpline9.setBounds(900,160,10,10);
	      
	      
	      meter1.setBounds(90,180,50,10);
	      meter2.setBounds(190,180,50,10);
	      meter3.setBounds(290,180,50,10);
	      meter4.setBounds(390,180,50,10);
	      meter5.setBounds(490,180,50,10);
	      meter6.setBounds(590,180,50,10);
	      meter7.setBounds(690,180,50,10);
	      meter8.setBounds(790,180,50,10);
	      meter9.setBounds(890,180,50,10);
	      
		  
	      panel.add(meter1);
	      panel.add(meter2);
	      panel.add(meter3);
	      panel.add(meter4);
	      panel.add(meter5);
	      panel.add(meter6);
	      panel.add(meter7);
	      panel.add(meter8);
	      panel.add(meter9);
	      
	      
	      
	      panel.add(cpline);
	      panel.add(cpline2);
	      panel.add(cpline3);
	      panel.add(cpline4);
	      panel.add(cpline5);
	      panel.add(cpline6);
	      panel.add(cpline7);
	      panel.add(cpline8);
	      panel.add(cpline9);
	      
	      panel.add(line);
	      panel.add(canvas);
	      panel.add(jb,BorderLayout.SOUTH);
	      panel.add(hs,BorderLayout.NORTH);
	      canvas.addMouseListener(new MouseControl());
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.pack();
	      frame.setResizable(false);
	      frame.setVisible(true);
	      canvas.createBufferStrategy(2);
	      bufferStrategy = canvas.getBufferStrategy();
	      stopwatch = new Timer(SEC * 1000, new MyTimerListener(jb));
	      stopwatch.setRepeats(false);
	      canvas.requestFocus();
	      
	     
	      
	}
	
	/**
	 * Eine Private Klasse von Mousecontrol die für Canvas verwendet wird aber 
	 * leer ist da sie nicht gebraucht wird.
	 * @author Gradonski Janusz
	 *
	 */
	  private class MouseControl extends MouseAdapter{
	      
	   }
	  /**
	   * Die Klase MytimerListner sorft dafür , dass
	   * nach den 10 sekunden vorbei sind das JButton wieder
	   * eingeschlatet wird.
	   * @author Gradonski Janusz
	   *
	   */
	  static class MyTimerListener implements ActionListener {
	        JComponent target;

	        public MyTimerListener(JComponent target) {
	            this.target = target;
	        }

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            target.setEnabled(true);
	        }

	    }
	   /**
	 * @return the bufferStrategy
	 */
	public BufferStrategy getBufferStrategy() {
		return bufferStrategy;
	}

	/**
	 * @param bufferStrategy the bufferStrategy to set
	 */
	public void setBufferStrategy(BufferStrategy bufferStrategy) {
		this.bufferStrategy = bufferStrategy;
	}

	public static void main(String [] args){
		 Graphics g = new Graphics();
		 g.Fenster();
		 


		   }

	/**
	 * @return the wIDTH
	 */
	public int getWIDTH() {
		return WIDTH;
	}

	/**
	 * @return the hEIGHT
	 */
	public int getHEIGHT() {
		return HEIGHT;
	}

	@Override
	/**
	 * Die Methode schaut nach ob es sich um Start-button handelt oder
	 * um Score button , und behandelt das dann.
	 * Start:
	 * Erzeugt 2 Threads die dann gestartet werden.
	 * Score:
	 * Erzeugt ein Objekt von der Klasse Highscore.java
	 * @param arg0
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == jb) {
		 Wagen T1 = new Wagen(1,0,0,bufferStrategy);
		 Wagen T2 = new Wagen(2,0,0,bufferStrategy);
		
		 T1.start();
		 T2.start();
		 jb.setEnabled(false);
		 System.out.println("Start Button blockiert fur 10 Sekunden.");
		 stopwatch.start();
		} else if  (arg0.getSource() == hs) {
			Highscore h = new Highscore();
		}
	}

}
