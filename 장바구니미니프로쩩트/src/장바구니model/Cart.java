package 장바구니model;

public class Cart {
	public String UserID;
	public String ItemName;
	
	public void print() {
		System.out.println("["+UserID+"] :"+ItemName);
	}
}