package 장바구니model;

public class Cart {
	private String userId;
	private String itemName;

	void print() {
		System.out.println(userId + "아이템 : " + itemName);
	}
}