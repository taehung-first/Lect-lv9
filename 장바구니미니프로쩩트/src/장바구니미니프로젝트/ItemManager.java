package ��ٱ��Ϲ̴�������Ʈ;

import java.util.Scanner;
import java.util.Vector;

import ��ٱ���model.Item;

class ItemManager {
	
	public static ItemManager instance = new ItemManager();
	
	Scanner scan = new Scanner(System.in);
	
	Vector<String> category = new Vector<String>();
	Vector<Item> itemList = new Vector<Item>(); 
	Vector<Cart> jangList = new Vector<Cart>(); // ��ü ��ٱ���
	
	ItemManager() {
		
		init();
	}
	void init() {
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

	void printJang() {
	}

	void printJang(User u) {
	}

	void printCategory() {
	}

	void printItemList() {
	}

	void printItemList(int caID) {
	}

	void addItem() {
		System.out.println("[�������߰�] �������̸��� �Է��ϼ���.");
		String name = scan.next();
		System.out.println("[�������߰�] ������ �Է��ϼ���. ");
		int price = scan.nextInt();
		printCategory();
		System.out.println("[�������߰�] ī�װ��� �Է��ϼ���. ");
		int sel = scan.nextInt();
		Item temp = new Item(name, price, category.get(sel));
		itemList.add(temp);
	}

	void addCategory() {
	}

	void addCart(String usID, int caID, int itemID) {
	}
}