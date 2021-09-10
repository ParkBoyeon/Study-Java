import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main01 {

	public static void main(String[] args) {
		// 데이터베이스에 접속하기 위한 정보 정의하기
		String db_hostname = "localhost";
		int db_portnumber = 3306;
		String db_database = "myschool";
		String db_charset = "utf8";
		String db_username = "root";
		String db_password = "root";
		
		Connection conn = null; //null로 초기화 한다.
		
		/**	데이터베이스 접속 처리 */
		// 사용하려는 데이터베이스명을 포함한 URL 기술
		// -> jdbc:/mysql://localhost:3306/myschool?characterEncoding=utf8&serverTimezone=UTC"
		String urlFormat = "jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=UTC";
		String url = String.format(urlFormat, db_hostname, db_portnumber, db_database, db_charset);
		
		// 접속 과정에서 예외 처리가 요구된다.
		try {
			// MySQL JDBC의 드라이버 클래스를 로딩해서 DriverManager클래스에 등록한다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// DriverManager 객체를 사용하여 DB에 접속한다.
			// -> 접속 URL, 아이디, 비밀번호를 전달
			// -> DriverManager에 등록된 Driver 객체를 사용하여 DB에 접속 후, 
			// Connection 객체를 리턴받는다.
			// -> import java.sql.Drivermanager 필요함
			conn = DriverManager.getConnection(url, db_username, db_password);
			
			// 성공시 메시지 출력
			System.out.println("=== DATABASE Connect Success ===");
			
		} catch (ClassNotFoundException e) {
			// 실패시 메시지와 에러 내용 출력
			System.out.println("=== DATABASE Connect Fail ===");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			// 실패시 메시지와 에러 내용 출력
			System.out.println("=== DATABASE Connect Fail ===");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		/** 데이터베이스 접속 해제 처리 */
		try {
			conn.close();
			System.out.println("=== DATABASE Disconnect Success ===");
		} catch (SQLException e) {
			System.out.println("=== DATABASE DisConnect Fail ===");
			e.printStackTrace();
		}
		conn = null;

	}

}
