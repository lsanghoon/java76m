package step02;

public class Computer5 {
	protected String model;
	protected String maker;
	protected int ram;
	protected float speed;

	public Computer5(String model, int ram) {
		System.out.println("Computer(String,int)");
		this.model = model;
		this.ram = ram;
	}

	public Computer5(int ram, String maker) {
		System.out.println("Computer(int,String)");
		this.maker = maker;
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Computer2 [model=" + model + ", maker=" + maker + ", ram=" + ram + ", speed=" + speed + "]";
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}


}
