package zombie;

import java.util.Random;
import java.util.Scanner; 


public class Hero extends Unit{
	Random ran = new Random();
	private int cnt = 3;
	public static Hero instance;
	
	public Hero(String name,int hp,int att,int def,int pos) {
		super(name, hp, att, def,pos);
		// TODO Auto-generated constructor stub
	}

	public int getcnt() {
		return cnt;
	}
	public void drink() {
		if(cnt>0) {
			System.out.println("ȸ������ ���ʴϴ�.");
			System.out.println("ü���� 100ȸ�� �Ǿ����ϴ�.");
			this.sethp(this.gethp()+100);
			System.out.println(this.getname()+"�� ���� ü�� : "+this.gethp());
			cnt--;
		}
		else {
			System.out.println("������ �����ϴ�.");
		}
	}
	public void attack(Unit target) {
		if(target instanceof Boss) {
			if(((Boss) target).shield>0) {
				int dam = (this.getatt() - target.getdef())*(ran.nextInt(150)+50)/100;
				if(dam<=0) {dam = 1;}
				System.out.println(getname()+"�� ����!");
				System.out.println(dam+"�� �����!");
				((Boss) target).setshield(((Boss) target).getshield()-dam);
				if(((Boss) target).getshield()<=0) {
					System.out.println(target.getname()+"�� ���尡 �ڻ쳵��!");
					((Boss) target).setshield(0);
				}
				System.out.println(target.getname()+"�� ���� ü�� : "+target.gethp()+" (���� : "+((Boss) target).getshield()+")");
			}
			else {
				super.attack(target);
			}
		}
		else {
			super.attack(target);
		}
	}

}