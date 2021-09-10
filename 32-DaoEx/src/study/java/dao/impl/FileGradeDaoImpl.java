package study.java.dao.impl;

import java.util.ArrayList;
import java.util.List;

import study.java.dao.GradeDao;
import study.java.helper.FileHelper;
import study.java.model.Grade;

public class FileGradeDaoImpl implements GradeDao{

	public FileGradeDaoImpl() {
		String clsName = this.getClass().getCanonicalName();
		System.out.println("-----" + clsName + "-----");
	}
	
	
	@Override
	public List<Grade> getGradeList() {
		List<Grade> list = null;
		
		String source = FileHelper.getInstance().readString("res/grade.csv", "euc-kr");
		
		if (source == null) {
			return null;
		}
		
		list = new ArrayList<Grade>();
		
		String[] data = source.split("\n");
		
		/** (2) 학생 수 만큼 반복 처리 */
		for (int i=0; i<data.length; i++) {
			/** (3) 한 명의 데이터 추출*/
			String line_string = data[i].trim();
			
			/** (4) 한 명의 데이터를 과목별로 분리*/
			String[] line_data = line_string.split(",");
			
			String name = line_data[0];
			int kor = Integer.parseInt(line_data[1]);
			int eng = Integer.parseInt(line_data[2]);
			int math = Integer.parseInt(line_data[3]);
			
			Grade item = new Grade(name, kor, eng, math);
			list.add(item);
		}
		
		return list;
	}

}
