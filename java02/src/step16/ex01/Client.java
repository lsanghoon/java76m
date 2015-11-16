package step16.ex01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		InputStream in = null;
		InputStreamReader in2 = null;
		BufferedReader in3 = null;
		OutputStream out = null;
		PrintStream out2 = null;
		
		//1) 서버에 연결
		try(Socket socket = new Socket("192.168.0.14", 8888);) {
			//2) 서버와 데이터를 주고 받기 위한 도구를 준비한다.
			in = socket.getInputStream();
			in2 = new InputStreamReader(in);
			in3 = new BufferedReader(in2);
			out = socket.getOutputStream();
			out2 = new PrintStream(out);
			
			//3) 서버에 요청하
			out2.println("Hello");
			
			//4) 서버로부터 응답 받기
			String message = in3.readLine();
			
			//5) 서버가 응답한 메시지 출력하기
			System.out.println(message);
		}
		catch (Exception e) {
			
		}
		finally {
			try {in3.close();}catch (Exception e) {}
			try {in2.close();}catch (Exception e) {}
			try {in.close();}catch (Exception e) {}
			try {out2.close();}catch (Exception e) {}
			try {out.close();}catch (Exception e) {}
		}
	}
}
