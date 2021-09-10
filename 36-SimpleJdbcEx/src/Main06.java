import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import study.java.helper.DBHelper;

public class Main06 {

	public static void main(String[] args) {
		// department 테이블에 '컴퓨터정보과' 추가하기 위한 SQL
		String sql = "SELECT profno, name, userid, position, sal, hiredate, comm, " 
				+ "deptno FROM professor WHERE name='김도훈'";
		
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
				// SELECT 절에 명시된 컬럼 이름을 사용하여 데이터 추출
				int profNo = rs.getInt("profno");
				String name = rs.getString("name");
				String userId = rs.getString("userid");
				String position = rs.getString("position");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				System.out.printf("교수번호: %d\n", profNo);
				System.out.printf("이름: %s\n", name);
				System.out.printf("아이디: %s\n", userId);
				System.out.printf("직급: %s\n", position);
				System.out.printf("급여: %d\n", sal);
				System.out.printf("입사일: %s\n", hiredate);
				System.out.printf("보직수당: %d\n", comm);
				System.out.printf("학과번호: %d\n", deptno);
			} else {
				System.out.println("조회 결과가 없습니다.");
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
