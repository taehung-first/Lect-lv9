package 장바구니model;

public class User11 {

	public class User {
		String id;
		int money;

		User(String id, int mo) {
			this.id = id;
			money = mo;
		}

		void print() {
			System.out.println("[" + id + "] " + "금액 : " + money);
		}
	}

}