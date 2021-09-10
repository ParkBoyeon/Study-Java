package study.java.daoex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import study.java.daoex.dao.ProfessorDao;
import study.java.daoex.model.Professor;

public class ProfessorDaoImpl implements ProfessorDao {

	/** 데이터베이스 접속 객체 */
	private Connection conn;

	/** 생성자를 통해서 데이터베이스 접속 객체를 전달 받는다. */
	public ProfessorDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int insert(Professor params) {
		int result = 0;

		/** 실행할 SQL구문 정의 */
		String sql = "INSERT INTO professor (profno, name, userid, position, sal, hiredate, comm, deptno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		/** SQL구문 실행하기 위한 객체 */
		// --> import java.sql.PreparedStatement;
		PreparedStatement pstmt = null;
		// --> import java.sql.ResultSet;
		ResultSet rs = null;

		/** SQL 구문 처리하기 */
		try {
			// pstmt 객체 할당
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// 템플릿에 데이터 설정
			pstmt.setInt(1, params.getProfno());
			pstmt.setString(2, params.getName());
			pstmt.setString(3, params.getUserid());
			pstmt.setString(4, params.getPosition());
			pstmt.setInt(5, params.getSal());
			pstmt.setString(6, params.getHiredate());
			pstmt.setInt(7, params.getComm());
			pstmt.setInt(8, params.getDeptno());

			// SQL문 실행하기 --> 결과 행의 수를 리턴할 변수에 대입함
			pstmt.executeUpdate();

			// Primary Key 받기
			rs = pstmt.getGeneratedKeys();
			rs.next();
			result = rs.getInt(1);

		} catch (SQLException e) {
			System.out.println("MySQL SQL Fail : " + e.getMessage());
		} finally {
			if (rs != null) {
				// 객체 닫기
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				// 객체 닫기
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}

		return result;
	}

	@Override
	public int delete(int params) {
		int result = 0;

		/** 실행할 SQL구문 정의 */
		String sql = "DELETE FROM professor WHERE profno=?";

		/** SQL구문 실행하기 위한 객체 */
		// --> import java.sql.PreparedStatement;
		PreparedStatement pstmt = null;

		/** SQL 구문 처리하기 */
		try {
			// pstmt 객체 할당
			pstmt = conn.prepareStatement(sql);

			// 템플릿에 데이터 설정
			pstmt.setInt(1, params);

			// SQL문 실행하기 --> 결과 행의 수를 리턴할 변수에 대입함
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("MySQL SQL Fail : " + e.getMessage());
		} finally {
			if (pstmt != null) {
				// 객체 닫기
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

	@Override
	public int update(Professor params) {
		int result = 0;

		/** 실행할 SQL구문 정의 */
		String sql = "UPDATE professor SET name=?, userid=?, position=?, sal=?, hiredate=?, comm=?, deptno=? WHERE profno=?";

		/** SQL구문 실행하기 위한 객체 */
		// --> import java.sql.PreparedStatement;
		PreparedStatement pstmt = null;

		/** SQL 구문 처리하기 */
		try {
			// pstmt 객체 할당
			pstmt = conn.prepareStatement(sql);

			// 템플릿에 데이터 설정
			pstmt.setInt(8, params.getProfno());
			pstmt.setString(1, params.getName());
			pstmt.setString(2, params.getUserid());
			pstmt.setString(3, params.getPosition());
			pstmt.setInt(4, params.getSal());
			pstmt.setString(5, params.getHiredate());
			pstmt.setInt(6, params.getComm());
			pstmt.setInt(7, params.getDeptno());

			// SQL문 실행하기 --> 결과 행의 수를 리턴할 변수에 대입함
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("MySQL SQL Fail : " + e.getMessage());
		} finally {
			if (pstmt != null) {
				// 객체 닫기
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

	@Override
	public Professor selectOne(int params) {
		Professor result = null;

		/** 실행할 SQL구문 정의 */
		String sql = "SELECT profno, name, userid, position, sal, hiredate, comm, deptno FROM professor WHERE profno=?";

		/** SQL구문 실행하기 위한 객체 */
		// --> import java.sql.PreparedStatement;
		PreparedStatement pstmt = null;
		// --> import java.sql.Resultset;
		ResultSet rs = null;

		/** SQL 구문 처리하기 */
		try {
			// pstmt 객체 할당
			pstmt = conn.prepareStatement(sql);

			// 템플릿에 데이터 설정
			pstmt.setInt(1, params);

			// SQL문 실행하기 --> 결과 행의 수를 리턴할 변수에 대입함
			rs = pstmt.executeQuery();

			// 조회 결과의 첫 번째 줄로 이동
			boolean first = rs.next();

			if (first) {
				// SELECT 절에 명시한 컬럼 이름을 사용하여 데이터 추출
				int profno = rs.getInt("profno");
				String name = rs.getString("name");
				String userid = rs.getString("userid");
				String position = rs.getString("position");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");

				// 리턴할 객체에 조회한 값을 사용하여 객체를 할당한다.
				result = new Professor(profno, name, userid, position, sal, hiredate, comm, deptno);
			} else {
				System.out.println("조회 결과가 없습니다. ");
			}

		} catch (SQLException e) {
			System.out.println("MySQL SQL Fail : " + e.getMessage());
		} finally {
			if (pstmt != null) {
				// 객체 닫기
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

	@Override
	public List<Professor> select() {
		List<Professor> result = null;

		/** 실행할 SQL구문 정의 */
		// 'department'테이블에 데이터를 갱신하기 위한 SQL의 템플릿
		String sql = "SELECT profno, name, userid, position, sal, hiredate, comm, deptno FROM professor";

		/** SQL구문 실행하기 위한 객체 */
		// --> import java.sql.PreparedStatement;
		PreparedStatement pstmt = null;
		// --> import java.sql.Resultset;
		ResultSet rs = null;

		/** SQL 구문 처리하기 */
		try {
			// pstmt 객체 할당
			pstmt = conn.prepareStatement(sql);

			// SELECT 구문을 실행한 후, 결과셋을 리턴받는다.
			rs = pstmt.executeQuery(sql);

			/** SQL 결과를 컬렉션에 할당 */
			// SQL이 실행되므로 컬렉션을 할당한다.
			result = new ArrayList<Professor>();

			// 한 줄씩 스캔하는 반복문 구성
			while (rs.next()) {
				int profno = rs.getInt("profno");
				String name = rs.getString("name");
				String userid = rs.getString("userid");
				String position = rs.getString("position");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");

				Professor item = new Professor(profno, name, userid, position, sal, hiredate, comm, deptno);
				result.add(item);
			}

		} catch (SQLException e) {
			System.out.println("MySQL SQL Fail : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				// 객체 닫기
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

}
