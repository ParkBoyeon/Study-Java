
public class Main02 {

	public static void main(String[] args) {
		// 정수의 나눗셈
		int a = 7;
		int b = 3;
		int result1 = a / b;
		System.out.println("7 / 3 = " + result1);

		// 실수의 나눗셈
		double c = 7.0D;
		double d = 3.0D;
		double result2 = c / d;
		System.out.println("7.0 / 3.0 = " + result2);

		// 정수와 실수의 계산
		// int result3 c / b;
		// 이건 에러가 난다.
		double result3 = c / b;
		System.out.println("7.0 / 3 = " + result3);

		// 나눗셈의 오차
		System.out.println("5 % 2 = " + 5 % 2);
		System.out.println("5.2D % 2.0D = " + 5.2D % 2.0D);

		// 0으로 나누기
		int num = 100;
		int zero = 0;
		// int result4 = num / zero;

		// 에러
		// System.out.println("100 / 0 = " + result4);

	}

}
