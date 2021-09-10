import java.sql.Connection;

import study.java.daoex.dao.StudentDao;
import study.java.daoex.dao.impl.StudentDaoImpl;
import study.java.daoex.model.Student;
import study.java.helper.DBHelper;

public class Main03_s {
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
		Student model = new Student(10204, "박진욱", "samba7", 3, "7904021358671", "1979-04-02 00:00:00", "053)487-2698", 171, 70, 102, 9905);

		// 3) 데이터 수정
		StudentDao dao = new StudentDaoImpl(conn);
		int result = dao.update(model);

		// 4) 결과 판별
		System.out.println(result + "개의 데이터 수정됨");

		// 5) DB 접속 해제
		DBHelper.getInstance().close();

	}

}
