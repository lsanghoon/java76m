package fileTran;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class testClient {
	public static void main(String[] args) throws Exception {
		String file = null;
		String dir = null;
		
		File f = new File("/Users/isanghoon/test/a.gif");

		file = f.getName();
		dir = f.getPath();
		
		Socket sock = new Socket("localhost", 8888);
		
		//소켓으로부터 OutputStream얻어서 파일명을 먼저 보냄
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		System.out.println("파일명 : " + file);
		out.write(file + "\n");
		out.flush();
		
		//파일로 부터 스트림을 읽어들여서 얻어놓은 OutputStrema에 연결
		DataInputStream din = new DataInputStream(new FileInputStream(new File(dir)));
		DataOutputStream dout = new DataOutputStream(sock.getOutputStream());
		
		//바이트 단위로 읽어서 스트림으로 쓰기
		int b = 0;
		while ((b = din.read()) != -1) {
			dout.writeByte(b);
			dout.flush();
		}
		
		//자원정리
		din.close();
		dout.close();
		sock.close();
		
	}
}
