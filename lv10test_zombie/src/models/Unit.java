package models;

import control.Game;

public abstract class Unit {
	private String name;
	private int hp;
	private int att;
	private int def;
	private int pos;

	public int getPos() {
		return pos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	Unit(String name, int hp, int att, int def, int pos) {
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.pos = pos;
	}

	public void print() {
		System.out.println("[이름 ] : " + this.getName() + " [체력 ] : " + this.getHp());
		System.out.println("[공격력 ] : " + this.getAtt() + "[방어력 ] : " + this.getDef());
	}

	public void attack(Unit enemy) {
		int rN = Game.rn.nextInt(150) + 50;
		int deal = (this.getAtt() - enemy.getDef()) * rN / 100;
		if (deal <= 0) {
			deal = 1;
		}
		System.out.println(this.getName() + "의 공격!");
		System.out.println(deal + "의 데미지");
		enemy.setHp(enemy.getHp() - deal);
		System.out.println(enemy.getName() + "의 남은 체력 : " + enemy.getHp());
	}

}