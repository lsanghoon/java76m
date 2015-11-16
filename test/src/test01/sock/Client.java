package test01.sock;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		System.out.print("IP : ");
		String ip = input.nextLine();
		
		System.out.print("PORT : ");
		int port = Integer.parseInt(input.nextLine());
		
		Socket sock = new Socket(ip, port);
		
		System.out.print(">>");
		
		String sendText = input.nextLine();
		PrintStream send = new PrintStream(sock.getOutputStream());
		send.println(sendText);
		
		Scanner recv = new Scanner(sock.getInputStream());
		System.out.println(recv.nextLine());
		
		sock.close();
		System.out.println("Connection Closed");
	}

}
