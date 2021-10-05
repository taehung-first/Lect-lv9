package controller;

import java.util.ArrayList;
import java.util.Scanner;

public class 은행매니저 {
	public static 은행매니저 instance = new 은행매니저();
	Scanner sc = new Scanner(System.in);
	private ArrayList<사용자> users = new ArrayList<사용자>();
	
	은행매니저(){
		this.users = new ArrayList<>();
	}


}
