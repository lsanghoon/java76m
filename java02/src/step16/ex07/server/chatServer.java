/*
 * v02 - 다중 클라이언트와의 채팅
 */

package step16.ex07.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class chatServer {
	ArrayList<PrintStream> outList = new ArrayList<PrintStream>();

	synchronized public void add(PrintStream out) {
		outList.add(out);
	}

	synchronized public void remove(PrintStream out) {
		outList.remove(out);
	}

	synchronized public void send(String send) {
		for (PrintStream out : outList) {
			try {
				out.println(send);
			} catch (Exception e) {
				this.remove(out);
			}
		}
	}

	class ChatAgent extends Thread {
		Socket socket;

		public ChatAgent(Socket socket) {
			this.socket = socket;
		}
		@Override
		public void run() {
			try (
					BufferedReader in =
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintStream out = new PrintStream(socket.getOutputStream());
					)
			{
				//서버 출력스트림 테이블에 클라이언트 출력스트림을 등록한다.
				chatServer.this.add(out);
				
				String recv = null;

				while (true) {
					recv = in.readLine();
					if (recv.equals("quit")) {
						chatServer.this.send("Good Bye~");
						break;
					}
					chatServer.this.send(recv);
				}
				
				//채팅이 끝났으면, 서버 출력스트림 테이블에서 클라이언트 출력 스트림을 제거한다.
				chatServer.this.remove(out);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void service(int port) {
		try (
				ServerSocket servSocket = new ServerSocket(port);
				)
		{
			System.out.println("채팅서버 시작~");

			// 대기열에서 소켓을 꺼낼 때 까지 blocking 한다.
			while (true)
				new ChatAgent(servSocket.accept()).start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("사용법: java [-옵션들] step16.ex07.server.chatServer 포트");
			return;
		}
		chatServer server = new chatServer();
		server.service(Integer.parseInt(args[0]));
	}
}
