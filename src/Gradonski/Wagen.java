package Gradonski;

import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.omg.Messaging.SyncScopeHelper;

/**
 * Die Klasse "Wagen"
 * In dieser Klasse bekommt das Wagen eine ID
 * geschwindigkeit (die Zufällig zwischen 50 und 100 km/h liegt)
 * Das Wagen kann Steine sammeln die dann + bzw. - 1 km/h geschwindikgeit erhöhen oder erniedrigen.
 * Nach dem Rennen werden die Zeiten in ein file "highscore.txt" gespeichert.
 * @author Gradonski Janusz
 *
 */
public class Wagen extends Thread implements Runnable{

private double geschw;
private boolean running;
private int steine;
private int meter;
private Autorennen ar;
private int id;
Random generator;
private  long startTime;
private  long endTime;
private long elapsedTime;
private double geschwInKm;
private File highscore;
/*
 * Konstruktor
 * Er übernimmt die Parameter:
 * id = die Thread id (Am besten nur 1 und 2 verwenden!)
 * meter =(es kann einsgestellt werden ab wie viel meter das Wagen starten soll
 * steine = Die Anzahl der Steine kann schon am Anfang angegeben werden
 * Bufferstrategy = Bufferstrategy an Autorennen weitergeben damit die "Autos" gezeichnet werden.
 */
public Wagen(int id,int meter,int steine,BufferStrategy bf){
	generator  = new Random();
	running  = true;
	/*
	 * Es wird ein int generiert und ein double generiert
	 * int ist zuständlich für die Zehner schritte von der Geschwindigkeit (10,20,30 km/h)
	 * double ist zuständig für die einzer schritte von der Geschwindigkeit (1,2,3 km/h)
	 */
	geschw = 5+generator.nextInt(5)+generator.nextDouble();

	this.id= id;
	this.meter = meter;
	this.steine = steine;
	geschwInKm = geschw*10;
	ar = new Autorennen(bf);
	System.out.println("Wagen(Thread): "+ id +" hat die Geschwindigkeit von "+ (int)geschwInKm + "km/h.");
	startTime = System.currentTimeMillis();
	highscore = new File("./src/highscore.txt");
}


/*
 * Run-Methode von Thread.
 * Synchronized wir benutzt damit die Threads "hinteranander" abwechselnd laufen
 * und kein Wagen unfair ist.
 * Die Zeit die ein Wagen bis zum Ziel gebraucht hat wird mit System.currentTime ausgerechent.
 * (non-Javadoc)
 * @see java.lang.Thread#run()
 */
public void run() {

	while (running) {
		synchronized(ar) {
			if (ar.update(geschw)==false){
				running = false;
				this.interrupt();
				endTime = System.currentTimeMillis();
				elapsedTime = endTime - startTime;
				System.out.println("Wagen mit der ID: "+ id + " hat "+ elapsedTime + " millisekunden gebraucht und " + steine + " Steine gefunden." );
				 System.out.println("=========================================================");
				    // Das Score wird in das highscore.txt file gespeichert , wenn es nicht existiert wird es neu Angelegt.
				    try{
				    if(highscore.exists()==false){
				            System.out.println("Highscore wurde neu angelegt.");
				            highscore.createNewFile();
				    }

				    PrintWriter out = new PrintWriter(new FileWriter(highscore, true));
					out.append(elapsedTime  +","+id+ System.getProperty("line.separator"));
				    out.close();
				    }catch(IOException e){
				        System.out.println("COULD NOT LOG!!");
				    }
			}
			// Es schaut nach ob ein Stein gefunden wurde
			if(ar.stein == true)
			{
				 System.out.println("=========================================================");
				System.out.println("Wagen " + id + " hat ein STEIN gefunden.");
				steine++;
				// int pom = generator.nextInt... ist zuständig um zufällig + oder minus 1 km/h dazugeben bzw. wegnehmen
				int pom = generator.nextInt(2); // Plus oder Minus
				if(pom == 1){
					geschw = geschw+0.1;
					geschwInKm = geschw*10;
					System.out.println("Das Wagen " + id + " ist um 1 Km/h schneller. \n Geschwindigkeit: " + (int)geschwInKm +" km/h.");
					 System.out.println("=========================================================");
				} else {
					geschw = geschw-0.1;
					geschwInKm = geschw*10;
					System.out.println("Das Wagen " + id + " ist um 1  km/h langsamer. \n Die Geschwindigkeit betragt jetzt " + (int)geschwInKm +" km/h.");
					 System.out.println("=========================================================");
				}

				ar.stein = false;
			}

			ar.render(id,(int)geschwInKm);

		}

		try {
			// Warum sleep auf 7 gestellt wurd lesen sie bitte in der mitgelieferten Mitschrift
				this.sleep((long) 7);

		} catch (InterruptedException e) {
		}
	}
}

}
