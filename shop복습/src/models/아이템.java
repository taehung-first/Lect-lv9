package models;

public class ������ {
	public String name;
	public int price;
	public String category;
	
	public ������(String na, int pr, String cate) {
		this.category = cate;
		this.name = na;
		this.price = pr;
	}
	public void print () {
		System.out.println(name +" : "+ price + " : " +category);
	}
}
