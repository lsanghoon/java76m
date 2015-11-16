package step16.ex08.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	
	class FileAgent extends Thread {
		Socket socket;
		String path;

		public FileAgent(Socket socket, String path) {
			this.socket = socket;
			this.path = path;
		}

		@Override
		public void run() {
			BufferedOutputStream Bout = null;
			try (
					DataInputStream Din = new DataInputStream(socket.getInputStream());
					)
			{
				String fileName = Din.readUTF();	//파일명 받아오기
				
				File file = new File(path.toString(), fileName);
				Bout = new BufferedOutputStream(new FileOutputStream(file));
				
				int len;
				int size = 4096;
				byte[] data = new byte[size];
				while ((len = Din.read(data)) != -1)
					Bout.write(data, 0, len);
				Bout.flush();
				
				System.out.println("파일저장완료");
				System.out.println("받은 파일의 사이즈 : " + file.length());

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//try {fileOut.close();} catch (Exception e) {}
			}
		}
	}	
	
	private void service(String path) {
		try (
				ServerSocket servSocket = new ServerSocket(8888);
				)
		{
			while (true)
				new FileAgent(servSocket.accept(), path).start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		/*if (args.length < 1) {
			System.out.println(
					"사용법: java -cp ./bin step16.ex08.server.FileServer 파일위치경로");
			return;
		}*/
		String path = "/Users/isanghoon/test2";
		FileServer server = new FileServer();
		server.service(path);
	}
}
