package a1028;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class fc {
	public static void main(String[] args) {
		String serverIp = "localhost";
		Socket socket = null;

		try {
			// 서버 연결
			socket = new Socket(serverIp, 8888);

			FileSender fs = new FileSender(socket);
			fs.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class FileSender extends Thread {
	Socket socket;
	DataOutputStream dos;
	BufferedInputStream bis;

	public FileSender(Socket socket) {
		this.socket = socket;
		try {
			// 데이터 전송용 스트림 생성
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			System.out.println("파일 전송 작업을 시작합니다.");

			String fName = "a.gif";
			dos.writeUTF(fName);

			// 파일 내용을 읽으면서 전송
			File f = new File("/Users/isanghoon/test", fName);
			bis = new BufferedInputStream(new FileInputStream(f));

			int len;
			int size = 4096;
			byte[] data = new byte[size];
			while ((len = bis.read(data)) != -1) 
				dos.write(data, 0, len);


			dos.flush();
			dos.close();
			bis.close();
			System.out.println("파일 전송 작업을 완료하였습니다.");
			System.out.println("보낸 파일의 사이즈 : " + f.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
