package models;

import control.Game;

public class ZombieKing extends Unit {
	private int shield;
	public ZombieKing(String name, int hp, int att, int def, int pos, int shield) {
		super(name, hp, att, def, pos);
		this.shield = shield;
		// TODO Auto-generated constructor stub
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public void attack(Unit enemy) {
		if (Game.rn.nextInt(100) > 74) {
			int dam = (this.getAtt() - enemy.getDef()) * (Game.rn.nextInt(150) + 50) / 100;
			if (dam <= 0) {
				dam = 1;
			}
			dam *= 2;
			System.out.println(this.getName() + "의 필살기!!!!!!!!!!!");
			System.out.println(dam + "의 대미지!");
			enemy.setHp(enemy.getHp() - dam);
			System.out.println(enemy.getName() + "의 남은체력" + enemy.getHp());
		} else {
			super.attack(enemy);
		}
	}
}