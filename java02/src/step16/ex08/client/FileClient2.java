package step16.ex08.client;

import java.io.*;
import java.net.Socket;

public class FileClient2 {
	private void service(String path) {
		File file = new File(path);
		if (!file.exists() || !file.isFile()) {
			System.out.println("파일이 존재하지 않거나 디렉토리입니다.");
			return;
		}

		String fileName = file.getName();
		long fileSize = file.length();

		try (
				Socket socket = new Socket("localhost", 8888);
				DataOutputStream out = new DataOutputStream(
						new BufferedOutputStream(socket.getOutputStream()));
				DataInputStream in = new DataInputStream(
						new BufferedInputStream(new FileInputStream(new File(path))));
				)
		{
			out.writeUTF(fileName);	// 파일 바이트크기(2) UTF바이트배(n)
			out.writeLong(fileSize);
			
			int len;
			while ((len = in.read()) != -1) 
				out.write(len);
			out.flush();
			
			System.out.println("전송완료");
			System.out.println("보낸 파일의 사이즈 : " + file.length());			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println(
					"사용법: java [-옵션들] java -cp ./bin step16.ex08.client.FileClient 파일위치경로");
			return;
		}
		//String path = "/Users/isanghoon/test/a.gif";
		FileClient2 client = new FileClient2();
		client.service(args[0]);
	}
}
