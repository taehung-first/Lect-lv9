package controler;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.사용자;
public class 사용자관리 {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();
	static 사용자관리 instance = new 사용자관리();
	public Vector<사용자> userList = new Vector<사용자>();
	public int log;
	
	public 사용자관리(){
		inti();
	}
	void inti() {
		for(int i=0; i<10;i++) {
			String []a = { "김", "박", "이", "최", "정", "오" };
			String []b = { "철", "병", "만", "여", "아", "영" };
			String []c = { "수", "욱", "수", "정", "름", "희" };
			
			int r = rn.nextInt(a.length);
			String name = a[r];
			r = rn.nextInt(b.length);
			name +=b[r];
			r = rn.nextInt(c.length);
			name +=c[r];
			
			r = rn.nextInt(10000);
			int money = r;
			사용자 temp = new 사용자(name,money);
			userList.add(temp);
		}
	}
	public void join() {
		int check = -1;
		System.out.println("아이디를 입력:");
		String id = sc.next();
		
		for(int i=0;i<userList.size();i++) {
			if(id.equals(userList.get(i).id)) {
				check = i ;
				break;
			}
		}
		if(check==-1) {
			System.out.println(id +"님 가입을 환영합니다.");
			사용자 temp = new 사용자(id, 0);
		userList.add(temp);
		
		}
		else {
			System.out.println("중복되는 아이디");
			return;
		}
	}
	
	
}
