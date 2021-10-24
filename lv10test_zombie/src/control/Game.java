package control;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.Hero;
import models.Unit;
import models.Zombie;
import models.ZombieKing;

public class Game {
	// �̱���
	public static Game instance = new Game();

	private Game() {
	};

	public static Game getInstance() {
		return instance;
	}

	private Hero p;

	ArrayList<Unit> enemyList = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static Random rn = new Random();

	public void init() {
		p = new Hero("���", 300, 5, 1, 1); 
		enemyList.add(new Zombie("�ʺ�����", 100, 5, 1, 3));
		enemyList.add(new Zombie("�߱�����", 150, 10, 2, 6));
		enemyList.add(new Zombie("�������", 200, 15, 3, 9));
		enemyList.add(new ZombieKing("����ŷ", 300, 20, 4, 12, 50));
	}

	public void run() {
		init();
		int act = 1;
		while (true) {
			if (p.getPos() >= 12) {
				System.out.println("������ ���!!");
				break;
			}
			printMenu(act);
			int sel = sc.nextInt();
			if (sel == 1) {
				p.setPos(p.getPos() + 1);
				int enemyN = check();
				if (enemyN == -1) {
					System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҴ�");
				} else {
					boolean a = fight(enemyList.get(enemyN));
					if (a == false) {
						break;
					}

				}
				act = 1;

			} else if (sel == 2 && act == 1) {
				act = heal(act, p);
			} else if (sel == 3 && act == 1) {
				act = enchant(act, p);
			}
		}
	}

	private boolean fight(Unit enemy) {
		System.out.println("����߰�!");
		while (true) {
			p.print();
			System.out.println("=========VS===========");
			enemy.print();
			System.out.println("[������ �ұ�? ]");
			System.out.println("1.���� 2.���� (" + p.getCnt() + "�� ����)");
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
			System.out.println("��簡 ����ߴ�.");
			return false;
		} else {
			System.out.println("�¸��ߴ�");
			return true;
		}
	}

	private int die(Unit enemy) {
		if (p.getHp() <= 0) {
			return 1; 
		} else if (enemy.getHp() <= 0) {
			return 2; 
		}
		return 0;
	}

	private int check() {
		int idx = -1;
		for (int i = 0; i < enemyList.size(); i++) {
			if (enemyList.get(i).getPos() == p.getPos()) {
				idx = i;
			}
		}
		return idx;
	}

	private int enchant(int act, Hero p) {
		int rN = rn.nextInt(2) + 1;
		if (rN == 1) {
			int addAtt = rn.nextInt(5) + 1;
			p.setAtt(p.getAtt() + addAtt);
			System.out.println("���ݷ��� " + addAtt + "��ŭ �����Ǿ����ϴ�");
		} else if (rN == 2) {
			int addDef = rn.nextInt(3) + 1;
			p.setDef(p.getDef() + addDef);
			System.out.println("������ " + addDef + "��ŭ �����Ǿ����ϴ�");
		}
		return act = 2;
	}

	private int heal(int act, Hero p) {
		int rHeal = rn.nextInt(50) + 20;
		p.setHp(p.getHp() + rHeal);
		System.out.println("ü���� " + rHeal + "��ŭ ȸ���Ǿ����ϴ�");
		return act = 2;
	}

	private void printMenu(int act) {
		System.out.println("[ ���� �� : " + p.getPos() + "]");
		System.out.println("[1] : �ö󰣴�");
		if (act == 1) {
			System.out.println("[2] : ü���� ȸ���Ѵ�");
			System.out.println("[3] : ���⸦ ��ȭ�Ѵ�");
		}
	}

}