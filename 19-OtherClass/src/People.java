/**
 * InnerClass
 * 상속과 같이 하나의 클래스에서 파생되는 그룹을 지정하기 위한 방법
 * 바깥의 클래스를 부모, 안쪽의 클래스를 자식으로 놓을 때
 * 자식은 부모의 모든기능을 포함한다.
 */
public class People {
	
	public class Man {		// InnerClass
		
		public String name;
		public int age;
		public boolean military;
		
		public Man(String name, int age, boolean military) {
			this.name = name;
			this.age = age;
			this.military = military;
		}

		@Override
		public String toString() {
			return "Man [name=" + name + ", age=" + age + ", military=" + military + "]";
		}


		
	}
	
	public static class Woman {		// InnerClass
		public String name;
		public int age;
		
		public Woman(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Woman [name=" + name + ", age=" + age + "]";
		}
		
	}

}
