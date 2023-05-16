# KushsMP3Player
This repository is a compilation of my data structures and algorithms projects. The numbers of the projects display are their order completed within the classes and my progression in complexity of code, organization, and javadoc commenting can be noticed.
--------------------------------------------------------------------------------------------------------------------------------------
The MP3Player.java file contains all code related to the GUI and playing of Mp3 files, as well as a main class that tests my data structure that mimics an ArrayList.
I am using the javazoom mp3 decoder which is imported at the top of MP3Player.java in the following way: import javazoom.jl.player.advanced.*; // This is the MP3 decoder and player import java.io.FileInputStream; // This allows us to read files from disk
--------------------------------------------------------------------------------------------------------------------------------------
Setting up the MP3 jar file 

To run the player you must import the javazoom jar: jl1.0.1.jar
For Eclipse, here are the instructions for adding the javazoom mp3 player to your classpath: Drag and drop the jar file into the /src folder of your project.
Right-click the project and select Properties under the Java Build Path menu, select the Libraries button.
On the right-hand side, press the “Add External JARs” button and add the javazoom jar from your project source folder.
--------------------------------------------------------------------------------------------------------------------------------------
