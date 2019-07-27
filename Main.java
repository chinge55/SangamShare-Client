import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{

		Scanner scanner = new Scanner(System.in);
		System.out.println("1. CHAT\n 2. RECEIVE FILE 3. SEND FILE");
		int data = scanner.nextInt();
		System.out.println(data);
		switch(data){
		case 1:
			Client client = new Client();
			break;
		case 2:
			break;
		case 3:
			break;	
		default:
			break;
		}
	}
}