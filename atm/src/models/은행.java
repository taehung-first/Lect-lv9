package models;

public class 은행 {
	public static 은행 instance = new 은행();
	
	private String brand="";
	
	public static int log =-1;
	
	public String getBrand() {
		return this.brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

}
