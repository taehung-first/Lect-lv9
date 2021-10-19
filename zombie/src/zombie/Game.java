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
		enemy.add(new Zombie("좀비", 20, 5, 3, ran.nextInt(99)+1));
		enemy.add(new Zombie("약한좀비", 20, 3, 5, ran.nextInt(99)+1));
		enemy.add(new Zombie("정예좀비", 40, 7, 5, ran.nextInt(89)+20));
		enemy.add(new Boss("보스", 200, 7, 10, ran.nextInt(49)+50, 30));
	}
	private int chk() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getpos() == enemy.get(i).getpos()) {
				System.out.println("좀비가 나타났다!!!");
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
			System.out.println("[무엇을 할까? ]");
			System.out.println("1.공격   2.물약(" + p.getcnt() + "개 남음)");
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
			System.out.println("사망했다.....");
			return false;
		} 
		else {
			System.out.println("승리했다!");
			int check = 0;
			int weaponBox = 0;
			while (check == 0) {
				weaponBox = (int) (Math.random() * (1000 - 1 + 1) + 1);
				if (1 <= weaponBox && weaponBox <= 3) {
					System.out.print("**==SSR==무기가 떨어졌다");
					System.out.println("무기를 장착 하시겠습니까? 1)예 2) 아니요");
					int sel = sc.nextInt();
					if (sel == 1) {
						Weapon wp = new Weapon("SSR",50);
						wpm.garage.add(wp);
						System.out.println("SSR무기를 장착하였습니다.");
						wpm.SuperSuperRare();
						check = 1;
					} else if (sel == 2) {
						System.out.println("무기를 버렸습니다.");
						check = 1;
					}
				} else if (4 <= weaponBox && weaponBox <= 13) {
					System.out.print("*==SR==무기가 떨어졌다");
					System.out.println("무기를 장착 하시겠습니까? 1)예 2) 아니요");
					int sel = sc.nextInt();
					if (sel == 1) {
						Weapon wp = new Weapon("SR",50);
						wpm.garage.add(wp);
						System.out.println("SR무기를 장착하였습니다.");
						wpm.SuperRare();
						check = 1;
					} else if (sel == 2) {
						System.out.println("무기를 버렸습니다.");
						check = 1;
					}
				} else if (14 <= weaponBox && weaponBox <= 30) {
					System.out.print("==R==무기가 떨어졌다");
					System.out.println("무기를 장착 하시겠습니까? 1)예 2) 아니요");
					int sel = sc.nextInt();
					if (sel == 1) {
						Weapon wp = new Weapon("R",50);
						wpm.garage.add(wp);
						System.out.println("R무기를 장착하였습니다.");
						wpm.Rare();
						check = 1;
					} else if (sel == 2) {
						System.out.println("무기를 버렸습니다.");
						check = 1;
					}
				} else if (31 <= weaponBox && weaponBox <= 1000) {
					System.out.println("==N==무기가 떨어졌다");
					System.out.println("무기를 장착 하시겠습니까? 1)예 2) 아니요");
					int sel = sc.nextInt();
					if (sel == 1) {
						Weapon wp = new Weapon("N",50);
						wpm.garage.add(wp);
						System.out.println("N무기를 장착하였습니다.");
						wpm.Nomal();
						check = 1;
					} else if (sel == 2) {
						System.out.println("무기를 버렸습니다.");
						check = 1;
					}
				}
			}
		}
		return true;
	}

	private void map(int a) {
		System.out.println("[ 현재 층 : " + p.getpos() + " ]");
		System.out.println("[1] : 올라간다");
		if (a == 1) {
			System.out.println("[2] : 체력을 회복한다.");
			System.out.println("[3] : 무기를 강화한다.");
		}
	}

	public void run() {
		info();
		int act = 1;
		while (true) {
			if (p.getpos() >= 50) {
				System.out.println("생존에 성공했다!!");
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
					System.out.println("아무일도 일어나지 않았다..");
				}
				act = 1;
			} else if (sel == 2 && act == 1) {
				int rnum = ran.nextInt(40) + 20;
				p.sethp(p.gethp() + rnum);
				System.out.println("체력을 " + rnum + "만큼 회복했다!");
				act = 2;
			} else if (sel == 3 && act == 1) {
				int rnum = ran.nextInt(2) + 1;
				if (rnum == 1) {
					rnum = ran.nextInt(3) + 1;
					p.setatt(p.getatt() + rnum);
					System.out.println("공격력이 " + rnum + "만큼 증가했다!");
				} else if (rnum == 2) {
					rnum = ran.nextInt(3) + 1;
					p.setdef(p.getdef() + rnum);
					System.out.println("방어력이 " + rnum + "만큼 증가했다!");
				}
				act = 2;
			}
		}
	}

}
