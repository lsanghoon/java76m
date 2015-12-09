package java76.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Article  implements Serializable {
  private static final long serialVersionUID = 1L;

  protected int       no;
  protected String    name;
  protected String    content;
  protected Date      createdDate;
  protected String    photo; // 컬럼명 = photo
  
  public Article() {}

	@Override
	public String toString() {
	return "Article [no=" + no + ", name=" + name + ", content=" + content + ", createdDate=" + createdDate + ", photo="
	    + photo + "]";
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
