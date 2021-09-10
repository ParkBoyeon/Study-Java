
public class Main02 {

	public static void main(String[] args) {
		int point = 75;
		
		if (point > 70 && point <= 80) {
			System.out.println("C학점 입니다.");
		}
		
		if (point <= 70 || point > 80) {
			System.out.println("범위를 벗어났습니다.");
		}

	}

}
