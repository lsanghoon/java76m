package java76.pms.domain;

import java.io.Serializable;

public class Product  implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int       no;
	protected String    pname;
	protected int    		pcost;
	protected String 	  pphoto;
	protected String 	  fimage;
	protected String 	  simage;
	protected int				pstock;
	protected String		pcate;
	protected int				pviews;

	public Product() {}

	@Override
	public String toString() {
	return "Product [no=" + no + ", pname=" + pname + ", pcost=" + pcost + ", pphoto=" + pphoto + ", fimage=" + fimage
	    + ", simage=" + simage + ", pstock=" + pstock + ", pcate=" + pcate + ", pviews=" + pviews + "]";
	}

	public String getFimage() {
		return fimage;
	}
	public void setFimage(String fimage) {
		this.fimage = fimage;
	}
	public String getSimage() {
		return simage;
	}
	public void setSimage(String simage) {
		this.simage = simage;
	}
	public int getPviews() {
		return pviews;
	}
	public void setPviews(int pviews) {
		this.pviews = pviews;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	public String getPphoto() {
		return pphoto;
	}
	public void setPphoto(String pphoto) {
		this.pphoto = pphoto;
	}
	public int getPstock() {
		return pstock;
	}
	public void setPstock(int pstock) {
		this.pstock = pstock;
	}
	public String getPcate() {
		return pcate;
	}
	public void setPcate(String pcate) {
		this.pcate = pcate;
	}

}
