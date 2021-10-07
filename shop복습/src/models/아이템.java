package models;

public class 아이템 {
	public String name;
	public int price;
	public String category;
	
	public 아이템(String na, int pr, String cate) {
		this.category = cate;
		this.name = na;
		this.price = pr;
	}
	public void print () {
		System.out.println(name +" : "+ price + " : " +category);
	}
}
