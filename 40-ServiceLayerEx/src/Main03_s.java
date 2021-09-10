import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Student;
import study.java.myschool.service.StudentService;
import study.java.myschool.service.impl.StudentServiceImpl;

public class Main03_s {

	public static void main(String[] args) {
		/** 처리 결과를 기록할 Log4j 객체 생성 */
		// 파라미터는 현재 클래스의 이름 (String)
		// --> import org.apache.logging.log4j.Logger;
		// --> import org.apache.logging.log4j.LogManager;
		Logger logger = LogManager.getFormatterLogger(Main03_s.class.getName());

		/** 삭제될 데이터를 담고 있는 Beans 객체 생성 */
		// --> import study.java.myschool.model.Department;
		Student stud = new Student();
		stud.setStudno(20112);

		/** 데이터베이스 접속 */
		SqlSession session = MyBatisConnectionFactory.getSqlSession();

		/** 데이터 처리 수행 */
		// 비즈니스 로직을 위한 Service 객체 생성
		StudentService studentService = new StudentServiceImpl(session, logger);
		
		try {
			// 학과 삭제하기
			studentService.deleteStudent(stud);
			// 삭제 결과를 데이터베이스에 반영하기 
		//	session.commit();
			// 처리 결과를 로그에 기록하기
			logger.debug("데이터 삭제 완료");
		} catch (NullPointerException e) {
			logger.error("삭제된 데이터가 없습니다.");
		} catch (Exception e) {
			logger.error("데이터 삭제에 실패했습니다. " + e.getMessage());
		}

		/** 데이터베이스 접속 해제 */
	//	session.close();

	}

}
