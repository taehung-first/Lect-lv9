package zombie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game  {
	Random rm = new Random();
	Scanner sc = new Scanner(System.in);
	private Game() {}
	private static Game instance = new Game();
	public static Game getinstance() {return instance;}
	private Unit p;
	private ArrayList<Unit> enemy = new ArrayList<>();
	
	private void info() {
		p = new Hero("����",100,5,1,1);
		enemy.add(new Zombie("����",20,5,1,1));
	}
}
