package java76.pms.domain;

import java.io.Serializable;

public class Calculator  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected double result;
	protected double v1;
	protected double v2;
	
	@Override
	public String toString() {
	return "Calculator [result=" + result + ", v1=" + v1 + ", v2=" + v2 + "]";
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public double getV1() {
		return v1;
	}

	public void setV1(double v1) {
		this.v1 = v1;
	}

	public double getV2() {
		return v2;
	}

	public void setV2(double v2) {
		this.v2 = v2;
	}
	
	
	
	
}
