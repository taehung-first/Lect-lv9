package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.User;

public class ����ڸŴ��� {
	public static ����ڸŴ��� instance = new ����ڸŴ���();
	Scanner sc = new Scanner(System.in);
	private ArrayList<User> users = new ArrayList<User>();

	private ����ڸŴ���() {
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
			System.out.print("�̸� �Է� : ");
			String name = BankManager.sc.next();
			
			this.users.add(new User(randomCode(), id, pw, name));
		}else {
			System.out.println("�ߺ��� ���̵� �Դϴ�.");
		}
	}

	public static void main(String[] args) {

	}

}
