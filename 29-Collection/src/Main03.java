import java.util.ArrayList;
import java.util.List;

public class Main03 {

	public static void main(String[] args) {
		
		List<People> plist = new ArrayList<People>();
		
		for(int i=0; i<10; i++) {
			People p = new People("회원" + i, "010-1234-5678" + i);
			plist.add(p);
		}
		
		for(int i=0; i<plist.size(); i++) {
			People item = plist.get(i);
			System.out.println(item.toString());
		}
		
		

	}

}
