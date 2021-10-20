package 장바구니model;

public class User11 {
	String id;
	int money;

	User11(String id, int mo) {
		this.id = id;
		money = mo;
	}

	void print() {
		System.out.println("[" + id + "] " + "금액 : " + money);
	}
}
