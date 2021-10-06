package controller;

import java.util.Scanner;

import models.����;

public class ����Ŵ���{
	public static Scanner sc = new Scanner(System.in);
	static ����Ŵ��� instance = new ����Ŵ���();
	
	private ���ϰ����� fm = ���ϰ�����.instance;
	private ����ڸŴ��� um = ����ڸŴ���.instance;
	private ���¸Ŵ��� am = ���¸Ŵ���.instance;
	
	public void run() {
		fm.load();
		boolean isRun = true;
		while(isRun) {
			System.out.println(����.instance.getBrand()+ " ATM");
			
			printAllData();
			printMenu();
			isRun = selectMenu();
	
		}
		fm.save();
	}
	private void printAllData() {
		for(int i=0; i<um.getUsersSize(); i++) {
			System.out.println(um.getUser(i));
			
			for(int j=0; j<um.getUserAccSize(i); j++) {
				System.out.println(um.getUser(i).getAcc(j));
			}
		}
	}
	private void printMenu() {
		if(����.log == -1) {
			System.out.println(" 1.�α���\n 2.ȸ������\n 3.ȸ��Ż��\n 4.���� ");			
		}else {
			System.out.println(" 1�Ա�\n 2.���\n 3.��ȸ\n 4.��ü\n 5.���»���\n 6.����öȸ\n 7.�α׾ƿ�");
		}
	}
	private boolean selectMenu() {
		System.out.println("menu : ");
		String input = sc.next();
		
		try {
			int sel = Integer.parseInt(input);
			
			if(����.log == -1) {
				if(sel == 1) {
					login();
				}else if(sel == 2) {
					um.joinUser();
				}
				else if(sel == 3) {
					um.removeUser();
				}else if(sel == 4) {
					return false;
				}else {
					System.out.println("�߸��� �����Դϴ�.");
				}
			}else {
				if(um.getUserAccSize(����.log) > 0) {
					if(sel == 1) {
						am.inputMoney(����.log);
					}else if(sel == 2) {
						am.outMoney(����.log);
					}else if(sel == 3) {
						am.printUserAccs(����.log);
					}else if(sel == 4) {
						am.moveMoney(����.log);
					}else if(sel == 6) {
						am.dropAccount(����.log);
					}
				}
				
				if(sel == 5) {
					am.createAcc(����.log);
				}if(sel == 7) {
					logout();
				}
				
			}
		}catch(Exception e) {
			
		}
		return true;
	}
	private void login() {
		System.out.println("id : ");
		String id = sc.next();
		System.out.println("pw : ");
		String pw = sc.next();
		
		for(int i=0; i<um.getUsersSize(); i++) {
			if(id.equals(um.getUser(i).getId())&& pw.equals(um.getUser(i).getPw())) {
				����.log = i;
			}
		}
		if(����.log != -1) {
			System.out.println("�α��� ����");
		}
	}
	private void logout() {
		����.log = -1;
	}
}