import java.util.ArrayList;
import java.util.List;


public class Main02 {

	public static void main(String[] args) {

		List<Integer> numberList = new ArrayList<Integer>();
		
		numberList.add(10);
		numberList.add(20);
		numberList.add(30);
		numberList.add(40);
		numberList.add(50);
		numberList.add(60);
		numberList.add(70);
		numberList.add(80);
		numberList.add(90);
		
		int count = numberList.size();
		System.out.println("데이터 크기: " + count);
		
		int value = numberList.get(4);
		System.out.println("5번째 요소의 값: " + value);
		
		numberList.remove(4);
		
		count = numberList.size();
		System.out.println("데이터 크기: " + count);
		
		value = numberList.get(4);
		System.out.println("5번째 요소의 값: " + value);
		
		numberList.add(4, 123);
		value = numberList.get(4);
		System.out.println("5번째 요소의 값: " + value);
		
		numberList.clear();
		count = numberList.size();
		System.out.println("데이터 크기: " + count);
		
	}

}
