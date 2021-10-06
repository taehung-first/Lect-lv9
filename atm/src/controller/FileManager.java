import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import models.Account;
import models.User;

public class FileManager {

	public static FileManager instance = new FileManager();
	private UserManager um = UserManager.instance;
	private AccountManager am = AccountManager.instance;


	private String userFileName = "users.txt";
	private String accsFileName = "accs.txt";
	
	private File file = null;
	private FileWriter fw = null;
	private FileReader fr = null;
	private BufferedReader br = null;


	
	
	public void save() {
		/*
		 * user
		 * code / id / pw / name
		 */ 
		String data = "";
		for(int i=0; i<um.getUsersSize(); i++) {
			data += um.getUser(i).getCode() + "/";
			data += um.getUser(i).getId() + "/";
			data += um.getUser(i).getPw() + "/";
			data += um.getUser(i).getName() + "\n";
		}
		
		try {
			file = new File(userFileName);
			fw = new FileWriter(file);
			fw.write(data);
			fw.close();
			System.out.println("����Ϸ�");
		}catch(Exception e) {
			System.out.println("�������");
		}
		/* accs
		 * code / num / money
		 */
		
		data = "";	
		for(int i=0; i<am.getAccsSize(); i++) {
			data += am.getAcc(i).getUserCode() + "/";
			data += am.getAcc(i).getAccNum() + "/";
			data += am.getAcc(i).getMoney() + "\n";
		}
		try {
			file = new File(accsFileName);
			fw = new FileWriter(file);
			fw.write(data);
			fw.close();
		}catch(Exception e) {
			
		}
	}
	
	public void load() {
		
		//users
		try {
			file = new File(accsFileName);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String data = br.readLine();
			while(data != null) {
				String info[] = data.split("/");
				int code = Integer.parseInt(info[0]);
				String id = info[1];
				String pw = info[2];
				String name = info[3];
				um.addUser(new User(code,id,pw,name));
				data = br.readLine();
				
			}
			fr.close();
			br.close();
		}catch(Exception e) {
			
		}
		//accs
		try {
			file = new File(accsFileName);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String data = br.readLine();
			while(data != null) {
				String info[] = data.split("/");
				
				int code = Integer.parseInt(info[0]);
				int accNum = Integer.parseInt(info[1]);
				int money = Integer.parseInt(info[2]);
	
				Account acc = new Account(code, accNum,money);
				am.addAcc(acc);
				
				// code �� Ȱ�� -> �ش� User ��ü�� accs �迭���� �߰�
				for(int i=0; i<um.getUsersSize(); i++) {
					if(code == um.getUser(i).getCode()) {
						um.getUser(i).addAcc(acc);
					}
				}
				data = br.readLine();
			}
			
			fr.close();
			br.close();
		}catch(Exception e) {
			
		}
	}
	
	
	
}