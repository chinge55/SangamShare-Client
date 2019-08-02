import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client
{
	//private int ServerPort = 1234;
	//private InetAddress ip = InetAddress.getByName("localhost");
	Socket s = null;
	DataInputStream datainputstream = null;
	DataOutputStream dataoutputstream = null;

	public Client()
	{
		Scanner scanner = new Scanner(System.in);
		try
		{      
			s= new Socket(CheckForServer.serverip, 4000);
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
		Thread sendmessage = new Thread(new Runnable()
                        {
                                //Override
                                public void run()
                                {
                                        int i =1;
                                        while(true)
                                        {
                                                // read the message to del$
                                                String str_msg = scanner.nextLine();

                                                try
                                                {
                                                        dataoutputstream.writeUTF(str_msg);
                                                }catch(IOException e)
                                                {

                                                        //e.printStackTrace();
                                                	System.out.println("Error in Sending message");
                                                	Thread.currentThread().interrupt();
                                                	return;
                                                }
                                                
                                        }
                                }       

                        });

	

 		Thread readMessage = new Thread(new Runnable()
                        {
                                //Override
                                public void run()
                                {
                                        while(true)
                                        {
                                                // read the message to be $
                                                String str_msg_taken = "";
                                                try{
                                                        str_msg_taken = datainputstream.readUTF();
                                                        System.out.println("Server:"+str_msg_taken);
                                                }catch(IOException e)
                                                {
                                                
                                                        
                                                        //e.printStackTrace();
                                                	System.out.println("Error in Receiving message");
                                                	Thread.currentThread().interrupt();
                                                	return;
                                                }
                                        }
                                }
                        });
        sendmessage.start();
        readMessage.start();
	}
	// public static void main(String[] args)
	// {

	// 	Scanner scanner = new Scanner(System.in);
	// 	System.out.println("1. CHAT\n 2. RECEIVE FILE 3. SEND FILE");
	// 	int data = scanner.nextInt();
	// 	System.out.println(data);
	// 	Client client = new Client();	
	// }

}