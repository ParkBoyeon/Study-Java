public class Main03 {

	public static void main(String[] args) {
		double a = 10.5D;
		float b = 20.5F;
		
		//큰 범위의 변수와 작은 범위의 변수가 연산을 수행하면, 작은범위의 변수가 큰범위의 데이터형으로 암묵적형변환
		//그러므로 아래의 a+b는  double형의 변수가 되므로, float형의 값에 대입하는 것은 에러이다.
		//float < double
		/** float f = a + b; **/

		float f = (float) (a + b);
		System.out.println(f);

		double d = a + b;
		System.out.println(d);

	}

}
