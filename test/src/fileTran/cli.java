package fileTran;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;

public class cli {
	public static void main(String[] args) throws Exception {

		ByteArrayInputStream byteInArr = null;
		ByteArrayOutputStream byteOutArr = null;
		BufferedInputStream fileIn = null;
	//FileInputStream fileIn = null;
		/*try 
		{
			//fileIn = new FileInputStream("./test/test.mp4");
			fileIn = new BufferedInputStream(new FileInputStream("./test/test.txt"));
			byteOutArr = new ByteArrayOutputStream();
			int readCount = 0;
			byte[] inbuf = new byte[2048];
			while ((readCount = fileIn.read(inbuf)) != -1)
				byteOutArr.write(inbuf, 0, readCount);
			
			byte[] fileArray = byteOutArr.toByteArray();
			System.out.println("byte 배열 완성!");
			System.out.println("byte 배열 길이: " + fileArray.length);
			byteInArr = new ByteArrayInputStream(fileArray);
			
			byte[] outBuf = new byte[2048];
			while((readCount = byteInArr.read(outBuf)) != -1)
				System.out.write(outBuf, 0, readCount);
			
			System.out.println("출력완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {byteOutArr.close();}	catch (Exception e) {}
			try {byteInArr.close();}	catch (Exception e) {}
		}*/

		FileOutputStream sink2 = new FileOutputStream("./test/test2.mp4");
		BufferedOutputStream out = new BufferedOutputStream(sink2);
		
		byteOutArr = new ByteArrayOutputStream();
		int b;
		
		while ((b = fileIn.read()) != -1)
			out.write(b);
		out.flush();
		
		fileIn.close();
		out.close();
		sink2.close();
	}
}
