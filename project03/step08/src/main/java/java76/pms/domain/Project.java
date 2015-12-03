package java76.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int no;
	protected String Title;
	protected Date startDate;
	protected Date endDate;
	protected String member;

	public Project() { }

	public Project(String Title, String member) {
		this.Title = Title;
		this.member = member;
	}

	@Override
	public String toString() {
	return "Project [No=" + no + ", Title=" + Title + ", startDate=" + startDate + ", endDate=" + endDate + ", member="
	    + member + "]";
	}

	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	

}
