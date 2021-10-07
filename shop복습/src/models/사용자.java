package models;

public class 사용자 {
	public String id;
	public int money;
	
	public 사용자(String id, int money ) {
		this.id = id;
		this.money = money;
	}
	public void print() {
		System.out.println(id+":"+money+"원");
	}
}
