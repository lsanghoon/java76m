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
	protected String		m;
	protected int				s;
	protected String		sbDate;
	protected String		ebDate;
	
	public Purchase() {}

	@Override
	public String toString() {
	return "Product [no=" + no + ", bDate=" + bDate + ", bpname=" + bpname + ", bpsum=" + bpsum + ", buname=" + buname
	    + ", buemail=" + buemail + "]";
	}

	
	public String getSbDate() {
		return sbDate;
	}
	public void setSbDate(String sbDate) {
		this.sbDate = sbDate;
	}
	public String getEbDate() {
		return ebDate;
	}
	public void setEbDate(String ebDate) {
		this.ebDate = ebDate;
	}
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	public int getS() {
		return s;
	}
	public void setS(int s) {
		this.s = s;
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
