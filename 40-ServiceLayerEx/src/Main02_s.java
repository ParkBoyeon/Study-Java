import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Student;
import study.java.myschool.service.StudentService;
import study.java.myschool.service.impl.StudentServiceImpl;

public class Main02_s {

	public static void main(String[] args) {
		/** 처리 결과를 기록할 Log4j 객체 생성 */
		// 파라미터는 현재 클래스의 이름 (String)
		// --> import org.apache.logging.log4j.Logger;
		// --> import org.apache.logging.log4j.LogManager;
		Logger logger = LogManager.getFormatterLogger(Main02_s.class.getName());

		/** 수정될 데이터를 담고 있는 Beans 객체 생성 */
		// --> import study.java.myschool.model.Department;
		Student stud = new Student();
		stud.setStudno(20112);
		stud.setName("뚬땜이");
		stud.setUserid("boyeon");
		stud.setGrade(2);
		stud.setIdnum("123");
		stud.setBirthdate("1998-05-19 00:00:00");
		stud.setTel("02)000-0000");
		stud.setHeight(165);
		stud.setWeight(12);
		stud.setDeptno(101);
		stud.setProfno(9924);

		/** 데이터베이스 접속 */
		SqlSession session = MyBatisConnectionFactory.getSqlSession();

		/** 데이터 처리 수행 */
		// 비즈니스 로직을 위한 Service 객체 생성
		StudentService studentService = new StudentServiceImpl(session, logger);
		
		try {
			// 학과 수정하기
			studentService.editStudent(stud);
		} catch (NullPointerException e) {
			// 수정된 데이터가 없는 경우
			logger.error("수정된 데이터가 없습니다.");
		} catch (Exception e) {
			// SQL문에 문제가 있는 경우.
			logger.error("데이터 수정에 실패했습니다." + e.getMessage());
		}
		

		
	}

}
