
public class Main02 {
	public static void main(String[] args) {
		
		Unit[] units = new Unit[5];
		
		units[0] = new AirForce("공군1호");
		units[1] = new AirForce("공군2호");
		units[2] = new Navy("해군1호");
		units[3] = new Army("육군1호");
		units[4] = new Army("육군2호");
		
		for(int i=0; i < units.length; i++) {
			units[i].attack();
			
			
		}
				
		
	}

}
