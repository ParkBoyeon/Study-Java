import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Student;
import study.java.myschool.service.StudentService;
import study.java.myschool.service.impl.StudentServiceImpl;

public class Main01_s {

	public static void main(String[] args) {
		/** 처리 결과를 기록할 Log4j 객체 생성 */
		// 파라미터는 현재 클래스의 이름 (String)
		// --> import org.apache.logging.log4j.Logger;
		// --> import org.apache.logging.log4j.LogManager;
		Logger logger = LogManager.getFormatterLogger(Main01_s.class.getName());
		
		/** 저장될 데이터를 담고 있는 Beans 객체 생성 */
		// --> import study.java.myschool.model.Department;
		Student stud = new Student();
		stud.setName("박보연");
		stud.setUserid("boyeon");
		stud.setGrade(1);
		stud.setIdnum("123");
		stud.setBirthdate("1998-05-19 00:00:00");
		stud.setTel("02)000-0000");
		stud.setHeight(165);
		stud.setWeight(12);
		stud.setDeptno(101);
		stud.setProfno(9924);
		
		
		/** 데이터베이스 접속 */
		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSession();
		
		/** 데이터 처리 수행 */
		// 비즈니스 로직을 위한 Service 객체 생성
		StudentService studentService = new StudentServiceImpl(sqlsession, logger);
		// 저장된 결과를 리턴받기 위한 Beans 객체
		
		
		
		try {
			// 학과 저장하기
			studentService.addStudent(stud);
			// 저장 결과를 데이터베이스에 반영하기
			
			// 처리 결과를 로그에 기록하기
			//logger.debug("저장된 데이터 >> " + result.toString());
		} catch (NullPointerException e) {
			// 저장된 데이터가 없는 경우
			logger.error("저장된 데이터가 없습니다.");
		} catch (Exception e) {
			// SQL문에 문제가 있는 경우
			logger.error("데이터 저장에 실패했습니다." + e.getMessage());
		}
		
		
		/** 데이터베이스 접속 해제 */
		

	}

}
