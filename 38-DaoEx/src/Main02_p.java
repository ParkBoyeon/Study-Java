import java.sql.Connection;

import study.java.daoex.dao.ProfessorDao;
import study.java.daoex.dao.impl.ProfessorDaoImpl;
import study.java.helper.DBHelper;

public class Main02_p {

	public static void main(String[] args) {
		// 1) 데이터베이스 접속
				//--> import java.sql.Connection;
				//--> import study.java.helper.DBHelper;
				Connection conn = DBHelper.getInstance().open();
				
				if (conn == null) {
					System.out.println("데이터베이스 접속 실패");
					return;
				}
				
				// 2) 삭제할 데이터
				// Main01에서 출력된 값을 입력하세요.
				int target = 9922;
				
				// 3) 501번 데이터 삭제
				ProfessorDao dao = new ProfessorDaoImpl(conn);
				int result = dao.delete(target);
				
				// 4) 결과 판별
				System.out.println(result + "개의 데이터 삭제됨");
				
				// 5) DB 접속 해제
				DBHelper.getInstance().close();

	}

}
