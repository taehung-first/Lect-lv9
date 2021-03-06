package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.계좌;
import models.사용자;

public class 사용자매니저 {
	public static 사용자매니저 instance = new 사용자매니저();
	Scanner sc = new Scanner(System.in);
	// User 배열이 존재
	private ArrayList<사용자> users = new ArrayList<사용자>();
	
	private 사용자매니저() {
		this.users = new ArrayList<>();
	}
	public void joinUser() {
		System.out.println("id : ");
		String id = 은행매니저.sc.next();
		System.out.println("pw : ");
		String pw = 은행매니저.sc.next();
		
		boolean check = false;
		for(사용자 user : users) {
			if(id.equals(user.getId()))
				check = true;
		}
		if(!check) {
			System.out.print("이름 입력 : ");
			String name = 은행매니저.sc.next();
			
			this.users.add(new 사용자(randomCode(), id, pw, name));
		}else {
			System.out.println("중복된 아이디 입니다.");
		}
	}
	public void addUser(사용자 e) {
		this.users.add(e);
	}
	public void removeUser() {
		System.out.println("id : ");
		String id = 은행매니저.sc.next();
		System.out.println("pw : ");
		String pw = 은행매니저.sc.next();
		
		사용자 delUser = null;
		for(사용자 user : users) {
			if(id.equals(user.getId())&&pw.equals(user.getPw())) {
				delUser = user;
			}else {
				System.out.println("아이디 또는 비밀번호가 틀립니다.");
			}
		}
		this.users.remove(delUser);
	}
	private int randomCode() {
		Random rn = new Random();
		
		while(true) {
			int rCode = rn.nextInt(8999)+1000;
			
			boolean check = false;
			for(사용자 user : users) {
				if(rCode == user.getCode())
					check = true;
			}
			if(!check)
				return rCode;
		}
	}
	public void removeAcc(int log, 계좌 e) {
		this.users.get(log).removeAcc(e);
	}
	// 탈퇴
	// 사이즈
	public int getUsersSize() {
		return this.users.size();
	}
	// 회원조회
	public 사용자 getUser(int index) {
		return this.users.get(index);
	}
	
	public int getUserAccSize(int log) {
		return this.users.get(log).getAccsSize();
	}
	
	public void addAcc(int log, 계좌 e) {
		this.users.get(log).addAcc(e);
	}
	
}
	
		
	
