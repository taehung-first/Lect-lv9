package models;
import java.util.ArrayList;
import java.util.Random;

import controller.사용자매니저;


public class 사용자 {
	private static char[] toString;
	Random rn = new Random();
	private int code; //회원한테 부여되는 번호
	private String id; //회원 ID
	private String pw; //회원 PW
	private String name; //회원 이름
	private int money; //회원 소지금
	
	사용자매니저 user = 사용자매니저.instance;
	private ArrayList<Account> accs = new ArrayList<Account>();
	
	public 사용자(int code, String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.code = code;
	}
	public int getCode() {
		return this.code;
	}
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public String getName() {
		return this.name;
	}
	public Account getAcc(int index) {
		return this.accs.get(index);
	}
	public int getAccsSize() {
		return this.accs.size();
	}
	public void addAcc(Account e) {
		this.accs.add(e);
	}
	public void removeAcc(Account e) {
		this.accs.remove(e);
	}
	
	public String toString() {
		String str = "";
		str += this.code + " ";
		str += this.id + "/";
		str += this.pw + " : ";
		str += this.name;
		str += "(" + this.accs.size()+")";
		return str;
	}
}
