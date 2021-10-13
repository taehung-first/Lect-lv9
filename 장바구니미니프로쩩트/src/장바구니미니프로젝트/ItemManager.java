package ��ٱ��Ϲ̴�������Ʈ;

import java.util.Scanner;
import java.util.Vector;

import models.Cart;
import models.Item;
import models.User;

public class ItemManager {
	Vector<Item> itemList = new Vector<Item>();
	Vector<Cart> jangList = new Vector<Cart>();
	Vector<String> category = new Vector<String>();
	Scanner scan = new Scanner(System.in);
	
	public ItemManager(){
		inti();
	}
	
	void inti() {
		category.add("����");
		category.add("����");
		category.add("����");
		category.add("�����");
		Item temp = new Item("�����", 1000, category.get(0));
		itemList.add(temp);
		temp = new Item("����", 2000, category.get(1));
		itemList.add(temp);
		temp = new Item("ĭ��", 3600, category.get(0));
		itemList.add(temp);
		temp = new Item("�Ұ��", 6500, category.get(2));
		itemList.add(temp);
		temp = new Item("�ݶ�", 500, category.get(3));
		itemList.add(temp);
		temp = new Item("����", 1800, category.get(1));
		itemList.add(temp);
	}
	
	public void printJang(User u) {
		for(int i=0; i<jangList.size(); i++) {
			if(u.id.equals(jangList.get(i).UserID)) {
				jangList.get(i).print();
			}
		}
	}
	
	public void printCategory() {
		for(int i=0; i<category.size(); i++) {
			System.out.println("["+i+"]"+category.get(i));
		}
	}
	
	public void printItem() {
		for(int i=0; i<itemList.size(); i++) {
			itemList.get(i).print();
		}
	}
	
	public void printItem(int caID) {
		int n = 0;
		for(int i=0; i<itemList.size(); i++) {
			if(category.get(caID).equals(itemList.get(i).category)) {
				System.out.print("["+n+"]");
				System.out.println(itemList.get(i).name);
				n += 1;
			}
		}
	}
	
	public void addItem() {
		System.out.println("������ �̸��� �Է��ϼ���.");
		String name = scan.next();
		System.out.println("������ ������ �Է��ϼ���.");
		int price = scan.nextInt();
		printCategory();
		System.out.println("ī�װ� ��ȣ�� �Է��ϼ���.");
		int caID = scan.nextInt();
		Item temp = new Item(name, price, category.get(caID));
		itemList.add(temp);
	}
	public void removeItem() {
		int check = -1;
		printItem();
		System.out.println("������ �̸��� �Է��ϼ���.");
		String name = scan.next();
		for(int i=0; i<itemList.size(); i++) {
			if(itemList.get(i).name.equals(name)) {
				check = i;
			}
		}
		if(check == -1) {
			System.out.println("���������ʴ� �������Դϴ�.");
			return;
		}
		else {
			itemList.remove(check);
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		}
	}
	
	public void addCategory() {
		System.out.println("ī�װ� �̸��� �Է��ϼ���.");
		String name = scan.next();
		category.add(name);
	}
	
	public void removeCategory() {
		printCategory();
		System.out.println("��ȣ�� �Է��ϼ���.");
		int index = scan.nextInt();
		for(int i=0; i<itemList.size(); i++) {
			if(category.get(index).equals(itemList.get(i).category)) {
				itemList.remove(i);
			}
			
		}
		category.remove(index);
	}
	
	public void addCart(String usID, int caID, int itemID) {
		int n = 0;
		Cart temp = new Cart();
		for(int i=0; i<itemList.size(); i++) {
			if(category.get(caID).equals(itemList.get(i).category)) {
				if(n == itemID) {
					temp.ItemName = itemList.get(i).name;
				}
				n += 1;
			}
		}
		temp.UserID = usID;
		jangList.add(temp);
	}
	
	public void removeCart(User u) {
		System.out.println("������ �������� �Է����ּ���.");
		String name = scan.next();
		
		int check = -1;
		for(int i=0; i<jangList.size(); i++) {
			if(jangList.get(i).UserID.equals(u.id) && jangList.get(i).ItemName.equals(name)) {
				check = i;
			}
		}
		if(check == -1) {
			System.out.println("���������ʴ� �������Դϴ�.");
		}
		else {
			System.out.println("�����Ǿ����ϴ�.");
			jangList.remove(check);
		}
	}
	
	public void buyItem(User u) {
		int money = 0;
		for(int i=0; i<jangList.size(); i++) {
			String name;
			if(jangList.get(i).UserID.equals(u.id)) {
				name = jangList.get(i).ItemName;
				for(int j=0; j<itemList.size(); j++) {
					if(itemList.get(j).name.equals(name)) {
						money += itemList.get(j).price;
					}
				}
			}
		}
		System.out.println("�� ���� : "+ money+", �����Ͻðڽ��ϱ�?1)�� 2)�ƴϿ�");
		int sel = scan.nextInt();
		
		if(sel==1) {
			u.money -= money;
			System.out.println("���� �Ϸ�Ǿ����ϴ�.");
		}
		else if(sel==2) {
			return;
		}
	}
}