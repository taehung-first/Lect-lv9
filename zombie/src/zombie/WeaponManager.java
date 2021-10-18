package zombie;

public abstract class WeaponManager{
	private String name;
	private int dmg;
	private int dura;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDmg() {
		return dmg;
	}
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
	public int getDura() {
		return dura;
	}
	public void setDura(int dura) {
		this.dura = dura;
	}
	WeaponManager(String name, int dmg, int dura){
		this.name = name;
		this.dmg = dmg;
		this.dura = dura;
	}
	public void equip(Hero ) {
		int dmg = (this.att+Weapon.dmg); 
	}

}
