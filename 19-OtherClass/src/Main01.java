
public class Main01 {
	public static void main(String[] args) {
		People p = new People() ;
		People.Man man = p.new Man("철수", 19, true);
		
		People.Woman woman = new People.Woman("영희", 18);
		
		System.out.println(man.toString());
		System.out.println(woman.toString());
	}

}
