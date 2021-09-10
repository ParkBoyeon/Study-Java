
public class Article {
	
	/** static 은 모든 객체가 공유하는 값*/
	// 전체 게시물의 수를 표현하기 귀한 데이터
	private static int count = 0;
	
	//모든 게시물은 하나의 카테고리 안에 존재한다고 가정한다
	//게시물의 분류를 구별하기 위한 데이터
	private static String category;
	
	private int num;
	
	private String title;
	
	private String regData;

	public Article(int num, String title, String regData) {
		super();
		this.num = num;
		this.title = title;
		this.regData = regData;
		
		count++;
		//게시물이 새로 등록될 때 마다, 전체 글 수를 의미하는 count 변수가 1씩 증가한다.
		// 전체 게시물 수는 모든 객체가 공유하는 값이므로 static 으로 생성되어야 한다.
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Article.count = count;
	}

	public static String getCategory() {
		return category;
	}

	public static void setCategory(String category) {
		Article.category = category;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegData() {
		return regData;
	}

	public void setRegData(String regData) {
		this.regData = regData;
		
	}

	@Override
	public String toString() {
		return "글 분류=" + category + ", 전체글 수=" + count +
				" Article [num=" + num + ", title=" + title + ", regData=" + regData + "]";
	}
	
	

	
}
