package step16.ex08.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer2 {
	
	class FileAgent extends Thread {
		Socket socket;
		String path;

		public FileAgent(Socket socket, String path) {
			this.socket = socket;
			this.path = path;
		}

		@Override
		public void run() {
			BufferedOutputStream out = null;
			try (
					DataInputStream fileIn = new DataInputStream(
							new BufferedInputStream(socket.getInputStream()));
					)
			{
				String fileName = fileIn.readUTF();	//파일명 받아오기
				long fileSize = fileIn.readLong();
				
				
				
				File file = new File(path.toString(), fileName);
				out = new BufferedOutputStream(new FileOutputStream(file));
				
				for (int i = 0; i < fileSize; i++) {
					out.write(fileIn.read());
				}
				
				/*int len;
				int size = 4096;
				byte[] data = new byte[size];
				while ((len = fileIn.read(data)) != -1)
					out.write(data, 0, len);
				out.flush();*/
				
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
		System.out.println("파일 서버 시작!");
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
		if (args.length < 1) {
			System.out.println(
					"사용법: java -cp ./bin step16.ex08.server.FileServer 파일위치경로");
			return;
		}
		//String path = "/Users/isanghoon/test2";
		FileServer2 server = new FileServer2();
		server.service(args[0]);
	}
}
