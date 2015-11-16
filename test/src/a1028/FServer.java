package a1028;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class FServer {
  class FileAgent extends Thread {
    Socket socket;
    String path;

    public FileAgent(Socket socket, String path) {
      this.socket = socket;
      this.path = path;
    }

    @Override
    public void run() {
    	BufferedOutputStream fileOut = null;
      try (
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          //BufferedOutputStream out = 
          //new BufferedOutputStream(new FileOutputStream(new File(path.toString())));
          DataInputStream dis = 
              new DataInputStream(socket.getInputStream());
          )
      {
     // 파일명을 전송 받고 파일명 수정.
        String fName = in.readLine();
        fileOut = new BufferedOutputStream(
						new FileOutputStream(new File(path.toString(), fName)));
        int len;
        int size = 4096;
        byte[] data = new byte[size];
        while ((len = dis.read(data)) != -1) {
          fileOut.write(data, 0, len);
        }
        fileOut.flush();
        
      }catch (Exception e) {
        e.printStackTrace();
      } 

    }
  }

  private void service(String path) {
    try (
        ServerSocket serverSocket = new ServerSocket(8888);
        )
    {
      while(true) {
        new FileAgent(serverSocket.accept(), path).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    /*if (args.length < 1) {
      System.out.println(
          "사용법: java [options] step16.ex08.server.FileServer (path)");
    }*/
  	String path = "/Users/isanghoon/test2";
    FServer fileServer = new FServer();
    fileServer.service(path);
  }
}