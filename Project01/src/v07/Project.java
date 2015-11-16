package v07;

import java.sql.Date;

public class Project {
	protected String pName;
	protected Date sDate;
	protected Date fDate;
	protected String member;

	void setValue(String str) {
		String[] tokens = str.split(",");
		if (tokens.length < 4)
			return;
		pName = tokens[0];
		sDate = Date.valueOf(tokens[1]);
		fDate = Date.valueOf(tokens[2]);
		member = tokens[3];
	}

	public Project() { }

	public Project(String str) {
		this.setValue(str);
	}

	public Project(String pName, String member) {
		this.pName = pName;
		this.member = member;
	}

	@Override
	public String toString() {
		return this.getpName() + "," + this.getsDate() + ","
				+ this.getfDate() + "," + this.getMember();
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
