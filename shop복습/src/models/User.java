package models;

public class User {
	private String id;
	private static int money;
	
	public User(String id ) {
		this.id = id;
		this.money =5000;
	}
	public void print() {
		System.out.println(id+":"+money+"¿ø");
	}
	public String getId() {
		return this.id;
	
	}
	public int getMoney() {
		return money;
	}
}
