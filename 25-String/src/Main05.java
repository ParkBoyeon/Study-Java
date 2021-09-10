
public class Main05 {
	public static void main(String[] args) {
		String data = "D:/photo/2014/travel/food.jpg";
		
		String name = data.substring(data.lastIndexOf("/") + 1, data.lastIndexOf("."));
		System.out.println("파일이름:" + name);
		
		String ext = data.substring(data.lastIndexOf(".") + 1);
		System.out.println("확장자:" + ext);
		
		System.out.println("폴더명:" + data.substring(0, data.lastIndexOf("/")));
	}

}
