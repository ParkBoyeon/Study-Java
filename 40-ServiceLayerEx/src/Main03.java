import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Department;
import study.java.myschool.service.DepartmentService;
import study.java.myschool.service.impl.DepartmentServiceImpl;

public class Main03 {

	public static void main(String[] args) {
		/** 처리 결과를 기록할 Log4j 객체 생성 */
		// 파라미터는 현재 클래스의 이름 (String)
		// --> import org.apache.logging.log4j.Logger;
		// --> import org.apache.logging.log4j.LogManager;
		Logger logger = LogManager.getFormatterLogger(Main03.class.getName());

		/** 삭제될 데이터를 담고 있는 Beans 객체 생성 */
		// --> import study.java.myschool.model.Department;
		Department dept = new Department();
		dept.setDeptno(319);

		/** 데이터베이스 접속 */
		SqlSession session = MyBatisConnectionFactory.getSqlSession();

		/** 데이터 처리 수행 */
		// 비즈니스 로직을 위한 Service 객체 생성
		DepartmentService departmentService = new DepartmentServiceImpl(session);
		
		try {
			// 학과 삭제하기
			departmentService.deleteDepartment(dept);
			// 삭제 결과를 데이터베이스에 반영하기 
			session.commit();
			// 처리 결과를 로그에 기록하기
			logger.debug("데이터 삭제 완료");
		} catch (NullPointerException e) {
			logger.error("삭제된 데이터가 없습니다.");
		} catch (Exception e) {
			logger.error("데이터 삭제에 실패했습니다. " + e.getMessage());
		}

		/** 데이터베이스 접속 해제 */
		session.close();

	}

}
