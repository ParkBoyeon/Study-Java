import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Department;
import study.java.myschool.service.DepartmentService;
import study.java.myschool.service.impl.DepartmentServiceImpl;

public class Main05 {

	public static void main(String[] args) {
		/** 처리 결과를 기록할 Log4j 객체 생성 */
		// 파라미터는 현재 클래스의 이름 (String)
		// --> import org.apache.logging.log4j.Logger;
		// --> import org.apache.logging.log4j.LogManager;
		Logger logger = LogManager.getFormatterLogger(Main05.class.getName());
		
		/** 조회할 데이터의 일렬번호를 저장하고 있는 Beans 객체 생성 */
		// --> import study.java.myschool.model.Department;
	//	Department dept = new Department();
		
		/** 데이터베이스 접속 */
		SqlSession session = MyBatisConnectionFactory.getSqlSession();
		
		/** 데이터 처리 수행 */
		// 비즈니스 로직을 위한 Service 객체 생성
		DepartmentService departmentService = new DepartmentServiceImpl(session);
		// 조회 결과가 저장될 객체 선언 --> import java.util.List;
		List<Department> list = null;
		
		try {
			// 학과 조회하기 
			list = departmentService.getDepartmentList();
			// 조회 결과를 반복문으로 스캔하면서 출력한다. 
			for (int i= 0; i<list.size(); i++) {
				Department temp = list.get(i);
				logger.debug(String.format("조회결과[%d] >> %s", i, temp.toString()));
			}
		} catch (NullPointerException e) {
			logger.error("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			logger.error("데이터 조회에 실패했습니다. "  + e.getMessage());
		}
		
		
		
		/** 데이터베이스 접속 해제 */
		session.close();

	}

}
