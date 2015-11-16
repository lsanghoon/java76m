package step16.ex08.client;

import java.io.*;
import java.net.Socket;

public class FileClient {
	private void service(String path) {
		try (
				Socket socket = new Socket("localhost", 8888);
				DataOutputStream Dout = new DataOutputStream(socket.getOutputStream());
				BufferedInputStream Bin = new BufferedInputStream(new FileInputStream(new File(path)));
				)
		{
			File file = new File(path);
			String fileName = file.getName();
			Dout.writeUTF(fileName);
			
			int len;
			int size = 8192;
			byte[] data = new byte[size];
			while ((len = Bin.read(data)) != -1) 
				Dout.write(data, 0, len);
			Dout.flush();
			
			System.out.println("전송완료");
			System.out.println("보낸 파일의 사이즈 : " + file.length());			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		/*if (args.length < 1) {
			System.out.println(
					"사용법: java [-옵션들] java -cp ./bin step16.ex08.client.FileClient 파일위치경로");
			return;
		}*/
		String path = "/Users/isanghoon/test/a.gif";
		FileClient client = new FileClient();
		client.service(path);
	}
}
