# ::: RENNSPIEL - THREADS ::: "THE RACE CONDITIONS” :::

## Description
My solution draws a "pitch" where are checkpoints (in meters) located.

After pressing the "Start"-button, two rectangles which represent cars are displayed and go off immediately.

(From now the "Start"-button is disabled for 10 seconds, so it will not be misused.)

A timer is started, which counts how long the respective car needs to reach the destination.

Both cars receive a random (between 50 and 100) speed [km/h].
Every 100 Meters a car can pickup a stone (random).

If one of the two cars pickup a stone, then it is randomly determined whether the car is 1 km/h faster or slower.

When one of the cars reach 1000 Meters then the timer will be stopped and the time that he needed saved in a file called "highscore.txt".


## Technical

The Pitch is 1000 px long , so that it represents a distance of 1km (1000 meters) but in pixels. 1 pixel = 1 meter.
Bei generieren von zufälligen Zahlen von der Geschwindigkeit steht das Int für die Zehner Schritte (10 /20 / 30 km/h ) und Double für die Einzer Schritte (1 / 2 / 3 km/h)

So it means:
* 5.5 = 55 km/h
* 7.6 = 76 km/h
* 8.2 = 82 km/h

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
