package models;

public class Cart {
	public String UserId;
	public String ItemName;
	
	public void print() {
		System.out.println(UserId + ", "+this.ItemName);
	}
	
}
