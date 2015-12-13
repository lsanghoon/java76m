package java76.pms.domain;

import java.io.Serializable;

public class Users implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected String email;
  protected String password;
  protected String name;
  protected String addr;
  protected String tel;
  protected int		 point;
  
  public Users() {}
  
  @Override
	public String toString() {
	return "Users [email=" + email + ", password=" + password + ", name=" + name + ", addr=" + addr + ", tel=" + tel
	    + ", point=" + point + "]";
	}

	public Users(String email) {
    this.email = email;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

}









