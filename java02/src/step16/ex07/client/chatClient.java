/*
 * v02 - 서버에서 보낸 메시지를 별도의쓰레드에서 수신한다.
 */
package step16.ex07.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class chatClient {

	class Receiver extends Thread {
		BufferedReader in;

		public Receiver(BufferedReader in) {
			this.in =in;
		}

		@Override
		public void run() {
			while (true) {
				try {
					System.out.println(in.readLine());
				} catch (Exception e) {	
					// 서버와의 연결이 끊겨 읽기 오류가 발생한다면 즉시 스레드를 종료한다.
					break;
				}
			}
		}
	}

	private void service(String ip, int port) {
		try (
				Socket socket = new Socket(ip, port);
				BufferedReader in =
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintStream out = new PrintStream(socket.getOutputStream());
				Scanner scanner = new Scanner(System.in);
				)
		{
			// Receiver가동 - 서버 메시지 수신기가동
			new Receiver(in).start();
			
			String send = null;
			
			// 메시지 송신 - 사용자가 입력한 메시지를 서버에 전송한다.
			do {
				System.out.print(">");
				send = scanner.nextLine();
				out.println(send);
			} while (!send.equals("quit"));

		}	catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println
			("사용법: java [-옵션들] step16.ex07.client.chatClient 서버주소 포트");
			return;
		}
		chatClient client = new chatClient();
		client.service(args[0], Integer.parseInt(args[1]));
	}
}