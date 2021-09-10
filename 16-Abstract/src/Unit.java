
public abstract class Unit {
	private String name;
	
	public Unit(String name) {
		super(); //파라미터를 초기화하기위해 Object (최상위클래스)에서 상속받음
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void attack();
	
	public abstract void move();

}
