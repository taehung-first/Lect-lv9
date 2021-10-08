package models;

import java.util.Scanner;

import controler.ItemManager;
import controler.UserManager;
import models.User;

	public class Shop {
		Scanner scan = new Scanner(System.in);
		private UserManager um = new UserManager();
		private ItemManager im = new ItemManager();

		public void MainMenu() {
			while (true) {
				um.printID();

				System.out.println("[1.����] [2.Ż��] [3.�α���] [4.�α׾ƿ�]" + "\n[100.������] [0.����] ");
				int sel = scan.nextInt();

				if (sel == 1) {
					um.join();
				} else if (sel == 2) {
					um.remove();
				} else if (sel == 3) {
					if (um.logIn()) {
						loginMenu();
					}
				} else if (sel == 4) {
					um.logOut();
				} else if (sel == 100) {
					ManagerMenu();
				} else if (sel == 0) {
					System.out.println("���α׷� ����");
					break;
				}
			}
		}

		void loginMenu() {

			while (true) {

				System.out.println("[1.����] [2.��ٱ��ϸ��] [0.�ڷΰ���]");
				int sel = scan.nextInt();

				if (sel == 1) {
					while (true) {
						String usID = um.userList.get(um.log).getId();
						System.out.println("ī�װ��� �����ϼ���. [����:-1]");
						im.printCategory();
						int caID = scan.nextInt();
						if (caID == -1) {
							break;
						}
						System.out.println("�������� �����ϼ���.");
						im.printItem(caID);
						int itemID = scan.nextInt();
						im.addCart(usID, caID, itemID);
						System.out.println("�������� ��ٱ��Ͽ� �����ϴ�.");
					}
				} else if (sel == 2) {
					CartMenu();
				} else if (sel == 0) {
					break;
				}
			}
		}

		void CartMenu() {

			while (true) {
				System.out.println("[1.�� ��ٱ���] 2.[����] 3.[����] 0.[�ڷΰ���]");
				int sel = scan.nextInt();

				String id = um.userList.get(um.log).getId();
				int mo = um.userList.get(um.log).getMoney();
				User u = new User(id, mo);

				if (sel == 1) {
					im.printJang(u);
				} else if (sel == 2) {
					im.printJang(u);
					im.removeCart(u);
				} else if (sel == 3) {
					im.printJang(u);
					im.buyItem(u);
				} else if (sel == 0) {
					break;
				}
			}
		}

		void ManagerMenu() {
			while (true) {
				System.out.println("1)�����۰��� 2)ī�װ����� 3)��ٱ��ϰ��� 4)��������] [0.�ڷΰ���] ");
				int sel = scan.nextInt();
				if (sel == 1) {
					itemMenu();
				} else if (sel == 2) {
					cateMenu();
				} else if (sel == 3) {
					basket();
				} else if (sel == 4) {
					userMenu();
				} else if (sel == 0) {
					break;
				}
			}
		}

		void itemMenu() {
			while (true) {
				System.out.println("1)��üī�װ� 2.)�߰�] 3).���� 0)�ڷΰ���");
				int sel = scan.nextInt();
				if (sel == 1) {
					im.printItem();
				} else if (sel == 2) {
					im.addItem();
				} else if (sel == 3) {
					im.removeItem();
				} else if (sel == 0) {
					break;
				}
			}
		}
		void basket() {
			System.out.println("1)��ٱ���"+"0)�ڷΰ���" );
			int pik = scan.nextInt();
			int cont =0;
			while (cont==0) {
				System.out.println("1)��ٱ��� ��Ȳ 2)��ٱ��� ���� 0)�ڷΰ���");
				int sel = scan.nextInt();
				if(sel==1) {
					for(int i=0;i<um.userList.size();i++) {
						if(im.jangList.get(i) != null) {
							System.out.println("ȸ�� ID "+ um.userList.get(i).getId() +" ǰ�� "+im.jangList.get(i).ItemName);
						}
					}
				}else if(sel==2) {
					System.out.println("������ �������� �̸� ����");
					for(int i=0;i<im.jangList.size();i++) {
						im.jangList.get(i).print();
						String del = scan.next();
//						if(im.jangList.get(i)) {
//							
//						}
						
					}
				}else if(sel==0) {
					cont=-1;
				}
				if(pik==0) {
					MainMenu();
				}
			}
		}

		void cateMenu() {
			while (true) {
				System.out.println("1)��üī�װ� 2.)�߰�] 3).���� 0)�ڷΰ���");
				int sel = scan.nextInt();
				if (sel == 1) {
					im.printCategory();
				} else if (sel == 2) {
					im.addCategory();
				} else if (sel == 3) {
					im.removeCategory();
				} else if (sel == 0) {
					break;
				}
			}
		}

		void userMenu() {
			while(true) {
				System.out.println("[1.��ü����] [2.�߰�] [3.����] [0.�ڷΰ���]");
				int sel = scan.nextInt();
				if(sel==1) {
					um.print();
				}
				else if(sel==2) {
					um.join();
				}
				else if(sel==3) {
					um.remove();
				}
				else if(sel==0) {
					break;
				}
			}
		}
	}
