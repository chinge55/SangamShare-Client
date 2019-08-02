all:
	javac Main.java Client.java CheckForServer.java
	java Main
clean:
	rm *.class
