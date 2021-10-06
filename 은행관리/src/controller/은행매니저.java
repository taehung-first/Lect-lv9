package controller;

import java.util.Scanner;

import models.은행;

public class 은행매니저{
	public static Scanner sc = new Scanner(System.in);
	static 은행매니저 instance = new 은행매니저();
	
	private 파일관리자 fm = 파일관리자.instance;
	private 사용자매니저 um = 사용자매니저.instance;
	private 계좌매니저 am = 계좌매니저.instance;
	
	public void run() {
		fm.load();
		boolean isRun = true;
		while(isRun) {
			System.out.println(은행.instance.getBrand()+ " ATM");
			
			printAllData();
			printMenu();
			isRun = selectMenu();
	
		}
		fm.save();
	}
	private void printAllData() {
		for(int i=0; i<um.getUsersSize(); i++) {
			System.out.println(um.getUser(i));
			
			for(int j=0; j<um.getUserAccSize(i); j++) {
				System.out.println(um.getUser(i).getAcc(j));
			}
		}
	}
	private void printMenu() {
		if(은행.log == -1) {
			System.out.println(" 1.로그인\n 2.회원가입\n 3.회원탈퇴\n 4.종료 ");			
		}else {
			System.out.println(" 1입금\n 2.출금\n 3.조회\n 4.이체\n 5.계좌생성\n 6.계좌철회\n 7.로그아웃");
		}
	}
	private boolean selectMenu() {
		System.out.println("menu : ");
		String input = sc.next();
		
		try {
			int sel = Integer.parseInt(input);
			
			if(은행.log == -1) {
				if(sel == 1) {
					login();
				}else if(sel == 2) {
					um.joinUser();
				}
				else if(sel == 3) {
					um.removeUser();
				}else if(sel == 4) {
					return false;
				}else {
					System.out.println("잘못된 선택입니다.");
				}
			}else {
				if(um.getUserAccSize(은행.log) > 0) {
					if(sel == 1) {
						am.inputMoney(은행.log);
					}else if(sel == 2) {
						am.outMoney(은행.log);
					}else if(sel == 3) {
						am.printUserAccs(은행.log);
					}else if(sel == 4) {
						am.moveMoney(은행.log);
					}else if(sel == 6) {
						am.dropAccount(은행.log);
					}
				}
				
				if(sel == 5) {
					am.createAcc(은행.log);
				}if(sel == 7) {
					logout();
				}
				
			}
		}catch(Exception e) {
			
		}
		return true;
	}
	private void login() {
		System.out.println("id : ");
		String id = sc.next();
		System.out.println("pw : ");
		String pw = sc.next();
		
		for(int i=0; i<um.getUsersSize(); i++) {
			if(id.equals(um.getUser(i).getId())&& pw.equals(um.getUser(i).getPw())) {
				은행.log = i;
			}
		}
		if(은행.log != -1) {
			System.out.println("로그인 성공");
		}
	}
	private void logout() {
		은행.log = -1;
	}
}