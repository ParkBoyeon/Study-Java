
public class Main03 {

	public static void main(String[] args) {
		boolean is_korean = true;

		if (is_korean == true) {
			System.out.println("한국사람입니다.");
		}

		if (is_korean == false) {
			System.out.println("한국사람이 아닙니다.");
		}

		if (is_korean) {
			System.out.println("한국사람입니다.");
		}

		if (!is_korean) {
			System.out.println("한국사람이 아닙니다.");
		}

		boolean is_japanese = false;

		if (is_japanese != true) {
			System.out.println("일본사람이 아닙니다.");
		}

		if (is_japanese != false) {
			System.out.println("일본사람 입니다.");
		}

		if (is_japanese) {
			System.out.println("일본사람이 아닙니다.");
		}

		if (!is_japanese) {
			System.out.println("일본사람입니다.");
		}

	}

}
