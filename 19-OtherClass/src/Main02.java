
public class Main02 {
	public static void main(String[] args) {

	MySite bbs = new MySite() {
	
	@Override
	public void write() {
		System.out.println("새 글 쓰기");
	} 
	
	@Override
	public void delete() {
		System.out.println("글 삭제");
	}
	
};

	bbs.write();
	bbs.delete();
	
	MySite member = new MySite() {
		@Override
		public void write() {
			System.out.println("회원가입");
		}
		
		@Override	
		public void delete() {
			System.out.println("회원탈퇴");
		}
	};
	
	member.write();
	member.delete();
}
}

	
