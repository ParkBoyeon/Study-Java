class Calc {
	int plus(int x, int y) { return x + y; }
	
	int minus(int x, int y) { return x - y; }
	
	int times(int x, int y) { return x * y; }
	
	int divide(int x, int y) {
		int result = 0;
		if (y != 0) {
			//0으로 나눌 수 없으므로
			result = x / y;
		}
		return result;
	} 
	
	int f(int x, int y) {
		int result = plus(x, y) + times(x, y);
		return result;
	}
}
public class Main04 {

	public static void main(String[] args) {
		Calc c = new Calc();
		// c라는 하나의 객체
		
		int p = c.plus(100, 50);
		System.out.println("100+50=" + p);
		
		System.out.println("100+50=" + c.minus(100, 50));
		System.out.println("100+50=" + c.times(100, 50));
		System.out.println("100+50=" + c.divide(100, 50));
		System.out.println("f(100+50)=" + c.f(100, 50));
		//객체 c를 재사용한다

	}

}
