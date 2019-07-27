import java.io.*;
import java.net.*;
import java.util.Scanner;


public class FileReceiveClient
{
	Socket s = null;
	DataInputStream datainputstream = null;
	DataOutputStream dataoutputstream = null;
	public FileReceiveClient()
	{
		Scanner scanner = new Scanner(System.in);
		try
		{
			s= new Socket("192.168.100.149", 4000);
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			datainputstream = new DataInputStream(s.getInputStream());
			dataoutputstream = new DataOutputStream(s.getOutputStream());
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}