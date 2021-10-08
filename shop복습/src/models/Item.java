package models;

public class Item {
	private String name;
	private int price;
	private String category;
	
	public Item(String na, int pr, String cate){
		this.name = na;
		this.price = pr;
		this.category = cate;
	}
	
	public void print() {
		System.out.println("["+name+"]"+"["+price+"]"+"["+category+"]");
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}