[주제: 웹 애플리케이션 배포]
1. 톰캣 서버의 webapps 폴더에 웹 애플리케이션을 배포할 폴더를 만든다.
2. index.html 작성한다.
3. Servlet 구현체 작성 => HelloServlet.java
4. 톰캣 서버에 서블릿 구현체 배포.
   => 웹 애플리케이션 폴더 구조에 맞춰 배포해야 한다.
   => 웹 애플리케이션 폴더 구조
   웹애플리케이션폴더/.html, .css, .js, .gif, .jpeg, .jsp, 하위 폴더 등등
                /WEB-INF  <== 웹 애플리케이션 설정 파일과 클래스 파일, 
                              라이브러리 등을 두는 폴더
                /WEB-INF/web.xml    <== 웹 애플리케이션 설정 파일
                /WEB-INF/lib        <== .jar 라이브러리 파일을 두는 폴더
                /WEB-INF/classes    <== 클래스 파일을 두는 폴더
   => 라이브러리 파일 배포하라! 
      => 당장 사용하는 라이브러리가 없기 때문에 배포할 필요가 없다.
      => servlet-api 라이브러리는 이미 톰캣 서버가 갖고 있다. 따로배포할 필요가 없다.
   => 서블릿 클래스 파일을 배포하라!
      => /WEB-INF/classes/servlet/HelloServlet.class
   => web.xml에 서블릿 정보를 등록한다.
5. 웹 애ㅡㄹ리케이션을 배치한 후 톰켓 서버를 재실행해야 한다.

[주제: 이클립스의 WTP(Web Tool Plugin)을 사용하여 웹 애플리케이션 자동 배치하기]
1. 톰캣 서버에 대해 작업용 디렉토리를 만든다.
   => 먼저 이클립스에 톰캣 설치 폴더의 위치를 알려준다.
   => 톰캣 원본 설정 파일을 복사해 온다.
   => 배치하고 테스트하기 위한 임시 작업 폴더를 생성한다.
   => 이점: 원본 톰캣 서버를 손대지 않고 여러 개의 작업용 서버를 구축할 수 있다.
   => eclipes/Servers뷰를 띄워라. (JavaEE 퍼스펙티브를 선택하면 해당 뷰가 존재한다.)
   
2. 서버를 실행한다.