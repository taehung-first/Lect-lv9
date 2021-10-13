package ��ٱ��Ϲ̴�������Ʈ;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.User;

public class UserManager {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	public Vector<User> userList = new Vector<User>();
	public int log;
	
	public UserManager(){
		inti();
	}
	
	void inti() {
		for(int i=0; i<10; i++) {
			String[] a = { "��", "��", "��", "��", "��", "��" };
			String[] b = { "ö", "��", "��", "��", "��", "��" };
			String[] c = { "��", "��", "��", "��", "��", "��" };
			
			int r = ran.nextInt(a.length);
			String name = a[r];
			r = ran.nextInt(b.length);
			name += b[r];
			r= ran.nextInt(c.length); 
			name += c[r];
			
			r = ran.nextInt(10000);
			int money = r;
			User temp = new User(name, money);
			userList.add(temp);
		}
	}
	
	public void join() {
		int check = -1;
		System.out.println("���̵� �Է��ϼ���.");
		String id = scan.next();
		
		for(int i=0; i<userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				check = i;
				break;
			}
		}
		if(check == -1) {
			System.out.println(id+"�� ������ ȯ���մϴ�.");
			User temp = new User(id, 0);
			userList.add(temp);
		}
		else {
			System.out.println("�ߺ��Ǵ� ���̵��Դϴ�.");
			return;
		}
	}
	��
	public void remove() {
		int check = -1;
		System.out.println("���̵� �Է��ϼ���.");
		String id = scan.next();
		for(int i=0; i<userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				check = i;
				break;
			}
		}
		if(check == -1) {
			System.out.println("���������ʴ� ���̵��Դϴ�.");
		}
		else {
			System.out.println(id+"�� Ż��Ǿ����ϴ�.");
			userList.remove(check);
		}
	}
	
	public boolean logIn() {
		int check = -1;
		System.out.println("���̵� �Է��ϼ���.");
		String id = scan.next();
		for(int i=0; i<userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				check = i;
				break;
			}
		}
		if(check == -1) {
			System.out.println("���̵� Ȯ�����ּ���.");
			return false;
		}
		else {
			System.out.println(id+"�� ȯ���մϴ�.");
			log = check;
			return true;
		}
	}
	
	public void logOut() {
		
		if(log != -1) {
			System.out.println(userList.get(log).id+"�� �α׾ƿ��Ǿ����ϴ�.");
			log = -1;	
		}
		else {
			System.out.println("�α��νÿ��� �����մϴ�.");
			return;
		}
	}
	
	public void print() {
		for(int i=0; i<userList.size(); i++) {
			System.out.print("["+i+"]");
			userList.get(i).print();
		}
	}
	
	public void printID() {
		for(int i=0; i<userList.size(); i++) {
			System.out.println("ȸ��ID:"+userList.get(i).getId() + " �ܾ� :"+userList.get(i).getMoney());
		}
	}
	
	
	
}