import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import study.java.helper.DBHelper;

public class Main05 {

	public static void main(String[] args) {
		// department 테이블에 '컴퓨터정보과' 추가하기 위한 SQL
		String sql = "SELECT count(studno) FROM student WHERE grade=4";
		
		/**DBHelper를 통한 DB접속 처리*/
		DBHelper db = DBHelper.getInstance();
		Connection conn = db.open();
		
		/** SQL 구문 실행하기*/
		// SQL문을 실행할 수 있는 객체 
		Statement stmt = null;
		// SELECT 결과를 저장할 객체
		// --> import java.sql.ResultSet;
		ResultSet rs = null;
		
		try {
			// SQL문을 실행할 수 있는 객체 생성 (예외처리 요구됨)
			stmt=conn.createStatement();
			// SELECT 구문을 실행한 후, 결과셋을 리턴받는다.
			rs = stmt.executeQuery(sql);
			
			// 조회 결과의 첫 번째 줄로 이동
			boolean first = rs.next();
			if(first) {
				// SELECT 절에 명시된 '1'번째 항목을 int 형으로 추출하기
				int count = rs.getInt(1);
				
				// 결과 출력
				System.out.println("4학년 학생은 " + count + "명 입니다.");
			}
		} catch (SQLException e) {
			System.out.println("MySQL SQL Fail" + e.getMessage());
		} finally {
			// resetset 닫기 --> 생성된 순서의 역순으로 객체를 닫는다.
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) { }
			}
			
			
			// SQL 구문의 에러 여부에 상관없이 stmt 객체를 닫기 위하여 finally  블록 사용.
			// --> 객체의 유효범위 설정을 위해서 stmt 객체는 try블록 밖에 선언되었다.
			if (stmt != null) {
				// 객체 닫기
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//			
//			// 결과 출력
//			System.out.println(rs + "Record Delete");
		}
		
		
		
		/** DB 접속 해체 */
		db.close();

	}

}
