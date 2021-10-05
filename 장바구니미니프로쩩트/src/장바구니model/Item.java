package ��ٱ���model;

import ��ٱ��Ϲ̴�������Ʈ.ItemManager;

public class Item {
	
	private String name;
	private int price;
	private String category; 
	
	public static Item instance = new Item();
	
	ItemManager it = ItemManager.instance;
	
	public Item(String na, int pr, String cate) {
		this.name = na;
		this.price = pr;
		this.category  = cate;
	}
	

	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public int getPrice() {
		return price;
	}

	void print() {
		System.out.println("[" + name + "]" + "[" + price + "]" + "[" + category + "]");
	}
}