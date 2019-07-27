all:
	javac Main.java Client.java
	java Main
clean:
	rm *.class
