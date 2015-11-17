//주제: 객체 사용할 때 프로퍼티 값도 함께 설정하기
package step05

//1) 그루비 VO클래스 사용하기
// - 객체를 생성할 때 프로퍼티 값을 함께 설정할 수 있다.
// - new 클래스명(필드명,
s1 = new Student(
	no:1, 
	name:"홍길동", 
	tel:"1111-1111", 
	email:"hong@test.com")

println s1.no + "," + s1.name + "," + s1.tel + "," + s1.email


//2) 자바의 VO 클래스를 사용할 경우,
// - 셋터 메서드가 있으면 호출한다.
// - 셋터 메서드가 없다면, 직접 필드를 찾아서 값을 넣는다.
s2 = new Student2(
	no:1,
	name:"홍길동",
	tel:"1111-1111",
	email:"hong@test.com")

println s2.no + "," + s2.name + "," + s2.tel + "," + s2.email