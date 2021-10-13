package 장바구니model;

public class User {
	public String id;
	public int money;
	
	public User(String id, int mo){
		this.id = id;
		this.money = mo;
	}
	
	public void print() {
		System.out.println("["+id+"]"+ "금액 : "+money);
	}

	public String getId() {
		return this.id;
	}

	public int getMoney() {
		return this.money;
	}
}