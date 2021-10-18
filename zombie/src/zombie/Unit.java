package zombie;
import java.util.Random;

public abstract class Unit {
	private String name;
	private int hp;
	private int att;
	private int def;
	private int pos;
	
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
	public int getdef() {
		return def;
	}
	public void setdef(int def) {
		this.def = def;
	}
	public int getpos() {
		return pos;
	}
	public void setpos(int pos) {
		this.pos = pos;
	}
	Unit(String name,int hp,int att,int def,int pos){
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.pos = pos;
	}
	public void attack(Unit target) {
		int dam = (this.att - target.def);
		if(dam<=0) {dam = 1;}
		System.out.println(name+"�� ����!");
		System.out.println(dam+"�� �����!");
		target.sethp(target.gethp()-dam);
		System.out.println(target.name+"�� ���� ü�� : "+target.hp);
	}
	public void print() {
		System.out.println("[�̸�] : "+name+"    [ü��] : "+hp);
		System.out.println("[���ݷ�] : "+att+"  [����] : "+def+"  [��ġ] : "+pos);
	}
}
