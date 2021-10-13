package models;

import java.util.Vector;

import controler.ItemManager;

public class User {
	private String id;
	private static int money;
	private Vector<Item> jang = new Vector<>();
	
	private ItemManager im = new ItemManager();
	
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
	void shoopingBag(){
		for(int i=0;i<im.jangList.size();i++) {
			jang.add(im.jangList.get(i).ItemName);
			
		}
	}
	
}
