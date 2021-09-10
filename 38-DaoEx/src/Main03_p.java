import java.sql.Connection;

import study.java.daoex.dao.ProfessorDao;
import study.java.daoex.dao.impl.ProfessorDaoImpl;
import study.java.daoex.model.Professor;
import study.java.helper.DBHelper;

public class Main03_p {

	public static void main(String[] args) {
		// 1) 데이터베이스 접속
		// --> import java.sql.Connection;
		// --> import study.java.helper.DBHelper;
		Connection conn = DBHelper.getInstance().open();

		if (conn == null) {
			System.out.println("데이터베이스 접속 실패");
			return;
		}

		// 2) UPDATE를 수행할 데이터 생성
		Professor model = new Professor(9920, "김길동", "gilldong", "교수", 450, "2014-01-01 00:00:00", 0, 101);

		// 3) 데이터 수정
		ProfessorDao dao = new ProfessorDaoImpl(conn);
		int result = dao.update(model);

		// 4) 결과 판별
		System.out.println(result + "개의 데이터 수정됨");

		// 5) DB 접속 해제
		DBHelper.getInstance().close();

	}

}
