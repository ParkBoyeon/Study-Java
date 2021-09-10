
public class Main02 {

	public static void main(String[] args) {
		
		int[] arr = new int[3];
		
		for (int i=0; i<5; i++) {
			arr[i] = i; // <-- i가 3일때 에러 발생
			System.out.println(arr[i]);
		}
 
	}

}
