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
			System.out.println("Inside File Receiver");
			datainputstream = new DataInputStream(s.getInputStream());
			dataoutputstream = new DataOutputStream(s.getOutputStream());

			Thread sendmessage = new Thread(new Runnable()
                        {
                                //Override
                                public void run()
                                {
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
			sendmessage.start();

			while(true)
			{
				String received = datainputstream.readUTF();
				if(received.equals("sendingafile"))
					break;
				else
					System.out.println(received);
			}
			String filename = "";
			filename = datainputstream.readUTF();
			File targetFile = new File(filename);
			OutputStream file_outputstream = new FileOutputStream(targetFile);
			//byte [] buffer = new byte[8 * 1024];
			//datainputstream.read(buffer);
			
			
			try
			{
				while(true)
				{
					String rec;
					rec = datainputstream.readUTF();
					byte b[] = rec.getBytes();
					file_outputstream.write(b);
				}
			}catch(Exception exception)
			{
				System.out.println("ERRORRR");
			}
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}