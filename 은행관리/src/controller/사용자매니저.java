package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.����;
import models.�����;

public class ����ڸŴ��� {
	public static ����ڸŴ��� instance = new ����ڸŴ���();
	Scanner sc = new Scanner(System.in);
	// User �迭�� ����
	private ArrayList<�����> users = new ArrayList<�����>();
	
	private ����ڸŴ���() {
		this.users = new ArrayList<>();
	}
	public void joinUser() {
		System.out.println("id : ");
		String id = ����Ŵ���.sc.next();
		System.out.println("pw : ");
		String pw = ����Ŵ���.sc.next();
		
		boolean check = false;
		for(����� user : users) {
			if(id.equals(user.getId()))
				check = true;
		}
		if(!check) {
			System.out.print("�̸� �Է� : ");
			String name = ����Ŵ���.sc.next();
			
			this.users.add(new �����(randomCode(), id, pw, name));
		}else {
			System.out.println("�ߺ��� ���̵� �Դϴ�.");
		}
	}
	public void addUser(����� e) {
		this.users.add(e);
	}
	public void removeUser() {
		System.out.println("id : ");
		String id = ����Ŵ���.sc.next();
		System.out.println("pw : ");
		String pw = ����Ŵ���.sc.next();
		
		����� delUser = null;
		for(����� user : users) {
			if(id.equals(user.getId())&&pw.equals(user.getPw())) {
				delUser = user;
			}else {
				System.out.println("���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�.");
			}
		}
		this.users.remove(delUser);
	}
	private int randomCode() {
		Random rn = new Random();
		
		while(true) {
			int rCode = rn.nextInt(8999)+1000;
			
			boolean check = false;
			for(����� user : users) {
				if(rCode == user.getCode())
					check = true;
			}
			if(!check)
				return rCode;
		}
	}
	public void removeAcc(int log, ���� e) {
		this.users.get(log).removeAcc(e);
	}
	// Ż��
	// ������
	public int getUsersSize() {
		return this.users.size();
	}
	// ȸ����ȸ
	public ����� getUser(int index) {
		return this.users.get(index);
	}
	
	public int getUserAccSize(int log) {
		return this.users.get(log).getAccsSize();
	}
	
	public void addAcc(int log, ���� e) {
		this.users.get(log).addAcc(e);
	}
	
}
	
		
	
