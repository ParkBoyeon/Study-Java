
public class Main01 {

	public static void main(String[] args) {
		String a = "20";
		String b = "3.14";
		
		int num_a = Integer.parseInt(a);
		float num_b = Float.parseFloat(b);
		
		int v1 = num_a + 500;
		float v2 = num_b + 500;
		System.out.println("v1=" + v1);
		System.out.println("v2=" + v2);
		
		Integer i = new Integer(123);
		
		int j = i + 300;
		System.out.println("j=" + j);

	}

}
