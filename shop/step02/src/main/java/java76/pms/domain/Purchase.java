package java76.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Purchase  implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int       no;
	protected Date			bDate;
	protected String		bpname;
	protected int				bpsum;
	protected String		buname;
	protected String		buemail;
	
	public Purchase() {}

	@Override
	public String toString() {
	return "Product [no=" + no + ", bDate=" + bDate + ", bpname=" + bpname + ", bpsum=" + bpsum + ", buname=" + buname
	    + ", buemail=" + buemail + "]";
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public String getBpname() {
		return bpname;
	}
	public void setBpname(String bpname) {
		this.bpname = bpname;
	}
	public int getBpsum() {
		return bpsum;
	}
	public void setBpsum(int bpsum) {
		this.bpsum = bpsum;
	}
	public String getBuname() {
		return buname;
	}
	public void setBuname(String buname) {
		this.buname = buname;
	}
	public String getBuemail() {
		return buemail;
	}
	public void setBuemail(String buemail) {
		this.buemail = buemail;
	}
	
}
