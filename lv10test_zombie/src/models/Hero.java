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
				System.out.println(this.getName() + "�� ����");
				System.out.println(enemy.getName() + "�� ���尡 ����������: " + deal);
				((ZombieKing) enemy).setShield(((ZombieKing) enemy).getShield() - deal);
				if (((ZombieKing) enemy).getShield() <= 0) {
					System.out.println(enemy.getName() + "�� ���尡 �������ϴ�");
					((ZombieKing) enemy).setShield(0);
				}
				System.out.println(enemy.getName() + "�� ���� ü�� : " + enemy.getHp());
			} else {
				super.attack(enemy);
			}

		} else {
			super.attack(enemy);
		}

	}

	public void drink() {
		if (this.getCnt() > 0) {
			System.out.println("ȸ������ ���ʴϴ�");
			System.out.println("ü��100 ȸ��");
			this.setHp(this.getHp() + 100);
			System.out.println(this.getName() + "�� ����ü��: " + this.getHp());
			this.setCnt(this.getCnt() - 1);
		}
	}

}