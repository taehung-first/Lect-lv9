package zombie;

public class Hero extends Unit {
	private int cnt =3;
	public Hero (String name, int hp, int att, int def,int pos) {
		super(name, hp,att,def,pos);
	}
	public int getcnt() {
		return cnt;
		
	}
	public void drink() {
		if(cnt>0) {
			this.sethp(this.gethp()+100);
			System.out.println(this.getname()+"�� ���� ü�� : "+this.gethp());
			cnt--;
		}
		else {
			System.out.println("������ �ٻ���߽��ϴ�.");
		}
	}
	
}
