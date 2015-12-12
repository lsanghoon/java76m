package java76.pms.domain;

import java.io.Serializable;

public class Cart  implements Serializable {
  private static final long serialVersionUID = 1L;

  protected int       no;
  protected String    cpname;
  protected int   	  cpcost;
  protected String    cemail; // 컬럼명 = photo
  protected String		cpphoto;
  protected int				cstock;
  protected int				sum;
  
  public Cart() {}

	@Override
	public String toString() {
	return "Cart [no=" + no + ", cpname=" + cpname + ", cpcost=" + cpcost + ", cemail=" + cemail + ", cpphoto="
	    + cpphoto + "]";
	}

	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getCstock() {
		return cstock;
	}
	public void setCstock(int cstock) {
		this.cstock = cstock;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCpname() {
		return cpname;
	}
	public void setCpname(String cpname) {
		this.cpname = cpname;
	}
	public int getCpcost() {
		return cpcost;
	}
	public void setCpcost(int cpcost) {
		this.cpcost = cpcost;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCpphoto() {
		return cpphoto;
	}
	public void setCpphoto(String cpphoto) {
		this.cpphoto = cpphoto;
	}
  
}
