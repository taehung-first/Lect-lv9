package controler;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.User;
public class UserManager {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();
	public static UserManager instance = new UserManager();
	public Vector<User> userList = new Vector<User>();
	public static int log;
	public UserManager(){
		
		inti();
	}
	void inti() {
		for(int i=0; i<10;i++) {
			String []a = { "��", "��", "��", "��", "��", "��" };
			String []b = { "ö", "��", "��", "��", "��", "��" };
			String []c = { "��", "��", "��", "��", "��", "��" };
			
			int r = rn.nextInt(a.length);
			String name = a[r];
			r = rn.nextInt(b.length);
			name +=b[r];
			r = rn.nextInt(c.length);
			name +=c[r];
			
			User temp = new User(name, r);
			userList.add(temp);
		}
	}
	public void join() {
		int check = -1;
		System.out.println("���̵� �Է�:");
		String id = sc.next();
		
		for(int i=0;i<userList.size();i++) {
			if(id.equals(userList.get(i).getId())) {
				check = i ;
				break;
			}
		}
		if(check==-1) {
			System.out.println(id +"�� ������ ȯ���մϴ�.");
			User temp = new User(id, check);
		userList.add(temp);
		}
		else {
			System.out.println("�ߺ��Ǵ� ���̵�");
			return;
		}
	}
	public void remove() {
		int check =-1;
		System.out.println("���̵� �Է�:");
		String id = sc.next();
		for(int i=0;i<userList.size();i++) {
			if(id.equals(userList.get(i).getId())) {
				check =i;
				break;
			}
		}
		if(check ==-1) {
			System.out.println("���̵� Ȯ���ϼ���");
		}else {
			System.out.println(id+"�� Ż��Ǿ����ϴ�.");
			userList.remove(check);
		}
	}
	public boolean logIn() {
		int check=-1;
		System.out.println("���̵� �Է�:");
		String id = sc.next();
		for(int i=0;i<userList.size();i++) {
			if(id.equals(userList.get(i).getId())) {
				check =i;
				break;
			}
		}
		if(check ==-1) {
			System.out.println("�������� ���� ���̵��Դϴ�.");
			return false;
		}else {
			System.out.println(id +"�� ȯ���մϴ�.");
			log = check;
			return true;
		}
	}
	
	public void logOut() {
		if(log != -1) {
			System.out.println(userList.get(log).getId()+"�� �α׾ƿ�");
			log = -1 ;
		}
		else {
			System.out.println("�α����� �Ǿ����� �ʽ��ϴ�.");
			return;
		}
	}
	public void print() {
		for(int i=0;i<userList.size();i++) {
			System.out.println(i);
			userList.get(i).print();
		}
	}
	public void printID() {
		for(int i=0;i<userList.size();i++) {
			System.out.println("ȸ�� ID"+userList.get(i).getId()+"�ܾ�"+userList.get(i).getMoney());
		}
	}
	
	
}
