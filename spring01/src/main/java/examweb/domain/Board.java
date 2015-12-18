package examweb.domain;

import java.io.Serializable;
import java.sql.Date;

public class Board  implements Serializable {
  private static final long serialVersionUID = 1L;

  protected int       no;
  protected String    title;
  protected String    content;
  protected int       views;
  protected Date      createdDate;
  protected String    attachFile; // 컬럼명 = afile
  public String getAttachFile() {
    return attachFile;
  }

  public void setAttachFile(String attachFile) {
    this.attachFile = attachFile;
  }

  protected String    password;
  
  public Board() {}

  @Override
  public String toString() {
    return "Board [no=" + no + ", title=" + title + ", content=" + content + ", views=" + views + ", createdDate="
        + createdDate + ", password=" + password + "]";
  }

  public int getNo() {
    return no;
  }

  public Board setNo(int no) {
    this.no = no;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public Board setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getContent() {
    return content;
  }

  public Board setContent(String content) {
    this.content = content;
    return this;
  }

  public int getViews() {
    return views;
  }

  public void setViews(int views) {
    this.views = views;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  
  
}
