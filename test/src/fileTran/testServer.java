package fileTran;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class testServer {
	
	public static void main(String[] args) throws Exception {
		ServerSocket servSock = new ServerSocket(8888);
		
		Socket sock = servSock.accept();
		System.out.println("소켓 " + sock + "에 연결됨");
		
		//소켓으로부터 스트림 얻어옴
		BufferedReader in =
				new BufferedReader(new InputStreamReader(sock.getInputStream()));
		
		//저장할 파일의 객체 생성함
		File file = new File("/Users/isanghoon/desktop/fileTransper"); 
		if (file.exists() == false)
			file.mkdirs();

		String fileName = in.readLine();
		file = new File(file.getAbsolutePath(), fileName);
		//기록할 파일 연결함
		FileOutputStream out = new FileOutputStream(file);
		
		//받은 파일의 끝까지 읽어서 파일로 쓴다.
		int i = 0;
		while ((i = in.read()) != -1) {
			out.write((char)i);
		}
		System.out.println("파일명: " + file.getName());
		System.out.println("받은파일은 " + file.getCanonicalPath().replace(fileName, "") + "경로에 저장됨");
		
		//자원관리
		out.close();
		in.close();
		sock.close();
		servSock.close();
		
	}
}
