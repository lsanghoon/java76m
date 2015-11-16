package step16.ex06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

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

				String recv = in.readLine();
				System.out.println(recv);
				
				String[] params = recv.split("&");	//예) ["a=10", "b=20", "op=+"]
				HashMap<String,String> map = new HashMap<String,String>();
				String[] keyValue = null;
				
				for (String param : params) {
					keyValue = param.split("=");	//예) ["a" = "10", "b" = "20", "op" = "+"]
					map.put(keyValue[0], keyValue[1]);
				}

				int a = Integer.parseInt(map.get("a"));
				int b = Integer.parseInt(map.get("b"));
				int result = 0;

				switch (map.get("op")) {
				case "+": result = a + b; break;
				case "-": result = a - b; break;
				case "*": result = a * b; break;
				case "/": result = a / b; break;
				default:
					out.println(result);
					return;
				}

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
			Socket socket;

			while (true) {
				socket= servSock.accept();
				new Thread(new EchoAgent(socket)).start();
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