package models;

public class User {
	public String id;
	public int money;
	
	public User(String id, int money ) {
		this.id = id;
		this.money = money;
	}
	public void print() {
		System.out.println(id+":"+money+"¿ø");
	}
	public String getId() {
		return this.id;
	
	}
	public int getMoney() {
		return this.money;
	}
}
