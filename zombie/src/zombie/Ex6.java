package zombie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//자료구조 : 데이터를 어떤 규칙(조직)으로 저장하고, 가져올것인가
//Collection
//s ArrayList,Vector

//ㄴhash map (key-value):key 값이 인덱스의 역할을 하게됨

public class Ex6 {
	public static void main(String[] args) {

		// 제네릭<?>은 : 객체의 자료형을 지정
		// ㄴ 선언부에서 자료형 (Type)을 정해주기 전까지는
		// ㄴ 결정되어지지 않은 열린 상태

		// HashMap 선언 및 초기화
		Map<String, Integer> users = new HashMap<String, Integer>();

		// 추가
		// put() 메소드 활용
		// .1쌍의 키-벨류 가 들어가야 함
		// . 중복키를 허용하지 x
		users.put("홍길동", 31);
		users.put("도우너", 11);
		users.put("권태흥", 25);
		users.put("김진범", 23);

		System.out.println(users.size());
		for (Object key : users.keySet()) {
			System.out.println(key + ":");
			System.out.println(users.get(key));
		}
		// 삭제
		// remove()
		users.remove("홍길동");
		for (Object val : users.values()) {
			System.out.println(val);
		}

		// 정렬(우회적인 방법)
		Object[] keys = users.keySet().toArray();
		Arrays.sort(keys);
//
//		for (int i = 0; i < keys.length; i++) {
////			System.out.ㄴprintln(keys[i]);
//			System.out.print(keys[i] + ": ");
//			System.out.println(users.get(keys[i]));
//			//
//		}
	
		// 값 정렬
		//keys 배열의 순서를 값 정렬의 순서로 나열
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
//					//keys 배열을 정렬
//					Object temp = keys[i];
//					keys[i]= keys[j];
//					keys[j]=temp;
//				}
//			}
//		}
		for (int i = 0; i < keys.length; i++) {
//			System.out.ㄴprintln(keys[i]);
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

