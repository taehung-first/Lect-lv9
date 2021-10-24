package control;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.Hero;
import models.Unit;
import models.Zombie;
import models.ZombieKing;

public class Game {
	// 싱글톤
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
		p = new Hero("용사", 500, 5, 1, 1); // Hero클래스 생성자를 public 해야 이코드 작동
		enemyList.add(new Zombie("초보좀비", 100, 5, 1, 3)); // Zombie도 위와 마찬가지
		enemyList.add(new Zombie("중급좀비", 150, 10, 2, 6));
		enemyList.add(new Zombie("고급좀비", 200, 15, 3, 9));
		enemyList.add(new ZombieKing("좀비킹", 300, 20, 4, 12, 50));
	}

	public void run() {
		init();
		int act = 1;
		while (true) {
			if (p.getPos() >= 12) {
				System.out.println("모든관문 통과!!");
				break;
			}
			printMenu(act);
			int sel = sc.nextInt();
			if (sel == 1) {
				p.setPos(p.getPos() + 1);
				int enemyN = check();
				if (enemyN == -1) {
					System.out.println("아무일도 일어나지 않았다");
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
		System.out.println("좀비발견!");
		while (true) {
			p.print();
			System.out.println("=========VS===========");
			enemy.print();
			System.out.println("[무엇을 할까? ]");
			System.out.println("1.공격 2.물약 (" + p.getCnt() + "개 남음)");
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
			System.out.println("용사가 사망했다.");
			return false;
		} else {
			System.out.println("승리했다");
			return true;
		}
	}

	private int die(Unit enemy) {
		if (p.getHp() <= 0) {
			return 1; // 플레이어 죽음
		} else if (enemy.getHp() <= 0) {
			return 2; // 좀비죽음
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
			System.out.println("공격력이 " + addAtt + "만큼 증가되었습니다");
		} else if (rN == 2) {
			int addDef = rn.nextInt(3) + 1;
			p.setDef(p.getDef() + addDef);
			System.out.println("방어력이 " + addDef + "만큼 증가되었습니다");
		}
		return act = 2;
	}

	private int heal(int act, Hero p) {
		int rHeal = rn.nextInt(50) + 20;
		p.setHp(p.getHp() + rHeal);
		System.out.println("체력이 " + rHeal + "만큼 회복되었습니다");
		return act = 2;
	}

	private void printMenu(int act) {
		System.out.println("[ 현재 층 : " + p.getPos() + "]");
		System.out.println("[1] : 올라간다");
		if (act == 1) {
			System.out.println("[2] : 체력을 회복한다");
			System.out.println("[3] : 무기를 강화한다");
		}
	}

}