package models;

import models.Unit;
import models.ZombieKing;
import control.Game;

public class Hero extends Unit {

	public Hero(String name, int hp, int att, int def, int pos) {
		super(name, hp, att, def, pos);
		// TODO Auto-generated constructor stub
	}

	private int cnt = 3;

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void attack(Unit enemy) {
		if (enemy instanceof ZombieKing) {
			if (((ZombieKing) enemy).getShield() > 0) {
				int deal = (this.getAtt() - enemy.getDef()) * (Game.rn.nextInt(150) + 50) / 100;
				if (deal <= 0) {
					deal = 1;
				}
				System.out.println(this.getName() + "의 공격");
				System.out.println(enemy.getName() + "의 쉴드가 받은데미지: " + deal);
				((ZombieKing) enemy).setShield(((ZombieKing) enemy).getShield() - deal);
				if (((ZombieKing) enemy).getShield() <= 0) {
					System.out.println(enemy.getName() + "의 쉴드가 깨졌습니다");
					((ZombieKing) enemy).setShield(0);
				}
				System.out.println(enemy.getName() + "의 남은 체력 : " + enemy.getHp());
			} else {
				super.attack(enemy);
			}

		} else {
			super.attack(enemy);
		}

	}

	public void drink() {
		if (this.getCnt() > 0) {
			System.out.println("회복약을 마십니다");
			System.out.println("체력100 회복");
			this.setHp(this.getHp() + 100);
			System.out.println(this.getName() + "의 남은체력: " + this.getHp());
			this.setCnt(this.getCnt() - 1);
		}
	}

}