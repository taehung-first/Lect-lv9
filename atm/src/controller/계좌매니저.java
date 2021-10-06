package controller;

import java.util.ArrayList;
import java.util.Random;

import models.계좌;

public class 계좌매니저 {
	
	public static 계좌매니저 instance = new 계좌매니저();
	private UserManager um = UserManager.instance;
	private ArrayList<계좌> accs = new ArrayList<>();
	
	public void inputMoney(int log) {
		int accIdx = selectUserAccs(log,"입금");

		System.out.print("입금금액 : ");
		String input = 은행매니저.sc.next();
		try {

			int money = Integer.parseInt(input);

			int balance = this.accs.get(accIdx).getMoney();
			balance += money;
			this.accs.get(accIdx).setMoney(balance);
		} catch (Exception e) {
			
		}
	}

	public void outMoney(int log) {
		int accIdx = selectUserAccs(log,"출금할");

		System.out.println("출금금액 : ");
		String input = 은행매니저.sc.next();

		try {
			int money = Integer.parseInt(input);
			int balance = this.accs.get(accIdx).getMoney();
			
			if (money < balance) {
				balance -= money;
				this.accs.get(accIdx).setMoney(balance);
			} else {
				System.out.println("잔액이 부족합니다.");
			}
		} catch (Exception e) {
		}
	}

	public void dropAccount(int log) {
		if (um.getUserAccSize(log) > 1) {
			
			int delAccIdx = selectUserAccs(log,"삭제할");
			
			int defaultAccIdx = selectUserAccs(log, "기본");

			if (delAccIdx != defaultAccIdx) {
				int money = this.accs.get(delAccIdx).getMoney();
				int balance = this.accs.get(defaultAccIdx).getMoney();
				balance += money;
				this.accs.get(defaultAccIdx).setMoney(money);
			
				계좌 delAcc = this.accs.get(delAccIdx);
				this.accs.remove(delAcc);
				um.removeAcc(log, delAcc);
				
			}

		}

	}

	public int selectUserAccs(int log, String sub) {
		printUserAccs(log);

		int accIdx = -1;

		System.out.printf("%s계좌 선택 (1~%d): ", sub, um.getUserAccSize(log));
		String input = 은행매니저.sc.next();
		
		try {
			
			int idx = Integer.parseInt(input);
			
			int cnt=0;
			for(int i=0;i<this.accs.size();i++) {
				if(this.accs.get(i).getUserCode()==getUserCode(log)) {
					cnt++;
					if(cnt==idx) {
						accIdx=i;
					}
				}
			}
			return accIdx;
		} catch (Exception e) {
			return accIdx;
		}

	}

	public void printUserAccs(int log) {
		int index = -1;
		int n = 0;
		for (int i = 0; i < this.accs.size(); i++) {
			if (this.accs.get(i).getUserCode() == getUserCode(log)) {
				System.out.println(n + 1 + ")" + this.accs.get(i));
				index = i;
				n++;
			}
		}
	}

	public void moveMoney(int log) {
		System.out.print("이체할 계좌번호 : ");
		String input = 은행매니저.sc.next();

		System.out.println("이체할 금액 : ");
		String input2 = 은행매니저.sc.next();

		try {
			int accNum = Integer.parseInt(input);
			int money = Integer.parseInt(input2);

			int accIdx = -1;
			for (int i = 0; i < this.accs.size(); i++) {
				if (this.accs.get(i).getAccNum() == accNum) {
					accIdx = i;
				}
			}

			int myAccIdx = selectUserAccs(log,"출금할");
			int balance = this.accs.get(myAccIdx).getMoney();

			if (balance >= money && myAccIdx != accIdx) {
				balance -= money;
				this.accs.get(myAccIdx).setMoney(balance);

				balance = this.accs.get(accIdx).getMoney();
				balance += money;
				this.accs.get(accIdx).setMoney(balance);

			} else {
				System.out.println("계좌의 잔액을 확인하세요");
			}

		} catch (Exception e) {

		}

	}

	public int getUserCode(int log) {
		int userCode = um.getUser(log).getCode();
		return userCode;

	}

	public void createAcc(int log) {
		if (um.getUserAccSize(log) < 계좌.MAX) {
			계좌 newAcc = new 계좌(getUserCode(log), ranAccNum());
			this.accs.add(newAcc);
			um.addAcc(log, newAcc);
		} else {
			System.out.println("더이상 가입이 불가능합니다");
		}
	}

	public int ranAccNum() {
		Random rn = new Random();

		boolean check = false;
		while (true) {
			int rNum = rn.nextInt(89999) + 10000;

			for (계좌 acc : accs) {
				if (rNum == acc.getAccNum()) {
					check = true;
				}
			}
			if (!check) {
				return rNum;
			}
		}
	}
	
	public int getAccsSize() {
		return this.accs.size();
	}
	public 계좌 getAcc(int index) {
		return this.accs.get(index);
	}
	public void addAcc(계좌 e) {
		this.accs.add(e);
	}

}