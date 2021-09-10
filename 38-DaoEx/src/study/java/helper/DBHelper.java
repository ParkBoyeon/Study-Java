package study.java.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	// 데이터베이스에 접속하기 위한 정보 정의하기
	private static final String db_hostname = "localhost";
	private static final int db_portnumber = 3306;
	private static final String db_database = "myschool";
	private static final String db_charset = "utf8";
	private static final String db_username = "root";
	private static final String db_password = "root";
	
	private Connection conn = null; // null로 초기화 한다
	
	// ------ 싱글톤 객체 시작 ------
	private static DBHelper current;
	
	/**싱글톤 객체를 생성하여 리턴한다*/
	public static DBHelper getInstance() {
		if (current == null) {
			current = new DBHelper();
		}
		return current;
		
	}
	/**싱글톤 객체를 삭제한다.*/
	public static void freeInstance() {
		current = null;
	}
	/**생성자*/
	private DBHelper() {}
	
	// ------ 싱글톤 객체 끝 ------

	public Connection open() {
		// 중복 실행될 경우 발생될 문제를 방지하기 위하여, 
		//	Connection 객체가 null인 경우만 처리하도록 if문으로 구성
		if(conn == null) {
			
			/**	데이터베이스 접속 처리 */
			// 사용하려는 데이터베이스명을 포함한 URL 기술
			// -> jdbc:/mysql://localhost:3306/myschool?characterEncoding=utf8&serverTimezone=UTC"
			String urlFormat = "jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=UTC";
			String url = String.format(urlFormat, db_hostname, db_portnumber, db_database, db_charset);
			
			// MySQL JDBC의 드라이버 클래스를 로딩해서 DriverManager클래스에 등록한다.
			try {
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
			
			
		}
		return conn;
	}
	
	/** 데이터베이스 접속 해제 한다*/
	public void close() {
		if (conn!=null) {
			/**데이터베이스 접속 해제 처리*/
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
}
		

