package models;

public class °èÁÂ {
	public static final int MAX = 3;
	
	private int accNum;
	private int money;
	private int userCode;
	
	public °èÁÂ(int userCode, int accNum) {
		this.userCode = userCode;
		this.accNum = accNum;
		this.money = 1000;
	}
	public °èÁÂ(int userCode, int accNum, int money) {
		this.userCode = userCode;
		this.accNum = accNum;
		this.money = money;
	}
	public int getUserCode() {
		return this.userCode;
	}
	
	public int getAccNum() {
		return this.accNum;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public String toString() {
		return this.accNum + " : " + this.money;
	}
	

}
