package ��ٱ���model;

import java.util.Scanner;

import ��ٱ��Ϲ̴�������Ʈ.UserManager;

public class Shop {
	Scanner scan = new Scanner(System.in);
	
	private UserManager um = new UserManager();
	private I
	
	void mainMenu() {
		boolean run = ture;
		while (run) {
			System.out.println("[1.����] [2.Ż��] [3.�α���] [4.�α׾ƿ�]" + "\n[100.������] [0.����] ");
			int sel = scan.nextInt();
			if (sel == 1) {
			} else if (sel == 3) {
			
			} else if (sel == 4) {
				
			} else if (sel == 100) {
				
			}
		}
	}

	void loginMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.����] [2.��ٱ��ϸ��] [0.�ڷΰ���]");
			int sel = scan.nextInt();
			if (sel == 1) {
				shopMenu();
			} else if (sel == 2) {
				cartMenu();
			} else if (sel == 0) {
				break;
			}
		}
	}

	void cartMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.�� ��ٱ���] [2.����] [3.����] [0.�ڷΰ���]");
			int sel = scan.nextInt();
			if (sel == 1) {
				im.printJang(um.userList.get(um.userLog));
			} else if (sel == 0) {
				break;
			}
		}
	}

	void shopMenu() {
	}
	void managerMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.�����۰���] [2.ī�װ�����] [3.��ٱ��ϰ���] [4.��������] [0.�ڷΰ���] ");
			int sel = scan.nextInt();
			if (sel == 1) {
				itemMenu();
			} else if (sel == 2) {
				categoryMenu();
			} else if (sel == 3) {

			} else if (sel == 4) {
				userMenu();
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	void categoryMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.��üī�װ�] [2.ī�װ��߰�] [3.ī�װ�����] [0.�ڷΰ���]");
			int sel = scan.nextInt();
			if (sel == 1) {
			} else if (sel == 2) {

			} else if (sel == 0) {
				run = false;
			}
		}
	}

	void itemMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.��ü������] [2.�������߰�] [3.�����ۻ���] [0.�ڷΰ���]");
			int sel = scan.nextInt();
			if (sel == 1) {
			} else if (sel == 2) {
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	void userMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.��ü����] [2.�����߰�] [3.��������] [0.�ڷΰ���]");
			int sel = scan.nextInt();
			if (sel == 1) {
				um.printUser();
			} else if (sel == 0) {
				run = false;
			}
		}
	}
}