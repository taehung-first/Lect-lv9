package zombie;

import java.util.ArrayList;

public class WeaponManager {
	public Game g = Game.getinstance();
	public Hero p = Hero.instance;
	public static WeaponManager instance = new WeaponManager();

	public ArrayList<Weapon> garage = new ArrayList<>();
	
	
	public void SuperSuperRare() {
		System.out.println("test3");
		p.setatt(p.getatt() + 50);
		System.out.println("���ݷ��� " + 50 + "��ŭ �����ߴ�!");
	}
	public void SuperRare() {
		System.out.println("test2");
		p.setatt(p.getatt() + 25);
		System.out.println("���ݷ��� " + 25 + "��ŭ �����ߴ�!");
	}
	public void Rare() {
		System.out.println("test1");
		p.setatt(p.getatt() + 10);
		System.out.println("���ݷ��� " + 10 + "��ŭ �����ߴ�!");
	}
	public void Nomal() {
		System.out.println("test");
		p.setatt(p.getatt() + 5);
		System.out.println("���ݷ��� " + 5 + "��ŭ �����ߴ�!");
	}
}
