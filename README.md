# ::: RENNSPIEL - THREADS ::: "THE RACE CONDITIONS” :::

## Beschreibung
Meine Lösung der Aufgabe zeichnet ein “Spielfeld” wo sich die Checkpoints (Meter) und 2 Buttons Start bzw. Score befinden.

Nach dem betätigen des Buttons „Start“ werden zwei Rechtecke die Autos darstellen sollen geziechnet und fahren gleich los.

(Das „Start“ Button wird für 10 Sekunden geblockt damit es nicht Missbraucht wird.)

Es wird ein Timer gestartet das die Zeit wie lange das jeweilige Auto braucht um bis zum Ziel zu gelangen.

Beide Autos bekommen eine zufällige (zwischen 50 und 100) km/h Geschwindigkeit. Nach jeden 100 Metern liegt vielleicht zufällig ein Stein (ist unsichtbar :D ).

Wenn ein von den Beiden Autos auf ein Stein trifft wird dann zufällig bestimmt ob das Auto um 1km/h schneller oder langsamer wird.

Wenn ein Auto die 1000 Meter schafft wird der Timer gestoppt und die Zeit die er benötigt hat in ein File „highscore.txt“ gespeichert.

Es wird die Zeit von beiden Autos berechnet. Also müssen beide Autos an die Ziellinie gelangen.

## Technisch

Das Spielfeld ist 1000 px Lang damit es eine Strecke von 1 km (1000 Meter) darstellt. 1 px = 1 Meter.

Bei generieren von zufälligen Zahlen von der Geschwindigkeit steht das Int für die Zehner Schritte (10 /20 / 30 km/h ) und Double für die Einzer Schritte (1 / 2 / 3 km/h)

Also bedeutet: 5.5 = 55 km/h |	7.6 = 76 km/h

Das Sleep ist auf „7“ms gestellt da nach meinen Rechnungen wenn 7 bei Sleep steht wird eine fast exakte Darstellung der Realität dargestellt.

Wenn in Realität
50 km/h = 13 m/s = 76 sec / km

Wird es im Spiel:

50 km/h = ~7360 millisekunden / 1000px

Realität:

55 km/h = 15 m/s = 66 sec / km

Spiel:
55 km/h = ~6700 millisekunden /1000px

## Klassen
*	Autorennen.java
*	Graphics.java
*	Highscore.java
*	Wagen.java

###### Coded with :heart:
