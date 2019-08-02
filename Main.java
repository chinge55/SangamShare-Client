import java.util.Scanner;

public class Main
{	public static int data;
	public static void main(String[] args)
	{
		
		//CheckForServer checkForServer = new CheckForServer();
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. CHAT\n 2. RECEIVE FILE \n 3. SEND FILE");
		int date = scanner.nextInt();
		data = date;
		System.out.println(data);
		switch(data){
		case 1:
			Client client = new Client();
			break;
		case 2:
			FileReceiveClient fileReceiveClient = new FileReceiveClient();
			break;
		case 3:
			FileSendClient fileSendClient = new FileSendClient(); 
			break;	
		default:
			break;
		}
	}
}