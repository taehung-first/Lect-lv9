package ��ٱ���model;

public class Item {
	String name;
	int price;
	String category; // ī�װ� // ���� , ���� , ��� , ���� ���

	Item(String na, int pr, String cate) {
		name = na;
		price = pr;
		category = cate;
	}

	void print() {
		System.out.println("[" + name + "]" + "[" + price + "]" + "[" + category + "]");
	}
}