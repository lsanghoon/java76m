[주제: DAO 구현체 자동 생성]
* 목표
- mybatis 3.x 버전에 추가된 DAO 구현체 자동 생성 기능을 도입
- 개발자가 직접 DAO를 구현하는 것을 없앤다.

* 실습
1) 스프링 설정 파일에 DAO 구현체를 생성하는 공장을 등록한다.
application-context.xml 파일
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <!-- DAO 인터페이스가 선언된 패키지 지정한다. -->
    <property name="basePackage" value="java76.pms.dao" />
</bean>

2) 기존 DAO 클래스를 인터페이스로 전환한다.
  - SQL 맵퍼 파일의 namespace 이름이 DAO 인터페이스와 일치해야 한다.
  - 단 메서드의 이름과 파라미터 타입은 SQL 맵퍼 파일에 선언된 SQL과 일치해야 한다.