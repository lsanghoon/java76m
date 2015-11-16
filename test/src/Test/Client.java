package Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {


	public static void main(String[] args) {

		try(
				Socket socket = new Socket("192.168.0.55", 8888);
				Scanner scanner = new Scanner(System.in);
				
				BufferedReader strSend = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintStream strRecv = new PrintStream(socket.getOutputStream());
				
				BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream("./test/test.mp4"));
				
				BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
				BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
				ByteArrayOutputStream byteOutArr = new ByteArrayOutputStream();
				ByteArrayInputStream byteInArr = new ByteArrayInputStream(byteOutArr.toByteArray());
				) 
		{
			String str = "Hello";
			strRecv.println(str);
			
			int readCount = 0;
			byte[] buf = new byte[ 2048 ];
			while ((readCount = fileIn.read(buf)) != -1)
				byteOutArr.write(buf, 0, readCount);
				
			in.read(buf, 0, readCount);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
/*	

InputStream inputStream = socket.getInputStream();  

//read from the stream  
ByteArrayOutputStream baos = new ByteArrayOutputStream();  
byte[] content = new byte[ 2048 ];  
int bytesRead = -1;  
while( ( bytesRead = inputStream.read( content ) ) != -1 ) {  
   baos.write( content, 0, bytesRead );  
} // while  

ByteArrayInputStream bais = new ByteArrayInputStream( baos.toByteArray() );
*/
	}
