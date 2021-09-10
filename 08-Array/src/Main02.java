
public class Main02 {

	public static void main(String[] args) {
		//학급 성적을 위한 배열
		int[][] grade = new int[3][3];
		
		//둘리의 과목별 점수 
		grade[0][0] = 75;
		grade[0][1] = 82;
		grade[0][2] = 91;
		
		//도우너의 과목별 점수
		grade[1][0] = 88;
		grade[1][1] = 64;
		grade[1][2] = 50;
		
		//또치의 과목별 점수
		grade[2][0] = 100;
		grade[2][1] = 100;
		grade[2][2] = 90;
		
		/** 2차 배열을 탐색하여 총점과 평균점수 구하기 **/
		for (int i=0; i<grade.length; i++) {
			//반복문 안에서 선언된 변수는 매 실행시마다 새로 생성된다.
			int sum = 0;
			int avg = 0;
			
			for (int j=0; j<grade[i].length; j++) {
				// i번째 위치의 0번째에 각 과목별 점수에 대한 누적처리
				sum += grade[i][j];
			}
			
			// i번째 위치의 평균점수 구하기 = 총점 / 과목수
			// i번째 학생의 과목수는 grade배열의 i번째에 대한 길이
			avg = sum / grade[i].length;
			
			System.out.println("총점=" + sum + ", 평균=" + avg);
		}
	}

}
