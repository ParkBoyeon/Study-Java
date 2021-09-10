class Student {
	// 은닉된 멤버변수
	private String name;
	private int age;
	
	// 은닉되지않은 메서드 (은닉된 멤버변수에 값을 넣는 방법)
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
public class Main01 {

	public static void main(String[] args) {
		Student s = new Student();
		s.setName("JAVA학생");
		s.setAge(20);
		
		String name = s.getName();
		System.out.println("이름:" + name);
		
		int age = s.getAge();
		System.out.println("나이:" + age);
	}

}
