package Gradonski;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

/**
 * Die Klasse Autorennen 
 * zeichnet das jeweilige Wagen und sorgt dafür , dass das Wagen sich bewegt.
 * 
 * @author Gradonski Janusz
 *
 */

public class Autorennen {
	private Graphics gr;
	private int dx;
	private int dy;
	private double x = 0;
	private int y;
	private final int WIDTH;
	private final int HEIGHT;
	private JFrame frame;
	boolean running = true;
	BufferStrategy bufferStrategy;
	boolean stein = false;
	boolean stsch = false;
	/**
	 * Konstruktor
	 * beim Parameter wird Bufferstrategy von Graphics mitgeliefert
	 * damit die Objekte gezeichnet werden können
	 */
	public Autorennen(BufferStrategy bf){
		gr = new Graphics();
		this.WIDTH = gr.getWIDTH();
		this.HEIGHT = gr.getHEIGHT();
		this.bufferStrategy = bf;
		
	
	}
	/**
	 * Die Metode Render sorgt dafür ,dass das
	 * Wagen von der Oberfläche gelöscht wird damit ein neues 
	 * Wagen an einer neuen Position gezeichnet werden kann.
	 * Wichtig ist es ,dass die Methode nur zwischen 2 Threads unterscheided
	 * und nur 2 Threads mit dem id 1 und 2!!
	 * 
	 */
	   public void render(int id,int kmh) {
		   switch(id){
		   
		   case 1:
		      Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		      g.clearRect(0, 0, WIDTH, HEIGHT);
		      render(g,1,kmh);
		      g.dispose();
		      bufferStrategy.show();
		      break;
		   case 2:
			   Graphics2D e = (Graphics2D) bufferStrategy.getDrawGraphics();
			      e.clearRect(0, 0, WIDTH, HEIGHT);
			      render(e,2,kmh);
			      e.dispose();
			      bufferStrategy.show();
			      break;
		   }
		 
	   }
	   /**
	    * Die Methode macht ein zufälliges Boolean dass dann
	    * entscheided ob sich ein Stein bei dem Checkpoint befindet oder nicht
	    * 
	    */
	   public static boolean getRandomBoolean() {
	       return Math.random() < 0.5;
	   }

	   /**
	    * Update.
	    * Das Update bewegt mittels der delta Zeit 
	    * das Objekt.
	    * Wenn das Objekt (Thread , Wagen) sich auf über 1000 
	    * px befindet wird das Rennen für das Wagen beeendet.
	    * Das switch-case sorgt dafür , dass jede 100 meter
	    * entschieden wird ob sich ein Stein auf dem boden befindet
	    * oder nicht.
	    */
	   protected boolean update(double deltaTime){
	      x += deltaTime * 0.2;
	      while(x > 1000){
	    	  System.out.println("=========================================================");
	    	  System.out.println("Rennen Beendet");
	    	  return false;
	      }
	      switch((int)x){
	      case 100:  
	    	  stein = getRandomBoolean();
	    	  stsch = stein;
	    	  break;
	      case 200: 
	    	  stein = getRandomBoolean();
	    	  stsch = stein;
	    	  break;
	      case 300:
	    	  stein = getRandomBoolean();
	    	  stsch = stein;
	    	  break;
	      case 400: 
	    	  stein = getRandomBoolean();
	    	  stsch = stein;
	    	  break;
	      case 500: 
	    	  stein = getRandomBoolean();
	    	  stsch = stein;
	    	  break;
	      case 600:
	    	  stein = getRandomBoolean();
	    	  stsch = stein;
	    	  break;
	      case 700: 
	    	  stein = getRandomBoolean();
	    	  stsch = stein;
	    	  break;
	      case 800: 
	    	  stein = getRandomBoolean();
	    	  stsch = stein;
	    	  break;
	      case 900: 
	    	  stein = getRandomBoolean();
	    	  stsch = stein;
	    	  break;
	      }
	      return true;
	   }


	   /**
	    * Render übernimmt im Paramter das Objekt das gezeichnet werden soll und
	    * gleichzeitig die id damit unterschieden wird ob sich um
	    * das Wagen 1 oder Wagen 2 handelt.
	    * Das jeweilige wagen wird mit einem gefüllten rechteck gezeichnet.
	    */
	   protected void render(Graphics2D g,int id,int kmh){
		   switch(id){
		   case 1:
			   if(stsch == true){
				   int steinschr = (int)x % 30;
				   g.drawString("Stein", (int)x,20);
				   
			   }
		  g.drawString(kmh +" km/h", (int)x, 40);   
	      g.fillRect((int)x, 40, 20, 20);
	      break;
		   case 2:
			   if(stsch == true){
				   g.drawString("Stein", (int)x,190);
				   
			   }
	      g.drawString(kmh + " km/h", (int)x, 100);    
		  g.fillRect((int)x, 100, 20, 20);
		   }
	   }
}
