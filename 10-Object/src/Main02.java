class Charactor {
	//일반적으로 멤버변수는 선언만 한다.
	String name;
	int age;
}
public class Main02 {

	public static void main(String[] args) {
		//하나의 클래스가 정의되면, 그 클래스의 구조를 기반으로 하는 
		//여러개의 정보덩어리(=객체)를 생성할 수 있다.
		//클래스는 객체를 여러개 만들기 위해서 존재한다.
		Charactor d = new Charactor(); //Charactor라는 클래스, d 라는 객체
		d.name = "둘리";
		d.age = 19; //객체의 사용(객체 안에 포함된 변수에 다른 값을 대입하는 경우)
		
		Charactor h = new Charactor();
		h.name = "희동";
		h.age = 3;
		
		System.out.println("이름: " + d.name + ", 나이: " + d.age);
		System.out.println("이름: " + h.name + ", 나이: " + h.age);
		
	}

}
