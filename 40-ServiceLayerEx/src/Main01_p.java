import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Professor;
import study.java.myschool.service.ProfessorService;
import study.java.myschool.service.impl.ProfessorServiceImpl;

public class Main01_p {

	public static void main(String[] args) {
		/** 처리 결과를 기록할 Log4j 객체 생성 */
		// 파라미터는 현재 클래스의 이름 (String)
		// --> import org.apache.logging.log4j.Logger;
		// --> import org.apache.logging.log4j.LogManager;
		Logger logger = LogManager.getFormatterLogger(Main01_p.class.getName());
		
		/** 저장될 데이터를 담고 있는 Beans 객체 생성 */
		// --> import study.java.myschool.model.Department;
		Professor prof = new Professor();
		prof.setName("박보연");
		prof.setUserid("boyeon");
		prof.setPosition("학생");
		prof.setSal(100);
		prof.setHiredate("2021-04-20 00:00:00");
		prof.setComm(100);
		prof.setDeptno(201);
		
		
		/** 데이터베이스 접속 */
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		
		/** 데이터 처리 수행 */
		// 비즈니스 로직을 위한 Service 객체 생성
		ProfessorService professorService = new ProfessorServiceImpl(sqlSession, logger);
		// 저장된 결과를 리턴받기 위한 Beans 객체
		
		
		
		try {
			// 학과 저장하기
			professorService.addProfessor(prof);
			// 저장 결과를 데이터베이스에 반영하기
			//sqlSession.commit();
			// 처리 결과를 로그에 기록하기
			//logger.debug("저장된 데이터 >> " + toString());
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
