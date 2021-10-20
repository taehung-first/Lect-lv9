package control;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.Hero;

public class Game {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	private Game() {
		
	}
	private static Game instance = new Game();
	public static Game getInstance() {
		return instance;
	}
	private Hero h;
	private ArrayList<Unit> enemy = new ArrayList<>(); 
	private void init() {
		
	}
	
}
