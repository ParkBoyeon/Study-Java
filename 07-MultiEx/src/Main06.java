
public class Main06 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		
		while (true) {
			i++;
			if (i % 2 == 0) { continue; } //조건식으로 이동
			//i % 2 == 0 는 짝수를 뜻한다.
			if ( i > 100 ) { break; }
			sum += i;
			System.out.println(i); //결과적으로 홀수인 수만 출력이 된다. 
			
		}
		System.out.println(sum); // 100 이하의 홀수값의 합

	}

}
