package controller;

import java.util.ArrayList;
import java.util.Random;

import models.����;

public class ���¸Ŵ���{
	static ���¸Ŵ��� instance = new ���¸Ŵ���();
	private ArrayList<����> accs = new ArrayList<����>();
	private ����ڸŴ��� um = ����ڸŴ���.instance;
	
	public void inputMoney(int log) {
		int accIdx = selectUserAccs(log,"�Ա���");
		/////////////////////////////

		System.out.print("�Աݱݾ� : ");
		String input = ����Ŵ���.sc.next();
		try {

			int money = Integer.parseInt(input);

			int balance = this.accs.get(accIdx).getMoney();
			balance += money;
			this.accs.get(accIdx).setMoney(balance);

		} catch (Exception e) {
		}
	}
	public void outMoney(int log) {
		int accIdx = selectUserAccs(log,"�����");

		System.out.println("��ݱݾ� : ");
		String input = ����Ŵ���.sc.next();

		try {
			int money = Integer.parseInt(input);

			int balance = this.accs.get(accIdx).getMoney();

			if (money < balance) {
				balance -= money;
				this.accs.get(accIdx).setMoney(balance);
			} else {
				System.out.println("�ܾ��� �����մϴ�.");
			}

		} catch (Exception e) {

		}
	}
	public void dropAccount(int log) {
		if (um.getUserAccSize(log) > 1) {
			
			int delAccIdx = selectUserAccs(log,"������");
			
			int defaultAccIdx = selectUserAccs(log, "�⺻");

			if (delAccIdx != defaultAccIdx) {
				int money = this.accs.get(delAccIdx).getMoney();
				int balance = this.accs.get(defaultAccIdx).getMoney();
				balance += money;
				this.accs.get(defaultAccIdx).setMoney(money);
			
				���� delAcc = this.accs.get(delAccIdx);
				this.accs.remove(delAcc);
				um.removeAcc(log, delAcc);
				
			}
		}
	}
	public int selectUserAccs(int log, String sub) {
		printUserAccs(log);

		int accIdx = -1;

		System.out.printf("%s���� ���� (1~%d): ", sub, um.getUserAccSize(log));
		String input = ����Ŵ���.sc.next();
		try {
			accIdx = Integer.parseInt(input) - 1;
			return accIdx;
		} catch (Exception e) {
			return accIdx;
		}

	}
	public void printUserAccs(int log) {
		// �α����� ȸ���� ���¸� �����ؼ� ���������� ������
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
		System.out.print("��ü�� ���¹�ȣ : ");
		String input = ����Ŵ���.sc.next();

		System.out.println("��ü�� �ݾ� : ");
		String input2 = ����Ŵ���.sc.next();

		try {
			int accNum = Integer.parseInt(input);
			int money = Integer.parseInt(input2);

			// ���� ���� Ȯ��
			int accIdx = -1;
			for (int i = 0; i < this.accs.size(); i++) {
				if (this.accs.get(i).getAccNum() == accNum) {
					accIdx = i;
				}
			}

			// �� ���� Ȯ��
			int myAccIdx = selectUserAccs(log,"�����");
			int balance = this.accs.get(myAccIdx).getMoney();

			if (balance >= money && myAccIdx != accIdx) {
				// ��ü����
				balance -= money;
				this.accs.get(myAccIdx).setMoney(balance);

				balance = this.accs.get(accIdx).getMoney();
				balance += money;
				this.accs.get(accIdx).setMoney(balance);

			} else {
				System.out.println("������ �ܾ��� Ȯ���ϼ���");
			}

		} catch (Exception e) {

		}

	}
	public int getUserCode(int log) {
		int userCode = um.getUser(log).getCode();
		return userCode;

	}
	public void createAcc(int log) {
		if (um.getUserAccSize(log) < ����.MAX) {
			���� newAcc = new ����(getUserCode(log), ranAccNum());
			this.accs.add(newAcc);
			um.addAcc(log, newAcc);
		} else {
			System.out.println("���̻� ������ �Ұ����մϴ�");
		}
	}
	public int ranAccNum() {
		Random rn = new Random();

		boolean check = false;
		while (true) {
			int rNum = rn.nextInt(89999) + 10000;

			for (���� acc : accs) {
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
	
	public ���� getAcc(int index) {
		return this.accs.get(index);
	}
	
	public void addAcc(���� e) {
		this.accs.add(e);
	}


}