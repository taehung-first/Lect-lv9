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
		
		//제네릭<?>은 : 객체의 자료형을 지정
		//ㄴ 선언부에서 자료형 (Type)을 정해주기 전까지는
		//ㄴ 결정되어지지 않은 열린 상태
		
		//HashMap 선언 및 초기화
		Map<String, Integer> users = new HashMap<String, Integer>();
		
		//추가
		//put() 메소드 활용
		//.1쌍의 키-벨류 가 들어가야 함
		//. 중복키를 허용하지 x
		users.put("홍길동", 31);
		users.put("도우너", 11);
		users.put("권태흥", 25);
		users.put("정진범", 25);
		
		System.out.println(users.size());
		for(Object key : users.keySet()) {
			System.out.println(key +":");
			System.out.println(users.get(key));
		}
		
		//삭제
		//remove()
		users.remove("홍길동");
		for(Object val : users.values()) {
			System.out.println(val);
		}
		
		//정렬(우회적인 방법) 
		Object[]keys = users.keySet().toArray();
		Arrays.sort(keys);
		
		for(int i=0;i<keys.length;i++) {
//			System.out.println(keys[i]);
			System.out.print(keys[i]+": ");
			System.out.println(users.get(keys[i]));
			
		}
	
	}

}
