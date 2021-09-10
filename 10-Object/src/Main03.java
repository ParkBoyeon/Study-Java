class HelloWorld {
	String message; // 예) SayHello메서드 입장에서 멤버변수(=전역변수)
	
	// 두개 이상의 메서드가 공존
	void sayHello() { System.out.println(message);}
	void setEng() { message = "Hello Java"; }
	void setKor() { message = "안녕하세요. 자바";}
}
public class Main03 {

	public static void main(String[] args) {
		HelloWorld hello = new HelloWorld();
		
		//메서드의 호출
		hello.setEng();
		hello.sayHello();
		
		hello.setKor();
		hello.sayHello();

	}

}
