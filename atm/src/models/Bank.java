package models;

public class Bank {
	public static Bank instance = new Bank();
	
	private String brand = "";
	//�� Bank �ν��Ͻ�(��ü)�� �ý��� ���� ��, �����ϰ� �����ϵ��� �������
	public static int log = -1;
	
	
	public String getBrand() {
		return this.brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}