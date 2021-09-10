
public class Main03 {

	public static void main(String[] args) {
		int sum1 = 0;
		int sum2 = 0;
		
		for (int i = 1; i <= 100; i++) {
			if(i % 2 == 0) { sum1 += i; } //짝수
			else	{ sum2 += i; } //홀수
			
		}
		System.out.println(sum1); //짝수끼리 더한 것
		System.out.println(sum2); //홀수끼리 더한 것

	}

}
