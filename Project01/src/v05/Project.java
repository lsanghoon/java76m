package v05;

import java.sql.Date;

public class Project {
	protected String pName;
	protected Date sDate;
	protected Date fDate;
	protected String member;
	
	public Project() { }
	
	public Project(String pName, String member) {
		this.pName = pName;
		this.member = member;
	}
	
	

	@Override
	public String toString() {
	return "Project [pName=" + pName + 
			", sDate=" + sDate + 
			", fDate=" + fDate + 
			", member=" + member + "]";
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public Date getfDate() {
		return fDate;
	}

	public void setfDate(Date fDate) {
		this.fDate = fDate;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}
	
	
}
