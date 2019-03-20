package Z.Last2_Problems;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// SW maestro 지원 대비 모르는 것 위주 문제임
// HashMap , HashTable 
// 일반적으로 동기화가 필요하다면 Map, 필요없다면 table을 사용.
// 상위호환의 개념으로 HashMap을 사용하세염.

public class SM_aboutHash {
	public static void main(String[] args) {
		// Map으로 선언하는것이 상위호환 관계로 보았을 때 이득임. 
		// Key / Value 순으로 감. 
		Map<Integer,Integer> hash = new HashMap<>();
		Date date = new Date();
		
		//hash data init
		for(int i = 0; i < 10 ; i++)
		{
			hash.put(i, (int) date.getTime()+i);
		}
		
		System.out.println("isEmpty / Size / Containkey / contaonValue");
		System.out.println(hash.isEmpty() + " / " + hash.size() + " / " + hash.containsKey(6) + " / "  + hash.containsValue(1212));
		
		//전체 출력 
		Iterator<Integer> it = hash.keySet().iterator();
		while(it.hasNext())
		{
			int key = it.next();
			System.out.println("key : value / " + key + " : " + hash.get(key));
			
		}
		
		System.out.println("key = 3 삭제 ");
		hash.remove(3);
		
		// null 
		System.out.println(hash.get(new Integer(3)));

		
		
		
	}
}
