import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Professor;
import study.java.myschool.service.ProfessorService;
import study.java.myschool.service.impl.ProfessorServiceImpl;

/** 데이터베이스 접속 해제 */
public class Main04_p {

	public static void main(String[] args) {
		/** 처리 결과를 기록할 Log4j 객체 생성 */
		// 파라미터는 현재 클래스의 이름 (String)
		// --> import org.apache.logging.log4j.Logger;
		// --> import org.apache.logging.log4j.LogManager;
		Logger logger = LogManager.getFormatterLogger(Main04_p.class.getName());

		/** 조회할 데이터의 일렬번호를 저장하고 있는 Beans 객체 생성 */
		// --> import study.java.myschool.model.Department;
		Professor prof = new Professor();
		prof.setProfno(9901);

		/** 데이터베이스 접속 */
		SqlSession session = MyBatisConnectionFactory.getSqlSession();

		/** 데이터 처리 수행 */
		// 비즈니스 로직을 위한 Service 객체 생성
		ProfessorService professorService = new ProfessorServiceImpl(session, logger);
		// 조회 결과가 저장될 객체 선언
		Professor item = null;
		
		try {
			// 학과 조회하기 
			item = professorService.getProfessorItem(prof);
			// 처리 결과를 로그에 기록하기 
			logger.debug("조회된 데이터 >> " + item.toString());
		} catch (NullPointerException e) {
			logger.error("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			logger.error("데이터 조회에 실패했습니다." + e.getMessage());
		}
		

		/** 데이터베이스 접속 해제 */
		session.close();

	}

}