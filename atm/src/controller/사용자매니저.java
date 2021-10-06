package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.User;

public class 사용자매니저 {
	public static 사용자매니저 instance = new 사용자매니저();
	Scanner sc = new Scanner(System.in);
	private ArrayList<User> users = new ArrayList<User>();

	private 사용자매니저() {
		this.users = new ArrayList<>();
	}

	public void joinUser() {
		System.out.println("id : ");
		String id = BankManager.sc.next();
		System.out.println("pw : ");
		String pw = BankManager.sc.next();

		boolean check = false;
		for (User user : users) {
			if (id.equals(user.getId()))
				check = true;
		}
		if(!check) {
			System.out.print("이름 입력 : ");
			String name = BankManager.sc.next();
			
			this.users.add(new User(randomCode(), id, pw, name));
		}else {
			System.out.println("중복된 아이디 입니다.");
		}
	}

	public static void main(String[] args) {

	}

}
