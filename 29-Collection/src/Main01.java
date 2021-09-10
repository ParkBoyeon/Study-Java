import java.util.HashMap;
import java.util.Map;

public class Main01 {

	public static void main(String[] args) {

		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("aaa", 111);
		hm.put("bbb", 222);
		hm.put("aaa", 444);
		hm.put("ccc", 333);
		hm.put("ccc", null);
		
		System.out.println("HashMap size : " + hm.size());
		
		System.out.println(hm.get("aaa"));
		System.out.println(hm.get("bbb"));
		System.out.println(hm.get("ccc"));

	}

}
