package a1028;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class fs {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			// 리스너 소켓 생성 후 대기
			serverSocket = new ServerSocket(8888);
			// 연결되면 통신용 소켓 생성
			socket = serverSocket.accept();
			// 파일 수신 작업 시작
			FileReceiver fr = new FileReceiver(socket);
			fr.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class FileReceiver extends Thread {
	Socket socket;
	DataInputStream dis;
	BufferedOutputStream bos;

	public FileReceiver(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("파일 수신 작업을 시작합니다.");
			dis = new DataInputStream(socket.getInputStream());

			// 파일명을 전송 받고 파일명 수정.
			String fName = dis.readUTF();

			// 파일을 생성하고 파일에 대한 출력 스트림 생성
			File f = new File("/Users/isanghoon/test2", fName);
			bos = new BufferedOutputStream(new FileOutputStream(f));

			// 바이트 데이터를 전송받으면서 기록
			int len;
			int size = 4096;
			byte[] data = new byte[size];
			while ((len = dis.read(data)) != -1) {
				bos.write(data, 0, len);
			}

			bos.flush();
			bos.close();
			dis.close();
			System.out.println("파일 수신 작업을 완료하였습니다.");
			System.out.println("받은 파일의 사이즈 : " + f.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
