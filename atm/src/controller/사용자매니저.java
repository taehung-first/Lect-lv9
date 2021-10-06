package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.Account;
import models.User;
import models.사용자;

public class 사용자매니저 {
	public static 사용자매니저 instance = new 사용자매니저();
	Scanner sc = new Scanner(System.in);
	private ArrayList<사용자> users = new ArrayList<사용자>();

	private 사용자매니저() {
		this.users = new ArrayList<>();
	}

	public void joinUser() {
		System.out.println("id : ");
		String id = BankManager.sc.next();
		System.out.println("pw : ");
		String pw = BankManager.sc.next();

		boolean check = false;
		for (사용자 user : users) {
			if (id.equals(user.getId()))
				check = true;
		}
		if(!check) {
			System.out.print("이름 입력 : ");
			String name = BankManager.sc.next();
			
			this.users.add(new 사용자(randomCode(), id, pw, name));
		}else {
			System.out.println("중복된 아이디 입니다.");
		}
	}

	private int randomCode() {
		Random rn = new Random();
		while(true) {
			int rCode = rn.nextInt(8999)+1001;
			
			boolean check = false;
			for(사용자 user : users) {
				if(rCode == user.getCode())
					check = true;
			}
			if(!check)
				return rCode;
		}
	}
	public void removeAcc(int log, Account e) {
		this.users.get(log).removeAcc(e);
	}
	public int getUsersSize() {
		return this.users.size();
	}
	public 사용자 getUser(int index) {
		return this.users.get(index);
	}
	
	public int getUserAccSize(int log) {
		return this.users.get(log).getAccsSize();
	}
	
	public void addAcc(int log, Account e) {
		this.users.get(log).addAcc(e);
	}
}
