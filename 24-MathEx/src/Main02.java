
public class Main02 {
	public static void main(String[] args) {
		
		System.out.println("원주율=" + Math.PI);
		
		System.out.println("파이에 대한 Dgree=" + Math.toDegrees(Math.PI));
		double radian30 = Math.toRadians(30);
		System.out.println("30도를 라디안으로 변환=" + radian30);
		
		System.out.println("sin(30)=" + Math.sin(radian30));
		System.out.println("cos(30)=" + Math.cos(radian30));
		System.out.println("tan(30)=" + Math.tan(radian30));
		System.out.println("asin(30)=" + Math.asin(radian30));
		System.out.println("acos(30)=" + Math.acos(radian30));
		System.out.println("atan(30)=" + Math.atan(radian30));
		
		System.out.println("log(5)=" + Math.log(5));
		System.out.println("루트5=" + Math.sqrt(5));
		System.out.println("2의 5승=" + Math.pow(2, 5));
	}

}
