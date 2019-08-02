all:
	javac Main.java Client.java CheckForServer.java FileSendClient.java FileReceiveClient.java
	java Main
clean:
	rm *.class
