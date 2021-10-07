package models;


import java.util.Scanner;

import controler.사용자관리;
import controler.아이템관리;

public class 상점 {
	
	Scanner scan = new Scanner(System.in);
	private 사용자관리 um = new 사용자관리();
	private 아이템관리 im = new 아이템관리();
	
	public void MainMenu() {
		while(true) {
			um.printID();
			
			
		}
	}
	
}
