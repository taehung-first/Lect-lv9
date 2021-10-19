package zombie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);

	private static Game instance = new Game();

	public static Game getinstance() {
		return instance;
	}

	public Hero p= Hero.instance;
	public WeaponManager wpm = WeaponManager.instance;
	private ArrayList<Unit> enemy = new ArrayList<>();

	private void info() {
		enemy.add(new Zombie("����", 20, 5, 3, ran.nextInt(99)+1));
		enemy.add(new Zombie("��������", 20, 3, 5, ran.nextInt(99)+1));
		enemy.add(new Zombie("��������", 40, 7, 5, ran.nextInt(89)+20));
		enemy.add(new Boss("����", 200, 7, 10, ran.nextInt(49)+50, 30));
	}
	private int chk() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getpos() == enemy.get(i).getpos()) {
				System.out.println("���� ��Ÿ����!!!");
				return i;
			}
		}
		return -1;
	}
	private int die(Unit a) {
		if (p.gethp() <= 0) {
			return 1;
		} else if (a.gethp() <= 0) {
			return 2;
		} else {
			return 0;
		}
	}

	private boolean fight(Unit enemy) {
		while (true) {
			p.print();
			System.out.println("===== VS =====");
			enemy.print();
			System.out.println("--------------");
			System.out.println("[������ �ұ�? ]");
			System.out.println("1.����   2.����(" + p.getcnt() + "�� ����)");
			int sel = sc.nextInt();
			if (sel == 1) {
				p.attack(enemy);
			} else if (sel == 2) {
				p.drink();
			}
			if (die(enemy) != 0) {
				break;
			}
			System.out.println();
			enemy.attack(p);
			if (die(enemy) != 0) {
				break;
			}
			System.out.println();
		}
		if (die(enemy) == 1) {
			System.out.println("����ߴ�.....");
			return false;
		} 
		else {
			System.out.println("�¸��ߴ�!");
			int check = 0;
			int weaponBox = 0;
			while (check == 0) {
				weaponBox = (int) (Math.random() * (1000 - 1 + 1) + 1);
				if (1 <= weaponBox && weaponBox <= 3) {
					System.out.print("**==SSR==���Ⱑ ��������");
					System.out.println("���⸦ ���� �Ͻðڽ��ϱ�? 1)�� 2) �ƴϿ�");
					int sel = sc.nextInt();
					if (sel == 1) {
						Weapon wp = new Weapon("SSR",50);
						wpm.garage.add(wp);
						System.out.println("SSR���⸦ �����Ͽ����ϴ�.");
						wpm.SuperSuperRare();
						check = 1;
					} else if (sel == 2) {
						System.out.println("���⸦ ���Ƚ��ϴ�.");
						check = 1;
					}
				} else if (4 <= weaponBox && weaponBox <= 13) {
					System.out.print("*==SR==���Ⱑ ��������");
					System.out.println("���⸦ ���� �Ͻðڽ��ϱ�? 1)�� 2) �ƴϿ�");
					int sel = sc.nextInt();
					if (sel == 1) {
						Weapon wp = new Weapon("SR",50);
						wpm.garage.add(wp);
						System.out.println("SR���⸦ �����Ͽ����ϴ�.");
						wpm.SuperRare();
						check = 1;
					} else if (sel == 2) {
						System.out.println("���⸦ ���Ƚ��ϴ�.");
						check = 1;
					}
				} else if (14 <= weaponBox && weaponBox <= 30) {
					System.out.print("==R==���Ⱑ ��������");
					System.out.println("���⸦ ���� �Ͻðڽ��ϱ�? 1)�� 2) �ƴϿ�");
					int sel = sc.nextInt();
					if (sel == 1) {
						Weapon wp = new Weapon("R",50);
						wpm.garage.add(wp);
						System.out.println("R���⸦ �����Ͽ����ϴ�.");
						wpm.Rare();
						check = 1;
					} else if (sel == 2) {
						System.out.println("���⸦ ���Ƚ��ϴ�.");
						check = 1;
					}
				} else if (31 <= weaponBox && weaponBox <= 1000) {
					System.out.println("==N==���Ⱑ ��������");
					System.out.println("���⸦ ���� �Ͻðڽ��ϱ�? 1)�� 2) �ƴϿ�");
					int sel = sc.nextInt();
					if (sel == 1) {
						Weapon wp = new Weapon("N",50);
						wpm.garage.add(wp);
						System.out.println("N���⸦ �����Ͽ����ϴ�.");
						wpm.Nomal();
						check = 1;
					} else if (sel == 2) {
						System.out.println("���⸦ ���Ƚ��ϴ�.");
						check = 1;
					}
				}
			}
		}
		return true;
	}

	private void map(int a) {
		System.out.println("[ ���� �� : " + p.getpos() + " ]");
		System.out.println("[1] : �ö󰣴�");
		if (a == 1) {
			System.out.println("[2] : ü���� ȸ���Ѵ�.");
			System.out.println("[3] : ���⸦ ��ȭ�Ѵ�.");
		}
	}

	public void run() {
		info();
		int act = 1;
		while (true) {
			if (p.getpos() >= 50) {
				System.out.println("������ �����ߴ�!!");
				break;
			}
			map(act);
			int sel = sc.nextInt();
			if (sel == 1) {
				p.setpos(p.getpos() + 1);
				int chk = chk();
				if (chk != -1) {
					boolean a = fight(enemy.get(chk));
					if (a == false) {
						break;
					}
				} else {
					System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҴ�..");
				}
				act = 1;
			} else if (sel == 2 && act == 1) {
				int rnum = ran.nextInt(40) + 20;
				p.sethp(p.gethp() + rnum);
				System.out.println("ü���� " + rnum + "��ŭ ȸ���ߴ�!");
				act = 2;
			} else if (sel == 3 && act == 1) {
				int rnum = ran.nextInt(2) + 1;
				if (rnum == 1) {
					rnum = ran.nextInt(3) + 1;
					p.setatt(p.getatt() + rnum);
					System.out.println("���ݷ��� " + rnum + "��ŭ �����ߴ�!");
				} else if (rnum == 2) {
					rnum = ran.nextInt(3) + 1;
					p.setdef(p.getdef() + rnum);
					System.out.println("������ " + rnum + "��ŭ �����ߴ�!");
				}
				act = 2;
			}
		}
	}

}
