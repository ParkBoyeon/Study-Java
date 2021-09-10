import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Professor;
import study.java.myschool.service.ProfessorService;
import study.java.myschool.service.impl.ProfessorServiceImpl;

public class Main02_p {

	public static void main(String[] args) {
		/** 처리 결과를 기록할 Log4j 객체 생성 */
		// 파라미터는 현재 클래스의 이름 (String)
		// --> import org.apache.logging.log4j.Logger;
		// --> import org.apache.logging.log4j.LogManager;
		Logger logger = LogManager.getFormatterLogger(Main02_p.class.getName());

		/** 수정될 데이터를 담고 있는 Beans 객체 생성 */
		// --> import study.java.myschool.model.Department;
		Professor prof = new Professor();
		prof.setProfno(9933);
		prof.setName("뚬땜이");
		prof.setUserid("boyeon");
		prof.setPosition("교수");
		prof.setSal(100);
		prof.setHiredate("2021-04-20 00:00:00");
		prof.setComm(100);
		prof.setDeptno(101);

		/** 데이터베이스 접속 */
		SqlSession session = MyBatisConnectionFactory.getSqlSession();

		/** 데이터 처리 수행 */
		// 비즈니스 로직을 위한 Service 객체 생성
		ProfessorService professorService = new ProfessorServiceImpl(session, logger);
		
		
		try {
			// 학과 수정하기
			professorService.editProfessor(prof);
		} catch (NullPointerException e) {
			// 수정된 데이터가 없는 경우
			logger.error("수정된 데이터가 없습니다.");
		} catch (Exception e) {
			// SQL문에 문제가 있는 경우.
			logger.error("데이터 수정에 실패했습니다." + e.getMessage());
		}
		
		
		
	}

}
