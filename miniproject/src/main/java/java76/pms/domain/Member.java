package java76.pms.domain;

import java.io.Serializable;

public class Member implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected String email;
  protected String password;
  protected String name;
  protected String tel;
  protected String photo;
  
  public Member() {}
  
  public Member(String email) {
    this.email = email;
  }

	@Override
	public String toString() {
	return "Member [email=" + email + ", password=" + password + ", name=" + name + ", tel=" + tel + ", photo=" + photo
	    + "]";
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
  
}









