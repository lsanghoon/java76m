package test01.sock;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket sevrSock = new ServerSocket(8888);
		System.out.println("Server Connecting...");
		
		Socket sock = sevrSock.accept();
		
		Scanner recvToClient = new Scanner(sock.getInputStream());
		System.out.println(recvToClient.nextLine());
		
		Scanner input = new Scanner(System.in);
		System.out.print(">>");
		String sendText = input.nextLine();
		
		PrintStream send = new PrintStream(sock.getOutputStream());
		send.println(sendText);
		
		sock.close();
		sevrSock.close();
		System.out.println("Server Closed");
	}
}
