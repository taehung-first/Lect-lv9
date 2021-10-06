package models;

import java.util.ArrayList;
import java.util.Random;

import controller.사용자매니저;

public class 사용자 {
	Random rn = new Random();
	private int code;	// 1000~ 9999 중복X 랜덤
	private String id;
	private String pw;
	private String name;
	private int money;
	
	사용자매니저 user = 사용자매니저.instance;
	
	private ArrayList<계좌> accs = new ArrayList<계좌>();
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
	public 계좌 getAcc(int index) {
		return this.accs.get(index);
	}
	public int getAccsSize() {
		return this.accs.size();
	}
	public void addAcc(계좌 e) {
		this.accs.add(e);
	}
	public void removeAcc(계좌 e) {
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