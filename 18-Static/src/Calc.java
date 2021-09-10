
public class Calc {
 
	// --- 싱글톤 객체 생성을 위한 준비시작 ---
	// 외부에서 이 객체에 직접적인 접근 못하도록 은닉시킨다.
	private static Calc current;

	// 은닉시켰으니까 객체를 메모리에서 간접적으로 할당하고 삭제하기 위한 메서드 필요하다.
	public static Calc getInstance() { // getInststance() 사용하여 객체를 리턴받음
		if (current == null) {
			current = new Calc();
		}
		return current;
	}

	public static void freeInstance() {
		current = null; // 객체에 null대입 = 메모리에서 삭제
	}

	// 기본 생성자를 은닉
	// new 활용한 객체할당이 금지된다.
	private Calc() {
		super();
	}
	// --- 싱글톤 객체 생성을 위한 준비 끝 ---

	public void plus(int x, int y) {
		int z = x + y;
		System.out.println(x + "+" + y + "=" + z);
	}

	public void minus(int x, int y) {
		int z = x - y;
		System.out.println(x + "-" + y + "=" + z);
	}

}
