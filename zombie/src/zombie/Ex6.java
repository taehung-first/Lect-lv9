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

		// ���׸�<?>�� : ��ü�� �ڷ����� ����
		// �� ����ο��� �ڷ��� (Type)�� �����ֱ� ��������
		// �� �����Ǿ����� ���� ���� ����

		// HashMap ���� �� �ʱ�ȭ
		Map<String, Integer> users = new HashMap<String, Integer>();

		// �߰�
		// put() �޼ҵ� Ȱ��
		// .1���� Ű-���� �� ���� ��
		// . �ߺ�Ű�� ������� x
		users.put("ȫ�浿", 31);
		users.put("�����", 11);
		users.put("������", 25);
		users.put("������", 23);

		System.out.println(users.size());
		for (Object key : users.keySet()) {
			System.out.println(key + ":");
			System.out.println(users.get(key));
		}
		// ����
		// remove()
		users.remove("ȫ�浿");
		for (Object val : users.values()) {
			System.out.println(val);
		}

		// ����(��ȸ���� ���)
		Object[] keys = users.keySet().toArray();
		Arrays.sort(keys);
//
//		for (int i = 0; i < keys.length; i++) {
////			System.out.��println(keys[i]);
//			System.out.print(keys[i] + ": ");
//			System.out.println(users.get(keys[i]));
//			//
//		}
	
		// �� ����
		//keys �迭�� ������ �� ������ ������ ����
		System.out.println();
		int min =0;
		int idx = 0;
		for(int i=0;i<keys.length;i++) {
			min = users.get(keys[i]);
			idx=i;
			for(int j=i;j<keys.length;j++) {
				if(min >users.get(keys[j])) {
					min = users.get(keys[j]);
					idx = j;
				}
			}
			Object temp = keys[i];
			keys[i] = keys[idx];
			keys[idx] = temp;
		}
//		System.out.println();
//		for(int i=0;i<keys.length;i++) {
//			for(int j=i;j<keys.length;j++) {
//				if(users.get(keys[i])>users.get(keys[j])) {
//					//keys �迭�� ����
//					Object temp = keys[i];
//					keys[i]= keys[j];
//					keys[j]=temp;
//				}
//			}
//		}
		for (int i = 0; i < keys.length; i++) {
//			System.out.��println(keys[i]);
			System.out.print(keys[i] + ": ");
			System.out.println(users.get(keys[i]));
		}
//		Object[][] newKey = new String[users.size()][2];
//
//	    Object[] a = users.keySet().toArray();
//	    Object[] b = users.values().toArray();
//	    
//	    
//	    for (int i = 0; i < newKey.length; i++) {
//	    	newKey[i][0] = a[i];
//	    	newKey[i][1] = b[i];
//	    }
//	    
//	    for (int i = 0; i < newKey.length; i++) {
//	        for (int j = 0; j < newKey[i].length; j++) {
//	            System.out.println(newKey[i][j]);
//	        }
//	    }
		int arr[] = { 4, 3, 7, 1, 2 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}

