package step07.ex13;

abstract public class User {
	String name;
	String tel;
	String id;
	String pwd;
	String email;
	
	public User (String id, String pwd, String email) {
		this.id = id;
		this.pwd = pwd;
		this.email = email;
	}
}
