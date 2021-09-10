import java.util.List;

import study.java.dao.AirQualityDao;
import study.java.dao.AirQualityDaoImpl;
import study.java.helper.FileHelper;
import study.java.model.AirQualityItem;

public class Main {
	public static void main(String[] args) {
		String keyword = "";
		
		AirQualityDao dao = new AirQualityDaoImpl();
		List<AirQualityItem> list = dao.getAirQualityList(keyword);
		
		if (list == null) {
			System.out.println("데이터 수신 실패");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("관측소, ");
		sb.append("오존농도, ");
		sb.append("미세먼지(㎍/m³), ");
		sb.append("초미세먼지(㎍/m³)\n");
		
		for (int i=0; i<list.size(); i++) {
			AirQualityItem item = list.get(i);
			String MSRSTE_NM = replaceTag(item.getMSRSTE_NM());
			String o3 = String.format("%.3f", item.getO3());
			//String O3 = "" + (item.getO3());
			String PM10 = "" + (item.getPM10());
			String PM25 = "" + (item.getPM25());
			
			sb.append(MSRSTE_NM + ", " + o3 + ", " + PM10 + ", " + PM25 + "\n");
			}
			keyword = sb.toString();
			System.out.println(keyword);
			
			/** 파일 출력 */ 
			String encType = "euc-kr";
			String filePath = "서울시 월별 평균 대기오염도 정보 2019년 3월.csv";

			boolean is = FileHelper.getInstance().writeString(
					filePath, keyword, encType);
			
			if (is) {
				System.out.println("파일 저장 성공 >> ");
			}

		
	}

	public static String replaceTag(String str) {
		return str.replace("<b>", "")
				.replace("</b>", "")
				.replace("&amp;", "&")
				.replace(",", " ");

	}
	
}


