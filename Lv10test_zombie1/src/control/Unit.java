package control;

import java.util.Random;

public class Unit {
	public static Unit instance = new Unit();
	Random ran = new Random();
	private String name;
	private int hp;
	private int att;
	private int pos;

	Unit(String name, int hp, int att, int pos) {
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.pos = pos;
	}

	public Unit() {
		// TODO Auto-generated constructor stub
	}

	public String getname() {
		return name;
	}

	public int gethp() {
		return hp;
	}

	public void sethp(int hp) {
		this.hp = hp;
	}

	public int getatt() {
		return att;
	}

	public void setatt(int att) {
		this.att = att;
	}


	public int getpos() {
		return pos;
	}

	public void setpos(int pos) {
		this.pos = pos;
	}

	public void attack(Unit target) {
		int dam = (this.att - target.hp);
		if (dam <= 0) {
			dam = 1;
		}
		System.out.println(name + "�� ����");
		System.out.println(dam + "�� �����");
		target.sethp(target.gethp() - dam);
		System.out.println(target.name + "�� ���� ü�� : " + target.hp);
	}

	public void print() {
		System.out.println("[�̸�] : " + name + "    [ü��] : " + hp);
		System.out.println("[���ݷ�] : " + att + "    [��ġ] : " + pos);
	}
}
