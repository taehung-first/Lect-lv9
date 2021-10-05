package 장바구니미니프로젝트;

import java.util.Scanner;
import java.util.Vector;

import 장바구니model.Item;

class ItemManager {
	
	public static ItemManager instance = new ItemManager();
	
	Scanner scan = new Scanner(System.in);
	
	Vector<String> category = new Vector<String>();
	Vector<Item> itemList = new Vector<Item>(); 
	Vector<Cart> jangList = new Vector<Cart>(); // 전체 장바구니
	
	ItemManager() {
		
		init();
	}
	void init() {
		category.add("과자");
		category.add("생선");
		category.add("육류");
		category.add("음료수");
		Item temp = new Item("새우깡", 1000, category.get(0));
		itemList.add(temp);
		temp = new Item("고등어", 2000, category.get(1));
		itemList.add(temp);
		temp = new Item("칸쵸", 3600, category.get(0));
		itemList.add(temp);
		temp = new Item("소고기", 6500, category.get(2));
		itemList.add(temp);
		temp = new Item("콜라", 500, category.get(3));
		itemList.add(temp);
		temp = new Item("새우", 1800, category.get(1));
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
		System.out.println("[아이템추가] 아이템이름을 입력하세요.");
		String name = scan.next();
		System.out.println("[아이템추가] 가격을 입력하세요. ");
		int price = scan.nextInt();
		printCategory();
		System.out.println("[아이템추가] 카테고리를 입력하세요. ");
		int sel = scan.nextInt();
		Item temp = new Item(name, price, category.get(sel));
		itemList.add(temp);
	}

	void addCategory() {
	}

	void addCart(String usID, int caID, int itemID) {
	}
}