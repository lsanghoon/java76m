package step16.ex05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * Runnable 인터페이스를 구현하여 클라이언트 요청처리
 * 실습:
 * 1) main 메서드의 작업을 server클레스의 메서드로 만들기
 */

public class Server {

	static class EchoAgent implements Runnable {
		Socket socket;

		public EchoAgent(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			BufferedReader in = null;
			PrintStream out = null;

			try {
				System.out.println("클라이언트와 연결됨...");

				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				out = new PrintStream(socket.getOutputStream());

				String recv = null;

				while (true) {
					recv = in.readLine();
					System.out.println(recv);
					if (recv.endsWith(":bye")) {
						out.println("안녕히 가세요!");
						break;
					}
					out.println(recv);
				}
				
				//String send = recv;
				//out.println(send);
				
				//System.out.printf("서버가 보낸 메시지: %s\n", recv);

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				try {in.close();}	catch (Exception e) {}
				try {out.close();}	catch (Exception e) {}
				try {socket.close();}	catch (Exception e) {}
			}

		}
	}

	public void service() {
		try (ServerSocket servSock = new ServerSocket(8888);)
		{
			System.out.println("클라이언 연결 기다림...");
			Socket socket = null;

			while (true) {
				socket = servSock.accept();
				new Thread(new EchoAgent(socket)).start();
				/*
				EchoAgent agent = new EchoAgent(socket);
				Thread t = new Thread(agent);
				t.start();
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server service = new Server();
		service.service();
	}

}