import java.io.*;
import java.net.*;
import java.util.Scanner;
public class CheckForServer
{
	 public static String serverip = "192.168.100.149"; 	
	public CheckForServer()
	{
		System.out.println("Enter server IP Address");
		Scanner scaner = new Scanner(System.in);
		this.serverip = scaner.nextLine();
		//TODO : check for all the ip address and find out the server IP address
	}

}