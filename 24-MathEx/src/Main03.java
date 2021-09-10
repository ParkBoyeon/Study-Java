
public class Main03 {

	public static void main(String[] args) {
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Main03.random(1, 10));
		System.out.println(Main03.random(11, 20));
	}
	
	public static int random(int min, int max) {
		int num = (int) ((Math.random() * (max - min + 1)) + min);
		return num;
	}

}
