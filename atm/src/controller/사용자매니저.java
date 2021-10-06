package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.Account;
import models.User;
import models.�����;

public class ����ڸŴ��� {
	public static ����ڸŴ��� instance = new ����ڸŴ���();
	Scanner sc = new Scanner(System.in);
	private ArrayList<�����> users = new ArrayList<�����>();

	private ����ڸŴ���() {
		this.users = new ArrayList<>();
	}

	public void joinUser() {
		System.out.println("id : ");
		String id = BankManager.sc.next();
		System.out.println("pw : ");
		String pw = BankManager.sc.next();

		boolean check = false;
		for (����� user : users) {
			if (id.equals(user.getId()))
				check = true;
		}
		if(!check) {
			System.out.print("�̸� �Է� : ");
			String name = BankManager.sc.next();
			
			this.users.add(new �����(randomCode(), id, pw, name));
		}else {
			System.out.println("�ߺ��� ���̵� �Դϴ�.");
		}
	}

	private int randomCode() {
		Random rn = new Random();
		while(true) {
			int rCode = rn.nextInt(8999)+1001;
			
			boolean check = false;
			for(����� user : users) {
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
	public ����� getUser(int index) {
		return this.users.get(index);
	}
	
	public int getUserAccSize(int log) {
		return this.users.get(log).getAccsSize();
	}
	
	public void addAcc(int log, Account e) {
		this.users.get(log).addAcc(e);
	}
}
