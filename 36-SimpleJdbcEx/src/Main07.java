import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import study.java.helper.DBHelper;

public class Main07 {

	public static void main(String[] args) {
		// department 테이블에 '컴퓨터정보과' 추가하기 위한 SQL
		String sql = "SELECT deptno, dname, loc FROM department ORDER BY deptno ASC";
		
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
			
			// 한 줄씩 스캔하는 반복문 구성
			while (rs.next()) {
				int deptNo = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				System.out.printf("학과번호: %d\n", deptNo);
				System.out.printf("학과이름: %s\n", dname);
				System.out.printf("이름: %s\n", loc);
				System.out.println();
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
