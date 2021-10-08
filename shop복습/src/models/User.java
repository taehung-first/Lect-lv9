package models;

public class User {
	private String id;
	private static int money;
	
	
	public User(String id, int money) {
		this.id = id;
		this.money =5000;
	}
	public void print() {
		System.out.println(id+":"+money+"¿ø");
	}
	public int getMoney() {
		return money;
	}
	public static void setMoney(int money) {
		User.money = money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
