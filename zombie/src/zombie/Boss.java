package zombie;

public class Boss extends Unit{
	int shield;
	public Boss(String name,int hp,int att,int def,int pos,int shield) {
		super(name, hp, att, def,pos);
		this.shield = shield;
		// TODO Auto-generated constructor stub
	}
	public int getshield() {
		return shield;
	}
	public void setshield(int shield) {
		this.shield = shield;
	}
	public void attack(Unit target) {
		if(ran.nextInt(100)>74) {
			int dam = (this.getatt() - target.getdef())*(ran.nextInt(150)+50)/100;
			if(dam<=0) {dam = 1;}
			dam*=2;
			System.out.println(getname()+"�� �ʻ��!!!!!!");
			System.out.println(dam+"�� �����!");
			target.sethp(target.gethp()-dam);
			System.out.println(target.getname()+"�� ���� ü�� : "+target.gethp());
		}else {
			super.attack(target);
		}
	}

}
