package controler;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.�����;
public class ����ڰ��� {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();
	static ����ڰ��� instance = new ����ڰ���();
	public Vector<�����> userList = new Vector<�����>();
	public int log;
	
	public ����ڰ���(){
		inti();
	}
	void inti() {
		for(int i=0; i<10;i++) {
			String []a = { "��", "��", "��", "��", "��", "��" };
			String []b = { "ö", "��", "��", "��", "��", "��" };
			String []c = { "��", "��", "��", "��", "��", "��" };
			
			int r = rn.nextInt(a.length);
			String name = a[r];
			r = rn.nextInt(b.length);
			name +=b[r];
			r = rn.nextInt(c.length);
			name +=c[r];
			
			r = rn.nextInt(10000);
			int money = r;
			����� temp = new �����(name,money);
			userList.add(temp);
		}
	}
	public void join() {
		int check = -1;
		System.out.println("���̵� �Է�:");
		String id = sc.next();
		
		for(int i=0;i<userList.size();i++) {
			if(id.equals(userList.get(i).id)) {
				check = i ;
				break;
			}
		}
		if(check==-1) {
			System.out.println(id +"�� ������ ȯ���մϴ�.");
			����� temp = new �����(id, 0);
		userList.add(temp);
		
		}
		else {
			System.out.println("�ߺ��Ǵ� ���̵�");
			return;
		}
	}
	
	
}
