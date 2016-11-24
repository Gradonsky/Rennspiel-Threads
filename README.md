# ::: RENNSPIEL - THREADS ::: "THE RACE CONDITIONS� :::

## Beschreibung
Meine L�sung der Aufgabe zeichnet ein �Spielfeld� wo sich die Checkpoints (Meter) und 2 Buttons Start bzw. Score befinden.

Nach dem bet�tigen des Buttons �Start� werden zwei Rechtecke die Autos darstellen sollen geziechnet und fahren gleich los.

(Das �Start� Button wird f�r 10 Sekunden geblockt damit es nicht Missbraucht wird.)

Es wird ein Timer gestartet das die Zeit wie lange das jeweilige Auto braucht um bis zum Ziel zu gelangen.

Beide Autos bekommen eine zuf�llige (zwischen 50 und 100) km/h Geschwindigkeit. Nach jeden 100 Metern liegt vielleicht zuf�llig ein Stein (ist unsichtbar :D ).

Wenn ein von den Beiden Autos auf ein Stein trifft wird dann zuf�llig bestimmt ob das Auto um 1km/h schneller oder langsamer wird.

Wenn ein Auto die 1000 Meter schafft wird der Timer gestoppt und die Zeit die er ben�tigt hat in ein File �highscore.txt� gespeichert.

Es wird die Zeit von beiden Autos berechnet. Also m�ssen beide Autos an die Ziellinie gelangen.

## Technisch

Das Spielfeld ist 1000 px Lang damit es eine Strecke von 1 km (1000 Meter) darstellt. 1 px = 1 Meter.

Bei generieren von zuf�lligen Zahlen von der Geschwindigkeit steht das Int f�r die Zehner Schritte (10 /20 / 30 km/h ) und Double f�r die Einzer Schritte (1 / 2 / 3 km/h)

Also bedeutet: 5.5 = 55 km/h |	7.6 = 76 km/h

Das Sleep ist auf �7�ms gestellt da nach meinen Rechnungen wenn 7 bei Sleep steht wird eine fast exakte Darstellung der Realit�t dargestellt.

Wenn in Realit�t
50 km/h = 13 m/s = 76 sec / km

Wird es im Spiel:

50 km/h = ~7360 millisekunden / 1000px

Realit�t:

55 km/h = 15 m/s = 66 sec / km

Spiel:
55 km/h = ~6700 millisekunden /1000px

## Klassen
*	Autorennen.java
*	Graphics.java
*	Highscore.java
*	Wagen.java

