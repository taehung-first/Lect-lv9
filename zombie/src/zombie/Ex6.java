package zombie;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//�ڷᱸ�� : �����͸� � ��Ģ(����)���� �����ϰ�, �����ð��ΰ�
//Collection
//s ArrayList,Vector

//��hash map (key-value):key ���� �ε����� ������ �ϰԵ�

public class Ex6 {
	public static void main(String[] args) {
		
		//���׸�<?>�� : ��ü�� �ڷ����� ����
		//�� ����ο��� �ڷ��� (Type)�� �����ֱ� ��������
		//�� �����Ǿ����� ���� ���� ����
		
		//HashMap ���� �� �ʱ�ȭ
		Map<String, Integer> users = new HashMap<String, Integer>();
		
		//�߰�
		//put() �޼ҵ� Ȱ��
		//.1���� Ű-���� �� ���� ��
		//. �ߺ�Ű�� ������� x
		users.put("ȫ�浿", 31);
		users.put("�����", 11);
		users.put("������", 25);
		users.put("������", 25);
		
		System.out.println(users.size());
		for(Object key : users.keySet()) {
			System.out.println(key +":");
			System.out.println(users.get(key));
		}
		
		//����
		//remove()
		users.remove("ȫ�浿");
		for(Object val : users.values()) {
			System.out.println(val);
		}
		
		//����(��ȸ���� ���) 
		Object[]keys = users.keySet().toArray();
		Arrays.sort(keys);
		
		for(int i=0;i<keys.length;i++) {
//			System.out.println(keys[i]);
			System.out.print(keys[i]+": ");
			System.out.println(users.get(keys[i]));
			
		}
	
	}

}
