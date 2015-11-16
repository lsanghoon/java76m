/*
 * v01 - 객체 생성 자동화하기
 */

package java76.pms;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java76.pms.context.AnnotationApplicationContext;
import java76.pms.servlet.Servlet;

public class ProjectServer {
	AnnotationApplicationContext context;


	class RequestHandler implements Runnable {
		Socket socket;
		public RequestHandler(Socket socket) {
			this.socket = socket;
		}
		@Override
		public void run() {
			System.out.println("클라이언트 요청 처리...");
			try (
					BufferedReader in = 
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintStream out = new PrintStream(socket.getOutputStream());
					)
			{
				String message = in.readLine();

				int i = message.indexOf('?');
				String command = message.substring(0, (i != -1)? i : message.length());

				HashMap<String,Object> params = new HashMap<String,Object>();
				params.put("out", out);

				extractParamDataFromMessage(params, message);

				Object servlet = context.getBean(command);



				if (servlet != null && servlet instanceof Servlet) {
					((Servlet)servlet).service(params);
				}
				else
					System.out.println("죄송하지만 요청하신 명령을 찾을수 없습니다.");

				out.println();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {socket.close();} catch (Exception e) {}
			}
		}
	}

	public ProjectServer() throws Exception {
		
		// Bean Container 생성
		// Bean? 자바 인스턴스를 말한다.
		// Bean Container란 자바 인스턴스를 보관 관리하는 객체
		context = new AnnotationApplicationContext("java76.pms");
		
		// Resources 도구는 자바 클래스가 있는 경로를 뒤진다.
		// 그 경로에 있는 파일을 읽을 수 있도록 입력 스트림을 준비한다.
		InputStream configInputStream = Resources.getResourceAsStream(
				"java76/pms/dao/mybatis-config.xml");
		
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(configInputStream);
																					//mybatis 설정 파일을 읽을때 사용할 스트림
		
		// 빈 컨테이너에 mybatis 객체 보관
		// 누가 사용하는가? DAO가 SqlSessionFactory 객체를 사용한다.
		context.addBean("sqlSessionFactory", sqlSessionFactory);
		
	}

	public static void main(String[] args) {
		try {
			ProjectServer server = new ProjectServer();
			server.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void execute() {
		try (ServerSocket ss = new ServerSocket(8888);) {
			while (true) {
				System.out.println("클라이언트 요청을 기다리는중...");
				new Thread(new RequestHandler(ss.accept())).start();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void extractParamDataFromMessage(Map<String,Object> map, String message) {
		int i = 0;
		String paramString = null;
		String[] tokens = null;
		String[] keyValue = null;

		if (message.contains("?")) {
			i = message.indexOf('?');
			paramString = message.substring(i + 1);

			tokens = paramString.split("&");

			for (String token : tokens) {
				keyValue = token.split("=");
				map.put(keyValue[0], keyValue[1]);
			}
		}

	}

}
