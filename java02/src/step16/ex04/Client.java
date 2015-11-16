package step16.ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {

		//try(Socket socket = new Socket("192.168.0.14", 8888);) {
		try(
				Socket socket = new Socket("192.168.0.60", 8888);
				Scanner scanner = new Scanner(System.in);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				PrintStream out = new PrintStream(socket.getOutputStream());
				) 
		{
			String send = null;
			String recv = null;
			do {
			System.out.print("입력>");
			//보내기
			send = scanner.nextLine();
			out.println("이상훈:" + send);
			// 받기
			recv = in.readLine();
			System.out.println(recv);
			} while(!send.equals("bye"));

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
